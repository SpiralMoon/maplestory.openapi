import base64
from datetime import datetime
import httpx
import asyncio

from maplestory_openapi.api.msea.dto.character.character import Character
from maplestory_openapi.api.msea.dto.character.character_basic import CharacterBasic
from maplestory_openapi.api.msea.dto.character.character_popularity import CharacterPopularity
from maplestory_openapi.api.msea.dto.character.character_stat import CharacterStat
from maplestory_openapi.api.msea.dto.character.character_hyper_stat import CharacterHyperStat
from maplestory_openapi.api.msea.dto.character.character_propensity import CharacterPropensity
from maplestory_openapi.api.msea.dto.character.character_ability import CharacterAbility
from maplestory_openapi.api.msea.dto.character.character_item_equipment import CharacterItemEquipment
from maplestory_openapi.api.msea.dto.character.character_cashitem_equipment import CharacterCashitemEquipment
from maplestory_openapi.api.msea.dto.character.character_symbol_equipment import CharacterSymbolEquipment
from maplestory_openapi.api.msea.dto.character.character_set_effect import CharacterSetEffect
from maplestory_openapi.api.msea.dto.character.character_beauty_equipment import CharacterBeautyEquipment
from maplestory_openapi.api.msea.dto.character.character_android_equipment import CharacterAndroidEquipment
from maplestory_openapi.api.msea.dto.character.character_pet_equipment import CharacterPetEquipment
from maplestory_openapi.api.msea.dto.character.character_skill import CharacterSkill
from maplestory_openapi.api.msea.dto.character.character_link_skill import CharacterLinkSkill
from maplestory_openapi.api.msea.dto.character.character_vmatrix import CharacterVMatrix
from maplestory_openapi.api.msea.dto.character.character_hexamatrix import CharacterHexaMatrix
from maplestory_openapi.api.msea.dto.character.character_hexamatrix_stat import CharacterHexaMatrixStat
from maplestory_openapi.api.msea.dto.character.character_dojang import CharacterDojang
from maplestory_openapi.api.msea.dto.character.character_image import CharacterImage

from maplestory_openapi.api.msea.dto.union.union import Union
from maplestory_openapi.api.msea.dto.union.union_artifact import UnionArtifact
from maplestory_openapi.api.msea.dto.union.union_raider import UnionRaider

from maplestory_openapi.api.msea.dto.guild.guild import Guild
from maplestory_openapi.api.msea.dto.guild.guild_basic import GuildBasic

from maplestory_openapi.api.msea.param.character_image_option import CharacterImageOption

from maplestory_openapi.api.common.maplestory_api import MapleStoryApi as BaseMapleStoryApi


class MapleStoryApi(BaseMapleStoryApi):

    def __init__(self, api_key:str, timeout: int = 5000):
        super().__init__(
            api_key=api_key,
            timezone='Asia/Singapore',
            sub_url='maplestorysea',
            timeout=timeout,
        )

    #region Character Information Retrieval

    async def get_character_id(self, character_name: str) -> Character:
        """
        Retrieves the character identifier (ocid).

        - MapleStory game data can be verified approximately 15 minutes after updates.
        - Data is available starting from April 20, 2025.
        - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
        - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
        - This API provides data for MapleStory SEA.

        Args:
            character_name (str): Character name
        """

        path = self.sub_url + '/v1/id'
        query = {
            'character_name': character_name,
        }
        r = await self.fetch(path, query)
        return Character(**r)

    async def get_character_basic(self, ocid: str, date: datetime | None = None) -> CharacterBasic:
        """
        Retrieves basic character information.

        - MapleStory game data can be verified approximately 15 minutes after updates.
        - Data is available starting from April 20, 2025.
        - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
        - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
        - This API provides data for MapleStory SEA.

        Args:
            ocid (str): Character identifier
            date (datetime or None): Reference date for query (SGT)
        """
        path = self.sub_url + '/v1/character/basic'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 4, 20)) if date is not None else None
        }
        r = await self.fetch(path, query)

        return CharacterBasic(**r)

    async def get_character_image(self, ocid: str, option: CharacterImageOption | None = None, date: datetime | None = None) -> CharacterBasic:
        """
        Retrieves character image information.

        - MapleStory game data can be verified approximately 15 minutes after updates.
        - Data is available starting from April 20, 2025.
        - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
        - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
        - This API provides data for MapleStory SEA.

        Args:
            ocid (str): Character identifier
            option (CharacterImageOption or None): Image options
            date (datetime or None): Reference date for query (SGT)
        """

        basic = await self.get_character_basic(ocid, date)
        path = basic.character_image.replace(self.BASE_URL, '')
        image_option = option if option is not None else CharacterImageOption()

        action = image_option.action
        emotion = image_option.emotion
        wmotion = image_option.wmotion
        action_frame = image_option.action_frame
        emotion_frame = image_option.emotion_frame
        width = image_option.width
        height = image_option.height
        x = image_option.x
        y = image_option.y

        query = {
            'action': action.value + '.' + str(action_frame),
            'emotion': emotion.value + '.' + str(emotion_frame),
            'wmotion': wmotion.value,
            'width': width,
            'height': height,
            'x': x,
            'y': y,
        }

        async with httpx.AsyncClient(timeout=self.timeout) as client:
            origin_task = client.get(
                f'{self.BASE_URL}{path}',
                headers={'x-nxopen-api-key': self.api_key},
            )
            image_task = client.get(
                f'{self.BASE_URL}{path}',
                params={k: v for k, v in query.items() if v is not None},
                headers={'x-nxopen-api-key': self.api_key},
            )
            origin_image_response, image_response = await asyncio.gather(origin_task, image_task)

        origin_image_mime_type = origin_image_response.headers.get('content-type')
        image_mime_type = image_response.headers.get('content-type')

        origin_image = base64.b64encode(origin_image_response.content).decode('utf-8')
        image = base64.b64encode(image_response.content).decode('utf-8')

        return CharacterImage(
            date=basic.date,
            origin_url=basic.character_image,
            origin_image=f"data:{origin_image_mime_type};base64,{origin_image}",
            image=f"data:{image_mime_type};base64,{image}",
            action=action,
            emotion=emotion,
            wmotion=wmotion,
            action_frame=action_frame,
            emotion_frame=emotion_frame,
            width=width,
            height=height,
            x=x,
            y=y,
        )

    async def get_character_popularity(self, ocid: str, date: datetime | None = None) -> CharacterPopularity:
        """
        Retrieves popularity information of a character.

        - MapleStory game data can be verified approximately 15 minutes after updates.
        - Data is available starting from April 20, 2025.
        - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
        - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
        - This API provides data for MapleStory SEA.

        Args:
            ocid (str): Character identifier
            date (datetime or None): Reference date for query (SGT)
        """
        path = self.sub_url + '/v1/character/popularity'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 4, 20)) if date is not None else None
        }
        r = await self.fetch(path, query)

        return CharacterPopularity(**r)

    async def get_character_stat(self, ocid: str, date: datetime | None = None) -> CharacterStat:
        """
        Retrieves comprehensive character stats information.

        - MapleStory game data can be verified approximately 15 minutes after updates.
        - Data is available starting from April 20, 2025.
        - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
        - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
        - This API provides data for MapleStory SEA.

        Args:
            ocid (str): Character identifier
            date (datetime or None): Reference date for query (SGT)
        """
        path = self.sub_url + '/v1/character/stat'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 4, 20)) if date is not None else None
        }
        r = await self.fetch(path, query)

        return CharacterStat(**r)

    async def get_character_hyper_stat(self, ocid: str, date: datetime | None = None) -> CharacterHyperStat:
        """
        Retrieves Hyper Stat information.

        - MapleStory game data can be verified approximately 15 minutes after updates.
        - Data is available starting from April 20, 2025.
        - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
        - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
        - This API provides data for MapleStory SEA.

        Args:
            ocid (str): Character identifier
            date (datetime or None): Reference date for query (SGT)
        """
        path = self.sub_url + '/v1/character/hyper-stat'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 4, 20)) if date is not None else None
        }
        r = await self.fetch(path, query)

        return CharacterHyperStat(**r)

    async def get_character_propensity(self, ocid: str, date: datetime | None = None) -> CharacterPropensity:
        """
        Retrieves traits information.

        - MapleStory game data can be verified approximately 15 minutes after updates.
        - Data is available starting from April 20, 2025.
        - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
        - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
        - This API provides data for MapleStory SEA.

        Args:
            ocid (str): Character identifier
            date (datetime or None): Reference date for query (SGT)
        """
        path = self.sub_url + '/v1/character/propensity'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 4, 20)) if date is not None else None
        }
        r = await self.fetch(path, query)

        return CharacterPropensity(**r)

    async def get_character_ability(self, ocid: str, date: datetime | None = None) -> CharacterAbility:
        """
        Retrieves Ability information.

        - MapleStory game data can be verified approximately 15 minutes after updates.
        - Data is available starting from April 20, 2025.
        - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
        - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
        - This API provides data for MapleStory SEA.

        Args:
            ocid (str): Character identifier
            date (datetime or None): Reference date for query (SGT)
        """
        path = self.sub_url + '/v1/character/ability'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 4, 20)) if date is not None else None
        }
        r = await self.fetch(path, query)

        return CharacterAbility(**r)

    async def get_character_item_equipment(self, ocid: str, date: datetime | None = None) -> CharacterItemEquipment:
        """
        Retrieves information about equipped equipment, excluding cash items.

        - MapleStory game data can be verified approximately 15 minutes after updates.
        - Data is available starting from April 20, 2025.
        - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
        - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
        - This API provides data for MapleStory SEA.

        Args:
            ocid (str): Character identifier
            date (datetime or None): Reference date for query (SGT)
        """
        path = self.sub_url + '/v1/character/item-equipment'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 4, 20)) if date is not None else None
        }
        r = await self.fetch(path, query)

        return CharacterItemEquipment(**r)

    async def get_character_cashitem_equipment(self, ocid: str, date: datetime | None = None) -> CharacterCashitemEquipment:
        """
        Retrieves equipped cash item information.

        - MapleStory game data can be verified approximately 15 minutes after updates.
        - Data is available starting from April 20, 2025.
        - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
        - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
        - This API provides data for MapleStory SEA.

        Args:
            ocid (str): Character identifier
            date (datetime or None): Reference date for query (SGT)
        """
        path = self.sub_url + '/v1/character/cashitem-equipment'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 4, 20)) if date is not None else None
        }
        r = await self.fetch(path, query)

        return CharacterCashitemEquipment(**r)

    async def get_character_symbol_equipment(self, ocid: str, date: datetime | None = None) -> CharacterSymbolEquipment:
        """
        Retrieves information about equipped symbols.

        - MapleStory game data can be verified approximately 15 minutes after updates.
        - Data is available starting from April 20, 2025.
        - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
        - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
        - This API provides data for MapleStory SEA.

        Args:
            ocid (str): Character identifier
            date (datetime or None): Reference date for query (SGT)
        """
        path = self.sub_url + '/v1/character/symbol-equipment'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 4, 20)) if date is not None else None
        }
        r = await self.fetch(path, query)
        return CharacterSymbolEquipment(**r)

    async def get_character_set_effect(self, ocid: str, date: datetime | None = None) -> CharacterSetEffect:
        """
        Retrieves information about equipped set item effects.

        - MapleStory game data can be verified approximately 15 minutes after updates.
        - Data is available starting from April 20, 2025.
        - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
        - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
        - This API provides data for MapleStory SEA.

        Args:
            ocid (str): Character identifier
            date (datetime or None): Reference date for query (SGT)
        """
        path = self.sub_url + '/v1/character/set-effect'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 4, 20)) if date is not None else None
        }
        r = await self.fetch(path, query)
        return CharacterSetEffect(**r)

    async def get_character_beauty_equipment(self, ocid: str, date: datetime | None = None) -> CharacterBeautyEquipment:
        """
        Retrieves information about equipped hair, face, and skin.

        - MapleStory game data can be verified approximately 15 minutes after updates.
        - Data is available starting from April 20, 2025.
        - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
        - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
        - This API provides data for MapleStory SEA.

        Args:
            ocid (str): Character identifier
            date (datetime or None): Reference date for query (SGT)
        """
        path = self.sub_url + '/v1/character/beauty-equipment'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 4, 20)) if date is not None else None
        }
        r = await self.fetch(path, query)
        return CharacterBeautyEquipment(**r)

    async def get_character_android_equipment(self, ocid: str, date: datetime | None = None) -> CharacterAndroidEquipment:
        """
        Retrieves equipped android information.

        - MapleStory game data can be verified approximately 15 minutes after updates.
        - Data is available starting from April 20, 2025.
        - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
        - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
        - This API provides data for MapleStory SEA.

        Args:
            ocid (str): Character identifier
            date (datetime or None): Reference date for query (SGT)
        """
        path = self.sub_url + '/v1/character/android-equipment'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 4, 20)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return CharacterAndroidEquipment(**r)

    async def get_character_pet_equipment(self, ocid: str, date: datetime | None = None) -> CharacterPetEquipment:
        """
        Retrieves information about equipped pets, including pet skills and equipment.

        - MapleStory game data can be verified approximately 15 minutes after updates.
        - Data is available starting from April 20, 2025.
        - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
        - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
        - This API provides data for MapleStory SEA.

        Args:
            ocid (str): Character identifier
            date (datetime or None): Reference date for query (SGT)
        """
        path = self.sub_url + '/v1/character/pet-equipment'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 4, 20)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return CharacterPetEquipment(**r)

    async def get_character_skill(self, ocid: str, character_skill_grade: str, date: datetime | None = None) -> CharacterSkill:
        """
        Retrieves information about character skills and Hyper Skills.

        - MapleStory game data can be verified approximately 15 minutes after updates.
        - Data is available starting from April 20, 2025.
        - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
        - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
        - This API provides data for MapleStory SEA.

        Args:
            ocid (str): Character identifier
            date (datetime or None): Reference date for query (SGT)
            character_skill_grade(str): Job advancement tier to query (Available values: https://openapi.nexon.com/game/maplestorysea/?id=45)
        """
        path = self.sub_url + '/v1/character/skill'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 4, 20)) if date is not None else None,
            'character_skill_grade': character_skill_grade,
        }
        r = await self.fetch(path, query)
        return CharacterSkill(**r)

    async def get_character_link_skill(self, ocid: str, date: datetime | None = None) -> CharacterLinkSkill:
        """
        Retrieves information about equipped Link Skills.

        - MapleStory game data can be verified approximately 15 minutes after updates.
        - Data is available starting from April 20, 2025.
        - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
        - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
        - This API provides data for MapleStory SEA.

        Args:
            ocid (str): Character identifier
            date (datetime or None): Reference date for query (SGT)
        """
        path = self.sub_url + '/v1/character/link-skill'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 4, 20)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return CharacterLinkSkill(**r)

    async def get_character_vmatrix(self, ocid: str, date: datetime | None = None) -> CharacterVMatrix:
        """
        Retrieves V Matrix slot and equipped Node information.

        - MapleStory game data can be verified approximately 15 minutes after updates.
        - Data is available starting from April 20, 2025.
        - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
        - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
        - This API provides data for MapleStory SEA.

        Args:
            ocid (str): Character identifier
            date (datetime or None): Reference date for query (SGT)
        """
        path = self.sub_url + '/v1/character/vmatrix'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 4, 20)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return CharacterVMatrix(**r)

    async def get_character_hexamatrix(self, ocid: str, date: datetime | None = None) -> CharacterHexaMatrix:
        """
        Retrieves information about HEXA Nodes equipped in the HEXA Matrix.

        - MapleStory game data can be verified approximately 15 minutes after updates.
        - Data is available starting from April 20, 2025.
        - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
        - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
        - This API provides data for MapleStory SEA.

        Args:
            ocid (str): Character identifier
            date (datetime or None): Reference date for query (SGT)
        """
        path = self.sub_url + '/v1/character/hexamatrix'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 4, 20)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return CharacterHexaMatrix(**r)

    async def get_character_hexamatrix_stat(self, ocid: str, date: datetime | None = None) -> CharacterHexaMatrixStat:
        """
        Retrieves information about HEXA stats configured in the HEXA Matrix.

        - MapleStory game data can be verified approximately 15 minutes after updates.
        - Data is available starting from April 20, 2025.
        - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
        - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
        - This API provides data for MapleStory SEA.

        Args:
            ocid (str): Character identifier
            date (datetime or None): Reference date for query (SGT)
        """
        path = self.sub_url + '/v1/character/hexamatrix-stat'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 4, 20)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return CharacterHexaMatrixStat(**r)

    async def get_character_dojang(self, ocid: str, date: datetime | None = None) -> CharacterDojang:
        """
        Retrieves the character's highest record information in Mu Lung Garden.

        - MapleStory game data can be verified approximately 15 minutes after updates.
        - Data is available starting from April 20, 2025.
        - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
        - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
        - This API provides data for MapleStory SEA.

        Args:
            ocid (str): Character identifier
            date (datetime or None): Reference date for query (SGT)
        """
        path = self.sub_url + '/v1/character/dojang'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 4, 20)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return CharacterDojang(**r)

    #endregion

    #region Union Information Retrieval

    async def get_union(self, ocid: str, date: datetime | None = None) -> Union:
        """
        Retrieves Union level and Union rank information.

        - MapleStory game data can be verified approximately 15 minutes after updates.
        - Data is available starting from April 20, 2025.
        - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
        - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
        - This API provides data for MapleStory SEA.

        Args:
            ocid (str): Character identifier
            date (datetime or None): Reference date for query (SGT)
        """
        path = self.sub_url + '/v1/user/union'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 4, 20)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return Union(**r)

    async def get_union_raider(self, ocid: str, date: datetime | None = None) -> UnionRaider:
        """
        Retrieves detailed information about raid member effects and capture effects deployed in the Union.

        - MapleStory game data can be verified approximately 15 minutes after updates.
        - Data is available starting from April 20, 2025.
        - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
        - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
        - This API provides data for MapleStory SEA.

        Args:
            ocid (str): Character identifier
            date (datetime or None): Reference date for query (SGT)
        """
        path = self.sub_url + '/v1/user/union-raider'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 4, 20)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return UnionRaider(**r)

    async def get_union_artifact(self, ocid: str, date: datetime | None = None) -> UnionArtifact:
        """
        Retrieves Union Artifact information.

        - MapleStory game data can be verified approximately 15 minutes after updates.
        - Data is available starting from April 20, 2025.
        - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
        - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
        - This API provides data for MapleStory SEA.

        Args:
            ocid (str): Character identifier
            date (datetime or None): Reference date for query (SGT)
        """
        path = self.sub_url + '/v1/user/union-artifact'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 4, 20)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return UnionArtifact(**r)

    #endregion

    #region Guild Information Retrieval

    async def get_guild_id(self, guild_name: str, world_name: str) -> Guild:
        """
        Retrieves information for the guild identifier (oguild_id).

        - MapleStory game data can be verified approximately 15 minutes after updates.
        - Data is available starting from April 20, 2025.
        - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
        - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
        - This API provides data for MapleStory SEA.

        Args:
            guild_name (str): Guild name
            world_name (str): World name (Available values: https://openapi.nexon.com/game/maplestorysea/?id=47)
        """
        path = self.sub_url + '/v1/guild/id'
        query = {
            'guild_name': guild_name,
            'world_name': world_name,
        }
        r = await self.fetch(path, query)
        return Guild(**r)

    async def get_guild_basic(self, oguid_id: str, date: datetime | None = None) -> GuildBasic:
        """
        Retrieves guild basic information.

        - MapleStory game data can be verified approximately 15 minutes after updates.
        - Data is available starting from April 20, 2025.
        - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
        - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
        - This API provides data for MapleStory SEA.

        Args:
            oguild_id (str): Guild identifier
            date(datetime): Reference date for query (SGT)
        """
        path = self.sub_url + '/v1/guild/basic'
        query = {
            'oguild_id': oguid_id,
            'date': self._to_date_string(date, datetime(2025, 4, 20)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return GuildBasic(**r)

    #endregion

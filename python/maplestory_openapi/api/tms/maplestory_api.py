import base64
from datetime import datetime
import httpx
import asyncio

from maplestory_openapi.api.tms.dto.character.character import Character
from maplestory_openapi.api.tms.dto.character.character_basic import CharacterBasic
from maplestory_openapi.api.tms.dto.character.character_popularity import CharacterPopularity
from maplestory_openapi.api.tms.dto.character.character_stat import CharacterStat
from maplestory_openapi.api.tms.dto.character.character_hyper_stat import CharacterHyperStat
from maplestory_openapi.api.tms.dto.character.character_propensity import CharacterPropensity
from maplestory_openapi.api.tms.dto.character.character_ability import CharacterAbility
from maplestory_openapi.api.tms.dto.character.character_item_equipment import CharacterItemEquipment
from maplestory_openapi.api.tms.dto.character.character_cashitem_equipment import CharacterCashitemEquipment
from maplestory_openapi.api.tms.dto.character.character_symbol_equipment import CharacterSymbolEquipment
from maplestory_openapi.api.tms.dto.character.character_set_effect import CharacterSetEffect
from maplestory_openapi.api.tms.dto.character.character_beauty_equipment import CharacterBeautyEquipment
from maplestory_openapi.api.tms.dto.character.character_android_equipment import CharacterAndroidEquipment
from maplestory_openapi.api.tms.dto.character.character_pet_equipment import CharacterPetEquipment
from maplestory_openapi.api.tms.dto.character.character_skill import CharacterSkill
from maplestory_openapi.api.tms.dto.character.character_link_skill import CharacterLinkSkill
from maplestory_openapi.api.tms.dto.character.character_vmatrix import CharacterVMatrix
from maplestory_openapi.api.tms.dto.character.character_hexamatrix import CharacterHexaMatrix
from maplestory_openapi.api.tms.dto.character.character_hexamatrix_stat import CharacterHexaMatrixStat
from maplestory_openapi.api.tms.dto.character.character_dojang import CharacterDojang
from maplestory_openapi.api.tms.dto.character.character_image import CharacterImage

from maplestory_openapi.api.tms.dto.union.union import Union
from maplestory_openapi.api.tms.dto.union.union_artifact import UnionArtifact
from maplestory_openapi.api.tms.dto.union.union_raider import UnionRaider

from maplestory_openapi.api.tms.dto.guild.guild import Guild
from maplestory_openapi.api.tms.dto.guild.guild_basic import GuildBasic

from maplestory_openapi.api.tms.param.character_image_option import CharacterImageOption

from maplestory_openapi.api.common.maplestory_api import MapleStoryApi as BaseMapleStoryApi


class MapleStoryApi(BaseMapleStoryApi):

    def __init__(self, api_key:str, timeout: int = 5000):
        super().__init__(
            api_key=api_key,
            timezone='Asia/Taipei',
            sub_url='maplestorytw',
            timeout=timeout,
        )

    #region 檢視角色資訊

    async def get_character_id(self, character_name: str) -> Character:
        """
        檢視角色辨識器 (OCID)。

        - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
        - 您可以從 2025 年 10 月 15 日起搜尋資料。
        - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
        - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
        - 此 API 提供來自楓之谷台灣的資料。

        Args:
            character_name (str): 角色名稱
        """

        path = self.sub_url + '/v1/id'
        query = {
            'character_name': character_name,
        }
        r = await self.fetch(path, query)
        return Character(**r)

    async def get_character_basic(self, ocid: str, date: datetime | None = None) -> CharacterBasic:
        """
        檢視基本資訊。

        - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
        - 您可以從 2025 年 10 月 15 日起搜尋資料。
        - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
        - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
        - 此 API 提供來自楓之谷台灣的資料。

        Args:
            ocid (str): 角色辨識器
            date (datetime or None): 要搜尋的日期 (TST)
        """
        path = self.sub_url + '/v1/character/basic'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 10, 15)) if date is not None else None
        }
        r = await self.fetch(path, query)

        return CharacterBasic(**r)

    async def get_character_image(self, ocid: str, option: CharacterImageOption | None = None, date: datetime | None = None) -> CharacterBasic:
        """
        檢視角色外型圖片資訊。

        - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
        - 您可以從 2025 年 10 月 15 日起搜尋資料。
        - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
        - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
        - 此 API 提供來自楓之谷台灣的資料。

        Args:
            ocid (str): 角色辨識器
            option (CharacterImageOption or None): 圖像選項
            date (datetime or None): 要搜尋的日期 (TST)
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
        檢視名聲資訊。

        - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
        - 您可以從 2025 年 10 月 15 日起搜尋資料。
        - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
        - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
        - 此 API 提供來自楓之谷台灣的資料。

        Args:
            ocid (str): 角色辨識器
            date (datetime or None): 要搜尋的日期 (TST)
        """
        path = self.sub_url + '/v1/character/popularity'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 10, 15)) if date is not None else None
        }
        r = await self.fetch(path, query)

        return CharacterPopularity(**r)

    async def get_character_stat(self, ocid: str, date: datetime | None = None) -> CharacterStat:
        """
        檢視綜合能力值資訊。

        - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
        - 您可以從 2025 年 10 月 15 日起搜尋資料。
        - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
        - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
        - 此 API 提供來自楓之谷台灣的資料。

        Args:
            ocid (str): 角色辨識器
            date (datetime or None): 要搜尋的日期 (TST)
        """
        path = self.sub_url + '/v1/character/stat'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 10, 15)) if date is not None else None
        }
        r = await self.fetch(path, query)

        return CharacterStat(**r)

    async def get_character_hyper_stat(self, ocid: str, date: datetime | None = None) -> CharacterHyperStat:
        """
        檢視極限屬性資訊。

        - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
        - 您可以從 2025 年 10 月 15 日起搜尋資料。
        - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
        - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
        - 此 API 提供來自楓之谷台灣的資料。

        Args:
            ocid (str): 角色辨識器
            date (datetime or None): 要搜尋的日期 (TST)
        """
        path = self.sub_url + '/v1/character/hyper-stat'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 10, 15)) if date is not None else None
        }
        r = await self.fetch(path, query)

        return CharacterHyperStat(**r)

    async def get_character_propensity(self, ocid: str, date: datetime | None = None) -> CharacterPropensity:
        """
        檢視性向資訊。

        - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
        - 您可以從 2025 年 10 月 15 日起搜尋資料。
        - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
        - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
        - 此 API 提供來自楓之谷台灣的資料。

        Args:
            ocid (str): 角色辨識器
            date (datetime or None): 要搜尋的日期 (TST)
        """
        path = self.sub_url + '/v1/character/propensity'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 10, 15)) if date is not None else None
        }
        r = await self.fetch(path, query)

        return CharacterPropensity(**r)

    async def get_character_ability(self, ocid: str, date: datetime | None = None) -> CharacterAbility:
        """
        檢視能力資訊。

        - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
        - 您可以從 2025 年 10 月 15 日起搜尋資料。
        - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
        - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
        - 此 API 提供來自楓之谷台灣的資料。

        Args:
            ocid (str): 角色辨識器
            date (datetime or None): 要搜尋的日期 (TST)
        """
        path = self.sub_url + '/v1/character/ability'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 10, 15)) if date is not None else None
        }
        r = await self.fetch(path, query)

        return CharacterAbility(**r)

    async def get_character_item_equipment(self, ocid: str, date: datetime | None = None) -> CharacterItemEquipment:
        """
        檢視已裝備道具資訊 (不含現金道具)。

        - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
        - 您可以從 2025 年 10 月 15 日起搜尋資料。
        - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
        - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
        - 此 API 提供來自楓之谷台灣的資料。

        Args:
            ocid (str): 角色辨識器
            date (datetime or None): 要搜尋的日期 (TST)
        """
        path = self.sub_url + '/v1/character/item-equipment'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 10, 15)) if date is not None else None
        }
        r = await self.fetch(path, query)

        return CharacterItemEquipment(**r)

    async def get_character_cashitem_equipment(self, ocid: str, date: datetime | None = None) -> CharacterCashitemEquipment:
        """
        檢視已裝備現金道具資訊。

        - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
        - 您可以從 2025 年 10 月 15 日起搜尋資料。
        - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
        - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
        - 此 API 提供來自楓之谷台灣的資料。

        Args:
            ocid (str): 角色辨識器
            date (datetime or None): 要搜尋的日期 (TST)
        """
        path = self.sub_url + '/v1/character/cashitem-equipment'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 10, 15)) if date is not None else None
        }
        r = await self.fetch(path, query)

        return CharacterCashitemEquipment(**r)

    async def get_character_symbol_equipment(self, ocid: str, date: datetime | None = None) -> CharacterSymbolEquipment:
        """
        檢視已裝備符文資訊。

        - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
        - 您可以從 2025 年 10 月 15 日起搜尋資料。
        - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
        - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
        - 此 API 提供來自楓之谷台灣的資料。

        Args:
            ocid (str): 角色辨識器
            date (datetime or None): 要搜尋的日期 (TST)
        """
        path = self.sub_url + '/v1/character/symbol-equipment'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 10, 15)) if date is not None else None
        }
        r = await self.fetch(path, query)
        return CharacterSymbolEquipment(**r)

    async def get_character_set_effect(self, ocid: str, date: datetime | None = None) -> CharacterSetEffect:
        """
        檢視目前套用的套裝效果資訊。

        - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
        - 您可以從 2025 年 10 月 15 日起搜尋資料。
        - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
        - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
        - 此 API 提供來自楓之谷台灣的資料。

        Args:
            ocid (str): 角色辨識器
            date (datetime or None): 要搜尋的日期 (TST)
        """
        path = self.sub_url + '/v1/character/set-effect'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 10, 15)) if date is not None else None
        }
        r = await self.fetch(path, query)
        return CharacterSetEffect(**r)

    async def get_character_beauty_equipment(self, ocid: str, date: datetime | None = None) -> CharacterBeautyEquipment:
        """
        檢視目前已裝備的髮型、臉型與膚色資訊。

        - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
        - 您可以從 2025 年 10 月 15 日起搜尋資料。
        - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
        - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
        - 此 API 提供來自楓之谷台灣的資料。

        Args:
            ocid (str): 角色辨識器
            date (datetime or None): 要搜尋的日期 (TST)
        """
        path = self.sub_url + '/v1/character/beauty-equipment'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 10, 15)) if date is not None else None
        }
        r = await self.fetch(path, query)
        return CharacterBeautyEquipment(**r)

    async def get_character_android_equipment(self, ocid: str, date: datetime | None = None) -> CharacterAndroidEquipment:
        """
        檢視已裝備機器人資訊。

        - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
        - 您可以從 2025 年 10 月 15 日起搜尋資料。
        - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
        - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
        - 此 API 提供來自楓之谷台灣的資料。

        Args:
            ocid (str): 角色辨識器
            date (datetime or None): 要搜尋的日期 (TST)
        """
        path = self.sub_url + '/v1/character/android-equipment'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 10, 15)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return CharacterAndroidEquipment(**r)

    async def get_character_pet_equipment(self, ocid: str, date: datetime | None = None) -> CharacterPetEquipment:
        """
        檢視已裝備寵物、寵物技能與寵物道具資訊。

        - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
        - 您可以從 2025 年 10 月 15 日起搜尋資料。
        - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
        - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
        - 此 API 提供來自楓之谷台灣的資料。

        Args:
            ocid (str): 角色辨識器
            date (datetime or None): 要搜尋的日期 (TST)
        """
        path = self.sub_url + '/v1/character/pet-equipment'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 10, 15)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return CharacterPetEquipment(**r)

    async def get_character_skill(self, ocid: str, character_skill_grade: str, date: datetime | None = None) -> CharacterSkill:
        """
        檢視角色技能與超技能資訊。

        - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
        - 您可以從 2025 年 10 月 15 日起搜尋資料。
        - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
        - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
        - 此 API 提供來自楓之谷台灣的資料。

        Args:
            ocid (str): 角色辨識器
            date (datetime or None): 要搜尋的日期 (TST)
            character_skill_grade(str): 您要檢視的轉職階段 (Available values: https://openapi.nexon.com/game/maplestorytw/?id=49)
        """
        path = self.sub_url + '/v1/character/skill'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 10, 15)) if date is not None else None,
            'character_skill_grade': character_skill_grade,
        }
        r = await self.fetch(path, query)
        return CharacterSkill(**r)

    async def get_character_link_skill(self, ocid: str, date: datetime | None = None) -> CharacterLinkSkill:
        """
        檢視已裝備連結技能資訊。

        - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
        - 您可以從 2025 年 10 月 15 日起搜尋資料。
        - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
        - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
        - 此 API 提供來自楓之谷台灣的資料。

        Args:
            ocid (str): 角色辨識器
            date (datetime or None): 要搜尋的日期 (TST)
        """
        path = self.sub_url + '/v1/character/link-skill'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 10, 15)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return CharacterLinkSkill(**r)

    async def get_character_vmatrix(self, ocid: str, date: datetime | None = None) -> CharacterVMatrix:
        """
        檢視 V 矩陣欄位資訊與已裝備 V 核心資訊。

        - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
        - 您可以從 2025 年 10 月 15 日起搜尋資料。
        - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
        - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
        - 此 API 提供來自楓之谷台灣的資料。

        Args:
            ocid (str): 角色辨識器
            date (datetime or None): 要搜尋的日期 (TST)
        """
        path = self.sub_url + '/v1/character/vmatrix'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 10, 15)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return CharacterVMatrix(**r)

    async def get_character_hexamatrix(self, ocid: str, date: datetime | None = None) -> CharacterHexaMatrix:
        """
        檢視已裝備於 HEXA 矩陣的 HEXA 核心資訊。

        - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
        - 您可以從 2025 年 10 月 15 日起搜尋資料。
        - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
        - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
        - 此 API 提供來自楓之谷台灣的資料。

        Args:
            ocid (str): 角色辨識器
            date (datetime or None): 要搜尋的日期 (TST)
        """
        path = self.sub_url + '/v1/character/hexamatrix'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 10, 15)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return CharacterHexaMatrix(**r)

    async def get_character_hexamatrix_stat(self, ocid: str, date: datetime | None = None) -> CharacterHexaMatrixStat:
        """
        檢視設定於 HEXA 矩陣中的 HEXA 屬性資訊。

        - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
        - 您可以從 2025 年 10 月 15 日起搜尋資料。
        - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
        - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
        - 此 API 提供來自楓之谷台灣的資料。

        Args:
            ocid (str): 角色辨識器
            date (datetime or None): 要搜尋的日期 (TST)
        """
        path = self.sub_url + '/v1/character/hexamatrix-stat'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 10, 15)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return CharacterHexaMatrixStat(**r)

    async def get_character_dojang(self, ocid: str, date: datetime | None = None) -> CharacterDojang:
        """
        檢視角色在武陵道場的最高紀錄資訊。

        - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
        - 您可以從 2025 年 10 月 15 日起搜尋資料。
        - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
        - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
        - 此 API 提供來自楓之谷台灣的資料。

        Args:
            ocid (str): 角色辨識器
            date (datetime or None): 要搜尋的日期 (TST)
        """
        path = self.sub_url + '/v1/character/dojang'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 10, 15)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return CharacterDojang(**r)

    #endregion

    #region 檢視聯盟資訊

    async def get_union(self, ocid: str, date: datetime | None = None) -> Union:
        """
        檢視戰地等級與戰地階級資訊。

        - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
        - 您可以從 2025 年 10 月 15 日起搜尋資料。
        - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
        - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
        - 此 API 提供來自楓之谷台灣的資料。

        Args:
            ocid (str): 角色辨識器
            date (datetime or None): 要搜尋的日期 (TST)
        """
        path = self.sub_url + '/v1/user/union'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 10, 15)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return Union(**r)

    async def get_union_raider(self, ocid: str, date: datetime | None = None) -> UnionRaider:
        """
        檢視詳細資訊，例如派遣至聯盟的攻擊單位成員效果，以及攻擊單位佔領效果。

        - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
        - 您可以從 2025 年 10 月 15 日起搜尋資料。
        - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
        - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
        - 此 API 提供來自楓之谷台灣的資料。

        Args:
            ocid (str): 角色辨識器
            date (datetime or None): 要搜尋的日期 (TST)
        """
        path = self.sub_url + '/v1/user/union-raider'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 10, 15)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return UnionRaider(**r)

    async def get_union_artifact(self, ocid: str, date: datetime | None = None) -> UnionArtifact:
        """
        檢視戰地神器資訊。

        - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
        - 您可以從 2025 年 10 月 15 日起搜尋資料。
        - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
        - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
        - 此 API 提供來自楓之谷台灣的資料。

        Args:
            ocid (str): 角色辨識器
            date (datetime or None): 要搜尋的日期 (TST)
        """
        path = self.sub_url + '/v1/user/union-artifact'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 10, 15)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return UnionArtifact(**r)

    #endregion

    #region 檢視公會資訊

    async def get_guild_id(self, guild_name: str, world_name: str) -> Guild:
        """
        檢視公會識別碼 (oguild_id) 資訊。

        - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
        - 您可以從 2025 年 10 月 15 日起搜尋資料。
        - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
        - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
        - 此 API 提供來自楓之谷台灣的資料。

        Args:
            guild_name (str): 公會名稱
            world_name (str): 世界名稱 (Available values: https://openapi.nexon.com/game/maplestorytw/?id=51)
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
        檢視公會基本資訊。

        - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
        - 您可以從 2025 年 10 月 15 日起搜尋資料。
        - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
        - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
        - 此 API 提供來自楓之谷台灣的資料。

        Args:
            oguild_id (str): 公會識別碼
            date(datetime): 要搜尋的日期 (TST)
        """
        path = self.sub_url + '/v1/guild/basic'
        query = {
            'oguild_id': oguid_id,
            'date': self._to_date_string(date, datetime(2025, 10, 15)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return GuildBasic(**r)

    #endregion

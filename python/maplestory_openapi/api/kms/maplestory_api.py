import base64
from datetime import datetime
import httpx
import asyncio

from maplestory_openapi.api.kms.dto.character.character import Character
from maplestory_openapi.api.kms.dto.character.character_basic import CharacterBasic
from maplestory_openapi.api.kms.dto.character.character_popularity import CharacterPopularity
from maplestory_openapi.api.kms.dto.character.character_stat import CharacterStat
from maplestory_openapi.api.kms.dto.character.character_other_stat import CharacterOtherStat
from maplestory_openapi.api.kms.dto.character.character_ring_exchange_skill_equipment import CharacterRingExchangeSkillEquipment
from maplestory_openapi.api.kms.dto.character.character_hyper_stat import CharacterHyperStat
from maplestory_openapi.api.kms.dto.character.character_propensity import CharacterPropensity
from maplestory_openapi.api.kms.dto.character.character_ability import CharacterAbility
from maplestory_openapi.api.kms.dto.character.character_item_equipment import CharacterItemEquipment
from maplestory_openapi.api.kms.dto.character.character_cashitem_equipment import CharacterCashitemEquipment
from maplestory_openapi.api.kms.dto.character.character_symbol_equipment import CharacterSymbolEquipment
from maplestory_openapi.api.kms.dto.character.character_set_effect import CharacterSetEffect
from maplestory_openapi.api.kms.dto.character.character_beauty_equipment import CharacterBeautyEquipment
from maplestory_openapi.api.kms.dto.character.character_android_equipment import CharacterAndroidEquipment
from maplestory_openapi.api.kms.dto.character.character_pet_equipment import CharacterPetEquipment
from maplestory_openapi.api.kms.dto.character.character_skill import CharacterSkill
from maplestory_openapi.api.kms.dto.character.character_link_skill import CharacterLinkSkill
from maplestory_openapi.api.kms.dto.character.character_vmatrix import CharacterVMatrix
from maplestory_openapi.api.kms.dto.character.character_hexamatrix import CharacterHexaMatrix
from maplestory_openapi.api.kms.dto.character.character_hexamatrix_stat import CharacterHexaMatrixStat
from maplestory_openapi.api.kms.dto.character.character_dojang import CharacterDojang
from maplestory_openapi.api.kms.dto.character.character_image import CharacterImage

from maplestory_openapi.api.kms.dto.union.union import Union
from maplestory_openapi.api.kms.dto.union.union_artifact import UnionArtifact
from maplestory_openapi.api.kms.dto.union.union_champion import UnionChampion
from maplestory_openapi.api.kms.dto.union.union_raider import UnionRaider

from maplestory_openapi.api.kms.dto.guild.guild import Guild
from maplestory_openapi.api.kms.dto.guild.guild_basic import GuildBasic

from maplestory_openapi.api.kms.dto.history.cube_history import CubeHistory
from maplestory_openapi.api.kms.dto.history.potential_history import PotentialHistory
from maplestory_openapi.api.kms.dto.history.starforce_history import StarforceHistory

from maplestory_openapi.api.kms.dto.ranking.overall_ranking import OverallRanking
from maplestory_openapi.api.kms.dto.ranking.guild_ranking import GuildRanking
from maplestory_openapi.api.kms.dto.ranking.dojang_ranking import DojangRanking
from maplestory_openapi.api.kms.dto.ranking.union_ranking import UnionRanking
from maplestory_openapi.api.kms.dto.ranking.theseed_ranking import TheSeedRanking
from maplestory_openapi.api.kms.dto.ranking.achievement_ranking import AchievementRanking

from maplestory_openapi.api.kms.dto.notice.cashshop_notice_detail import CashshopNoticeDetail
from maplestory_openapi.api.kms.dto.notice.cashshop_notice_list import CashshopNoticeList
from maplestory_openapi.api.kms.dto.notice.event_notice_detail import EventNoticeDetail
from maplestory_openapi.api.kms.dto.notice.event_notice_list import EventNoticeList
from maplestory_openapi.api.kms.dto.notice.notice_detail import NoticeDetail
from maplestory_openapi.api.kms.dto.notice.notice_list import NoticeList
from maplestory_openapi.api.kms.dto.notice.update_notice_detail import UpdateNoticeDetail
from maplestory_openapi.api.kms.dto.notice.update_notice_list import UpdateNoticeList

from maplestory_openapi.api.kms.dto.user.achievement import Achievement
from maplestory_openapi.api.kms.dto.user.character_list import CharacterList

from maplestory_openapi.api.kms.param.character_image_option import CharacterImageOption

from maplestory_openapi.api.common.maplestory_api import MapleStoryApi as BaseMapleStoryApi


class MapleStoryApi(BaseMapleStoryApi):

    def __init__(self, api_key:str, timeout: int = 5000):
        super().__init__(
            api_key=api_key,
            timezone='Asia/Seoul',
            sub_url='maplestory',
            timeout=timeout,
        )

    #region 계정 정보 조회

    async def get_character_list(self) -> CharacterList:
        """
        계정의 보유 캐릭터 목록을 조회합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
        """

        path = self.sub_url + '/v1/character/list'
        query = {}
        r = await self.fetch(path, query)
        return CharacterList(**r)

    async def get_achievement(self) -> Achievement:
        """
        계정의 업적 정보를 조회합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
        """

        path = self.sub_url + '/v1/user/achievement'
        query = {}
        r = await self.fetch(path, query)
        return Achievement(**r)

    #endregion

    #region 캐릭터 정보 조회

    async def get_character_id(self, character_name: str) -> Character:
        """
        캐릭터 식별자를 조회합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        Args:
            character_name (str): 캐릭터 이름
        """

        path = self.sub_url + '/v1/id'
        query = {
            'character_name': character_name,
        }
        r = await self.fetch(path, query)
        return Character(**r)

    async def get_character_basic(self, ocid: str, date: datetime | None = None) -> CharacterBasic:
        """
        기본 정보를 조회합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        Args:
            ocid(str): 캐릭터 식별자
            date(datetime or None): 조회 기준일 (KST)
        """
        path = self.sub_url + '/v1/character/basic'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2023, 12, 21)) if date is not None else None
        }
        r = await self.fetch(path, query)

        return CharacterBasic(**r)

    async def get_character_image(self, ocid: str, option: CharacterImageOption | None = None, date: datetime | None = None) -> CharacterBasic:
        """
        캐릭터 외형 이미지 정보를 조회합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        Args:
            ocid(str): 캐릭터 식별자
            option(CharacterImageOption or None): 캐릭터 외형 파라미터
            date(datetime or None): 조회 기준일 (KST)
        """

        basic = await self.get_character_basic(ocid, date)
        path = basic.character_image.replace(self.BASE_URL, '')
        image_option = option if option is not None else CharacterImageOption()

        action = image_option.action
        emotion = image_option.emotion
        wmotion = image_option.wmotion
        action_frame = image_option.action_frame
        emotion_frame = image_option.emotion_frame

        query = {
            'action': action.value + '.' + str(action_frame),
            'emotion': emotion.value + '.' + str(emotion_frame),
            'wmotion': wmotion.value,
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
            width=300,
            height=300,
            x=150,
            y=200,
        )

    async def get_character_popularity(self, ocid: str, date: datetime | None = None) -> CharacterPopularity:
        """
        인기도 정보를 조회합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        Args:
            ocid(str): 캐릭터 식별자
            date(datetime or None): 조회 기준일 (KST)
        """
        path = self.sub_url + '/v1/character/popularity'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2023, 12, 21)) if date is not None else None
        }
        r = await self.fetch(path, query)

        return CharacterPopularity(**r)

    async def get_character_stat(self, ocid: str, date: datetime | None = None) -> CharacterStat:
        """
        종합능력치 정보를 조회합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        Args:
            ocid(str): 캐릭터 식별자
            date(datetime or None): 조회 기준일 (KST)
        """
        path = self.sub_url + '/v1/character/stat'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2023, 12, 21)) if date is not None else None
        }
        r = await self.fetch(path, query)

        return CharacterStat(**r)

    async def get_character_hyper_stat(self, ocid: str, date: datetime | None = None) -> CharacterHyperStat:
        """
        하이퍼스탯 정보를 조회합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        Args:
            ocid(str): 캐릭터 식별자
            date(datetime or None): 조회 기준일 (KST)
        """
        path = self.sub_url + '/v1/character/hyper-stat'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2023, 12, 21)) if date is not None else None
        }
        r = await self.fetch(path, query)

        return CharacterHyperStat(**r)

    async def get_character_propensity(self, ocid: str, date: datetime | None = None) -> CharacterPropensity:
        """
        성향 정보를 조회합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        Args:
            ocid(str): 캐릭터 식별자
            date(datetime or None): 조회 기준일 (KST)
        """
        path = self.sub_url + '/v1/character/propensity'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2023, 12, 21)) if date is not None else None
        }
        r = await self.fetch(path, query)

        return CharacterPropensity(**r)

    async def get_character_ability(self, ocid: str, date: datetime | None = None) -> CharacterAbility:
        """
        어빌리티 정보를 조회합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        Args:
            ocid(str): 캐릭터 식별자
            date(datetime or None): 조회 기준일 (KST)
        """
        path = self.sub_url + '/v1/character/ability'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2023, 12, 21)) if date is not None else None
        }
        r = await self.fetch(path, query)

        return CharacterAbility(**r)

    async def get_character_item_equipment(self, ocid: str, date: datetime | None = None) -> CharacterItemEquipment:
        """
        장착한 장비 중 캐시 장비를 제외한 나머지 장비 정보를 조회합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        Args:
            ocid(str): 캐릭터 식별자
            date(datetime or None): 조회 기준일 (KST)
        """
        path = self.sub_url + '/v1/character/item-equipment'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2023, 12, 21)) if date is not None else None
        }
        r = await self.fetch(path, query)

        return CharacterItemEquipment(**r)

    async def get_character_cashitem_equipment(self, ocid: str, date: datetime | None = None) -> CharacterCashitemEquipment:
        """
        장착한 캐시 장비 정보를 조회합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        Args:
            ocid(str): 캐릭터 식별자
            date(datetime or None): 조회 기준일 (KST)
        """
        path = self.sub_url + '/v1/character/cashitem-equipment'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2023, 12, 21)) if date is not None else None
        }
        r = await self.fetch(path, query)

        return CharacterCashitemEquipment(**r)

    async def get_character_symbol_equipment(self, ocid: str, date: datetime | None = None) -> CharacterSymbolEquipment:
        """
        장착한 심볼 정보를 조회합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        Args:
            ocid(str): 캐릭터 식별자
            date(datetime or None): 조회 기준일 (KST)
        """
        path = self.sub_url + '/v1/character/symbol-equipment'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2023, 12, 21)) if date is not None else None
        }
        r = await self.fetch(path, query)
        return CharacterSymbolEquipment(**r)

    async def get_character_set_effect(self, ocid: str, date: datetime | None = None) -> CharacterSetEffect:
        """
        적용받고 있는 세트 효과 정보를 조회합니다

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시기 바랍니다.

        Args:
            ocid(str): 캐릭터 식별자
            date(datetime or None): 조회 기준일 (KST)
        """
        path = self.sub_url + '/v1/character/set-effect'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2023, 12, 21)) if date is not None else None
        }
        r = await self.fetch(path, query)
        return CharacterSetEffect(**r)

    async def get_character_beauty_equipment(self, ocid: str, date: datetime | None = None) -> CharacterBeautyEquipment:
        """
        캐릭터 헤어, 성형, 피부 정보를 조회합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시기 바랍니다.

        Args:
            ocid(str): 캐릭터 식별자
            date(datetime or None): 조회 기준일 (KST)
        """
        path = self.sub_url + '/v1/character/beauty-equipment'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2023, 12, 21)) if date is not None else None
        }
        r = await self.fetch(path, query)
        return CharacterBeautyEquipment(**r)

    async def get_character_android_equipment(self, ocid: str, date: datetime | None = None) -> CharacterAndroidEquipment:
        """
        장착한 안드로이드 정보를 조회합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시기 바랍니다.

        Args:
            ocid(str): 캐릭터 식별자
            date(datetime or None): 조회 기준일 (KST)
        """
        path = self.sub_url + '/v1/character/android-equipment'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2023, 12, 21)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return CharacterAndroidEquipment(**r)

    async def get_character_pet_equipment(self, ocid: str, date: datetime | None = None) -> CharacterPetEquipment:
        """
        장착한 펫 및 펫 스킬, 장비 정보를 조회합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시기 바랍니다.

        Args:
            ocid(str): 캐릭터 식별자
            date(datetime or None): 조회 기준일 (KST)
        """
        path = self.sub_url + '/v1/character/pet-equipment'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2023, 12, 21)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return CharacterPetEquipment(**r)

    async def get_character_skill(self, ocid: str, character_skill_grade: str, date: datetime | None = None) -> CharacterSkill:
        """
        캐릭터 스킬과 하이퍼 스킬 정보를 조회합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시기 바랍니다.

        Args:
            ocid(str): 캐릭터 식별자
            date(datetime or None): 조회 기준일 (KST)
            character_skill_grade(str): 조회하고자 하는 전직 차수 (Available values: https://openapi.nexon.com/ko/game/maplestory/?id=14)
        """
        path = self.sub_url + '/v1/character/skill'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2023, 12, 21)) if date is not None else None,
            'character_skill_grade': character_skill_grade,
        }
        r = await self.fetch(path, query)
        return CharacterSkill(**r)

    async def get_character_link_skill(self, ocid: str, date: datetime | None = None) -> CharacterLinkSkill:
        """
        장착 링크 스킬 정보를 조회합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시기 바랍니다.

        Args:
            ocid(str): 캐릭터 식별자
            date(datetime or None): 조회 기준일 (KST)
        """
        path = self.sub_url + '/v1/character/link-skill'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2023, 12, 21)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return CharacterLinkSkill(**r)

    async def get_character_vmatrix(self, ocid: str, date: datetime | None = None) -> CharacterVMatrix:
        """
        V매트릭스 슬롯 정보와 장착한 V코어 정보를 조회합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시기 바랍니다.

        Args:
            ocid(str): 캐릭터 식별자
            date(datetime or None): 조회 기준일 (KST)
        """
        path = self.sub_url + '/v1/character/vmatrix'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2023, 12, 21)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return CharacterVMatrix(**r)

    async def get_character_hexamatrix(self, ocid: str, date: datetime | None = None) -> CharacterHexaMatrix:
        """
        HEXA 매트릭스에 장착한 HEXA 코어 정보를 조회합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시기 바랍니다.

        Args:
            ocid(str): 캐릭터 식별자
            date(datetime or None): 조회 기준일 (KST)
        """
        path = self.sub_url + '/v1/character/hexamatrix'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2023, 12, 21)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return CharacterHexaMatrix(**r)

    async def get_character_hexamatrix_stat(self, ocid: str, date: datetime | None = None) -> CharacterHexaMatrixStat:
        """
        HEXA 매트릭스에 설정한 HEXA 스탯 정보를 조회합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시기 바랍니다.

        Args:
            ocid(str): 캐릭터 식별자
            date(datetime or None): 조회 기준일 (KST)
        """
        path = self.sub_url + '/v1/character/hexamatrix-stat'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2023, 12, 21)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return CharacterHexaMatrixStat(**r)

    async def get_character_dojang(self, ocid: str, date: datetime | None = None) -> CharacterDojang:
        """
        캐릭터 무릉도장 최고 기록 정보를 조회합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시기 바랍니다.

        Args:
            ocid(str): 캐릭터 식별자
            date(datetime or None): 조회 기준일 (KST)
        """
        path = self.sub_url + '/v1/character/dojang'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2023, 12, 21)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return CharacterDojang(**r)

    async def get_character_other_stat(self, ocid: str, date: datetime | None = None) -> CharacterOtherStat:
        """
        기타 능력치에 영향을 주는 요소 정보를 조회합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2025년 8월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        Args:
            ocid(str): 캐릭터 식별자
            date(datetime or None): 조회 기준일 (KST)
        """
        path = self.sub_url + '/v1/character/other-stat'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 8, 21)) if date is not None else None
        }
        r = await self.fetch(path, query)

        return CharacterOtherStat(**r)

    async def get_character_ring_exchange_skill_equipment(self, ocid: str, date: datetime | None = None) -> CharacterRingExchangeSkillEquipment:
        """
        링 익스체인지 스킬 등록 장비를 조회합니다.
        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2025년 8월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (8월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
        Args:
            ocid(str): 캐릭터 식별자
            date(datetime or None): 조회 기준일 (KST)
        """
        path = self.sub_url + '/v1/character/ring-exchange-skill-equipment'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2025, 8, 21)) if date is not None else None
        }
        r = await self.fetch(path, query)
        return CharacterRingExchangeSkillEquipment(**r)

    #endregion

    #region 유니온 정보 조회

    async def get_union(self, ocid: str, date: datetime | None = None) -> Union:
        """
        유니온 레벨 및 유니온 등급 정보를 조회합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        Args:
            ocid(str): 캐릭터 식별자
            date(datetime or None): 조회 기준일 (KST)
        """
        path = self.sub_url + '/v1/user/union'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2023, 12, 21)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return Union(**r)

    async def get_union_raider(self, ocid: str, date: datetime | None = None) -> UnionRaider:
        """
        유니온에 배치된 공격대원 효과 및 공격대 점령 효과 등 상세 정보를 조회합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        Args:
            ocid(str): 캐릭터 식별자
            date(datetime or None): 조회 기준일 (KST)
        """
        path = self.sub_url + '/v1/user/union-raider'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2023, 12, 21)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return UnionRaider(**r)

    async def get_union_artifact(self, ocid: str, date: datetime | None = None) -> UnionArtifact:
        """
        유니온 아티팩트 정보를 조회합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        Args:
            ocid(str): 캐릭터 식별자
            date(datetime or None): 조회 기준일 (KST)
        """
        path = self.sub_url + '/v1/user/union-artifact'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2023, 12, 21)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return UnionArtifact(**r)

    async def get_union_champion(self, ocid: str, date: datetime | None = None) -> UnionChampion:
        """
        유니온 챔피언 정보를 조회합니다.

        유니온 챔피언 정보는 2025년 2월 20일 메이플스토리 점검 이후 데이터부터 조회 가능합니다.

        - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.
        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        Args:
            ocid(str): 캐릭터 식별자
            date(datetime or None): 조회 기준일 (KST)
        """
        path = self.sub_url + '/v1/user/union-champion'
        query = {
            'ocid': ocid,
            'date': self._to_date_string(date, datetime(2023, 12, 21)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return UnionChampion(**r)

    #endregion

    #region 길드 정보 조회

    async def get_guild_id(self, guild_name: str, world_name: str) -> Guild:
        """
        길드 식별자(gcid) 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        Args:
            guild_name (str): 길드 명
            world_name (str): 월드 명
                - 스카니아, 베라, 루나, 제니스, 크로아, 유니온, 엘리시움, 이노시스, 레드, 오로라, 아케인, 노바, 에오스, 헬리오스, 버닝, 버닝2, 버닝3
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
        길드 기본 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        Args:
            oguild_id (str): 길드 식별자
            date(datetime): 조회 기준일 (KST)
        """
        path = self.sub_url + '/v1/guild/basic'
        query = {
            'oguild_id': oguid_id,
            'date': self._to_date_string(date, datetime(2023, 12, 21)) if date is not None else None,
        }
        r = await self.fetch(path, query)
        return GuildBasic(**r)

    #endregion

    #region 확률 정보 조회

    async def get_cube_history(self, count, date: datetime | None = None, cursor: str | None = None) -> CubeHistory:
        """
        큐브 사용 결과를 조회합니다.

        - 큐브 확률 정보는 최대 30분 후 확인 가능합니다.
        - 큐브 사용 결과는 최근 2년 데이터만 조회 가능합니다.

        Args:
            count(int): 한번에 가져오려는 결과의 갯수(최소 10, 최대 1000)
            date(datetime or None): 조회 기준일 (KST) (cursor가 없는 경우 필수이며 cursor와 함께 사용 불가)
            cursor(str or None): 페이징 처리를 위한 cursor (date가 없는 경우 필수이며 date와 함께 사용 불가)
        """
        path = self.sub_url + '/v1/history/cube'
        query = {
            'count': count,
        }

        if cursor is None:
            query['date'] = self._to_date_string(self._get_proper_default_datetime(day_offset=0, update_hour=0) if date is None else date)
        else:
            query['cursor'] = cursor

        r = await self.fetch(path, query)
        return CubeHistory(**r)

    async def get_potential_history(self, count, date: datetime | None = None, cursor: str | None = None) -> PotentialHistory:
        """
        잠재능력 재설정 이용 결과를 조회합니다.

        - 잠재능력 재설정 정보는 최대 30분 후 확인 가능합니다.
        - 잠재능력 재설정 이용 결과는 2024년 01월 25일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.

        Args:
            count(int): 한번에 가져오려는 결과의 갯수(최소 10, 최대 1000)
            date(datetime or None): 조회 기준일 (KST) (cursor가 없는 경우 필수이며 cursor와 함께 사용 불가)
            cursor(str or None): 페이징 처리를 위한 cursor (date가 없는 경우 필수이며 date와 함께 사용 불가)
        """
        path = self.sub_url + '/v1/history/potential'
        query = {
            'count': count,
        }

        if cursor is None:
            query['date'] = self._to_date_string(self._get_proper_default_datetime(day_offset=0, update_hour=0) if date is None else date, datetime(2024, 1, 25)) ,
        else:
            query['cursor'] = cursor

        r = await self.fetch(path, query)
        return PotentialHistory(**r)

    async def get_starforce_history(self, count, date: datetime | None = None, cursor: str | None = None) -> StarforceHistory:
        """
        스타포스 강화 결과를 조회합니다.

        - 스타포스 확률 정보는 최대 5분 후 확인 가능합니다.
        - 2023년 12월 27일 데이터부터 조회할 수 있습니다.

        Args:
            count(int): 한번에 가져오려는 결과의 갯수(최소 10, 최대 1000)
            date(datetime or None): 조회 기준일 (KST) (cursor가 없는 경우 필수이며 cursor와 함께 사용 불가)
            cursor(str or None): 페이징 처리를 위한 cursor (date가 없는 경우 필수이며 date와 함께 사용 불가)
        """
        path = self.sub_url + '/v1/history/starforce'
        query = {
            'count': count,
        }

        if cursor is None:
            query['date'] = self._to_date_string(self._get_proper_default_datetime(day_offset=0) if date is None else date, datetime(2023, 12, 27)) ,
        else:
            query['cursor'] = cursor

        r = await self.fetch(path, query)
        return StarforceHistory(**r)

    #endregion

    #region 랭킹 정보 조회

    async def get_overall_ranking(self, world_name: str | None = None, world_type: int | None = None, class_name: str | None = None, ocid: str | None = None, page: int = 1,  date: datetime | None = None) -> OverallRanking:
        """
        종합 랭킹 정보를 조회합니다.

        - 2023년 12월 22일 데이터부터 조회할 수 있습니다.
        - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        Args:
            date(datetime or None): 조회 기준일 (KST)
            world_name(str or None): 월드 명 (Available values : https://openapi.nexon.com/ko/game/maplestory/?id=18)
            world_type(int or None): 월드 타입 (0:일반, 1:에오스,헬리오스) (기본 값은 0이며, world_name 입력 시 미 반영)
            class_name(str or None): 직업 및 전직 (Available values : https://openapi.nexon.com/ko/game/maplestory/?id=18)
            ocid(str or None): 캐릭터 식별자
            page(int or None): 페이지 번호
        """
        _date = self._get_proper_default_datetime(update_hour=8, update_minute=30, day_offset=0) if date is None else date
        path = self.sub_url + '/v1/ranking/overall'
        query = {
            'date': self._to_date_string(_date, datetime(2023, 12, 22)),
            'world_name': world_name,
            'world_type': world_type,
            'class': class_name,
            'ocid': ocid,
            'page': page,
        }
        r = await self.fetch(path, query)
        return OverallRanking(**r)

    async def get_union_ranking(self, world_name: str | None = None, ocid: str | None = None, page: int = 1,  date: datetime | None = None) -> UnionRanking:
        """
        유니온 랭킹 정보를 조회합니다.

        - 2023년 12월 22일 데이터부터 조회할 수 있습니다.
        - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        Args:
            date(datetime or None): 조회 기준일 (KST)
            world_name(str or None): 월드 명 (Available values : https://openapi.nexon.com/ko/game/maplestory/?id=18)
            ocid(str or None): 캐릭터 식별자
            page(int or None): 페이지 번호
        """
        _date = self._get_proper_default_datetime(update_hour=8, update_minute=30, day_offset=0) if date is None else date
        path = self.sub_url + '/v1/ranking/union'
        query = {
            'date': self._to_date_string(_date, datetime(2023, 12, 22)),
            'world_name': world_name,
            'ocid': ocid,
            'page': page,
        }
        r = await self.fetch(path, query)
        return UnionRanking(**r)

    async def get_guild_ranking(self, ranking_type: int = 0, world_name: str | None = None, guild_name: str | None = None, page: int = 1,  date: datetime | None = None) -> GuildRanking:
        """
        길드 랭킹 정보를 조회합니다.

        - 2023년 12월 22일 데이터부터 조회할 수 있습니다.
        - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        Args:
            date(datetime): 조회 기준일 (KST)
            ranking_type(int): 랭킹 타입 (0:주간 명성치, 1:플래그 레이스, 2:지하 수로)
            world_name(str or None): 월드 명 (Available values : https://openapi.nexon.com/ko/game/maplestory/?id=18)
            guild_name(str or None): 길드 명
            page(int or None): 페이지 번호
        """
        _date = self._get_proper_default_datetime(update_hour=8, update_minute=30, day_offset=0) if date is None else date
        path = self.sub_url + '/v1/ranking/guild'
        query = {
            'date': self._to_date_string(_date, datetime(2023, 12, 22)),
            'ranking_type': ranking_type,
            'world_name': world_name,
            'guild_name': guild_name,
            'page': page,
        }
        r = await self.fetch(path, query)
        return GuildRanking(**r)

    async def get_dojang_ranking(self, world_name: str | None = None, class_name: str | None = None, ocid: str | None = None, page: int = 1, difficulty: int = 1,  date: datetime | None = None) -> DojangRanking:
        """
        무릉도장 랭킹 정보를 조회합니다.

        - 2023년 12월 22일 데이터부터 조회할 수 있습니다.
        - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        Args:
            date(datetime or None): 조회 기준일 (KST)
            difficulty(int or None): 구간 (0:일반, 1:통달)
            world_name(str or None): 월드 명 (Available values : https://openapi.nexon.com/ko/game/maplestory/?id=18)
            class_name(str or None): 직업 및 전직 (Available values : https://openapi.nexon.com/ko/game/maplestory/?id=18)
            ocid(str or None): 캐릭터 식별자
            page(int or None): 페이지 번호
        """
        _date = self._get_proper_default_datetime(update_hour=8, update_minute=30, day_offset=0) if date is None else date
        path = self.sub_url + '/v1/ranking/dojang'
        query = {
            'date': self._to_date_string(_date, datetime(2023, 12, 22)),
            'world_name': world_name,
            'class': class_name,
            'ocid': ocid,
            'page': page,
            'difficulty': difficulty,
        }
        r = await self.fetch(path, query)
        return DojangRanking(**r)

    async def get_theseed_ranking(self, world_name: str | None = None, ocid: str | None = None, page: int = 1, date: datetime | None = None) -> TheSeedRanking:
        """
        더 시드 랭킹 정보를 조회합니다.

        - 2023년 12월 22일 데이터부터 조회할 수 있습니다.
        - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        Args:
            date(datetime or None): 조회 기준일 (KST)
            world_name(str or None): 월드 명 (Available values : https://openapi.nexon.com/ko/game/maplestory/?id=18)
            ocid(str or None): 캐릭터 식별자
            page(int or None): 페이지 번호
        """
        _date = self._get_proper_default_datetime(update_hour=8, update_minute=30, day_offset=0) if date is None else date
        path = self.sub_url + '/v1/ranking/theseed'
        query = {
            'date': self._to_date_string(_date, datetime(2023, 12, 22)),
            'world_name': world_name,
            'ocid': ocid,
            'page': page,
        }
        r = await self.fetch(path, query)
        return TheSeedRanking(**r)

    async def get_achievement_ranking(self, ocid: str | None = None, page: int = 1, date: datetime | None = None) -> AchievementRanking:
        """
        업적 랭킹 정보를 조회합니다.

        - 2023년 12월 22일 데이터부터 조회할 수 있습니다.
        - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        Args:
            date(datetime or None): 조회 기준일 (KST)
            ocid(str or None): 캐릭터 식별자
            page(int or None): 페이지 번호
        """
        _date = self._get_proper_default_datetime(update_hour=8, update_minute=30, day_offset=0) if date is None else date
        path = self.sub_url + '/v1/ranking/achievement'
        query = {
            'date': self._to_date_string(_date, datetime(2023, 12, 22)),
            'ocid': ocid,
            'page': page,
        }
        r = await self.fetch(path, query)
        return AchievementRanking(**r)

    #endregion

    #region 공지 정보 조회

    async def get_notice_list(self) -> NoticeList:
        """
        메이플스토리 공지사항에 최근 등록된 게시글 20개를 조회합니다.

        - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.
        - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.
        """
        path = self.sub_url + '/v1/notice'
        query = {}
        r = await self.fetch(path, query)
        return NoticeList(**r)

    async def get_notice_detail(self, notice_id: int) -> NoticeDetail:
        """
        메이플스토리 공지사항 게시글 세부 사항을 조회합니다.

        - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.
        - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.

        Args:
            notice_id(int): 공지 식별자
        """
        path = self.sub_url + '/v1/notice/detail'
        query = {
            'notice_id': notice_id,
        }
        r = await self.fetch(path, query)
        return NoticeDetail(**r)

    async def get_update_notice_list(self) -> UpdateNoticeList:
        """
        메이플스토리 업데이트에 최근 등록된 게시글 20개를 조회합니다.

        - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.
        - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.
        """
        path = self.sub_url + '/v1/notice-update'
        query = {}
        r = await self.fetch(path, query)
        return UpdateNoticeList(**r)

    async def get_update_notice_detail(self, notice_id: int) -> UpdateNoticeDetail:
        """
        메이플스토리 업데이트 게시글 세부 사항을 조회합니다.

        - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.
        - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.

        Args:
            notice_id(int): 공지 식별자
        """
        path = self.sub_url + '/v1/notice-update/detail'
        query = {
            'notice_id': notice_id,
        }
        r = await self.fetch(path, query)
        return UpdateNoticeDetail(**r)

    async def get_event_notice_list(self) -> EventNoticeList:
        """
        메이플스토리 진행 중 이벤트에 최근 등록된 게시글 20개를 조회합니다.

        - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.
        - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.
        """
        path = self.sub_url + '/v1/notice-event'
        query = {}
        r = await self.fetch(path, query)
        return EventNoticeList(**r)

    async def get_event_notice_detail(self, notice_id: int) -> EventNoticeDetail:
        """
        메이플스토리 진행 중 이벤트 게시글 세부 사항을 조회합니다.

        - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.
        - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.

        Args:
            notice_id(int): 공지 식별자
        """
        path = self.sub_url + '/v1/notice-event/detail'
        query = {
            'notice_id': notice_id,
        }
        r = await self.fetch(path, query)
        return EventNoticeDetail(**r)

    async def get_cashshop_notice_list(self) -> CashshopNoticeList:
        """
        메이플스토리 캐시샵 공지에 최근 등록된 게시글 20개를 조회합니다.

        - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.
        - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.
        """
        path = self.sub_url + '/v1/notice-cashshop'
        query = {}
        r = await self.fetch(path, query)
        return CashshopNoticeList(**r)

    async def get_cashshop_notice_detail(self, notice_id: int) -> CashshopNoticeDetail:
        """
        메이플스토리 캐시샵 공지 게시글 세부 사항을 조회합니다.

        - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.
        - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.

        Args:
            notice_id(int): 공지 식별자
        """
        path = self.sub_url + '/v1/notice-cashshop/detail'
        query = {
            'notice_id': notice_id,
        }
        r = await self.fetch(path, query)
        return CashshopNoticeDetail(**r)

    #endregion

    # def to_date_string(self, date: datetime, min: datetime | None = None) -> str:
    #
    #     target_date = self.get_kst_datetime(date)
    #     date_str = target_date.strftime('%Y-%m-%d')
    #
    #     if min is not None:
    #         min_date = self.get_kst_datetime(min)
    #         if target_date < min_date:
    #             raise ValueError(
    #                 f'You can only retrieve data after {min_date.strftime("%Y-%m-%d")}')
    #
    #     return date_str
    #
    # def get_kst_datetime(self, date: datetime) -> datetime:
    #     """datetime 객체를 KST datetime 객체로 변환합니다.
    #
    #     datetime.astimezone()을 사용하면 지역에 따라 다른 결과가 나오고 date.replace()에도 버그가 존재하므로 datetime으로 재설정합니다.
    #     """
    #     return datetime(year=date.year, month=date.month, day=date.day, tzinfo=ZoneInfo('Asia/Seoul'))

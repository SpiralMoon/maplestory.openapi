from abc import ABC, abstractmethod
from datetime import datetime, timedelta
from zoneinfo import ZoneInfo
from typing import Any
from pydantic import BaseModel
import httpx

from maplestory_openapi.api.common.dto.character.character import Character
from maplestory_openapi.api.common.dto.character.character_basic import CharacterBasic
from maplestory_openapi.api.common.dto.character.character_popularity import CharacterPopularity
from maplestory_openapi.api.common.dto.character.character_stat import CharacterStat
from maplestory_openapi.api.common.dto.character.character_hyper_stat import CharacterHyperStat
from maplestory_openapi.api.common.dto.character.character_propensity import CharacterPropensity
from maplestory_openapi.api.common.dto.character.character_ability import CharacterAbility
from maplestory_openapi.api.common.dto.character.character_item_equipment import CharacterItemEquipment
from maplestory_openapi.api.common.dto.character.character_cashitem_equipment import CharacterCashitemEquipment
from maplestory_openapi.api.common.dto.character.character_symbol_equipment import CharacterSymbolEquipment
from maplestory_openapi.api.common.dto.character.character_set_effect import CharacterSetEffect
from maplestory_openapi.api.common.dto.character.character_beauty_equipment import CharacterBeautyEquipment
from maplestory_openapi.api.common.dto.character.character_android_equipment import CharacterAndroidEquipment
from maplestory_openapi.api.common.dto.character.character_pet_equipment import CharacterPetEquipment
from maplestory_openapi.api.common.dto.character.character_skill import CharacterSkill
from maplestory_openapi.api.common.dto.character.character_link_skill import CharacterLinkSkill
from maplestory_openapi.api.common.dto.character.character_vmatrix import CharacterVMatrix
from maplestory_openapi.api.common.dto.character.character_hexamatrix import CharacterHexaMatrix
from maplestory_openapi.api.common.dto.character.character_hexamatrix_stat import CharacterHexaMatrixStat
from maplestory_openapi.api.common.dto.character.character_dojang import CharacterDojang
from maplestory_openapi.api.common.dto.character.character_image import CharacterImage

from maplestory_openapi.api.common.dto.union.union import Union
from maplestory_openapi.api.common.dto.union.union_artifact import UnionArtifact
from maplestory_openapi.api.common.dto.union.union_raider import UnionRaider

from maplestory_openapi.api.common.dto.guild.guild import Guild
from maplestory_openapi.api.common.dto.guild.guild_basic import GuildBasic

from maplestory_openapi.api.common.maplestory_api_error import MapleStoryApiError, MapleStoryApiException

from maplestory_openapi.api.common.param.character_image_option import CharacterImageOption


class MapleStoryApi(ABC, BaseModel):
    api_key: str
    BASE_URL: str = 'https://open.api.nexon.com/'
    timeout: int
    timezone: str
    sub_url: str

    def __init__(self, api_key: str, timezone: str, sub_url: str, timeout:int):
        super().__init__(
            api_key=api_key,
            timezone=timezone,
            sub_url=sub_url,
            timeout=timeout,
        )

    #region Character Information Retrieval

    @abstractmethod
    async def get_character_id(self, character_name: str) -> Character:
        pass

    @abstractmethod
    async def get_character_basic(self, ocid: str, date: datetime | None = None) -> CharacterBasic:
        pass

    @abstractmethod
    async def get_character_image(self, ocid: str, option: CharacterImageOption | None = None, date: datetime | None = None) -> CharacterImage:
        pass

    @abstractmethod
    async def get_character_popularity(self, ocid: str, date: datetime | None = None) -> CharacterPopularity:
        pass

    @abstractmethod
    async def get_character_stat(self, ocid: str, date: datetime | None = None) -> CharacterStat:
        pass

    @abstractmethod
    async def get_character_hyper_stat(self, ocid: str, date: datetime | None = None) -> CharacterHyperStat:
        pass

    @abstractmethod
    async def get_character_propensity(self, ocid: str, date: datetime | None = None) -> CharacterPropensity:
        pass

    @abstractmethod
    async def get_character_ability(self, ocid: str, date: datetime | None = None) -> CharacterAbility:
        pass

    @abstractmethod
    async def get_character_item_equipment(self, ocid: str, date: datetime | None = None) -> CharacterItemEquipment:
        pass

    @abstractmethod
    async def get_character_cashitem_equipment(self, ocid: str, date: datetime | None = None) -> CharacterCashitemEquipment:
        pass

    @abstractmethod
    async def get_character_symbol_equipment(self, ocid: str, date: datetime | None = None) -> CharacterSymbolEquipment:
        pass

    @abstractmethod
    async def get_character_set_effect(self, ocid: str, date: datetime | None = None) -> CharacterSetEffect:
        pass

    @abstractmethod
    async def get_character_beauty_equipment(self, ocid: str, date: datetime | None = None) -> CharacterBeautyEquipment:
        pass

    @abstractmethod
    async def get_character_android_equipment(self, ocid: str, date: datetime | None = None) -> CharacterAndroidEquipment:
        pass

    @abstractmethod
    async def get_character_pet_equipment(self, ocid: str, date: datetime | None = None) -> CharacterPetEquipment:
        pass

    @abstractmethod
    async def get_character_skill(self, ocid: str, character_skill_grade: str, date: datetime | None = None) -> CharacterSkill:
        pass

    @abstractmethod
    async def get_character_link_skill(self, ocid: str, date: datetime | None = None) -> CharacterLinkSkill:
        pass

    @abstractmethod
    async def get_character_vmatrix(self, ocid: str, date: datetime | None = None) -> CharacterVMatrix:
        pass

    @abstractmethod
    async def get_character_hexamatrix(self, ocid: str, date: datetime | None = None) -> CharacterHexaMatrix:
        pass

    @abstractmethod
    async def get_character_hexamatrix_stat(self, ocid: str, date: datetime | None = None) -> CharacterHexaMatrixStat:
        pass

    @abstractmethod
    async def get_character_dojang(self, ocid: str, date: datetime | None = None) -> CharacterDojang:
        pass

    #endregion

    #region Union Information Retrieval

    @abstractmethod
    async def get_union(self, ocid: str, date: datetime | None = None) -> Union:
        pass

    @abstractmethod
    async def get_union_raider(self, ocid: str, date: datetime | None = None) -> UnionRaider:
        pass

    @abstractmethod
    async def get_union_artifact(self, ocid: str, date: datetime | None = None) -> UnionArtifact:
        pass

    #endregion

    #region Guild Information Retrieval

    @abstractmethod
    async def get_guild_id(self, guild_name: str, world_name: str) -> Guild:
        pass

    @abstractmethod
    async def get_guild_basic(self, oguid_id: str, date: datetime | None = None) -> GuildBasic:
        pass

    #endregion

    async def fetch(self, path: str, query: dict) -> Any:

        params = {key: value for key, value in query.items() if value is not None}

        async with httpx.AsyncClient(timeout=self.timeout) as client:
            response = await client.get(
                f'{self.BASE_URL}{path}',
                params=params,
                headers={
                    'x-nxopen-api-key': self.api_key,
                },
            )

        r = response.json()

        if (r.get('error')):
            raise MapleStoryApiException(MapleStoryApiError(**r.get('error')))

        return r

    def _to_date_string(self, date: datetime, min: datetime | None = None) -> str:
        """
        날짜 정보를 API 서버에서 요구하는 포맷으로 변환합니다.

        Args:
            date (datetime): 조회 하려는 날짜
            min (datetime or None): API 호출 가능한 최소 날짜
        """

        target_date = self.__get_datetime(date)
        date_str = target_date.strftime('%Y-%m-%d')

        if min is not None:
            min_date = self.__get_datetime(min)
            if target_date < min_date:
                raise ValueError(
                    f'You can only retrieve data after {min_date.strftime("%Y-%m-%d")}')

        return date_str

    def __get_datetime(self, date: datetime) -> datetime:
        """
        datetime 객체를 timezone이 지정된 datetime 객체로 변환합니다.

        datetime.astimezone()을 사용하면 지역에 따라 다른 결과가 나오고 date.replace()에도 버그가 존재하므로 datetime으로 재설정합니다.
        """
        return datetime(year=date.year, month=date.month, day=date.day, tzinfo=ZoneInfo(self.timezone))

    def _get_proper_default_datetime(self, day_offset: int, update_hour: int = 0, update_minute: int = 0) -> datetime:
        """
        API 서버의 데이터 갱신 시간에 따라 데이터가 조회 가능한 최신 날짜를 반환합니다.

        Args:
            day_offset(int): 갱신시간에 갱신되는 데이터가 오늘인지 어제인지에 따라 숫자를 지정합니다 (0: 오늘, 1: 어제)
            update_hour(int): 갱신 시간의 시간을 지정합니다
            update_minute(int): 갱신 시간의 분을 지정합니다
        """
        now = datetime.now(
            tz=ZoneInfo(self.timezone))
        update_time = datetime(
            year=now.year,
            month=now.month,
            day=now.day,
            hour=update_hour,
            minute=update_minute,
            tzinfo=ZoneInfo(self.timezone))

        adjusted_time: datetime

        if now > update_time:
            adjusted_time = update_time - timedelta(days=day_offset)
        else:
            adjusted_time = update_time - timedelta(days=day_offset + 1)

        return adjusted_time

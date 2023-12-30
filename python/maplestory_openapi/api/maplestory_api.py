from datetime import datetime
from zoneinfo import ZoneInfo
from typing import Any
from pydantic import BaseModel
import requests

from maplestory_openapi.api.dto.character.character import Character
from maplestory_openapi.api.dto.character.character_basic import CharacterBasic
from maplestory_openapi.api.dto.character.character_popularity import CharacterPopularity
from maplestory_openapi.api.dto.character.character_stat import CharacterStat
from maplestory_openapi.api.dto.character.character_hyper_stat import CharacterHyperStat
from maplestory_openapi.api.dto.character.character_propensity import CharacterPropensity
from maplestory_openapi.api.dto.character.character_ability import CharacterAbility
from maplestory_openapi.api.dto.character.character_item_equipment import CharacterItemEquipment
from maplestory_openapi.api.dto.character.character_cashitem_equipment import CharacterCashitemEquipment
from maplestory_openapi.api.dto.character.character_symbol_equipment import CharacterSymbolEquipment
from maplestory_openapi.api.dto.character.character_set_effect import CharacterSetEffect
from maplestory_openapi.api.dto.character.character_beauty_equipment import CharacterBeautyEquipment
from maplestory_openapi.api.dto.character.character_android_equipment import CharacterAndroidEquipment
from maplestory_openapi.api.dto.character.character_pet_equipment import CharacterPetEquipment
from maplestory_openapi.api.dto.character.character_skill import CharacterSkill
from maplestory_openapi.api.dto.character.character_link_skill import CharacterLinkSkill
from maplestory_openapi.api.dto.character.character_vmatrix import CharacterVMatrix
from maplestory_openapi.api.dto.character.character_hexamatrix import CharacterHexaMatrix
from maplestory_openapi.api.dto.character.character_hexamatrix_stat import CharacterHexaMatrixStat
from maplestory_openapi.api.dto.character.character_dojang import CharacterDojang

from maplestory_openapi.api.dto.union.union import Union
from maplestory_openapi.api.dto.union.union_raider import UnionRaider

from maplestory_openapi.api.dto.guild.guild import Guild
from maplestory_openapi.api.dto.guild.guild_basic import GuildBasic

from maplestory_openapi.api.dto.history.cube_history import CubeHistory
from maplestory_openapi.api.dto.history.starforce_history import StarforceHistory

from maplestory_openapi.api.dto.ranking.overall_ranking import OverallRanking
from maplestory_openapi.api.dto.ranking.guild_ranking import GuildRanking
from maplestory_openapi.api.dto.ranking.dojang_ranking import DojangRanking
from maplestory_openapi.api.dto.ranking.union_ranking import UnionRanking
from maplestory_openapi.api.dto.ranking.theseed_ranking import TheSeedRanking
from maplestory_openapi.api.dto.ranking.achievement_ranking import AchievementRanking


from maplestory_openapi.api.maplestory_api_error import MapleStoryApiError, MapleStoryApiException
from maplestory_openapi.api.utils.date import get_proper_default_datetime


class MapleStoryApi(BaseModel):
    api_key: str
    BASE_URL: str = 'https://open.api.nexon.com/'
    timeout: int

    def __init__(self, api_key, timeout: int = 5000):
        super().__init__(
            api_key=api_key,
            timeout=timeout,
        )

    #region 캐릭터 정보 조회

    def get_character_id(self, character_name: str) -> Character:
        """캐릭터 식별자(ocid)를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        @param character_name (str): 캐릭터 이름
        """

        path = 'maplestory/v1/id'
        query = {
            'character_name': character_name,
        }
        r = self.fetch(path, query)
        return Character(**r)

    def get_character_basic(self, ocid: str, date: datetime = get_proper_default_datetime(update_hour=1, day_offset=1)) -> CharacterBasic:
        """기본 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        @param ocid(str): 캐릭터 식별자(ocid)
        @param date(datetime): 조회 기준일 (KST)
        """
        path = 'maplestory/v1/character/basic'
        query = {
            'ocid': ocid,
            'date': self.to_date_string(datetime(2023, 12, 21), date)
        }
        r = self.fetch(path, query)

        return CharacterBasic(**r)

    def get_character_popularity(self, ocid: str, date: datetime = get_proper_default_datetime(update_hour=1, day_offset=1)) -> CharacterPopularity:
        """인기도 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        @param ocid(str): 캐릭터 식별자(ocid)
        @param date(datetime): 조회 기준일 (KST)
        """
        path = 'maplestory/v1/character/popularity'
        query = {
            'ocid': ocid,
            'date': self.to_date_string(datetime(2023, 12, 21), date)
        }
        r = self.fetch(path, query)

        return CharacterPopularity(
            date=r.get('date'),
            popularity=r.get('popularity'),
        )

    def get_character_stat(self, ocid: str, date: datetime = get_proper_default_datetime(update_hour=1, day_offset=1)) -> CharacterStat:
        """종합능력치 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        @param ocid(str): 캐릭터 식별자(ocid)
        @param date(datetime): 조회 기준일 (KST)
        """
        path = 'maplestory/v1/character/stat'
        query = {
            'ocid': ocid,
            'date': self.to_date_string(datetime(2023, 12, 21), date)
        }
        r = self.fetch(path, query)

        return CharacterStat(**r)

    def get_character_hyper_stat(self, ocid: str, date: datetime = get_proper_default_datetime(update_hour=1, day_offset=1)) -> CharacterHyperStat:
        """하이퍼스탯 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        @param ocid(str): 캐릭터 식별자(ocid)
        @param date(datetime): 조회 기준일 (KST)
        """
        path = 'maplestory/v1/character/hyper-stat'
        query = {
            'ocid': ocid,
            'date': self.to_date_string(datetime(2023, 12, 21), date)
        }
        r = self.fetch(path, query)

        return CharacterHyperStat(**r)

    def get_character_propensity(self, ocid: str, date: datetime = get_proper_default_datetime(update_hour=1, day_offset=1)) -> CharacterPropensity:
        """성향 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        @param ocid(str): 캐릭터 식별자(ocid)
        @param date(datetime): 조회 기준일 (KST)
        """
        path = 'maplestory/v1/character/propensity'
        query = {
            'ocid': ocid,
            'date': self.to_date_string(datetime(2023, 12, 21), date)
        }
        r = self.fetch(path, query)

        return CharacterPropensity(**r)

    def get_character_ability(self, ocid: str, date: datetime = get_proper_default_datetime(update_hour=1, day_offset=1)) -> CharacterAbility:
        """어빌리티 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        @param ocid(str): 캐릭터 식별자(ocid)
        @param date(datetime): 조회 기준일 (KST)
        """
        path = 'maplestory/v1/character/ability'
        query = {
            'ocid': ocid,
            'date': self.to_date_string(datetime(2023, 12, 21), date)
        }
        r = self.fetch(path, query)

        return CharacterAbility(**r)

    def get_character_item_equipment(self, ocid: str, date: datetime = get_proper_default_datetime(update_hour=1, day_offset=1)) -> CharacterItemEquipment:
        """장착한 장비 중 캐시 장비를 제외한 나머지 장비 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        @param ocid(str): 캐릭터 식별자(ocid)
        @param date(datetime): 조회 기준일 (KST)
        """
        path = 'maplestory/v1/character/item-equipment'
        query = {
            'ocid': ocid,
            'date': self.to_date_string(datetime(2023, 12, 21), date)
        }
        r = self.fetch(path, query)

        return CharacterItemEquipment(**r)

    def get_character_cashitem_equipment(self, ocid: str, date: datetime = get_proper_default_datetime(update_hour=1, day_offset=1)) -> CharacterCashitemEquipment:
        """장착한 캐시 장비 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        @param ocid(str): 캐릭터 식별자(ocid)
        @param date(datetime): 조회 기준일 (KST)
        """
        path = 'maplestory/v1/character/cashitem-equipment'
        query = {
            'ocid': ocid,
            'date': self.to_date_string(datetime(2023, 12, 21), date)
        }
        r = self.fetch(path, query)

        return CharacterCashitemEquipment(**r)

    def get_character_symbol_equipment(self, ocid: str, date: datetime = get_proper_default_datetime(update_hour=1, day_offset=1)) -> CharacterSymbolEquipment:
        """장착한 심볼 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        @param ocid(str): 캐릭터 식별자(ocid)
        @param date(datetime): 조회 기준일 (KST)
        """
        path = 'maplestory/v1/character/symbol-equipment'
        query = {
            'ocid': ocid,
            'date': self.to_date_string(datetime(2023, 12, 21), date)
        }
        r = self.fetch(path, query)
        return CharacterSymbolEquipment(**r)

    def get_character_set_effect(self, ocid: str, date: datetime = get_proper_default_datetime(update_hour=1, day_offset=1)) -> CharacterSetEffect:
        """적용받고 있는 세트 효과 정보를 조회합니다

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.).
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시기 바랍니다.

        @param ocid(str): 캐릭터 식별자(ocid)
        @param date(datetime): 조회 기준일(KST)
        """
        path = 'maplestory/v1/character/set-effect'
        query = {
            'ocid': ocid,
            'date': self.to_date_string(datetime(2023, 12, 21), date)
        }
        r = self.fetch(path, query)
        return CharacterSetEffect(**r)

    def get_character_beauty_equipment(self, ocid: str, date: datetime = get_proper_default_datetime(update_hour=1, day_offset=1)) -> CharacterBeautyEquipment:
        """캐릭터 헤어, 성형, 피부 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.).
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시기 바랍니다.

        @param ocid(str): 캐릭터 식별자(ocid)
        @param date(datetime): 조회 기준일(KST)
        """
        path = 'maplestory/v1/character/beauty-equipment'
        query = {
            'ocid': ocid,
            'date': self.to_date_string(datetime(2023, 12, 21), date)
        }
        r = self.fetch(path, query)
        return CharacterBeautyEquipment(**r)

    def get_character_android_equipment(self, ocid: str, date: datetime = get_proper_default_datetime(update_hour=1, day_offset=1)) -> CharacterAndroidEquipment:
        """장착한 안드로이드 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.).
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시기 바랍니다.

        @param ocid(str): 캐릭터 식별자(ocid)
        @param date(datetime): 조회 기준일(KST)
        """
        path = 'maplestory/v1/character/android-equipment'
        query = {
            'ocid': ocid,
            'date': self.to_date_string(datetime(2023, 12, 21), date),
        }
        r = self.fetch(path, query)
        return CharacterAndroidEquipment(**r)

    def get_character_pet_equipment(self, ocid: str, date: datetime = get_proper_default_datetime(update_hour=1, day_offset=1)) -> CharacterPetEquipment:
        """장착한 펫 및 펫 스킬, 장비 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 캐릭터 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.).
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시기 바랍니다.

        @param ocid(str): 캐릭터 식별자(ocid)
        @param date(datetime): 조회 기준일(KST)
        """
        path = 'maplestory/v1/character/pet-equipment'
        query = {
            'ocid': ocid,
            'date': self.to_date_string(datetime(2023, 12, 21), date),
        }
        r = self.fetch(path, query)
        return CharacterPetEquipment(**r)

    def get_character_skill(self, ocid: str, character_skill_grade: str, date: datetime = get_proper_default_datetime(day_offset=1)) -> CharacterSkill:
        """캐릭터 스킬과 하이퍼 스킬 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 오전 0시부터 전일 데이터 조회가 가능합니다.
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신시 유의해 주시기 바랍니다.

        @param ocid(str): 캐릭터 식별자(ocid)
        @param date(datetime): 조회 기준일(KST)
        @param character_skill_grade(str): 조회하고자 하는 전직 차수
        - 0: 0차 스킬 및 제로 공용스킬
        - 1: 1차 스킬
        - 1.5: 1.5차 스킬
        - 2: 2차 스킬
        - 2.5: 2.5차 스킬
        - 3: 3차 스킬
        - 4: 4차 스킬 및 제로 알파/베타 스킬
        - hyperpassive: 하이퍼 패시브 스킬
        - hyperactive: 하이퍼 액티브 스킬
        - 5: 5차 스킬
        - 6: 6차 스킬
        """
        path = 'maplestory/v1/character/skill'
        query = {
            'ocid': ocid,
            'date': self.to_date_string(datetime(2023, 12, 21), date),
            'character_skill_grade': character_skill_grade,
        }
        r = self.fetch(path, query)
        return CharacterSkill(**r)

    def get_character_link_skill(self, ocid: str, date: datetime = get_proper_default_datetime(day_offset=1)) -> CharacterLinkSkill:
        """장착 링크 스킬 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 오전 0시부터 전일 데이터 조회가 가능합니다.
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신시 유의해 주시기 바랍니다.

        @param ocid(str): 캐릭터 식별자(ocid)
        @param date(datetime): 조회 기준일(KST)
        """
        path = 'maplestory/v1/character/link-skill'
        query = {
            'ocid': ocid,
            'date': self.to_date_string(datetime(2023, 12, 21), date),
        }
        r = self.fetch(path, query)
        return CharacterLinkSkill(**r)

    def get_character_vmatrix(self, ocid: str, date: datetime = get_proper_default_datetime(day_offset=1)) -> CharacterVMatrix:
        """V매트릭스 슬롯 정보와 장착한 V코어 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 오전 0시부터 전일 데이터 조회가 가능합니다.
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신시 유의해 주시기 바랍니다.

        @param ocid(str): 캐릭터 식별자(ocid)
        @param date(datetime): 조회 기준일(KST)
        """
        path = 'maplestory/v1/character/vmatrix'
        query = {
            'ocid': ocid,
            'date': self.to_date_string(datetime(2023, 12, 21), date),
        }
        r = self.fetch(path, query)
        return CharacterVMatrix(**r)

    def get_character_hexamatrix(self, ocid: str, date: datetime = get_proper_default_datetime(day_offset=1)) -> CharacterHexaMatrix:
        """HEXA 매트릭스에 장착한 HEXA 코어 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 오전 0시부터 전일 데이터 조회가 가능합니다.
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신시 유의해 주시기 바랍니다.

        @param ocid(str): 캐릭터 식별자(ocid)
        @param date(datetime): 조회 기준일(KST)
        """
        path = 'maplestory/v1/character/hexamatrix'
        query = {
            'ocid': ocid,
            'date': self.to_date_string(datetime(2023, 12, 21), date),
        }
        r = self.fetch(path, query)
        return CharacterHexaMatrix(**r)

    def get_character_hexamatrix_stat(self, ocid: str, date: datetime = get_proper_default_datetime(day_offset=1)) -> CharacterHexaMatrixStat:
        """HEXA 매트릭스에 설정한 HEXA 스탯 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 오전 0시부터 전일 데이터 조회가 가능합니다.
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신시 유의해 주시기 바랍니다.

        @param ocid(str): 캐릭터 식별자(ocid)
        @param date(datetime): 조회 기준일(KST)
        """
        path = 'maplestory/v1/character/hexamatrix-stat'
        query = {
            'ocid': ocid,
            'date': self.to_date_string(datetime(2023, 12, 21), date),
        }
        r = self.fetch(path, query)
        return CharacterHexaMatrixStat(**r)

    def get_character_dojang(self, ocid: str, date: datetime = get_proper_default_datetime(day_offset=1)) -> CharacterDojang:
        """캐릭터 무릉도장 최고 기록 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 오전 0시부터 전일 데이터 조회가 가능합니다.
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신시 유의해 주시기 바랍니다.

        @param ocid(str): 캐릭터 식별자(ocid)
        @param date(datetime): 조회 기준일(KST)
        """
        path = 'maplestory/v1/character/dojang'
        query = {
            'ocid': ocid,
            'date': self.to_date_string(datetime(2023, 12, 21), date),
        }
        r = self.fetch(path, query)
        return CharacterDojang(**r)

    #endregion

    #region 유니온 정보 조회

    def get_union(self, ocid: str, date: datetime = get_proper_default_datetime(day_offset=1)) -> Union:
        """유니온 레벨 및 유니온 등급 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 유니온 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        @param ocid(str): 캐릭터 식별자(ocid)
        @param date(datetime): 조회 기준일(KST)
        """
        path = 'maplestory/v1/user/union'
        query = {
            'ocid': ocid,
            'date': self.to_date_string(datetime(2023, 12, 21), date),
        }
        r = self.fetch(path, query)
        return Union(**r)

    def get_union_raider(self, ocid: str, date: datetime = get_proper_default_datetime(day_offset=1)) -> UnionRaider:
        """유니온에 배치된 공격대원 효과 및 공격대 점령 효과 등 상세 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 유니온 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        @param ocid(str): 캐릭터 식별자(ocid)
        @param date(datetime): 조회 기준일(KST)
        """
        path = 'maplestory/v1/user/union-raider'
        query = {
            'ocid': ocid,
            'date': self.to_date_string(datetime(2023, 12, 21), date),
        }
        r = self.fetch(path, query)
        return UnionRaider(**r)

    #endregion

    #region 길드 정보 조회

    def get_guild_id(self, guild_name: str, world_name: str) -> Guild:
        """길드 식별자(gcid) 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 길드 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)
        - 길드 식별자(gcid)는 길드명과 월드명으로 조회할 수 있습니다.

        @param guild_name (str): 길드 명
        @param world_name (str): 월드 명
        - 스카니아, 베라, 루나, 제니스, 크로아, 유니온, 엘리시움, 이노시스, 레드, 오로라, 아케인, 노바, 리부트, 리부트2, 버닝, 버닝2, 버닝3
        """
        path = 'maplestory/v1/guild/id'
        query = {
            'guild_name': guild_name,
            'world_name': world_name,
        }
        r = self.fetch(path, query)
        return Guild(**r)

    def get_guild_basic(self, oguid_id: str, date: datetime = get_proper_default_datetime(update_hour=1, day_offset=1)) -> GuildBasic:
        """길드 기본 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 길드 정보 조회 API는 일자별 데이터로 매일 오전 1시부터 전일 데이터 조회가 가능합니다. (예를 들어, 12월 22일 데이터를 조회하면 22일 00시부터 23일의 00시 사이의 데이터가 조회됩니다.)

        @param oguild_id (str): 길드 식별자
        @param date(datetime): 조회 기준일(KST)
        """
        path = 'maplestory/v1/guild/basic'
        query = {
            'oguild_id': oguid_id,
            'date': self.to_date_string(datetime(2023, 12, 21), date),
        }
        r = self.fetch(path, query)
        return GuildBasic(**r)

    #endregion

    #region 확률 정보 조회

    def get_cube_history(self, count, date: datetime | None = None, cursor: str | None = None) -> CubeHistory:
        """큐브 사용 결과를 조회합니다.

        - 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.
        - 2022년 11월 25일 데이터부터 조회할 수 있습니다.

        @param count(int): 한번에 가져오려는 결과의 갯수(최소 10, 최대 1000)
        @param date(datetime): 조회 기준일(KST) (cursor가 없는 경우 필수이며 cursor와 함께 사용 불가)
        @param cursor(str): 페이징 처리를 위한 cursor (date가 없는 경우 필수이며 date와 함께 사용 불가)
        """
        path = 'maplestory/v1/history/cube'
        query = {
            'count': count,
            'date': self.to_date_string(datetime(2022, 11, 25), date) if date else date,
            'cursor': cursor,
        }
        r = self.fetch(path, query)
        return CubeHistory(**r)

    def get_starforce_history(self, count, date: datetime | None = None, cursor: str | None = None) -> StarforceHistory:
        """스타포스 강화 결과를 조회합니다.

        - 스타포스 확률 정보는 최대 5분 후 확인 가능합니다.
        - 2023년 12월 27일 데이터부터 조회할 수 있습니다.

        @param count(int): 한번에 가져오려는 결과의 갯수(최소 10, 최대 1000)
        @param date(datetime): 조회 기준일(KST) (cursor가 없는 경우 필수이며 cursor와 함께 사용 불가)
        @param cursor(str): 페이징 처리를 위한 cursor (date가 없는 경우 필수이며 date와 함께 사용 불가)
        """
        path = 'maplestory/v1/history/starforce'
        query = {
            'count': count,
            'date': self.to_date_string(datetime(2023, 12, 27), date) if date else date,
            'cursor': cursor,
        }
        r = self.fetch(path, query)
        return StarforceHistory(**r)

    #endregion

    #region 랭킹 정보 조회

    def get_overall_ranking(self, world_name: str | None = None, world_type: int | None = None, class_name: str | None = None, ocid: str | None = None, page: int = 1,  date: datetime = get_proper_default_datetime(update_hour=8, update_minute=30, day_offset=0), ) -> OverallRanking:
        """종합 랭킹 정보를 조회합니다.

        - 2023년 12월 22일 데이터부터 조회할 수 있습니다.
        - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        @param date(datetime): 조회 기준일(KST)
        @param world_name(str): 월드 명
        - 스카니아, 베라, 루나, 제니스, 크로아, 유니온, 엘리시움, 이노시스, 레드, 오로라, 아케인, 노바, 리부트, 리부트2, 버닝, 버닝2, 버닝3

        @param world_type(int): 월드 타입 (0:일반, 1:리부트) (기본 값은 0이며, world_name 입력 시 미 반영)
        @param class_name(str): 직업 및 전직
        - 초보자-전체 전직, 전사-전체 전직, 전사-검사, 전사-파이터, 전사-페이지, 전사-스피어맨, 전사-크루세이더, 전사-나이트, 전사-버서커, 전사-히어로, 전사-팔라딘, 전사-다크나이트, 마법사-전체 전직, 마법사-매지션, 마법사-위자드(불,독), 마법사-위자드(썬,콜), 마법사-클레릭, 마법사-메이지(불,독), 마법사-메이지(썬,콜), 마법사-프리스트, 마법사-아크메이지(불,독), 마법사-아크메이지(썬,콜), 마법사-비숍, 궁수-전체 전직, 궁수-아처, 궁수-헌터, 궁수-사수, 궁수-레인저, 궁수-저격수, 궁수-보우마스터, 궁수-신궁, 궁수-아처(패스파인더), 궁수-에인션트아처, 궁수-체이서, 궁수-패스파인더, 도적-전체 전직, 도적-로그, 도적-어쌔신, 도적-시프, 도적-허밋, 도적-시프마스터, 도적-나이트로드, 도적-섀도어, 도적-세미듀어러, 도적-듀어러, 도적-듀얼마스터, 도적-슬래셔, 도적-듀얼블레이더, 해적-전체 전직, 해적-해적, 해적-인파이터, 해적-건슬링거, 해적-캐논슈터, 해적-버커니어, 해적-발키리, 해적-캐논블래스터, 해적-바이퍼, 해적-캡틴, 해적-캐논마스터, 기사단-전체 전직, 기사단-노블레스, 기사단-소울마스터, 기사단-플레임위자드, 기사단-윈드브레이커, 기사단-나이트워커, 기사단-스트라이커, 기사단-미하일, 아란-전체 전직, 에반-전체 전직, 레지스탕스-전체 전직, 레지스탕스-시티즌, 레지스탕스-배틀메이지, 레지스탕스-와일드헌터, 레지스탕스-메카닉, 레지스탕스-데몬슬레이어, 레지스탕스-데몬어벤져, 레지스탕스-제논, 레지스탕스-블래스터, 메르세데스-전체 전직, 팬텀-전체 전직, 루미너스-전체 전직, 카이저-전체 전직, 엔젤릭버스터-전체 전직, 초월자-전체 전직, 초월자-제로, 은월-전체 전직, 프렌즈 월드-전체 전직, 프렌즈 월드-키네시스, 카데나-전체 전직, 일리움-전체 전직, 아크-전체 전직, 호영-전체 전직, 아델-전체 전직, 카인-전체 전직, 라라-전체 전직, 칼리-전체 전직

        @param ocid(str): 캐릭터 식별자
        @param page(int): 페이지 번호
        """
        path = 'maplestory/v1/ranking/overall'
        query = {
            'date': self.to_date_string(datetime(2023, 12, 22), date),
            'world_name': world_name,
            'world_type': world_type,
            'class': class_name,
            'ocid': ocid,
            'page': page,
        }
        r = self.fetch(path, query)
        return OverallRanking(**r)

    def get_union_ranking(self, world_name: str | None = None, ocid: str | None = None, page: int = 1,  date: datetime = get_proper_default_datetime(update_hour=8, update_minute=30, day_offset=0), ) -> UnionRanking:
        """유니온 랭킹 정보를 조회합니다.

        - 2023년 12월 22일 데이터부터 조회할 수 있습니다.
        - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        @param date(datetime): 조회 기준일(KST)
        @param world_name(str): 월드 명
        - 스카니아, 베라, 루나, 제니스, 크로아, 유니온, 엘리시움, 이노시스, 레드, 오로라, 아케인, 노바, 리부트, 리부트2, 버닝, 버닝2, 버닝3

        @param ocid(str): 캐릭터 식별자
        @param page(int): 페이지 번호
        """
        path = 'maplestory/v1/ranking/union'
        query = {
            'date': self.to_date_string(datetime(2023, 12, 22), date),
            'world_name': world_name,
            'ocid': ocid,
            'page': page,
        }
        r = self.fetch(path, query)
        return UnionRanking(**r)

    def get_guild_ranking(self, ranking_type: int, world_name: str | None = None, guild_name: str | None = None, page: int = 1,  date: datetime = get_proper_default_datetime(update_hour=8, update_minute=30, day_offset=0), ) -> GuildRanking:
        """길드 랭킹 정보를 조회합니다.

        - 2023년 12월 22일 데이터부터 조회할 수 있습니다.
        - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        @param date(datetime): 조회 기준일(KST)
        @param ranking_type(int): 랭킹 타입 (0:주간 명성치, 1:플래그 레이스, 2:지하 수로)

        @param world_name(str): 월드 명
        - 스카니아, 베라, 루나, 제니스, 크로아, 유니온, 엘리시움, 이노시스, 레드, 오로라, 아케인, 노바, 리부트, 리부트2, 버닝, 버닝2, 버닝3

        @param guild_name(str): 길드 명
        @param page(int): 페이지 번호
        """
        path = 'maplestory/v1/ranking/guild'
        query = {
            'date': self.to_date_string(datetime(2023, 12, 22), date),
            'ranking_type': ranking_type,
            'world_name': world_name,
            'guild_name': guild_name,
            'page': page,
        }
        r = self.fetch(path, query)
        return GuildRanking(**r)

    def get_dojang_ranking(self, world_name: str | None = None, class_name: str | None = None, ocid: str | None = None, page: int = 1, difficulty: int = 1,  date: datetime = get_proper_default_datetime(update_hour=8, update_minute=30, day_offset=0), ) -> DojangRanking:
        """무릉도장 랭킹 정보를 조회합니다.

        - 2023년 12월 22일 데이터부터 조회할 수 있습니다.
        - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        @param date(datetime): 조회 기준일(KST)
        @param difficulty(int): 구간 (0:일반, 1:통달)
        @param world_name(str): 월드 명
        - 스카니아, 베라, 루나, 제니스, 크로아, 유니온, 엘리시움, 이노시스, 레드, 오로라, 아케인, 노바, 리부트, 리부트2, 버닝, 버닝2, 버닝3

        @param class_name(str): 직업 및 전직
        - 초보자-전체 전직, 전사-전체 전직, 전사-검사, 전사-파이터, 전사-페이지, 전사-스피어맨, 전사-크루세이더, 전사-나이트, 전사-버서커, 전사-히어로, 전사-팔라딘, 전사-다크나이트, 마법사-전체 전직, 마법사-매지션, 마법사-위자드(불,독), 마법사-위자드(썬,콜), 마법사-클레릭, 마법사-메이지(불,독), 마법사-메이지(썬,콜), 마법사-프리스트, 마법사-아크메이지(불,독), 마법사-아크메이지(썬,콜), 마법사-비숍, 궁수-전체 전직, 궁수-아처, 궁수-헌터, 궁수-사수, 궁수-레인저, 궁수-저격수, 궁수-보우마스터, 궁수-신궁, 궁수-아처(패스파인더), 궁수-에인션트아처, 궁수-체이서, 궁수-패스파인더, 도적-전체 전직, 도적-로그, 도적-어쌔신, 도적-시프, 도적-허밋, 도적-시프마스터, 도적-나이트로드, 도적-섀도어, 도적-세미듀어러, 도적-듀어러, 도적-듀얼마스터, 도적-슬래셔, 도적-듀얼블레이더, 해적-전체 전직, 해적-해적, 해적-인파이터, 해적-건슬링거, 해적-캐논슈터, 해적-버커니어, 해적-발키리, 해적-캐논블래스터, 해적-바이퍼, 해적-캡틴, 해적-캐논마스터, 기사단-전체 전직, 기사단-노블레스, 기사단-소울마스터, 기사단-플레임위자드, 기사단-윈드브레이커, 기사단-나이트워커, 기사단-스트라이커, 기사단-미하일, 아란-전체 전직, 에반-전체 전직, 레지스탕스-전체 전직, 레지스탕스-시티즌, 레지스탕스-배틀메이지, 레지스탕스-와일드헌터, 레지스탕스-메카닉, 레지스탕스-데몬슬레이어, 레지스탕스-데몬어벤져, 레지스탕스-제논, 레지스탕스-블래스터, 메르세데스-전체 전직, 팬텀-전체 전직, 루미너스-전체 전직, 카이저-전체 전직, 엔젤릭버스터-전체 전직, 초월자-전체 전직, 초월자-제로, 은월-전체 전직, 프렌즈 월드-전체 전직, 프렌즈 월드-키네시스, 카데나-전체 전직, 일리움-전체 전직, 아크-전체 전직, 호영-전체 전직, 아델-전체 전직, 카인-전체 전직, 라라-전체 전직, 칼리-전체 전직

        @param ocid(str): 캐릭터 식별자
        @param page(int): 페이지 번호
        """
        path = 'maplestory/v1/ranking/dojang'
        query = {
            'date': self.to_date_string(datetime(2023, 12, 22), date),
            'world_name': world_name,
            'class': class_name,
            'ocid': ocid,
            'page': page,
            'difficulty': difficulty,
        }
        r = self.fetch(path, query)
        return DojangRanking(**r)

    def get_theseed_ranking(self, world_name: str | None = None, ocid: str | None = None, page: int = 1, date: datetime = get_proper_default_datetime(update_hour=8, update_minute=30, day_offset=0), ) -> TheSeedRanking:
        """더 시드 랭킹 정보를 조회합니다.

        - 2023년 12월 22일 데이터부터 조회할 수 있습니다.
        - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        @param date(datetime): 조회 기준일(KST)
        @param world_name(str): 월드 명
        - 스카니아, 베라, 루나, 제니스, 크로아, 유니온, 엘리시움, 이노시스, 레드, 오로라, 아케인, 노바, 리부트, 리부트2, 버닝, 버닝2, 버닝3
        @param ocid(str): 캐릭터 식별자
        @param page(int): 페이지 번호
        """
        path = 'maplestory/v1/ranking/theseed'
        query = {
            'date': self.to_date_string(datetime(2023, 12, 22), date),
            'world_name': world_name,
            'ocid': ocid,
            'page': page,
        }
        r = self.fetch(path, query)
        return TheSeedRanking(**r)

    def get_achievement_ranking(self, ocid: str | None = None, page: int = 1, date: datetime = get_proper_default_datetime(update_hour=8, update_minute=30, day_offset=0)) -> AchievementRanking:
        """업적 랭킹 정보를 조회합니다.

        - 2023년 12월 22일 데이터부터 조회할 수 있습니다.
        - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        @param date(datetime): 조회 기준일(KST)
        @param ocid(str): 캐릭터 식별자
        @param page(int): 페이지 번호
        """
        path = 'maplestory/v1/ranking/achievement'
        query = {
            'date': self.to_date_string(datetime(2023, 12, 22), date),
            'ocid': ocid,
            'page': page,
        }
        r = self.fetch(path, query)
        return AchievementRanking(**r)

    #endregion

    def fetch(self, path: str, query: dict) -> Any:
        r = requests.get(
            f'{self.BASE_URL}{path}',
            params=query,
            headers={
                'x-nxopen-api-key': self.api_key,
            },
            timeout=self.timeout,
        ).json()

        if (r.get('error')):
            raise MapleStoryApiException(MapleStoryApiError(**r.get('error')))

        return r

    def to_date_string(self, min: datetime, date: datetime) -> str:
        min_date = self.get_kst_datetime(min)
        target_date = self.get_kst_datetime(date)
        if target_date < min_date:
            raise ValueError(
                f'You can only retrieve data after {min_date.strftime("%Y-%m-%d")}')
        return target_date.strftime('%Y-%m-%d')

    def get_kst_datetime(self, date: datetime) -> datetime:
        """datetime 객체를 KST datetime 객체로 변환합니다.

        datetime.astimezone()을 사용하면 지역에 따라 다른 결과가 나오고 date.replace()에도 버그가 존재하므로 datetime으로 재설정합니다.
        """
        return datetime(year=date.year, month=date.month, day=date.day, tzinfo=ZoneInfo('Asia/Seoul'))

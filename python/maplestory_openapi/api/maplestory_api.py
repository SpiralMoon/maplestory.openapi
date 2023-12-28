from datetime import datetime
from zoneinfo import ZoneInfo
from typing import Any
from pydantic import BaseModel
import requests

from maplestory_openapi.api.dto.character_basic import CharacterBasic
from maplestory_openapi.api.dto.character_popularity import CharacterPopularity
from maplestory_openapi.api.dto.character_stat import CharacterStat
from maplestory_openapi.api.dto.character_hyper_stat import CharacterHyperStat
from maplestory_openapi.api.dto.character_propensity import CharacterPropensity
from maplestory_openapi.api.dto.character_ability import CharacterAbility
from maplestory_openapi.api.dto.character_item_equipment import CharacterItemEquipment
from maplestory_openapi.api.dto.character_cashitem_equipment import CharacterCashitemEquipment
from maplestory_openapi.api.dto.character_symbol_equipment import CharacterSymbolEquipment
from maplestory_openapi.api.dto.character_set_effect import CharacterSetEffect
from maplestory_openapi.api.dto.character_beauty_equipment import CharacterBeautyEquipment
from maplestory_openapi.api.dto.character_android_equipment import CharacterAndroidEquipment
from maplestory_openapi.api.dto.character_pet_equipment import CharacterPetEquipment
from maplestory_openapi.api.dto.character_skill import CharacterSkill
from maplestory_openapi.api.dto.character_link_skill import CharacterLinkSkill
from maplestory_openapi.api.dto.character_vmatrix import CharacterVMatrix
from maplestory_openapi.api.dto.character_hexamatrix import CharacterHexaMatrix
from maplestory_openapi.api.dto.character_hexamatrix_stat import CharacterHexaMatrixStat
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

    def get_character_id(self, character_name: str) -> str:
        """캐릭터 식별자(ocid)를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 오전 1시부터 전일 데이터 조회가 가능합니다
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.

        @param character_name (str): 캐릭터 이름
        """

        path = 'maplestory/v1/id'
        query = {
            'character_name': character_name,
        }
        r = self.fetch(path, query)
        return r.get('ocid')

    def get_character_basic(self, ocid: str, date: datetime = get_proper_default_datetime()) -> CharacterBasic:
        """기본 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 오전 1시부터 전일 데이터 조회가 가능합니다
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

    def get_character_popularity(self, ocid: str, date: datetime = get_proper_default_datetime()) -> CharacterPopularity:
        """인기도 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 오전 1시부터 전일 데이터 조회가 가능합니다
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

    def get_character_stat(self, ocid: str, date: datetime = get_proper_default_datetime()) -> CharacterStat:
        """종합능력치 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 오전 1시부터 전일 데이터 조회가 가능합니다
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

    def get_character_hyper_stat(self, ocid: str, date: datetime = get_proper_default_datetime()) -> CharacterHyperStat:
        """하이퍼스탯 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 오전 1시부터 전일 데이터 조회가 가능합니다
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

    def get_character_propensity(self, ocid: str, date: datetime = get_proper_default_datetime()) -> CharacterPropensity:
        """성향 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 오전 1시부터 전일 데이터 조회가 가능합니다
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

    def get_character_ability(self, ocid: str, date: datetime = get_proper_default_datetime()) -> CharacterAbility:
        """어빌리티 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 오전 1시부터 전일 데이터 조회가 가능합니다
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

    def get_character_item_equipment(self, ocid: str, date: datetime = get_proper_default_datetime()) -> CharacterItemEquipment:
        """장착한 장비 중 캐시 장비를 제외한 나머지 장비 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 오전 1시부터 전일 데이터 조회가 가능합니다
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

    def get_character_cashitem_equipment(self, ocid: str, date: datetime = get_proper_default_datetime()) -> CharacterCashitemEquipment:
        """장착한 캐시 장비 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 오전 1시부터 전일 데이터 조회가 가능합니다
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

    def get_character_symbol_equipment(self, ocid: str, date: datetime = get_proper_default_datetime()) -> CharacterSymbolEquipment:
        """장착한 심볼 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 오전 1시부터 전일 데이터 조회가 가능합니다
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

    def get_character_set_effect(self, ocid: str, date: datetime = get_proper_default_datetime()) -> CharacterSetEffect:
        """적용받고 있는 세트 효과 정보를 조회합니다

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 오전 1시부터 전일 데이터 조회가 가능합니다.
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

    def get_character_beauty_equipment(self, ocid: str, date: datetime = get_proper_default_datetime()) -> CharacterBeautyEquipment:
        """캐릭터 헤어, 성형, 피부 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 오전 1시부터 전일 데이터 조회가 가능합니다.
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

    def get_character_android_equipment(self, ocid: str, date: datetime = get_proper_default_datetime()) -> CharacterAndroidEquipment:
        """장착한 안드로이드 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 오전 1시부터 전일 데이터 조회가 가능합니다.
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

    def get_character_pet_equipment(self, ocid: str, date: datetime = get_proper_default_datetime()) -> CharacterPetEquipment:
        """장착한 펫 및 펫 스킬, 장비 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 오전 1시부터 전일 데이터 조회가 가능합니다.
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

    def get_character_skill(self, ocid: str, character_skill_grade: str, date: datetime = get_proper_default_datetime()) -> CharacterSkill:
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

    def get_character_link_skill(self, ocid: str, date: datetime = get_proper_default_datetime()) -> CharacterLinkSkill:
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

    def get_character_vmatrix(self, ocid: str, date: datetime = get_proper_default_datetime()) -> CharacterVMatrix:
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

    def get_character_hexamatrix(self, ocid: str, date: datetime = get_proper_default_datetime()) -> CharacterHexaMatrix:
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

    def get_character_hexamatrix_stat(self, ocid: str, date: datetime = get_proper_default_datetime()) -> CharacterHexaMatrixStat:
        """HEXA 매트릭스에 설정한 HEXA 스탯 정보를 조회합니다.

        - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
        - 오전 0시부터 전일 데이터 조회가 가능합니다.
        - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신시 유의해 주시기 바랍니다.

        @param ocid(str): 캐릭터 식별자(ocid)
        """
        path = 'maplestory/v1/character/hexamatrix-stat'
        query = {
            'ocid': ocid,
            'date': self.to_date_string(datetime(2023, 12, 21), date),
        }
        r = self.fetch(path, query)
        return CharacterHexaMatrixStat(**r)

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

    def to_date_string(self, min: datetime, date: datetime = get_proper_default_datetime()) -> str:
        min_date = self.get_kst_datetime(min)
        target_date = self.get_kst_datetime(date)
        if target_date < min_date:
            raise ValueError(
                f'You can only retrieve data after {min_date.strftime("%Y-%m-%d")}')
        return target_date.strftime('%Y-%m-%d')

    def get_kst_datetime(self, date: datetime = get_proper_default_datetime()) -> datetime:
        """datetime 객체를 KST datetime 객체로 변환합니다.

        datetime.astimezone()을 사용하면 지역에 따라 다른 결과가 나오고 date.replace()에도 버그가 존재하므로 datetime으로 재설정합니다.
        """
        return datetime(year=date.year, month=date.month, day=date.day, tzinfo=ZoneInfo('Asia/Seoul'))

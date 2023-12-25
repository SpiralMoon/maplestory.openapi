from datetime import datetime, timedelta
from typing import Any
from pydantic import BaseModel
from zoneinfo import ZoneInfo
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


class MaplestoryApi(BaseModel):
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

    def get_character_basic(self, ocid: str, date: datetime = datetime.now()) -> CharacterBasic:
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

        return CharacterBasic(
            character_name=r.get('character_name'),
            world_name=r.get('world_name'),
            character_gender=r.get('character_gender'),
            character_class=r.get('character_class'),
            character_class_level=r.get('character_class_level'),
            character_level=r.get('character_level'),
            character_exp=r.get('character_exp'),
            character_exp_rate=r.get('character_exp_rate'),
            character_guild_name=r.get('character_guild_name'),
            character_image=r.get('character_image'),
        )

    def get_character_popularity(self, ocid: str, date: datetime = datetime.now()) -> CharacterPopularity:
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

    def get_character_stat(self, ocid: str, date: datetime = datetime.now()) -> CharacterStat:
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

        return CharacterStat(
            date=r.get('date'),
            character_class=r.get('character_class'),
            final_stat=r.get('final_stat'),
            remain_ap=r.get('remain_ap'),
        )

    def get_character_hyper_stat(self, ocid: str, date: datetime = datetime.now()) -> CharacterHyperStat:
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

        return CharacterHyperStat(
            date=r.get('date'),
            character_class=r.get('character_class'),
            use_preset_no=r.get('use_preset_no'),
            use_available_hyper_stat=r.get('use_available_hyper_stat'),
            hyper_stat_preset_1=r.get('hyper_stat_preset_1'),
            hyper_stat_preset_1_remain_point=r.get(
                'hyper_stat_preset_1_remain_point'),
            hyper_stat_preset_2=r.get('hyper_stat_preset_2'),
            hyper_stat_preset_2_remain_point=r.get(
                'hyper_stat_preset_2_remain_point'),
            hyper_stat_preset_3=r.get('hyper_stat_preset_3'),
            hyper_stat_preset_3_remain_point=r.get(
                'hyper_stat_preset_3_remain_point'),
        )

    def get_character_propensity(self, ocid: str, date: datetime = datetime.now()) -> CharacterPropensity:
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

        return CharacterPropensity(
            date=r.get('date'),
            charisma_level=r.get('charisma_level'),
            sensibility_level=r.get('sensibility_level'),
            insight_level=r.get('insight_level'),
            willingness_level=r.get('willingness_level'),
            handicraft_level=r.get('handicraft_level'),
            charm_level=r.get('charm_level'),
        )

    def get_character_ability(self, ocid: str, date: datetime = datetime.now()) -> CharacterAbility:
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

        return CharacterAbility(
            date=r.get('date'),
            ability_grade=r.get('ability_grade'),
            ability_info=r.get('ability_info'),
            remain_fame=r.get('remain_fame'),
        )

    def get_character_item_equipment(self, ocid: str, date: datetime = datetime.now()) -> CharacterItemEquipment:
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

        return CharacterItemEquipment(
            date=r.get('date'),
            character_gender=r.get('character_gender'),
            character_class=r.get('character_class'),
            item_equipment=r.get('item_equipment'),
            title=r.get('title'),
            dragon_equipment=r.get('dragon_equipment'),
            mechanic_equipment=r.get('mechanic_equipment'),
        )

    def get_character_cashitem_equipment(self, ocid: str, date: datetime = datetime.now()) -> CharacterCashitemEquipment:
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

        return CharacterCashitemEquipment(
            date=r.get('date'),
            character_gender=r.get('character_gender'),
            character_class=r.get('character_class'),
            preset_no=r.get('preset_no'),
            cash_item_equipment_preset_1=r.get('cash_item_equipment_preset_1'),
            cash_item_equipment_preset_2=r.get('cash_item_equipment_preset_2'),
            cash_item_equipment_preset_3=r.get('cash_item_equipment_preset_3'),
            additional_cash_item_equipment_preset_1=r.get(
                'additional_cash_item_equipment_preset_1'),
            additional_cash_item_equipment_preset_2=r.get(
                'additional_cash_item_equipment_preset_2'),
            additional_cash_item_equipment_preset_3=r.get(
                'additional_cash_item_equipment_preset_3'),
        )

    def get_character_symbol_equipment(self, ocid: str, date: datetime = datetime.now()) -> CharacterSymbolEquipment:
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
        return CharacterSymbolEquipment(
            date=r.get('date'),
            character_class=r.get('character_class'),
            symbol=r.get('symbol'),
        )

    def fetch(self, path: str, query: dict) -> Any:
        return requests.get(
            f'{self.BASE_URL}{path}',
            params=query,
            headers={
                'x-nxopen-api-key': self.api_key,
            },
            timeout=self.timeout,
        ).json()

    def to_date_string(self, min_date: datetime, date: datetime) -> str:
        min_date = min_date.astimezone(ZoneInfo('Asia/Seoul'))
        target_date = date.astimezone(ZoneInfo('Asia/Seoul'))
        max_date = datetime.now(tz=ZoneInfo('Asia/Seoul')) - timedelta(days=1)
        if target_date < min_date:
            return min_date.strftime('%Y-%m-%d')
        if target_date > max_date:
            return max_date.strftime('%Y-%m-%d')
        return date.strftime('%Y-%m-%d')

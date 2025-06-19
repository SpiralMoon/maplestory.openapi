from datetime import datetime
from pydantic import BaseModel, model_validator

from maplestory_openapi.api.common.dto.character.character_cashitem_equipment import CharacterCashitemEquipmentColoringPrism as BaseCharacterCashitemEquipmentColoringPrism
from maplestory_openapi.api.common.dto.character.character_cashitem_equipment import CharacterCashitemEquipmentOption as BaseCharacterCashitemEquipmentOption
from maplestory_openapi.api.common.dto.character.character_cashitem_equipment import CharacterCashitemEquipmentPreset as BaseCharacterCashitemEquipmentPreset
from maplestory_openapi.api.common.dto.character.character_cashitem_equipment import CharacterCashitemEquipment as BaseCharacterCashitemEquipment


class CharacterCashitemEquipmentColoringPrism(BaseModel, BaseCharacterCashitemEquipmentColoringPrism):
    """
    캐릭터 캐시 장비 컬러링프리즘

    Attributes:
        color_range (str): 컬러링프리즘 색상 범위
        hue (int): 컬러링프리즘 색상
        saturation (int): 컬러링프리즘 채도
        value (int): 컬러링프리즘 명도
    """
    color_range: str
    hue: int
    saturation: int
    value: int


class CharacterCashitemEquipmentOption(BaseModel, BaseCharacterCashitemEquipmentOption):
    """
    캐릭터 캐시 장비 옵션

    Attributes:
        option_type (str): 옵션 종류
        option_value (str): 옵션 값
    """
    option_type: str
    option_value: str


class CharacterCashitemEquipmentPreset(BaseModel, BaseCharacterCashitemEquipmentPreset):
    """
    캐릭터 프리셋 장착 캐시 장비 정보

    Attributes:
        cash_item_equipment_part (str): 캐시 장비 부위 명
        cash_item_equipment_slot (str): 캐시 장비 슬롯 위치
        cash_item_name (str): 캐시 장비 명
        cash_item_icon (str): 캐시 장비 아이콘
        cash_item_description (str or None): 캐시 장비 설명
        cash_item_option (list[CharacterCashitemEquipmentOption]): 캐시 장비 옵션
        date_expire (datetime or None): 캐시 장비 유효 기간 (KST)
        is_expired (bool): 캐시 장비 유효 기간 만료 여부
        date_option_expire (datetime or None): 캐시 장비 옵션 유효 기간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
        is_option_expired (bool): 캐시 장비 옵션 유효 기간 만료 여부
        cash_item_label (str or None): 캐시 장비 라벨 정보
        cash_item_coloring_prism (CharacterCashitemEquipmentColoringPrism or None): 캐시 장비 컬러링프리즘 정보
        item_gender (str or None): 아이템 장착 가능 성별
        skills (list[str]): 스킬명
        freestyle_flag (str or None): 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
    """
    cash_item_equipment_part: str
    cash_item_equipment_slot: str
    cash_item_name: str
    cash_item_icon: str
    cash_item_description: str | None
    cash_item_option: list[CharacterCashitemEquipmentOption]
    date_expire: datetime | None
    is_expired: bool = False
    date_option_expire: datetime | None
    is_option_expired: bool = False
    cash_item_label: str | None
    cash_item_coloring_prism: CharacterCashitemEquipmentColoringPrism | None
    item_gender: str | None
    skills: list[str]
    freestyle_flag: str | None

    @property
    def is_freestyle_flag(self) -> bool:
        """
        프리스타일 쿠폰 적용 여부
        """
        return self.freestyle_flag == '1'

class CharacterCashitemEquipment(BaseModel, BaseCharacterCashitemEquipment):
    """
    캐릭터 캐시 장비 아이템 정보

    Attributes:
        date (datetime or None): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        character_gender (str or None): 캐릭터 성별
        character_class (str or None): 캐릭터 직업
        character_look_mode (str or None): 캐릭터 외형 모드 (0: 일반 모드, 1: 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드)
        preset_no (int or None): 적용 중인 캐시 장비 프리셋 번호
        cash_item_equipment_base (list[CharacterCashitemEquipmentPreset]): 장착 중인 캐시 장비
        cash_item_equipment_preset_1 (list[CharacterCashitemEquipmentPreset]): 1번 코디 프리셋
        cash_item_equipment_preset_2 (list[CharacterCashitemEquipmentPreset]): 2번 코디 프리셋
        cash_item_equipment_preset_3 (list[CharacterCashitemEquipmentPreset]): 3번 코디 프리셋
        additional_cash_item_equipment_base (list[CharacterCashitemEquipmentPreset]): 제로/엔젤릭버스터 모드 장착 캐시 장비
        additional_cash_item_equipment_preset_1 (list[CharacterCashitemEquipmentPreset]): 제로/엔젤릭버스터 모드의 1번 코디 프리셋
        additional_cash_item_equipment_preset_2 (list[CharacterCashitemEquipmentPreset]): 제로/엔젤릭버스터 모드의 2번 코디 프리셋
        additional_cash_item_equipment_preset_3 (list[CharacterCashitemEquipmentPreset]): 제로/엔젤릭버스터 모드의 3번 코디 프리셋
    """
    date: datetime | None
    character_gender: str | None
    character_class: str | None
    character_look_mode: str | None
    preset_no: int | None
    cash_item_equipment_base: list[CharacterCashitemEquipmentPreset]
    cash_item_equipment_preset_1: list[CharacterCashitemEquipmentPreset]
    cash_item_equipment_preset_2: list[CharacterCashitemEquipmentPreset]
    cash_item_equipment_preset_3: list[CharacterCashitemEquipmentPreset]
    additional_cash_item_equipment_base: list[CharacterCashitemEquipmentPreset]
    additional_cash_item_equipment_preset_1: list[CharacterCashitemEquipmentPreset]
    additional_cash_item_equipment_preset_2: list[CharacterCashitemEquipmentPreset]
    additional_cash_item_equipment_preset_3: list[CharacterCashitemEquipmentPreset]

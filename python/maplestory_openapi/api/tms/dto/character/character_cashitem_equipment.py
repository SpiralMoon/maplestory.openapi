from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_cashitem_equipment import CharacterCashitemEquipmentColoringPrism as BaseCharacterCashitemEquipmentColoringPrism
from maplestory_openapi.api.common.dto.character.character_cashitem_equipment import CharacterCashitemEquipmentOption as BaseCharacterCashitemEquipmentOption
from maplestory_openapi.api.common.dto.character.character_cashitem_equipment import CharacterCashitemEquipmentPreset as BaseCharacterCashitemEquipmentPreset
from maplestory_openapi.api.common.dto.character.character_cashitem_equipment import CharacterCashitemEquipment as BaseCharacterCashitemEquipment


class CharacterCashitemEquipmentColoringPrism(BaseModel, BaseCharacterCashitemEquipmentColoringPrism):
    """
    現金道具彩色稜鏡資訊

    Attributes:
        color_range (str): 彩色稜鏡顏色範圍
        hue (int): 彩色稜鏡色調
        saturation (int): 彩色稜鏡彩度
        value (int): 彩色稜鏡明度
    """
    color_range: str
    hue: int
    saturation: int
    value: int


class CharacterCashitemEquipmentOption(BaseModel, BaseCharacterCashitemEquipmentOption):
    """
    現金道具選項

    Attributes:
        option_type (str): 選項類型
        option_value (str): 選項數值
    """
    option_type: str
    option_value: str


class CharacterCashitemEquipmentPreset(BaseModel, BaseCharacterCashitemEquipmentPreset):
    """
    外型預設

    Attributes:
        cash_item_equipment_part (str): 現金道具部位名稱
        cash_item_equipment_slot (str): 現金道具欄位位置
        cash_item_name (str): 現金道具名稱
        cash_item_icon (str): 現金道具圖示
        cash_item_description (str or None): 現金道具描述
        cash_item_option (list[CharacterCashitemEquipmentOption]): 現金道具選項
        date_expire (datetime or None): 現金道具有效期間 (TST)
        is_expired (bool): Whether the cash equipment is expired
        date_option_expire (datetime or None): 現金道具選項有效期間 (TST，時間單位資料中的分鐘顯示為 0)
        is_option_expired (bool): Whether the cash equipment option is expired
        cash_item_label (str or None): 現金道具等級資訊
        cash_item_coloring_prism (CharacterCashitemEquipmentColoringPrism or None): 現金道具彩色稜鏡資訊
        item_gender (str or None): 道具可裝備性別
        skills (list[str]): 技能名稱
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


class CharacterCashitemEquipment(BaseModel, BaseCharacterCashitemEquipment):
    """
    角色已裝備現金道具資訊

    Attributes:
        date (datetime or None): 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        character_gender (str or None): 角色性別
        character_class (str or None): 角色職業
        character_look_mode (str or None): 角色外型模式 (0：一般模式，1：神之子為 Beta、天使破壞者為變裝模式時)
        preset_no (int or None): 目前套用的現金道具預設編號
        cash_item_equipment_base (list[CharacterCashitemEquipmentPreset]): 目前已裝備的現金道具
        cash_item_equipment_preset_1 (list[CharacterCashitemEquipmentPreset]): 外型預設 1
        cash_item_equipment_preset_2 (list[CharacterCashitemEquipmentPreset]): 外型預設 2
        cash_item_equipment_preset_3 (list[CharacterCashitemEquipmentPreset]): 外型預設 3
        additional_cash_item_equipment_base (list[CharacterCashitemEquipmentPreset]): 神之子為 Beta 及天使破壞者為變裝模式時의 현재 已裝備現金道具
        additional_cash_item_equipment_preset_1 (list[CharacterCashitemEquipmentPreset]): 神之子為 Beta 及天使破壞者為變裝模式時的外型預設 1
        additional_cash_item_equipment_preset_2 (list[CharacterCashitemEquipmentPreset]): 神之子為 Beta 及天使破壞者為變裝模式時的外型預設 2
        additional_cash_item_equipment_preset_3 (list[CharacterCashitemEquipmentPreset]): 神之子為 Beta 及天使破壞者為變裝模式時的外型預設 3
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

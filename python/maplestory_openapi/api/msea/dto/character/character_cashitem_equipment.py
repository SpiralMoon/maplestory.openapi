from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_cashitem_equipment import CharacterCashitemEquipmentColoringPrism as BaseCharacterCashitemEquipmentColoringPrism
from maplestory_openapi.api.common.dto.character.character_cashitem_equipment import CharacterCashitemEquipmentOption as BaseCharacterCashitemEquipmentOption
from maplestory_openapi.api.common.dto.character.character_cashitem_equipment import CharacterCashitemEquipmentPreset as BaseCharacterCashitemEquipmentPreset
from maplestory_openapi.api.common.dto.character.character_cashitem_equipment import CharacterCashitemEquipment as BaseCharacterCashitemEquipment


class CharacterCashitemEquipmentColoringPrism(BaseModel, BaseCharacterCashitemEquipmentColoringPrism):
    """
    Cash equipment coloring prism information

    Attributes:
        color_range (str): Coloring prism color range
        hue (int): Coloring prism hue
        saturation (int): Coloring prism saturation
        value (int): Coloring prism brightness
    """
    color_range: str
    hue: int
    saturation: int
    value: int


class CharacterCashitemEquipmentOption(BaseModel, BaseCharacterCashitemEquipmentOption):
    """
    Cash equipment option

    Attributes:
        option_type (str): Option type
        option_value (str): Option value
    """
    option_type: str
    option_value: str


class CharacterCashitemEquipmentPreset(BaseModel, BaseCharacterCashitemEquipmentPreset):
    """
    Equipped cash item preset information

    Attributes:
        cash_item_equipment_part (str): Cash equipment part name
        cash_item_equipment_slot (str): Cash equipment slot position
        cash_item_name (str): Cash equipment name
        cash_item_icon (str): Cash equipment icon
        cash_item_description (str or None): Cash equipment description
        cash_item_option (list[CharacterCashitemEquipmentOption]): Cash equipment option
        date_expire (datetime or None): Cash equipment validity period (SGT)
        is_expired (bool): Whether the cash equipment is expired
        date_option_expire (datetime or None): Cash equipment option validity period (SGT, data with minutes set to 0)
        is_option_expired (bool): Whether the cash equipment option is expired
        cash_item_label (str or None): Cash equipment label information
        cash_item_coloring_prism (CharacterCashitemEquipmentColoringPrism or None): Cash equipment coloring prism information
        item_gender (str or None): Gender compatibility for item equipment
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


class CharacterCashitemEquipment(BaseModel, BaseCharacterCashitemEquipment):
    """
    Character cash item equipment information

    Attributes:
        date (datetime or None): Reference date for query (SGT, daily data with hours and minutes set to 0)
        character_gender (str or None): Character gender
        character_class (str or None): Character job
        character_look_mode (str or None): Character appearance mode (0:Normal mode, 1:Beta for Zero, Dress-up mode for Angelic Buster)
        preset_no (int or None): Preset number for equipped cash item
        cash_item_equipment_base (list[CharacterCashitemEquipmentPreset]): Equipped cash item
        cash_item_equipment_preset_1 (list[CharacterCashitemEquipmentPreset]): Cosmetic item preset 1
        cash_item_equipment_preset_2 (list[CharacterCashitemEquipmentPreset]): Cosmetic item preset 2
        cash_item_equipment_preset_3 (list[CharacterCashitemEquipmentPreset]): Cosmetic item preset 3
        additional_cash_item_equipment_base (list[CharacterCashitemEquipmentPreset]): Equipped cash items for Beta mode (if Zero) or Dress-up mode (if Angelic Buster)
        additional_cash_item_equipment_preset_1 (list[CharacterCashitemEquipmentPreset]): Cosmetic item preset 1 for Beta mode (if Zero) or Dress-up mode (if Angelic Buster)
        additional_cash_item_equipment_preset_2 (list[CharacterCashitemEquipmentPreset]): Cosmetic item preset 2 for Beta mode (if Zero) or Dress-up mode (if Angelic Buster)
        additional_cash_item_equipment_preset_3 (list[CharacterCashitemEquipmentPreset]): Cosmetic item preset 3 for Beta mode (if Zero) or Dress-up mode (if Angelic Buster)
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

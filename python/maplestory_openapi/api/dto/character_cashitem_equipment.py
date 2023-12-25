from datetime import datetime
from pydantic import BaseModel


class CharacterCashitemEquipmentColoringPrism(BaseModel):
    color_range: str
    hue: int
    saturation: int
    value: int


class CharacterCashitemEquipmentOption(BaseModel):
    option_type: str
    option_value: str


class CharacterCashitemEquipmentPreset(BaseModel):
    cash_item_equipment_part: str
    cash_item_equipment_slot: str
    cash_item_name: str
    cash_item_icon: str
    cash_item_description: str | None
    cash_item_option: list[CharacterCashitemEquipmentOption]
    date_expire: datetime | None
    date_option_expire: datetime | None
    cash_item_label: str | None
    cash_item_coloring_prism: CharacterCashitemEquipmentColoringPrism | None
    base_preset_item_disable_flag: str


class CharacterCashitemEquipment(BaseModel):
    date: datetime
    character_gender: str
    character_class: str
    preset_no: int
    cash_item_equipment_preset_1: list[CharacterCashitemEquipmentPreset]
    cash_item_equipment_preset_2: list[CharacterCashitemEquipmentPreset]
    cash_item_equipment_preset_3: list[CharacterCashitemEquipmentPreset]
    additional_cash_item_equipment_preset_1: list[CharacterCashitemEquipmentPreset]
    additional_cash_item_equipment_preset_2: list[CharacterCashitemEquipmentPreset]
    additional_cash_item_equipment_preset_3: list[CharacterCashitemEquipmentPreset]

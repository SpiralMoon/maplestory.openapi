from datetime import datetime
from pydantic import model_validator


class CharacterCashitemEquipmentColoringPrism:
    color_range: str
    hue: int
    saturation: int
    value: int


class CharacterCashitemEquipmentOption:
    option_type: str
    option_value: str


class CharacterCashitemEquipmentPreset:
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

    @model_validator(mode="before")
    @classmethod
    def set_default(cls, values):
        if values.get("date_expire") == 'expired':
            values["is_expired"] = True
            values["date_expire"] = None
        if values.get("date_option_expire") == 'expired':
            values["is_option_expired"] = True
            values["date_option_expire"] = None
        return values


class CharacterCashitemEquipment:
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

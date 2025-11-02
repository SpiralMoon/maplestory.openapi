from datetime import datetime


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
    cash_item_option: list[CharacterCashitemEquipmentOption] = []
    date_expire: datetime | None
    is_expired: bool | None = None
    date_option_expire: datetime | None
    is_option_expired: bool | None = None
    cash_item_label: str | None
    cash_item_coloring_prism: CharacterCashitemEquipmentColoringPrism | None
    item_gender: str | None


class CharacterCashitemEquipment:
    date: datetime | None
    character_gender: str | None
    character_class: str | None
    character_look_mode: str | None
    preset_no: int | None
    cash_item_equipment_base: list[CharacterCashitemEquipmentPreset] = []
    cash_item_equipment_preset_1: list[CharacterCashitemEquipmentPreset] = []
    cash_item_equipment_preset_2: list[CharacterCashitemEquipmentPreset] = []
    cash_item_equipment_preset_3: list[CharacterCashitemEquipmentPreset] = []
    additional_cash_item_equipment_base: list[CharacterCashitemEquipmentPreset] = []
    additional_cash_item_equipment_preset_1: list[CharacterCashitemEquipmentPreset] = []
    additional_cash_item_equipment_preset_2: list[CharacterCashitemEquipmentPreset] = []
    additional_cash_item_equipment_preset_3: list[CharacterCashitemEquipmentPreset] = []

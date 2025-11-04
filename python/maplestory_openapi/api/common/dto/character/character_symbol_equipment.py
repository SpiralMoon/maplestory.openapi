from datetime import datetime


class CharacterSymbolEquipmentInfo:
    symbol_name: str
    symbol_icon: str
    symbol_description: str
    symbol_force: str
    symbol_level: int
    symbol_str: str
    symbol_dex: str
    symbol_int: str
    symbol_luk: str
    symbol_hp: str
    symbol_drop_rate: str | None
    symbol_meso_rate: str | None
    symbol_exp_rate: str | None
    symbol_growth_count: int
    symbol_require_growth_count: int


class CharacterSymbolEquipment:
    date: datetime | None
    character_class: str
    symbol: list[CharacterSymbolEquipmentInfo] = []

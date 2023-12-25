from datetime import datetime
from pydantic import BaseModel


class CharacterSymbolEquipmentInfo(BaseModel):
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
    symbol_growth_count: int
    symbol_require_growth_count: int


class CharacterSymbolEquipment(BaseModel):
    date: datetime
    character_class: str
    symbol: list[CharacterSymbolEquipmentInfo]

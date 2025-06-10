from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_symbol_equipment import CharacterSymbolEquipmentInfo as BaseCharacterSymbolEquipmentInfo
from maplestory_openapi.api.common.dto.character.character_symbol_equipment import CharacterSymbolEquipment as BaseCharacterSymbolEquipment


class CharacterSymbolEquipmentInfo(BaseModel, BaseCharacterSymbolEquipmentInfo):
    """
    Symbol information

    Attributes:
        symbol_name (str): Symbol name
        symbol_icon (str): Symbol icon
        symbol_description (str): Symbol description
        symbol_force (str): Increase in stats due to the symbol
        symbol_level (int): Symbol level
        symbol_str (str): Increase in Strength due to the symbol
        symbol_dex (str): Increase in Dexterity due to the symbol
        symbol_int (str): Increase in Intelligence due to the symbol
        symbol_luk (str): Increase in Luck due to the symbol
        symbol_hp (str): Increase in HP due to the symbol
        symbol_drop_rate (str or None): Increase in item drop rate due to the symbol
        symbol_meso_rate (str or None): Increase in Meso acquisition rate due to the symbol
        symbol_exp_rate (str or None): Increase in EXP acquisition rate due to the symbol
        symbol_growth_count (int): Current growth points
        symbol_require_growth_count (int): Growth points required for the next level
    """
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


class CharacterSymbolEquipment(BaseModel, BaseCharacterSymbolEquipment):
    """
    Character equipped symbol information

    Attributes:
        date (datetime or None): Reference date for query (SGT, daily data with hours and minutes set to 0)
        character_class (str or None): Character job
        symbol (list[CharacterSymbolEquipmentInfo]): Symbol information
    """
    date: datetime | None
    character_class: str | None
    symbol: list[CharacterSymbolEquipmentInfo]

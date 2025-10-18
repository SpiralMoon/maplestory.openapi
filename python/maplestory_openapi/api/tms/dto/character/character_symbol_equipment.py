from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_symbol_equipment import CharacterSymbolEquipmentInfo as BaseCharacterSymbolEquipmentInfo
from maplestory_openapi.api.common.dto.character.character_symbol_equipment import CharacterSymbolEquipment as BaseCharacterSymbolEquipment


class CharacterSymbolEquipmentInfo(BaseModel, BaseCharacterSymbolEquipmentInfo):
    """
    符文資訊

    Attributes:
        symbol_name (str): 符文名稱
        symbol_icon (str): 符文圖示
        symbol_description (str): 符文描述
        symbol_force (str): 因符文增加的數值
        symbol_level (int): 符文等級
        symbol_str (str): 符文增加的力量 (STR)
        symbol_dex (str): 符文增加的敏捷 (DEX)
        symbol_int (str): 符文增加的智力 (INT)
        symbol_luk (str): 符文增加的幸運 (LUK)
        symbol_hp (str): 符文增加的體力 (HP)
        symbol_drop_rate (str or None): 符文增加的道具掉落率
        symbol_meso_rate (str or None): 符文增加的楓幣掉落率
        symbol_exp_rate (str or None): 符文增加的經驗值獲得量
        symbol_growth_count (int): 現有成長值
        symbol_require_growth_count (int): 成長所需的成長值
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
    角色已裝備符文資訊

    Attributes:
        date (datetime or None): 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        character_class (str or None): 角色職業
        symbol (list[CharacterSymbolEquipmentInfo]): 符文資訊
    """
    date: datetime | None
    character_class: str | None
    symbol: list[CharacterSymbolEquipmentInfo]

from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_stat import CharacterStatInfo as BaseCharacterStatInfo
from maplestory_openapi.api.common.dto.character.character_stat import CharacterStat as BaseCharacterStat


class CharacterStatInfo(BaseModel, BaseCharacterStatInfo):
    """
    當前能力值資訊

    Attributes:
        stat_name (str): 能力值名稱
        stat_value (str): 能力值數值
    """
    stat_name: str
    stat_value: str


class CharacterStat(BaseModel, BaseCharacterStat):
    """
    角色綜合能力值資訊

    Attributes:
        date (datetime or None): 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        character_class (str or None): 角色職業
        final_stat (list[CharacterStatInfo]): 當前能力值資訊
        remain_ap (int or None): 剩餘 AP
    """
    date: datetime | None
    character_class: str | None
    final_stat: list[CharacterStatInfo]
    remain_ap: int | None

from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_set_effect import CharacterSetEffectInfo as BaseCharacterSetEffectInfo
from maplestory_openapi.api.common.dto.character.character_set_effect import CharacterSetEffectOptionFull as BaseCharacterSetEffectOptionFull
from maplestory_openapi.api.common.dto.character.character_set_effect import CharacterSetEffectSet as BaseCharacterSetEffectSet
from maplestory_openapi.api.common.dto.character.character_set_effect import CharacterSetEffect as BaseCharacterSetEffect


class CharacterSetEffectInfo(BaseModel, BaseCharacterSetEffectInfo):
    """
    目前已裝備的套裝效果資訊

    Attributes:
        set_count (int): 套裝效果等級 (裝備件數)
        set_option (str): 套裝效果
    """
    set_count: int
    set_option: str


class CharacterSetEffectOptionFull(BaseModel, BaseCharacterSetEffectOptionFull):
    """
    全部套裝效果資訊

    Attributes:
        set_count (int): 套裝效果等級 (裝備件數)
        set_option (str): 套裝效果
    """
    set_count: int
    set_option: str


class CharacterSetEffectSet(BaseModel, BaseCharacterSetEffectSet):
    """
    套裝效果資訊

    Attributes:
        set_name (str): 套裝效果名稱
        total_set_count (int): 套裝件數 (包含幸運道具)
        set_effect_info (list[CharacterSetEffectInfo]): 目前已裝備的套裝效果資訊
        set_option_full (list[CharacterSetEffectOptionFull]): 全部套裝效果資訊
    """
    set_name: str
    total_set_count: int
    set_effect_info: list[CharacterSetEffectInfo]
    set_option_full: list[CharacterSetEffectOptionFull]


class CharacterSetEffect(BaseModel, BaseCharacterSetEffect):
    """
    角色目前套用的套裝效果資訊

    Attributes:
        date (datetime or None): 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        set_effect (list[CharacterSetEffectSet]): 套裝效果資訊
    """
    date: datetime | None
    set_effect: list[CharacterSetEffectSet]

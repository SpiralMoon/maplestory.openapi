from datetime import datetime
from pydantic import BaseModel, field_validator

from maplestory_openapi.api.common.dto.character.character_hyper_stat import CharacterHyperStatPreset as BaseCharacterHyperStatPreset
from maplestory_openapi.api.common.dto.character.character_hyper_stat import CharacterHyperStat as BaseCharacterHyperStat


class CharacterHyperStatPreset(BaseModel, BaseCharacterHyperStatPreset):
    """
    預設的極限屬性資訊

    Attributes:
        stat_type (str): 能力值類型
        stat_point (int or None): 投入於能力值的點數
        stat_level (int): 能力值等級
        stat_increase (str or None): 能力值提升量
    """
    stat_type: str
    stat_point: int | None
    stat_level: int
    stat_increase: str | None


class CharacterHyperStat(BaseModel, BaseCharacterHyperStat):
    """
    角色極限屬性資訊

    Attributes:
        date (datetime or None): 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        character_class (str): 角色職業
        use_preset_no (str): 目前套用的預設編號
        use_available_hyper_stat (int): 可用的極限屬性點數上限
        hyper_stat_preset_1 (list[CharacterHyperStatPreset]): 預設 1 的極限屬性資訊
        hyper_stat_preset_1_remain_point (int): 預設 1 剩餘的極限屬性點數
        hyper_stat_preset_2 (list[CharacterHyperStatPreset]): 預設 2 的極限屬性資訊
        hyper_stat_preset_2_remain_point (int): 預設 2 剩餘的極限屬性點數
        hyper_stat_preset_3 (list[CharacterHyperStatPreset]): 預設 3 的極限屬性資訊
        hyper_stat_preset_3_remain_point (int): 預設 3 剩餘的極限屬性點數
    """
    date: datetime | None
    character_class: str
    use_preset_no: str
    use_available_hyper_stat: int
    hyper_stat_preset_1: list[CharacterHyperStatPreset]
    hyper_stat_preset_1_remain_point: int
    hyper_stat_preset_2: list[CharacterHyperStatPreset]
    hyper_stat_preset_2_remain_point: int
    hyper_stat_preset_3: list[CharacterHyperStatPreset]
    hyper_stat_preset_3_remain_point: int

    @field_validator(
        "hyper_stat_preset_1",
        "hyper_stat_preset_2",
        "hyper_stat_preset_3",
        mode="before"
    )
    @classmethod
    def null_as_empty(cls, v):
        if v is None:
            return []
        return v

from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_hyper_stat import CharacterHyperStatPreset as BaseCharacterHyperStatPreset
from maplestory_openapi.api.common.dto.character.character_hyper_stat import CharacterHyperStat as BaseCharacterHyperStat


class CharacterHyperStatPreset(BaseModel, BaseCharacterHyperStatPreset):
    """
    Hyper Stat information for preset

    Attributes:
        stat_type (str): Stat type
        stat_point (int or None): Stat points to invest
        stat_level (int): Stat level
        stat_increase (str or None): Stat increases
    """
    stat_type: str
    stat_point: int | None
    stat_level: int | None
    stat_increase: str | None


class CharacterHyperStat(BaseModel, BaseCharacterHyperStat):
    """
    Character Hyper Stat information

    Attributes:
        date (datetime or None): Reference date for query (SGT, daily data with hours and minutes set to 0)
        character_class (str or None): Character job
        use_preset_no (str or None): Active preset number
        use_available_hyper_stat (int or None): Maximum available Hyper Stat points
        hyper_stat_preset_1 (list[CharacterHyperStatPreset]): Hyper Stat information for preset 1
        hyper_stat_preset_1_remain_point (int or None): Remaining Hyper Stat points for preset 1
        hyper_stat_preset_2 (list[CharacterHyperStatPreset]): Hyper Stat information for preset 2
        hyper_stat_preset_2_remain_point (int or None): Remaining Hyper Stat points for preset 2
        hyper_stat_preset_3 (list[CharacterHyperStatPreset]): Hyper Stat information for preset 3
        hyper_stat_preset_3_remain_point (int or None): Remaining Hyper Stat points for preset 3
    """
    date: datetime | None
    character_class: str | None
    use_preset_no: str | None
    use_available_hyper_stat: int | None
    hyper_stat_preset_1: list[CharacterHyperStatPreset]
    hyper_stat_preset_1_remain_point: int | None
    hyper_stat_preset_2: list[CharacterHyperStatPreset]
    hyper_stat_preset_2_remain_point: int | None
    hyper_stat_preset_3: list[CharacterHyperStatPreset]
    hyper_stat_preset_3_remain_point: int | None

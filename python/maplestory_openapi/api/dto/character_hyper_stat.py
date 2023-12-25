from datetime import datetime
from pydantic import BaseModel


class CharacterHyperStatInfo(BaseModel):
    stat_type: str
    stat_point: int | None
    stat_level: int | None
    stat_increase: str | None


class CharacterHyperStat(BaseModel):
    date: datetime
    character_class: str
    use_preset_no: str
    use_available_hyper_stat: int
    hyper_stat_preset_1: list[CharacterHyperStatInfo]
    hyper_stat_preset_1_remain_point: int
    hyper_stat_preset_2: list[CharacterHyperStatInfo]
    hyper_stat_preset_2_remain_point: int
    hyper_stat_preset_3: list[CharacterHyperStatInfo]
    hyper_stat_preset_3_remain_point: int

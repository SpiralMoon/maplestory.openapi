from datetime import datetime


class CharacterHyperStatPreset:
    stat_type: str
    stat_point: int | None
    stat_level: int
    stat_increase: str | None


class CharacterHyperStat:
    date: datetime | None
    character_class: str
    use_preset_no: str
    use_available_hyper_stat: int
    hyper_stat_preset_1: list[CharacterHyperStatPreset] = []
    hyper_stat_preset_1_remain_point: int
    hyper_stat_preset_2: list[CharacterHyperStatPreset] = []
    hyper_stat_preset_2_remain_point: int
    hyper_stat_preset_3: list[CharacterHyperStatPreset] = []
    hyper_stat_preset_3_remain_point: int

from datetime import datetime


class CharacterSetEffectInfo:
    set_count: int
    set_option: str


class CharacterSetEffectOptionFull:
    set_count: int
    set_option: str


class CharacterSetEffectSet:
    set_name: str
    total_set_count: int
    set_effect_info: list[CharacterSetEffectInfo] = []
    set_option_full: list[CharacterSetEffectOptionFull] = []


class CharacterSetEffect:
    date: datetime | None
    set_effect: list[CharacterSetEffectSet] = []

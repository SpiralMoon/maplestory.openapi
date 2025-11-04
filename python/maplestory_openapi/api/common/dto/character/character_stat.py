from datetime import datetime


class CharacterStatInfo:
    stat_name: str
    stat_value: str


class CharacterStat:
    date: datetime | None
    character_class: str
    final_stat: list[CharacterStatInfo] = []
    remain_ap: int

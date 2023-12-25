from datetime import datetime
from pydantic import BaseModel


class CharacterStatInfo(BaseModel):
    stat_name: str
    stat_value: str


class CharacterStat(BaseModel):
    date: datetime
    character_class: str
    final_stat: list[CharacterStatInfo]
    remain_ap: int

from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_stat import CharacterStatInfo as BaseCharacterStatInfo
from maplestory_openapi.api.common.dto.character.character_stat import CharacterStat as BaseCharacterStat


class CharacterStatInfo(BaseModel, BaseCharacterStatInfo):
    """
    Current stat information

    Attributes:
        stat_name (str): Stat name
        stat_value (str): Stat value
    """
    stat_name: str
    stat_value: str


class CharacterStat(BaseModel, BaseCharacterStat):
    """
    Character comprehensive stats information

    Attributes:
        date (datetime or None): Reference date for query (SGT, daily data with hours and minutes set to 0)
        character_class (str or None): Character class
        final_stat (list[CharacterStatInfo]): Current stat information
        remain_ap (int or None): Remaining AP
    """
    date: datetime | None
    character_class: str | None
    final_stat: list[CharacterStatInfo]
    remain_ap: int | None

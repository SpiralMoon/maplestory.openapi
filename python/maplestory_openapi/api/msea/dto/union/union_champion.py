from datetime import datetime
from pydantic import BaseModel, field_validator

from maplestory_openapi.api.common.dto.union.union_champion import UnionChampionBadgeInfo as BaseUnionChampionBadgeInfo
from maplestory_openapi.api.common.dto.union.union_champion import UnionChampionInfo as BaseUnionChampionInfo
from maplestory_openapi.api.common.dto.union.union_champion import UnionChampion as BaseUnionChampion


class UnionChampionBadgeInfo(BaseModel, BaseUnionChampionBadgeInfo):
    """
    Champion Insignia effects

    Attributes:
        stat (str): Union Champion Insignia information
    """
    stat: str


class UnionChampionInfo(BaseModel, BaseUnionChampionInfo):
    """
    Union Champion information

    Attributes:
        champion_name (str): Union Champion character name
        champion_slot (int): Union Champion slot
        champion_grade (str): Union Champion level
        champion_class (str): Union Champion character's job
        champion_badge_info (list[UnionChampionBadgeInfo]): Union Champion Insignia information
    """
    champion_name: str
    champion_slot: int
    champion_grade: str
    champion_class: str
    champion_badge_info: list[UnionChampionBadgeInfo]

    @field_validator("champion_badge_info", mode="before")
    @classmethod
    def null_as_empty(cls, v):
        if v is None:
            return []
        return v


class UnionChampion(BaseModel, BaseUnionChampion):
    """
    Union Champion information

    Attributes:
        date (datetime or None): Reference date for query (SGT, daily data with hours and minutes set to 0)
        union_champion (list[UnionChampionInfo]): Union Champion information
        champion_badge_total_info (list[UnionChampionBadgeInfo]): Champion Insignia effects
    """
    date: datetime | None
    union_champion: list[UnionChampionInfo]
    champion_badge_total_info: list[UnionChampionBadgeInfo]

    @field_validator("union_champion", "champion_badge_total_info", mode="before")
    @classmethod
    def null_as_empty(cls, v):
        if v is None:
            return []
        return v

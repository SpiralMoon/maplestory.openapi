from abc import ABC
from datetime import datetime


class UnionChampionBadgeInfo(ABC):
    stat: str


class UnionChampionInfo(ABC):
    champion_name: str
    champion_slot: int
    champion_grade: str
    champion_class: str
    champion_badge_info: list


class UnionChampion(ABC):
    date: datetime | None
    union_champion: list
    champion_badge_total_info: list

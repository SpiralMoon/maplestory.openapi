from datetime import datetime
from pydantic import BaseModel, field_validator

from maplestory_openapi.api.common.dto.union.union_champion import UnionChampionBadgeInfo as BaseUnionChampionBadgeInfo
from maplestory_openapi.api.common.dto.union.union_champion import UnionChampionInfo as BaseUnionChampionInfo
from maplestory_openapi.api.common.dto.union.union_champion import UnionChampion as BaseUnionChampion


class UnionChampionBadgeInfo(BaseModel, BaseUnionChampionBadgeInfo):
    """
    聯盟冠軍徽章資訊

    Attributes:
        stat (str): 聯盟冠軍徽章資訊
    """
    stat: str


class UnionChampionInfo(BaseModel, BaseUnionChampionInfo):
    """
    聯盟冠軍資訊

    Attributes:
        champion_name (str): 聯盟冠軍角色名稱
        champion_slot (int): 聯盟冠軍欄位
        champion_grade (str): 聯盟冠軍等級
        champion_class (str): 聯盟冠軍角色職業
        champion_badge_info (list[UnionChampionBadgeInfo]): 聯盟冠軍徽章資訊
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
    聯盟冠軍資訊

    Attributes:
        date (datetime or None): 查詢基準日（TST，以日為單位，時與分一律標示為 0）
        union_champion (list[UnionChampionInfo]): 聯盟冠軍資訊
        champion_badge_total_info (list[UnionChampionBadgeInfo]): 冠軍徽章效果
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

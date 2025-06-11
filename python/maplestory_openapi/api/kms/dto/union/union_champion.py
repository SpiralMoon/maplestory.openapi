from datetime import datetime
from pydantic import BaseModel


class UnionChampionBadgeInfo(BaseModel):
    """
    유니온 챔피언 휘장 정보

    Attributes:
        stat (str): 유니온 챔피언 휘장 효과
    """
    stat: str


class UnionChampionInfo(BaseModel):
    """
    유니온 챔피언 상세 정보

    Attributes:
        champion_name (str): 유니온 챔피언 캐릭터 명
        champion_slot (int): 유니온 챔피언 슬롯
        champion_grade (str): 유니온 챔피언 등급
        champion_class (str): 유니온 챔피언 캐릭터의 직업
        champion_badge_info (list[UnionChampionBadgeInfo]): 챔피언 휘장 효과 목록
    """
    champion_name: str
    champion_slot: int
    champion_grade: str
    champion_class: str
    champion_badge_info: list[UnionChampionBadgeInfo]


class UnionChampion(BaseModel):
    """
    유니온 챔피언 정보

    Attributes:
        date (datetime or None): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        union_champion (list[UnionChampionInfo]): 유니온 챔피언 정보
        champion_badge_total_info (list[UnionChampionBadgeInfo]): 유니온 챔피언 휘장 정보
    """
    date: datetime | None
    union_champion: list[UnionChampionInfo]
    champion_badge_total_info: list[UnionChampionBadgeInfo]

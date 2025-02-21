from datetime import datetime
from pydantic import BaseModel

class UnionChampionBadgeInfo(BaseModel):
    """유니온 챔피언 휘장 정보

    stat(str): 유니온 챔피언 휘장 효과
    """
    stat: str


class UnionChampionInfo(BaseModel):
    """유니온 챔피언 상세 정보

    champion_slot(int): 유니온 챔피언 슬롯
    champion_grade(str): 유니온 챔피언 등급
    champion_class(str): 유니온 챔피언 캐릭터의 직업
    champion_badge_info(list[UnionChampionBadgeInfo]): 챔피언 휘장 효과
    """
    champion_slot: int
    champion_grade: str
    champion_class: str
    champion_badge_info: list[UnionChampionBadgeInfo]


class UnionChampion(BaseModel):
    """유니온 챔피언 정보

    date(datetime): 조회 기준일
    union_champion(list[UnionArtifactEffect]): 유니온 챔피언 정보
    champion_badge_total_info(list[UnionArtifactCrystal]): 유니온 챔피언 휘장 정보
    """
    date: datetime | None
    union_champion: list[UnionChampionInfo]
    champion_badge_total_info: list[UnionChampionBadgeInfo]

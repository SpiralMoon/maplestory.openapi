from datetime import datetime
from pydantic import BaseModel

class UnionArtifactEffect(BaseModel):
    """유니온 아티팩트 효과 정보

    name(str): 아티팩트 효과 명
    level(int): 아티팩트 효과 레벨
    """
    name: str
    level: int


class UnionArtifactCrystal(BaseModel):
    """유니온 아티팩트 크리스탈 정보

    name(str): 아티팩트 효과 명
    validity_flag(str): 능력치 유효 여부 (0:유효, 1:유효하지 않음)
    date_expire(datetime): 능력치 유효 기간(KST)
    level(int): 아티팩트 크리스탈 등급
    crystal_option_name_1(str): 아티팩트 크리스탈 첫 번째 옵션 명
    crystal_option_name_2(str): 아티팩트 크리스탈 두 번째 옵션 명
    crystal_option_name_3(str): 아티팩트 크리스탈 세 번째 옵션 명
    """
    name: str
    validity_flag: str
    date_expire: datetime
    level: int
    crystal_option_name_1: str
    crystal_option_name_2: str
    crystal_option_name_3: str


class UnionArtifact(BaseModel):
    """유니온 아티팩트 정보

    date(datetime): 조회 기준일
    union_artifact_effect(list[UnionArtifactEffect]): 아티팩트 효과 정보
    union_artifact_crystal(list[UnionArtifactCrystal]): 아티팩트 크리스탈 정보
    union_artifact_remain_ap(int): 잔여 아티팩트 AP
    """
    date: datetime | None
    union_artifact_effect: list[UnionArtifactEffect]
    union_artifact_crystal: list[UnionArtifactCrystal]
    union_artifact_remain_ap: int | None

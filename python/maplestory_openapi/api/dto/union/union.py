from datetime import datetime
from pydantic import BaseModel


class Union(BaseModel):
    """유니온 정보

    date(datetime): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
    union_level(int): 유니온 레벨
    union_grade(str): 유니온 등급
    union_artifact_level(int): 아티팩트 레벨
    union_artifact_exp(int): 보유 아티팩트 경험치
    union_artifact_point(int): 보유 아티팩트 포인트
    """
    date: datetime | None
    union_level: int
    union_grade: str
    union_artifact_level: int | None
    union_artifact_exp: int | None
    union_artifact_point: int | None

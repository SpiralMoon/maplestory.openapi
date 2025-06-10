from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.union.union import Union as BaseUnion

class Union(BaseModel, BaseUnion):
    """
    유니온 정보

    Attributes:
        date (datetime or None): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        union_level (int or None): 유니온 레벨
        union_grade (str or None): 유니온 등급
        union_artifact_level (int or None): 아티팩트 레벨
        union_artifact_exp (int or None): 보유 아티팩트 경험치
        union_artifact_point (int or None): 보유 아티팩트 포인트
    """
    date: datetime | None
    union_level: int | None
    union_grade: str | None
    union_artifact_level: int | None
    union_artifact_exp: int | None
    union_artifact_point: int | None

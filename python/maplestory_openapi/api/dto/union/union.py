from datetime import datetime
from pydantic import BaseModel


class Union(BaseModel):
    """유니온 정보

    date(datetime): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
    union_level(int): 유니온 레벨
    union_grade(str): 유니온 등급
    """
    date: datetime
    union_level: int
    union_grade: str

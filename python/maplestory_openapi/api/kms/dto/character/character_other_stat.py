from datetime import datetime
from pydantic import BaseModel, model_validator


class CharacterOtherStatInfo(BaseModel):
    """
    스탯 정보

    Attributes:
        stat_name (str): 스탯 명
        stat_value (str): 스탯 값
    """
    stat_name: str
    stat_value: str


class CharacterOtherStatDetail(BaseModel):
    """
    능력치에 영향을 주는 요소 및 스탯 정보

    Attributes:
        other_stat_type (str): 스탯 타입
        stat_info (list[CharacterOtherStatInfo]): 스탯 정보
    """
    other_stat_type: str
    stat_info: list[CharacterOtherStatInfo]


class CharacterOtherStat(BaseModel):
    """
    캐릭터 기타 능력치 영향 요소 정보

    Attributes:
        date (datetime or None): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        other_stat (list[CharacterOtherStatDetail]): 능력치에 영향을 주는 요소 및 스탯 정보
    """
    date: datetime | None
    other_stat: list[CharacterOtherStatDetail]

    @model_validator(mode="before")
    @classmethod
    def set_default(cls, values):
        if values.get("other_stat") is None:
            values["other_stat"] = []
        return values

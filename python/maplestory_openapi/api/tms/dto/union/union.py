from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.union.union import Union as BaseUnion

class Union(BaseModel, BaseUnion):
    """
    戰地資訊

    Attributes:
        date (datetime or None): 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        union_level (int or None): 聯盟等級
        union_grade (str or None): 聯盟階級
        union_artifact_level (int or None): 神器等級
        union_artifact_exp (int or None): 持有的神器經驗值
        union_artifact_point (int or None): 持有的神器點數
    """
    date: datetime | None
    union_level: int | None
    union_grade: str | None
    union_artifact_level: int | None
    union_artifact_exp: int | None
    union_artifact_point: int | None

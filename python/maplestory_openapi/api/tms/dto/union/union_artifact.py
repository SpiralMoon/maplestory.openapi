from datetime import datetime
from pydantic import BaseModel, field_validator, model_validator

from maplestory_openapi.api.common.dto.union.union_artifact import UnionArtifactEffect as BaseUnionArtifactEffect
from maplestory_openapi.api.common.dto.union.union_artifact import UnionArtifactCrystal as BaseUnionArtifactCrystal
from maplestory_openapi.api.common.dto.union.union_artifact import UnionArtifact as BaseUnionArtifact


class UnionArtifactEffect(BaseModel, BaseUnionArtifactEffect):
    """
    神器效果資訊

    Attributes:
        name (str): 神器效果名稱
        level (int): 神器效果等級
    """
    name: str
    level: int


class UnionArtifactCrystal(BaseModel, BaseUnionArtifactCrystal):
    """
    神器水晶資訊

    Attributes:
        name (str): 神器水晶名稱
        validity_flag (str): 能力有效性 (0：有效，1：無效)
        date_expire (datetime or None): 能力有效期間 (TST)
        is_expired (bool or None): Whether the artifact crystal is expired
        level (int): 神器水晶階級
        crystal_option_name_1 (str): 神器水晶第一選項名稱
        crystal_option_name_2 (str): 神器水晶第二選項名稱
        crystal_option_name_3 (str): 神器水晶第三選項名稱
    """
    name: str
    validity_flag: str
    date_expire: datetime | None
    is_expired: bool | None
    level: int
    crystal_option_name_1: str
    crystal_option_name_2: str
    crystal_option_name_3: str

    @model_validator(mode="before")
    @classmethod
    def set_default(cls, values):
        if values.get("date_expire") == 'expired':
            values["is_expired"] = True
            values["date_expire"] = None
        return values


class UnionArtifact(BaseModel, BaseUnionArtifact):
    """
    戰地神器資訊

    Attributes:
        date (datetime or None): 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        union_artifact_effect (list[UnionArtifactEffect]): 神器效果資訊
        union_artifact_crystal (list[UnionArtifactCrystal]): 神器水晶資訊
        union_artifact_remain_ap (int or None): 剩餘神器 AP
    """
    date: datetime | None
    union_artifact_effect: list[UnionArtifactEffect]
    union_artifact_crystal: list[UnionArtifactCrystal]
    union_artifact_remain_ap: int | None

    @field_validator("union_artifact_effect", "union_artifact_crystal", mode="before")
    @classmethod
    def null_as_empty(cls, v):
        if v is None:
            return []
        return v

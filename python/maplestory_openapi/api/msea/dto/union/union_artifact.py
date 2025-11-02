from datetime import datetime
from pydantic import BaseModel, field_validator, model_validator

from maplestory_openapi.api.common.dto.union.union_artifact import UnionArtifactEffect as BaseUnionArtifactEffect
from maplestory_openapi.api.common.dto.union.union_artifact import UnionArtifactCrystal as BaseUnionArtifactCrystal
from maplestory_openapi.api.common.dto.union.union_artifact import UnionArtifact as BaseUnionArtifact


class UnionArtifactEffect(BaseModel, BaseUnionArtifactEffect):
    """
    Artifact effect information

    Attributes:
        name (str): Name of the artifact effect
        level (int): Level of the artifact effect
    """
    name: str
    level: int


class UnionArtifactCrystal(BaseModel, BaseUnionArtifactCrystal):
    """
    Artifact crystal information

    Attributes:
        name (str): Name of the artifact crystal
        validity_flag (str): Validity of the stat (0:Valid, 1:Invalid)
        date_expire (datetime or None): Expiration date of the stat (SGT)
        is_expired (bool or None): Whether the artifact crystal is expired
        level (int): Grade of the artifact crystal
        crystal_option_name_1 (str): First option of the artifact crystal
        crystal_option_name_2 (str): Second option of the artifact crystal
        crystal_option_name_3 (str): Third option of the artifact crystal
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
    Union artifact information

    Attributes:
        date (datetime or None): Reference date for query (SGT, daily data with hours and minutes set to 0)
        union_artifact_effect (list[UnionArtifactEffect]): Artifact effect information
        union_artifact_crystal (list[UnionArtifactCrystal]): Artifact crystal information
        union_artifact_remain_ap (int or None): Remaining artifact AP
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

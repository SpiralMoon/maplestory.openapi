from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.union.union import Union as BaseUnion

class Union(BaseModel, BaseUnion):
    """
    Union information

    Attributes:
        date (datetime or None): Reference date for query (SGT, daily data with hours and minutes set to 0)
        union_level (int or None): Union level
        union_grade (str or None): Union grade
        union_artifact_level (int or None): Artifact level
        union_artifact_exp (int or None): Earned Artifact EXP
        union_artifact_point (int or None): Earned Artifact Points
    """
    date: datetime | None
    union_level: int | None
    union_grade: str | None
    union_artifact_level: int | None
    union_artifact_exp: int | None
    union_artifact_point: int | None

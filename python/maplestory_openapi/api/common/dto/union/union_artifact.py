from datetime import datetime
from pydantic import model_validator


class UnionArtifactEffect:
    name: str
    level: int


class UnionArtifactCrystal:
    name: str
    validity_flag: str
    date_expire: datetime | None
    is_expired: bool = False
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


class UnionArtifact:
    date: datetime | None
    union_artifact_effect: list[UnionArtifactEffect]
    union_artifact_crystal: list[UnionArtifactCrystal]
    union_artifact_remain_ap: int | None

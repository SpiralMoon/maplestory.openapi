from datetime import datetime


class UnionArtifactEffect:
    name: str
    level: int


class UnionArtifactCrystal:
    name: str
    validity_flag: str
    date_expire: datetime | None
    is_expired: bool | None = None
    level: int
    crystal_option_name_1: str
    crystal_option_name_2: str
    crystal_option_name_3: str


class UnionArtifact:
    date: datetime | None
    union_artifact_effect: list[UnionArtifactEffect] = []
    union_artifact_crystal: list[UnionArtifactCrystal] = []
    union_artifact_remain_ap: int | None

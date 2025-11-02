from datetime import datetime


class UnionRaiderBlockPosition:
    x: int
    y: int


class UnionRaiderBlockControlPoint:
    x: int
    y: int


class UnionRaiderBlock:
    block_type: str
    block_class: str | None
    block_level: str
    block_control_point: UnionRaiderBlockControlPoint
    block_position: list[UnionRaiderBlockPosition] = []


class UnionRaiderInnerStat:
    stat_field_id: str
    stat_field_effect: str


class UnionRaiderPreset:
    union_raider_stat: list[str] = []
    union_occupied_stat: list[str] = []
    union_inner_stat: list[UnionRaiderInnerStat] = []
    union_block: list[UnionRaiderBlock] = []


class UnionRaider:
    date: datetime | None
    union_raider_stat: list[str] = []
    union_occupied_stat: list[str] = []
    union_inner_stat: list[UnionRaiderInnerStat] = []
    union_block: list[UnionRaiderBlock] = []
    use_preset_no: int
    union_raider_preset_1: UnionRaiderPreset | None
    union_raider_preset_2: UnionRaiderPreset | None
    union_raider_preset_3: UnionRaiderPreset | None
    union_raider_preset_4: UnionRaiderPreset | None
    union_raider_preset_5: UnionRaiderPreset | None

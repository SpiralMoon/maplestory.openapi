from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.union.union_raider import UnionRaiderBlockPosition as BaseUnionRaiderBlockPosition
from maplestory_openapi.api.common.dto.union.union_raider import UnionRaiderBlockControlPoint as BaseUnionRaiderBlockControlPoint
from maplestory_openapi.api.common.dto.union.union_raider import UnionRaiderBlock as BaseUnionRaiderBlock
from maplestory_openapi.api.common.dto.union.union_raider import UnionRaiderInnerStat as BaseUnionRaiderInnerStat
from maplestory_openapi.api.common.dto.union.union_raider import UnionRaiderPreset as BaseUnionRaiderPreset
from maplestory_openapi.api.common.dto.union.union_raider import UnionRaider as BaseUnionRaider


class UnionRaiderBlockPosition(BaseModel, BaseUnionRaiderBlockPosition):
    """
    Coordinates of the area occupied by the block

    Attributes:
        x (int): Block X-coordinate
        y (int): Block Y-coordinate
    """
    x: int
    y: int


class UnionRaiderBlockControlPoint(BaseModel, BaseUnionRaiderBlockControlPoint):
    """
    Coordinates of the block's reference point:
    - The bottom-right square among the four central squares is positioned at x: 0, y: 0.
    - Moving one square to the left decreases x by 1.
    - Moving one square to the right increases x by 1.
    - Moving one square downward decreases y by 1.
    - Moving one square upward increases y by 1.

    Attributes:
        x (int): Block reference point X-coordinate
        y (int): Block reference point Y-coordinate
    """
    x: int
    y: int


class UnionRaiderBlock(BaseModel, BaseUnionRaiderBlock):
    """
    Union Legion Block information

    Attributes:
        block_type (str): Block shapes (Warrior, Magician, Bowman, Thief, Pirate, Maple M, Hybrid)
        block_class (str): Character class corresponding to the block
        block_level (str): Character level corresponding to the block
        block_control_point (UnionRaiderBlockControlPoint): Coordinates of the block's reference point:
            - The bottom-right square among the four central squares is positioned at x: 0, y: 0.
            - Moving one square to the left decreases x by 1.
            - Moving one square to the right increases x by 1.
            - Moving one square downward decreases y by 1.
            - Moving one square upward increases y by 1.
        block_position (list[UnionRaiderBlockPosition] or None): Coordinates of the area occupied by the block (null if not placed)
    """
    block_type: str
    block_class: str
    block_level: str
    block_control_point: UnionRaiderBlockControlPoint
    block_position: list[UnionRaiderBlockPosition] | None


class UnionRaiderInnerStat(BaseModel, BaseUnionRaiderInnerStat):
    """
    Union raider deployment information

    Attributes:
        stat_field_id (str): Raider deployment position (0 to 7, clockwise from 11 o'clock)
        stat_field_effect (str): Occupation effects over the area
    """
    stat_field_id: str
    stat_field_effect: str


class UnionRaiderPreset(BaseModel, BaseUnionRaiderPreset):
    """
    Union preset information

    Attributes:
        union_raider_stat (list[str]): Union raid member effects
        union_occupied_stat (list[str]): Union raid capture effects
        union_inner_stat (list[UnionRaiderInnerStat]): Union raider deployment
        union_block (list[UnionRaiderBlock]): Union Legion Block
    """
    union_raider_stat: list[str]
    union_occupied_stat: list[str]
    union_inner_stat: list[UnionRaiderInnerStat]
    union_block: list[UnionRaiderBlock]


class UnionRaider(BaseModel, BaseUnionRaider):
    """
    Union raider information

    Attributes:
        date (datetime or None): Reference date for query (SGT, daily data with hours and minutes set to 0)
        union_raider_stat (list[str]): Union raid member effects
        union_occupied_stat (list[str]): Union raid capture effects
        union_inner_stat (list[UnionRaiderInnerStat]): Union raider deployment
        union_block (list[UnionRaiderBlock]): Union Legion Block
        use_preset_no (int): Number of the preset currently in use
        union_raider_preset_1 (UnionRaiderPreset or None): Information for Union Preset 1
        union_raider_preset_2 (UnionRaiderPreset or None): Information for Union Preset 2
        union_raider_preset_3 (UnionRaiderPreset or None): Information for Union Preset 3
        union_raider_preset_4 (UnionRaiderPreset or None): Information for Union Preset 4
        union_raider_preset_5 (UnionRaiderPreset or None): Information for Union Preset 5
    """
    date: datetime | None
    union_raider_stat: list[str]
    union_occupied_stat: list[str]
    union_inner_stat: list[UnionRaiderInnerStat]
    union_block: list[UnionRaiderBlock]
    use_preset_no: int
    union_raider_preset_1: UnionRaiderPreset | None
    union_raider_preset_2: UnionRaiderPreset | None
    union_raider_preset_3: UnionRaiderPreset | None
    union_raider_preset_4: UnionRaiderPreset | None
    union_raider_preset_5: UnionRaiderPreset | None

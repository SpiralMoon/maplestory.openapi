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
    블록이 차지하고 있는 영역 좌표들

    Attributes:
        x (int): 블록 X좌표
        y (int): 블록 Y좌표
    """
    x: int
    y: int


class UnionRaiderBlockControlPoint(BaseModel, BaseUnionRaiderBlockControlPoint):
    """
    블록 기준점 좌표

    - 중앙 4칸 중 오른쪽 아래 칸이 x: 0, y: 0 포지션
    - 좌측으로 1칸 이동하면 x가 1씩 감소
    - 우측으로 1칸 이동하면 x가 1씩 증가
    - 아래로 1칸 이동하면 y가 1씩 감소
    - 위로 1칸 이동하면 y가 1씩 증가

    Attributes:
        x (int): 기준점 X좌표
        y (int): 기준점 Y좌표
    """
    x: int
    y: int


class UnionRaiderBlock(BaseModel, BaseUnionRaiderBlock):
    """
    유니온 블록 정보

    Attributes:
        block_type (str): 블록 모양 (전사, 마법사, 궁수, 도적, 해적, 메이플m, 하이브리드)
        block_class (str): 해당 캐릭터 직업
        block_level (str): 해당 캐릭터 레벨
        block_control_point (UnionRaiderBlockControlPoint): 기준점 좌표
        block_position (list[UnionRaiderBlockPosition] or None): 차지하고 있는 영역 좌표들
    """
    block_type: str
    block_class: str
    block_level: str
    block_control_point: UnionRaiderBlockControlPoint
    block_position: list[UnionRaiderBlockPosition] | None


class UnionRaiderInnerStat(BaseModel, BaseUnionRaiderInnerStat):
    """
    유니온 공격대 배치 정보

    Attributes:
        stat_field_id (str): 배치 위치 (11시 방향부터 시계방향 0~7)
        stat_field_effect (str): 점령 효과
    """
    stat_field_id: str
    stat_field_effect: str


class UnionRaiderPreset(BaseModel, BaseUnionRaiderPreset):
    """
    유니온 프리셋 정보

    Attributes:
        union_raider_stat (list[str]): 유니온 공격대원 효과
        union_occupied_stat (list[str]): 유니온 점령 효과
        union_inner_stat (list[UnionRaiderInnerStat]): 공격대 배치
        union_block (list[UnionRaiderBlock]): 블록 정보
    """
    union_raider_stat: list[str]
    union_occupied_stat: list[str]
    union_inner_stat: list[UnionRaiderInnerStat]
    union_block: list[UnionRaiderBlock]


class UnionRaider(BaseModel, BaseUnionRaider):
    """
    유니온 공격대 전체 정보

    Attributes:
        date (datetime or None): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        union_raider_stat (list[str]): 공격대원 효과
        union_occupied_stat (list[str]): 점령 효과
        union_inner_stat (list[UnionRaiderInnerStat]): 공격대 배치
        union_block (list[UnionRaiderBlock]): 블록 정보
        use_preset_no (int): 적용 중인 프리셋 번호
        union_raider_preset_1 (UnionRaiderPreset or None): 프리셋 1
        union_raider_preset_2 (UnionRaiderPreset or None): 프리셋 2
        union_raider_preset_3 (UnionRaiderPreset or None): 프리셋 3
        union_raider_preset_4 (UnionRaiderPreset or None): 프리셋 4
        union_raider_preset_5 (UnionRaiderPreset or None): 프리셋 5
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

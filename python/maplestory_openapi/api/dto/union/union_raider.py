from datetime import datetime
from pydantic import BaseModel


class UnionRaiderBlockPosition(BaseModel):
    """블록이 차지하고 있는 영역 좌표들 (null:미 배치 시)

    x(int): 블록 X좌표
    y(int): 블록 Y좌표
    """
    x: int
    y: int


class UnionRaiderBlockControlPoint(BaseModel):
    """블록 기준점 좌표

    - 중앙 4칸 중 오른쪽 아래 칸이 x : 0, y : 0 포지션
    - 좌측으로 1칸씩 이동하면 x가 1씩 감소
    - 우측으로 1칸씩 이동하면 x가 1씩 증가
    - 아래로 1칸씩 이동하면 y가 1씩 감소
    - 위로 1칸씩 이동하면 y가 1씩 증가

    x(int): 블록 기준점 X좌표
    y(int): 블록 기준점 Y좌표
    """
    x: int
    y: int


class UnionRaiderBlock(BaseModel):
    """유니온 블록 정보

    block_type(str): 블록 모양 (전사, 마법사, 궁수, 도적, 해적, 메이플m, 하이브리드)
    block_class(str): 블록 해당 캐릭터 직업
    block_level(str): 블록 해당 캐릭터 레벨
    block_control_point(list[UnionRaiderBlockControlPoint]): 블록 기준점 좌표
    block_position(list[UnionRaiderBlockPosition]): 블록이 차지하고 있는 영역 좌표들 (null:미 배치 시)
    """
    block_type: str
    block_class: str
    block_level: str
    block_control_point: UnionRaiderBlockControlPoint
    block_position: list[UnionRaiderBlockPosition] | None


class UnionRaiderInnerStat(BaseModel):
    """유니온 공격대 배치

    stat_field_id(str): 공격대 배치 위치 (11시 방향부터 시계 방향 순서대로 0~7)
    stat_field_effect(str): 해당 지역 점령 효과
    """
    stat_field_id: str
    stat_field_effect: str


class UnionRaiderPreset(BaseModel):
    """유니온 프리셋 정보

    union_Raider_stat(list[str]): 유니온 공격대원 효과
    union_occupied_stat(list[str]): 유니온 공격대 점령 효과
    union_inner_stat(list[UnionRaiderInnerStat]): 유니온 공격대 배치
    union_block(list[UnionRaiderBlock]): 유니온 블록 정보
    """
    union_raider_stat: list[str]
    union_occupied_stat: list[str]
    union_inner_stat: list[UnionRaiderInnerStat]
    union_block: list[UnionRaiderBlock]


class UnionRaider(BaseModel):
    """유니온 공격대 정보

    date(datetime): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
    union_Raider_stat(list[str]): 유니온 공격대원 효과
    union_occupied_stat(list[str]): 유니온 공격대 점령 효과
    union_inner_stat(list[UnionRaiderInnerStat]): 유니온 공격대 배치
    union_block(list[UnionRaiderBlock]): 유니온 블록 정보
    use_preset_not(int): 적용 중인 프리셋 번호
    union_raider_preset_1(UnionRaiderPreset): 유니온 프리셋 1번 정보
    union_raider_preset_2(UnionRaiderPreset): 유니온 프리셋 2번 정보
    union_raider_preset_3(UnionRaiderPreset): 유니온 프리셋 3번 정보
    union_raider_preset_4(UnionRaiderPreset): 유니온 프리셋 4번 정보
    union_raider_preset_5(UnionRaiderPreset): 유니온 프리셋 5번 정보
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

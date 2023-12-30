from datetime import datetime
from pydantic import BaseModel


class CubePotentialOption(BaseModel):
    """잠재능력 옵션 정보

    value(str): 옵션 명
    grade(str): 옵션 등급
    """
    value: str
    grade: str


class CubeHistoryInfo(BaseModel):
    """큐브 사용 결과 정보

    id(str): 큐브 히스토리 식별자
    character_name(str): 캐릭터명
    date_create(datetime): 사용 일시 (KST)
    cube_type(str): 사용 큐브
    item_upgrade_result(str): 사용 결과
    miracle_time_flag(str): 미라클 타임 적용 여부
    item_equipment_part(str): 장비 분류
    item_level(int): 장비 레벨
    target_item(str): 큐브 사용한 장비
    potential_option_grade(str): 잠재능력 등급
    additional_potential_option_grade(str): 에디셔널 잠재능력 등급
    upgrade_guarantee(str): 천장에 도달하여 확정 등급 상승한 여부
    upgrade_guarantee_count(int): 현재까지 쌓은 스택
    before_potential_option(CubePotentialOption): 사용 전 잠재능력 옵션
    before_additional_potential_option(CubePotentialOption): 사용 전 에디셔널 잠재능력 옵션
    after_potential_option(CubePotentialOption): 사용 후 잠재능력 옵션
    after_additional_potential_option(CubePotentialOption): 사용 후 에디셔널 잠재능력 옵션
    """
    id: str
    character_name: str
    date_create: datetime
    cube_type: str
    item_upgrade_result: str
    miracle_time_flag: str
    item_equipment_part: str
    item_level: int
    target_item: str
    potential_option_grade: str
    additional_potential_option_grade: str
    upgrade_guarantee: str
    upgrade_guarantee_count: int
    before_potential_option: CubePotentialOption | None
    before_additional_potential_option: CubePotentialOption | None
    after_potential_option: CubePotentialOption | None
    after_additional_potential_option: CubePotentialOption | None


class CubeHistory(BaseModel):
    """큐브 사용 결과

    count(int): 결과 건 수
    next_cursor(str): 페이징 처리를 위한 cursor
    cube_history(list[CubeHistoryInfo]): 큐브 히스토리
    """
    count: int
    next_cursor: str | None
    cube_history: list[CubeHistoryInfo]

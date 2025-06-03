from datetime import datetime
from pydantic import BaseModel


class PotentialOption(BaseModel):
    """
    잠재능력 옵션 정보

    Attributes:
        value (str): 옵션 명
        grade (str): 옵션 등급
    """
    value: str
    grade: str


class PotentialHistoryInfo(BaseModel):
    """
    잠재능력 재설정 히스토리

    Attributes:
        id (str): 잠재능력 재설정 히스토리 식별자
        character_name (str): 캐릭터명
        date_create (datetime): 사용 일시 (KST)
        potential_type (str): 대상 잠재능력 타입 (잠재능력, 에디셔널 잠재능력)
        item_upgrade_result (str): 사용 결과
        miracle_time_flag (str): 미라클 타임 적용 여부
        item_equipment_part (str): 장비 분류
        item_level (int): 장비 레벨
        target_item (str): 잠재능력 재설정 장비 명
        potential_option_grade (str): 잠재능력 등급
        additional_potential_option_grade (str): 에디셔널 잠재능력 등급
        upgrade_guarantee (bool): 천장에 도달하여 확정 등급 상승한 여부
        upgrade_guarantee_count (int): 현재까지 쌓은 스택
        before_potential_option (list[PotentialOption]): 사용 전 잠재능력 옵션
        before_additional_potential_option (list[PotentialOption]): 사용 전 에디셔널 잠재능력 옵션
        after_potential_option (list[PotentialOption]): 사용 후 잠재능력 옵션
        after_additional_potential_option (list[PotentialOption]): 사용 후 에디셔널 잠재능력 옵션
    """
    id: str
    character_name: str
    date_create: datetime
    potential_type: str
    item_upgrade_result: str
    miracle_time_flag: str
    item_equipment_part: str
    item_level: int
    target_item: str
    potential_option_grade: str
    additional_potential_option_grade: str
    upgrade_guarantee: bool
    upgrade_guarantee_count: int
    before_potential_option: list[PotentialOption]
    before_additional_potential_option: list[PotentialOption]
    after_potential_option: list[PotentialOption]
    after_additional_potential_option: list[PotentialOption]


class PotentialHistory(BaseModel):
    """
    잠재능력 재설정 히스토리 응답 정보

    Attributes:
        count (int): 결과 건 수
        next_cursor (str or None): 페이징 처리를 위한 cursor
        potential_history (list[PotentialHistoryInfo]): 잠재능력 재설정 히스토리
    """
    count: int
    next_cursor: str | None
    potential_history: list[PotentialHistoryInfo]

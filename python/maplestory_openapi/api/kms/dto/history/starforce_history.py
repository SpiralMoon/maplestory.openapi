from datetime import datetime
from pydantic import BaseModel


class StarforceHistoryEvent(BaseModel):
    """
    스타포스 강화 이벤트 정보

    Attributes:
        success_rate (str): 이벤트 성공 확률
        destroy_decrease_rate (str or None): 이벤트 파괴 확률 감소율
        cost_discount_rate (str): 이벤트 비용 할인율
        plus_value (str): 이벤트 강화 수치 가중값
        starforce_event_range (str): 이벤트 적용 강화 시도 가능한 n성 범위
    """
    success_rate: str
    destroy_decrease_rate: str | None
    cost_discount_rate: str
    plus_value: str
    starforce_event_range: str


class StarforceHistoryInfo(BaseModel):
    """
    스타포스 히스토리

    Attributes:
        id (str): 스타포스 히스토리 식별자
        item_upgrade_result (str): 강화 시도 결과
        before_starforce_count (int): 강화 시도 전 스타포스 수치
        after_starforce_count (int): 강화 시도 후 스타포스 수치
        starcatch_result (str): 스타 캐치
        superior_item_flag (str): 슈페리얼 장비 여부
        destroy_defence (str): 파괴 방지 여부
        chance_time (str): 찬스 타임 여부
        event_field_flag (str): 파괴 방지 필드 이벤트 여부
        upgrade_item (str): 사용 주문서 명
        protect_shield (str): 프로텍트 실드 사용 여부
        bonus_stat_upgrade (str): 보너스 스탯 부여 아이템 사용 여부
        character_name (str): 캐릭터 명
        world_name (str): 월드 명
        target_item (str): 대상 장비 아이템 명
        date_create (datetime): 강화 일시 (KST)
        starforce_event_list (list[StarforceHistoryEvent] or None): 진행 중인 스타포스 강화 이벤트 정보
    """
    id: str
    item_upgrade_result: str
    before_starforce_count: int
    after_starforce_count: int
    starcatch_result: str
    superior_item_flag: str
    destroy_defence: str
    chance_time: str
    event_field_flag: str
    upgrade_item: str
    protect_shield: str
    bonus_stat_upgrade: str
    character_name: str
    world_name: str
    target_item: str
    date_create: datetime
    starforce_event_list: list[StarforceHistoryEvent] | None


class StarforceHistory(BaseModel):
    """
    스타포스 히스토리 응답 정보

    Attributes:
        count (int): 결과 건 수
        next_cursor (str or None): 페이징 처리를 위한 cursor
        starforce_history (list[StarforceHistoryInfo]): 스타포스 히스토리 목록
    """
    count: int
    next_cursor: str | None
    starforce_history: list[StarforceHistoryInfo]

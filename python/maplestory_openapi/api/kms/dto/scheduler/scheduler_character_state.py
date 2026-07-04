from datetime import datetime
from pydantic import BaseModel, field_validator


class SchedulerDailyContent(BaseModel):
    """
    스케줄러 일일 콘텐츠 정보

    Attributes:
        content_name (str): 콘텐츠/퀘스트 명
        type (str): 타입 ('contents', 'quest')
        registration_flag (str): 인게임 스케줄러 등록 여부 (true/false)
        now_count (int): 현재 완료 횟수/점수
        max_count (int): 최대 완료 가능 횟수/점수
        quest_state (str or None): 퀘스트인 경우 진행 상태 ("0":기타, "1":진행 중, "2":완료)
    """
    content_name: str
    type: str
    registration_flag: str
    now_count: int
    max_count: int
    quest_state: str | None


class SchedulerWeeklyContent(BaseModel):
    """
    스케줄러 주간 콘텐츠 정보

    Attributes:
        content_name (str): 콘텐츠 명
        type (str): 콘텐츠 종류 ('contents', 'quest')
        registration_flag (str): 인게임 스케줄러 등록 여부 (true/false)
        now_count (int): 현재 완료 횟수/점수
        max_count (int): 최대 완료 가능 횟수/점수
        quest_state (str or None): 퀘스트인 경우 진행 상태 ("0":기타, "1":진행 중, "2":완료)
    """
    content_name: str
    type: str
    registration_flag: str
    now_count: int
    max_count: int
    quest_state: str | None


class SchedulerBossContent(BaseModel):
    """
    스케줄러 보스 콘텐츠 정보

    Attributes:
        content_name (str): 보스 명
        difficulty (str): 보스 난이도
        cycle (str): 보스 초기화 주기
        list_order_no (int): 리스트 순서
        registration_flag (str): 인게임 스케줄러 등록 여부 (true/false)
        complete_flag (str): 완료 여부 (true/false)
    """
    content_name: str
    difficulty: str
    cycle: str
    list_order_no: int
    registration_flag: str
    complete_flag: str


class SchedulerCharacterState(BaseModel):
    """
    캐릭터 스케줄러 정보

    Attributes:
        date (datetime or None): 조회 기준일 (YYYY-MM-DD)
        character_name (str): 캐릭터 명
        world_name (str): 월드 명
        character_level (int): 캐릭터 레벨
        character_class (str): 캐릭터 직업
        daily_contents (list[SchedulerDailyContent]): 일일 콘텐츠 정보
        weekly_contents (list[SchedulerWeeklyContent]): 주간 콘텐츠 정보
        boss_contents (list[SchedulerBossContent]): 보스 콘텐츠 정보
        weekly_boss_clear_count (int): 주간 보스 처치 완료 횟수
        weekly_boss_clear_limit_count (int): 주간 보스 처치 제한 횟수
    """
    date: datetime | None
    character_name: str
    world_name: str
    character_level: int
    character_class: str
    daily_contents: list[SchedulerDailyContent]
    weekly_contents: list[SchedulerWeeklyContent]
    boss_contents: list[SchedulerBossContent]
    weekly_boss_clear_count: int
    weekly_boss_clear_limit_count: int

    @field_validator("daily_contents", "weekly_contents", "boss_contents", mode="before")
    @classmethod
    def null_as_empty(cls, v):
        if v is None:
            return []
        return v

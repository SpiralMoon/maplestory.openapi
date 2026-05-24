from pydantic import BaseModel


class BattlePracticeSkillTimelineEvent(BaseModel):
    """
    연무장 스킬 타임라인

    Attributes:
        elapse_time (int): 연무 시작 후 경과 시간 (ms)
        skill_name (str): 사용한 스킬 명
        hexa_skill_specificity_flag (str): 헥사 스킬 특성 여부 (0:그 외 스킬, 1:오리진 스킬, 2:어센트 스킬)
        sequence_name (str or None): 시퀀스 명
        sequence_key (str or None): 시퀀스 키
    """
    elapse_time: int
    skill_name: str
    hexa_skill_specificity_flag: str
    sequence_name: str | None
    sequence_key: str | None


class BattlePracticeSkillTimeline(BaseModel):
    """
    연무장 스킬 사용 내역

    Attributes:
        page_no (int): 조회된 페이지 번호
        total_page_no (int): 전체 페이지 번호
        skill_timeline (list[BattlePracticeSkillTimelineEvent]): 스킬 타임라인 정보
    """
    page_no: int
    total_page_no: int
    skill_timeline: list[BattlePracticeSkillTimelineEvent]

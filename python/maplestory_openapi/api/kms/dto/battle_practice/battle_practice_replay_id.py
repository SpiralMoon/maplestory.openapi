from datetime import datetime
from pydantic import BaseModel


class BattlePracticeReplayIdInfo(BaseModel):
    """
    연무장 리플레이 식별자 상세 정보

    Attributes:
        period_no (int): 기간 번호 (연무장 초기화 시마다 1씩 증가됩니다.)
        register_date (datetime): 리플레이 등록 일시 (KST)
        replay_id (str): 연무장 리플레이 고유 식별자
    """
    period_no: int
    register_date: datetime
    replay_id: str


class BattlePracticeReplayId(BaseModel):
    """
    연무장 리플레이 식별자 목록

    Attributes:
        replay_list (list[BattlePracticeReplayIdInfo]): 리플레이 목록
    """
    replay_list: list[BattlePracticeReplayIdInfo]

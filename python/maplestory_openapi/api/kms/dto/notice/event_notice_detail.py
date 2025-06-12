from datetime import datetime
from pydantic import BaseModel


class EventNoticeDetail(BaseModel):
    """
    진행 중 이벤트 상세

    Attributes:
        title (str): 공지 제목
        url (str): 공지 링크
        contents (str): 공지 본문
        date (datetime): 공지 등록일
        date_event_start (datetime): 이벤트 시작일
        date_event_end (datetime): 이벤트 종료일
    """
    title: str
    url: str
    contents: str
    date: datetime
    date_event_start: datetime
    date_event_end: datetime

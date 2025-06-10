from datetime import datetime
from pydantic import BaseModel


class EventNoticeListItem(BaseModel):
    """
    진행 중 이벤트 공지 항목

    Attributes:
        title (str): 공지 제목
        url (str): 공지 링크
        notice_id (int): 공지 식별자
        date (datetime): 공지 등록일
        date_event_start (datetime): 이벤트 시작일
        date_event_end (datetime): 이벤트 종료일
    """
    title: str
    url: str
    notice_id: int
    date: datetime
    date_event_start: datetime
    date_event_end: datetime


class EventNoticeList(BaseModel):
    """
    진행 중 이벤트 공지 목록

    Attributes:
        event_notice (list[EventNoticeListItem]): 공지 목록
    """
    event_notice: list[EventNoticeListItem]

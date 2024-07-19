from datetime import datetime
from pydantic import BaseModel


class NoticeListItem(BaseModel):
    """
    공지사항

    title(str): 공지 제목
    url(str): 공지 링크
    notice_id(int): 공지 식별자
    date(datetime): 공지 등록일
    """
    title: str
    url: str
    notice_id: int
    date: datetime


class NoticeList(BaseModel):
    """
    공지사항 목록

    notice(list[NoticeListItem]): 공지 목록
    """
    notice: list[NoticeListItem]

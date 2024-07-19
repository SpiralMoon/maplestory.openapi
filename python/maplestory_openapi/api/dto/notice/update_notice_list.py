from datetime import datetime
from pydantic import BaseModel


class UpdateNoticeListItem(BaseModel):
    """
    업데이트 공지

    title(str): 공지 제목
    url(str): 공지 링크
    notice_id(int): 공지 식별자
    date(datetime): 공지 등록일
    """
    title: str
    url: str
    notice_id: int
    date: datetime


class UpdateNoticeList(BaseModel):
    """
    업데이트 목록

    update_notice(list[UpdateNoticeListItem]): 공지 목록
    """
    update_notice: list[UpdateNoticeListItem]

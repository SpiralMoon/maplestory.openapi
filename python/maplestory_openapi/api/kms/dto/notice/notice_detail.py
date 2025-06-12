from datetime import datetime
from pydantic import BaseModel


class NoticeDetail(BaseModel):
    """
    공지사항 상세

    Attributes:
        title (str): 공지 제목
        url (str): 공지 링크
        contents (str): 공지 본문
        date (datetime): 공지 등록일
    """
    title: str
    url: str
    contents: str
    date: datetime

from datetime import datetime
from pydantic import BaseModel


class UpdateNoticeDetail(BaseModel):
    """
    업데이트 상세

    title(str): 공지 제목
    url(str): 공지 링크
    contents(str): 공지 본문
    date(datetime): 공지 등록일
    """
    title: str
    url: str
    contents: str
    date: datetime

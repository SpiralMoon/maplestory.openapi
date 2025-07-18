from datetime import datetime
from pydantic import BaseModel


class CashshopNoticeListItem(BaseModel):
    """
    캐시샵 공지 항목 정보

    Attributes:
        title (str): 공지 제목
        url (str): 공지 링크
        notice_id (int): 공지 식별자
        date (datetime): 공지 등록일
        date_sale_start (datetime or None): 판매 시작일
        date_sale_end (datetime or None): 판매 종료일
        ongoing_flag (str): 상시 판매 여부 (true - 상시)
    """
    title: str
    url: str
    notice_id: int
    date: datetime
    date_sale_start: datetime | None
    date_sale_end: datetime | None
    ongoing_flag: str

    @property
    def is_ongoing_flag(self) -> bool:
        """
        상시 판매 여부
        """
        return self.ongoing_flag == 'true'


class CashshopNoticeList(BaseModel):
    """
    캐시샵 공지 목록 정보

    Attributes:
        cashshop_notice (list[CashshopNoticeListItem]): 공지 항목 리스트
    """
    cashshop_notice: list[CashshopNoticeListItem]

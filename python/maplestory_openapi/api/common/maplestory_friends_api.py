from abc import ABC, abstractmethod
from datetime import datetime, timedelta
from zoneinfo import ZoneInfo
from typing import Any
from pydantic import BaseModel
import httpx

from maplestory_openapi.api.common.maplestory_api_error import MapleStoryApiError, MapleStoryApiException

class MapleStoryFriendsApi(ABC, BaseModel):
    access_token: str
    BASE_URL: str = 'https://open.api.nexon.com/'
    timeout: int
    timezone: str
    sub_url: str

    def __init__(self, access_token: str, timezone: str, sub_url: str, timeout: int):
        super().__init__(
            access_token=access_token,
            timezone=timezone,
            sub_url=sub_url,
            timeout=timeout,
        )

    async def fetch(self, path: str, query: dict) -> Any:

        params = {key: value for key, value in query.items() if value is not None}

        async with httpx.AsyncClient(timeout=self.timeout) as client:
            response = await client.get(
                f'{self.BASE_URL}{path}',
                params=params,
                headers={
                    'Authorization': f'Bearer {self.access_token}',
                },
            )

        r = response.json()

        if (r.get('error')):
            raise MapleStoryApiException(MapleStoryApiError(**r.get('error')))

        return r

    def _to_date_string(self, date: datetime, min: datetime | None = None) -> str:
        """
        날짜 정보를 API 서버에서 요구하는 포맷으로 변환합니다.

        Args:
            date (datetime): 조회 하려는 날짜
            min (datetime or None): API 호출 가능한 최소 날짜
        """

        target_date = self.__get_datetime(date)
        date_str = target_date.strftime('%Y-%m-%d')

        if min is not None:
            min_date = self.__get_datetime(min)
            if target_date < min_date:
                raise ValueError(
                    f'You can only retrieve data after {min_date.strftime("%Y-%m-%d")}')

        return date_str

    def __get_datetime(self, date: datetime) -> datetime:
        """
        datetime 객체를 timezone이 지정된 datetime 객체로 변환합니다.

        datetime.astimezone()을 사용하면 지역에 따라 다른 결과가 나오고 date.replace()에도 버그가 존재하므로 datetime으로 재설정합니다.
        """
        return datetime(year=date.year, month=date.month, day=date.day, tzinfo=ZoneInfo(self.timezone))

    def _get_proper_default_datetime(self, day_offset: int, update_hour: int = 0, update_minute: int = 0) -> datetime:
        """
        API 서버의 데이터 갱신 시간에 따라 데이터가 조회 가능한 최신 날짜를 반환합니다.

        Args:
            day_offset(int): 갱신시간에 갱신되는 데이터가 오늘인지 어제인지에 따라 숫자를 지정합니다 (0: 오늘, 1: 어제)
            update_hour(int): 갱신 시간의 시간을 지정합니다
            update_minute(int): 갱신 시간의 분을 지정합니다
        """
        now = datetime.now(
            tz=ZoneInfo(self.timezone))
        update_time = datetime(
            year=now.year,
            month=now.month,
            day=now.day,
            hour=update_hour,
            minute=update_minute,
            tzinfo=ZoneInfo(self.timezone))

        adjusted_time: datetime

        if now > update_time:
            adjusted_time = update_time - timedelta(days=day_offset)
        else:
            adjusted_time = update_time - timedelta(days=day_offset + 1)

        return adjusted_time

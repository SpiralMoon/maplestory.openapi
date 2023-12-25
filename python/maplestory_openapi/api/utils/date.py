from datetime import datetime, timedelta
from zoneinfo import ZoneInfo


def get_proper_default_datetime() -> datetime:
    """현재 시간 기준으로 어제 날짜를 반환합니다.

    오전 1시부터 전일데이터 조회가 가능하므로 현재 시간이 1시 이전이면 전전일 날짜를 반환합니다.
    """
    now = datetime.now(
        tz=ZoneInfo('Asia/Seoul'))
    if now.hour >= 1:
        return now - timedelta(days=1)
    return now - timedelta(days=2)

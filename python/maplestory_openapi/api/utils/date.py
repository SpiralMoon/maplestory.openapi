from datetime import datetime, timedelta
from zoneinfo import ZoneInfo


def get_proper_default_datetime(day_offset: int, update_hour: int = 0, update_minute: int = 0) -> datetime:
    """현재 시간 기준으로 어제 날짜를 반환합니다.

    @param day_offset: 갱신시간에 갱신되는 데이터가 오늘인지 어제인지에 따라 숫자를 지정합니다 (0: 오늘, 1: 어제)
    @param hour: 갱신 시간의 시간을 지정합니다
    @param minute: 갱신 시간의 분을 지정합니다
    """
    now = datetime.now(
        tz=ZoneInfo('Asia/Seoul'))
    update_time = datetime(
        year=now.year,
        month=now.month,
        day=now.day,
        hour=update_hour,
        minute=update_minute,
        tzinfo=ZoneInfo('Asia/Seoul'))

    adjusted_time: datetime

    if now > update_time:
        adjusted_time = update_time - timedelta(days=day_offset)
    else:
        adjusted_time = update_time - timedelta(days=day_offset + 1)

    return adjusted_time

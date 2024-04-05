from datetime import datetime
from pydantic import BaseModel


class CharacterStatInfo(BaseModel):
    """캐릭터 스탯 상세 정보

    stat_name(str): 스탯 이름
    stat_value(str): 스탯 값
    """
    stat_name: str
    stat_value: str


class CharacterStat(BaseModel):
    """캐릭터 스탯 정보

    date(datetime): 조회 기준일
    character_class(str): 직업
    final_stat(list[CharacterStatInfo]): 현재 스탯 정보
    remain_ap(int): 잔여 AP
    """
    date: datetime | None
    character_class: str
    final_stat: list[CharacterStatInfo]
    remain_ap: int

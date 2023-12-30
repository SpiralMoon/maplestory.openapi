from datetime import datetime
from pydantic import BaseModel


class CharacterDojang(BaseModel):
    """무릉도장 최고기록 정보

    date(datetime): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
    character_class(str): 캐릭터 직업
    world_name(str): 월드 명
    dojang_best_floor(int): 무릉도장 최고 기록 층수
    date_dojang_record(datetime): 무릉도장 최고 기록 달성 일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
    dojang_best_time(int): 무릉도장 최고 층수 클리어에 걸린 시간 (초)
    """
    date: datetime
    character_class: str
    world_name: str
    dojang_best_floor: int
    date_dojang_record: datetime
    dojang_best_time: int

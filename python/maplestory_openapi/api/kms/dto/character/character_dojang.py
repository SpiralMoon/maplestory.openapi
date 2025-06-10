from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_dojang import CharacterDojang as BaseCharacterDojang


class CharacterDojang(BaseModel, BaseCharacterDojang):
    """
    무릉도장 최고 기록 정보

    Attributes:
        date (datetime or None): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        character_class (str or None): 캐릭터 직업
        world_name (str or None): 월드 명
        dojang_best_floor (int or None): 무릉도장 최고 기록 층수
        date_dojang_record (datetime or None): 무릉도장 최고 기록 달성 일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        dojang_best_time (int or None): 무릉도장 최고 층수 클리어에 걸린 시간 (초)
    """
    date: datetime | None
    character_class: str | None
    world_name: str | None
    dojang_best_floor: int | None
    date_dojang_record: datetime | None
    dojang_best_time: int | None

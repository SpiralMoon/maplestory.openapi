from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_popularity import CharacterPopularity as BaseCharacterPopularity

class CharacterPopularity(BaseModel, BaseCharacterPopularity):
    """
    캐릭터 인기도 정보

    Attributes:
        date (datetime or None): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        popularity (int): 인기도
    """
    date: datetime | None
    popularity: int

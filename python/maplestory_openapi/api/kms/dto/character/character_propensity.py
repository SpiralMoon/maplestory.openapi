from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_propensity import CharacterPropensity as BaseCharacterPropensity


class CharacterPropensity(BaseModel, BaseCharacterPropensity):
    """
    캐릭터 성향 정보

    Attributes:
        date (datetime or None): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        charisma_level (int): 카리스마 레벨
        sensibility_level (int): 감성 레벨
        insight_level (int): 통찰력 레벨
        willingness_level (int): 의지 레벨
        handicraft_level (int): 손재주 레벨
        charm_level (int): 매력 레벨
    """
    date: datetime | None
    charisma_level: int
    sensibility_level: int
    insight_level: int
    willingness_level: int
    handicraft_level: int
    charm_level: int

from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_propensity import CharacterPropensity as BaseCharacterPropensity


class CharacterPropensity(BaseModel, BaseCharacterPropensity):
    """
    캐릭터 성향 정보

    Attributes:
        date (datetime or None): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        charisma_level (int or None): 카리스마 레벨
        sensibility_level (int or None): 감성 레벨
        insight_level (int or None): 통찰력 레벨
        willingness_level (int or None): 의지 레벨
        handicraft_level (int or None): 손재주 레벨
        charm_level (int or None): 매력 레벨
    """
    date: datetime | None
    charisma_level: int | None
    sensibility_level: int | None
    insight_level: int | None
    willingness_level: int | None
    handicraft_level: int | None
    charm_level: int | None

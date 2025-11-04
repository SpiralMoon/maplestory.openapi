from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_propensity import CharacterPropensity as BaseCharacterPropensity


class CharacterPropensity(BaseModel, BaseCharacterPropensity):
    """
    Character traits information

    Attributes:
        date (datetime or None): Reference date for query (SGT, daily data with hours and minutes set to 0)
        charisma_level (int): Ambition level
        sensibility_level (int): Empathy level
        insight_level (int): Insight level
        willingness_level (int): Willpower level
        handicraft_level (int): Diligence level
        charm_level (int): Charm level
    """
    date: datetime | None
    charisma_level: int
    sensibility_level: int
    insight_level: int
    willingness_level: int
    handicraft_level: int
    charm_level: int

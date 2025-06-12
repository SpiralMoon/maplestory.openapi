from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_propensity import CharacterPropensity as BaseCharacterPropensity


class CharacterPropensity(BaseModel, BaseCharacterPropensity):
    """
    Character traits information

    Attributes:
        date (datetime or None): Reference date for query (SGT, daily data with hours and minutes set to 0)
        charisma_level (int or None): Ambition level
        sensibility_level (int or None): Empathy level
        insight_level (int or None): Insight level
        willingness_level (int or None): Willpower level
        handicraft_level (int or None): Diligence level
        charm_level (int or None): Charm level
    """
    date: datetime | None
    charisma_level: int | None
    sensibility_level: int | None
    insight_level: int | None
    willingness_level: int | None
    handicraft_level: int | None
    charm_level: int | None

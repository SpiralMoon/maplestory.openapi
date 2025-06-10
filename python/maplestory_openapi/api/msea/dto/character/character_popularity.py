from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_popularity import CharacterPopularity as BaseCharacterPopularity


class CharacterPopularity(BaseModel, BaseCharacterPopularity):
    """
    Character popularity information

    Attributes:
        date (datetime or None): Reference date for query (SGT, daily data with hours and minutes set to 0)
        popularity (int): Character popularity
    """
    date: datetime | None
    popularity: int

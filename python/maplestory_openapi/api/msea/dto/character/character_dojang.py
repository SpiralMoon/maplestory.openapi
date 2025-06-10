from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_dojang import CharacterDojang as BaseCharacterDojang


class CharacterDojang(BaseModel, BaseCharacterDojang):
    """
    Character Mu Lung Garden highest record information

    Attributes:
        date (datetime or None): Reference date for query (SGT, daily data with hours and minutes set to 0)
        character_class (str or None): Character job
        world_name (str or None): World name
        dojang_best_floor (int or None): Highest floor record in Mu Lung Garden
        date_dojang_record (datetime or None): Achievement date of the highest Mu Lung Garden record (SGT, daily data with hours and minutes set to 0)
        dojang_best_time (int or None): Time taken to clear the highest floor in Mu Lung Garden (in seconds)
    """
    date: datetime | None
    character_class: str | None
    world_name: str | None
    dojang_best_floor: int | None
    date_dojang_record: datetime | None
    dojang_best_time: int | None

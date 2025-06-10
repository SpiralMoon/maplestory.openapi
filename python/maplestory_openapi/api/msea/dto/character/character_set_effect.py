from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_set_effect import CharacterSetEffectInfo as BaseCharacterSetEffectInfo
from maplestory_openapi.api.common.dto.character.character_set_effect import CharacterSetEffectOptionFull as BaseCharacterSetEffectOptionFull
from maplestory_openapi.api.common.dto.character.character_set_effect import CharacterSetEffectSet as BaseCharacterSetEffectSet
from maplestory_openapi.api.common.dto.character.character_set_effect import CharacterSetEffect as BaseCharacterSetEffect


class CharacterSetEffectInfo(BaseModel, BaseCharacterSetEffectInfo):
    """
    Active Set Item effect information

    Attributes:
        set_count (int): Set Item effect level (number of equipped items)
        set_option (str): Set Item effect
    """
    set_count: int
    set_option: str


class CharacterSetEffectOptionFull(BaseModel, BaseCharacterSetEffectOptionFull):
    """
    All Set Item effect information

    Attributes:
        set_count (int): Set Item effect level (number of equipped items)
        set_option (str): Set Item effect
    """
    set_count: int
    set_option: str


class CharacterSetEffectSet(BaseModel, BaseCharacterSetEffectSet):
    """
    Set Item effect information

    Attributes:
        set_name (str): Set Item effect name
        total_set_count (int): Number of Set Items (including Lucky Items)
        set_effect_info (list[CharacterSetEffectInfo]): Active Set Item effect information
        set_option_full (list[CharacterSetEffectOptionFull]): All Set Item effect information
    """
    set_name: str
    total_set_count: int
    set_effect_info: list[CharacterSetEffectInfo]
    set_option_full: list[CharacterSetEffectOptionFull]


class CharacterSetEffect(BaseModel, BaseCharacterSetEffect):
    """
    Character information about equipped set item effects

    Attributes:
        date (datetime or None): Reference date for query (SGT, daily data with hours and minutes set to 0)
        set_effect (list[CharacterSetEffectSet]): Set Item effect information
    """
    date: datetime | None
    set_effect: list[CharacterSetEffectSet]

from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_basic import CharacterBasic as BaseCharacterBasic


class CharacterBasic(BaseModel, BaseCharacterBasic):
    """
    Character basic information

    Attributes:
        date (datetime or None): Reference date for query (SGT, daily data with hours and minutes set to 0)
        character_name (str): Character name
        world_name (str): World name
        character_gender (str): Character gender
        character_class (str): Character job
        character_class_level (str): Character job advancement tier
        character_level (int): Character level
        character_exp (int): Experience points gained at the current level
        character_exp_rate (str): Percentage of experience points at the current level
        character_guild_name (str or None): Guild name the character belongs to
        character_image (str): Character appearance image
        character_date_create (datetime): Character creation date (SGT, daily data with hours and minutes set to 0)
        access_flag (str): Login status in the past 7 days (true:logged in, false:not logged in)
        liberation_quest_clear_flag (str): Liberation quest completion status (true:completed, false:not completed)
    """

    date: datetime | None
    character_name: str
    world_name: str
    character_gender: str
    character_class: str
    character_class_level: str
    character_level: int
    character_exp: int
    character_exp_rate: str
    character_guild_name: str | None
    character_image: str
    character_date_create: datetime
    access_flag: str
    liberation_quest_clear_flag: str

    @property
    def is_access_flag(self) -> bool:
        """
        Login status in the past 7 days
        """
        return self.access_flag == 'true'

    @property
    def is_liberation_quest_clear_flag(self) -> bool:
        """
        Liberation quest completion status
        """
        return self.liberation_quest_clear_flag == 'true'

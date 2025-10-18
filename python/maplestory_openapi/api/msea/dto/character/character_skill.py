from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_skill import CharacterSkillInfo as BaseCharacterSkillInfo
from maplestory_openapi.api.common.dto.character.character_skill import CharacterSkill as BaseCharacterSkill


class CharacterSkillInfo(BaseModel, BaseCharacterSkillInfo):
    """
    Skill information

    Attributes:
        skill_name (str): Skill name
        skill_description (str): Skill description
        skill_level (int): Skill level
        skill_effect (str or None): Effect description by skill level
        skill_effect_next (str or None): Effect description for the next skill level
        skill_icon (str): Skill icon
    """
    skill_name: str
    skill_description: str
    skill_level: int
    skill_effect: str | None
    skill_effect_next: str | None = None
    skill_icon: str


class CharacterSkill(BaseModel, BaseCharacterSkill):
    """
    Character skill information

    Attributes:
        date (datetime or None): Reference date for query (SGT, daily data with hours and minutes set to 0)
        character_class (str or None): Character job
        character_skill_grade (str or None): Job advancement tier required to acquire the skill
        character_skill (list[CharacterSkillInfo]): Skill information
    """
    date: datetime | None
    character_class: str | None
    character_skill_grade: str | None
    character_skill: list[CharacterSkillInfo]

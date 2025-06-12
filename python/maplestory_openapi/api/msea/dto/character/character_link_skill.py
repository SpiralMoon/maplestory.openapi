from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_link_skill import CharacterLinkSkillInfo as BaseCharacterLinkSkillInfo
from maplestory_openapi.api.common.dto.character.character_link_skill import CharacterLinkSkill as BaseCharacterLinkSkill


class CharacterLinkSkillInfo(BaseModel, BaseCharacterLinkSkillInfo):
    """
    Character link skill information

    Attributes:
        skill_name (str): Skill name
        skill_description (str): Skill description
        skill_level (int): Skill level
        skill_effect (str): Skill effect
        skill_effect_next (str or None): Effect for the next skill level
        skill_icon (str): Skill icon
    """
    skill_name: str
    skill_description: str
    skill_level: int
    skill_effect: str
    skill_effect_next: str | None = None
    skill_icon: str


class CharacterLinkSkill(BaseModel, BaseCharacterLinkSkill):
    """
    Character equipped link skill information

    Attributes:
        date (datetime or None): Reference date for query (SGT, daily data with hours and minutes set to 0)
        character_class (str or None): Character job
        character_link_skill (list[CharacterLinkSkillInfo]): Link Skill information
        character_link_skill_preset_1 (list[CharacterLinkSkillInfo]): Link Skill information for preset 1
        character_link_skill_preset_2 (list[CharacterLinkSkillInfo]): Link Skill information for preset 2
        character_link_skill_preset_3 (list[CharacterLinkSkillInfo]): Link Skill information for preset 3
        character_owned_link_skill (CharacterLinkSkillInfo or None): My Link Skill information
        character_owned_link_skill_preset_1 (CharacterLinkSkillInfo or None): My Link Skill information for preset 1
        character_owned_link_skill_preset_2 (CharacterLinkSkillInfo or None): My Link Skill information for preset 2
        character_owned_link_skill_preset_3 (CharacterLinkSkillInfo or None): My Link Skill information for preset 3
    """
    date: datetime | None
    character_class: str | None
    character_link_skill: list[CharacterLinkSkillInfo]
    character_link_skill_preset_1: list[CharacterLinkSkillInfo]
    character_link_skill_preset_2: list[CharacterLinkSkillInfo]
    character_link_skill_preset_3: list[CharacterLinkSkillInfo]
    character_owned_link_skill: CharacterLinkSkillInfo | None
    character_owned_link_skill_preset_1: CharacterLinkSkillInfo | None
    character_owned_link_skill_preset_2: CharacterLinkSkillInfo | None
    character_owned_link_skill_preset_3: CharacterLinkSkillInfo | None

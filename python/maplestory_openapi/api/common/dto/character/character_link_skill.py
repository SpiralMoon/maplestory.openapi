from datetime import datetime


class CharacterLinkSkillInfo:
    skill_name: str
    skill_description: str
    skill_level: int
    skill_effect: str
    skill_effect_next: str | None
    skill_icon: str


class CharacterLinkSkill:
    date: datetime | None
    character_class: str
    character_link_skill: list[CharacterLinkSkillInfo] = []
    character_link_skill_preset_1: list[CharacterLinkSkillInfo] = []
    character_link_skill_preset_2: list[CharacterLinkSkillInfo] = []
    character_link_skill_preset_3: list[CharacterLinkSkillInfo] = []
    character_owned_link_skill: CharacterLinkSkillInfo | None
    character_owned_link_skill_preset_1: CharacterLinkSkillInfo | None
    character_owned_link_skill_preset_2: CharacterLinkSkillInfo | None
    character_owned_link_skill_preset_3: CharacterLinkSkillInfo | None

from datetime import datetime


class CharacterSkillInfo:
    skill_name: str
    skill_description: str
    skill_level: int
    skill_effect: str | None
    skill_effect_next: str | None
    skill_icon: str


class CharacterSkill:
    date: datetime | None
    character_class: str | None
    character_skill_grade: str | None
    character_skill: list[CharacterSkillInfo]

from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_skill import CharacterSkillInfo as BaseCharacterSkillInfo
from maplestory_openapi.api.common.dto.character.character_skill import CharacterSkill as BaseCharacterSkill


class CharacterSkillInfo(BaseModel, BaseCharacterSkillInfo):
    """
    스킬 정보

    Attributes:
        skill_name (str): 스킬 명
        skill_description (str): 스킬 설명
        skill_level (int): 스킬 레벨
        skill_effect (str or None): 스킬 레벨 별 효과 설명
        skill_effect_next (str or None): 다음 스킬 레벨 효과 설명
        skill_icon (str): 스킬 아이콘
    """
    skill_name: str
    skill_description: str
    skill_level: int
    skill_effect: str | None
    skill_effect_next: str | None = None
    skill_icon: str


class CharacterSkill(BaseModel, BaseCharacterSkill):
    """
    캐릭터 스킬 정보

    Attributes:
        date (datetime or None): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        character_class (str or None): 캐릭터 직업
        character_skill_grade (str or None): 스킬 전직 차수
        character_skill (list[CharacterSkillInfo]): 스킬 정보
    """
    date: datetime | None
    character_class: str | None
    character_skill_grade: str | None
    character_skill: list[CharacterSkillInfo]

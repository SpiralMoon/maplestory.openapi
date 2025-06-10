from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_link_skill import CharacterLinkSkillInfo as BaseCharacterLinkSkillInfo
from maplestory_openapi.api.common.dto.character.character_link_skill import CharacterLinkSkill as BaseCharacterLinkSkill


class CharacterLinkSkillInfo(BaseModel, BaseCharacterLinkSkillInfo):
    """
    링크 스킬 상세 정보

    Attributes:
        skill_name (str): 스킬 명
        skill_description (str): 스킬 설명
        skill_level (int): 스킬 레벨
        skill_effect (str): 스킬 효과
        skill_effect_next (str or None): 다음 레벨의 스킬 효과
        skill_icon (str): 스킬 아이콘
    """
    skill_name: str
    skill_description: str
    skill_level: int
    skill_effect: str
    skill_effect_next: str | None = None
    skill_icon: str


class CharacterLinkSkill(BaseModel, BaseCharacterLinkSkill):
    """
    장착 링크 스킬 정보

    Attributes:
        date (datetime or None): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        character_class (str or None): 캐릭터 직업
        character_link_skill (list[CharacterLinkSkillInfo]): 링크 스킬 정보
        character_link_skill_preset_1 (list[CharacterLinkSkillInfo]): 링크 스킬 1번 프리셋 정보
        character_link_skill_preset_2 (list[CharacterLinkSkillInfo]): 링크 스킬 2번 프리셋 정보
        character_link_skill_preset_3 (list[CharacterLinkSkillInfo]): 링크 스킬 3번 프리셋 정보
        character_owned_link_skill (CharacterLinkSkillInfo or None): 내 링크 스킬 정보
        character_owned_link_skill_preset_1 (CharacterLinkSkillInfo or None): 내 링크 스킬 1번 프리셋 정보
        character_owned_link_skill_preset_2 (CharacterLinkSkillInfo or None): 내 링크 스킬 2번 프리셋 정보
        character_owned_link_skill_preset_3 (CharacterLinkSkillInfo or None): 내 링크 스킬 3번 프리셋 정보
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

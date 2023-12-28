from datetime import datetime
from pydantic import BaseModel


class CharacterLinkSkillInfo(BaseModel):
    """링크 스킬 상세 정보

    skill_name(str): 스킬 명
    skill_description(str): 스킬 설명
    skill_level(int): 스킬 레벨
    skill_effect(str): 스킬 효과
    skill_icon(str): 스킬 아이콘
    """
    skill_name: str
    skill_description: str
    skill_level: int
    skill_effect: str
    skill_icon: str


class CharacterLinkSkill(BaseModel):
    """장착 링크 스킬 정보

    date(datetime): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
    character_class(str): 캐릭터 직업
    character_link_skill(list[CharacterLinkSkillInfo]): 링크 스킬 정보
    character_owned_link_skill(CharacterLinkSkillInfo): 내 링크 스킬 정보
    """
    date: datetime
    character_class: str
    character_link_skill: list[CharacterLinkSkillInfo]
    character_owned_link_skill: CharacterLinkSkillInfo

from datetime import datetime
from pydantic import BaseModel


class CharacterSkillInfo(BaseModel):
    """스킬 정보

    skill_name(str): 스킬 명
    skill_description(str): 스킬 설명
    skill_level(int): 스킬 레벨
    skill_effect(str): 스킬 레벨 별 효과 설명
    skill_effect(str): 다음 스킬 레벨 효과 설명
    skill_icon(str): 스킬 아이콘
    """
    skill_name: str
    skill_description: str
    skill_level: int
    skill_effect: str | None
    skill_effect_next: str | None
    skill_icon: str


class CharacterSkill(BaseModel):
    """캐릭터 스킬 정보

    date(datetime): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
    character_class(str): 캐릭터 직업
    character_skill_grade(str): 스킬 전직 차수
    character_skill(list[CharacterSkillInfo]): 스킬 정보
    """
    date: datetime | None
    character_class: str
    character_skill_grade: str
    character_skill: list[CharacterSkillInfo]

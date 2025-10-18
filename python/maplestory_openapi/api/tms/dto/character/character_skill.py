from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_skill import CharacterSkillInfo as BaseCharacterSkillInfo
from maplestory_openapi.api.common.dto.character.character_skill import CharacterSkill as BaseCharacterSkill


class CharacterSkillInfo(BaseModel, BaseCharacterSkillInfo):
    """
    技能資訊

    Attributes:
        skill_name (str): 技能名稱
        skill_description (str): 技能描述
        skill_level (int): 技能等級
        skill_effect (str or None): 技能等級的效果描述
        skill_effect_next (str or None): 下一等級的技能效果
        skill_icon (str): 技能圖示
    """
    skill_name: str
    skill_description: str
    skill_level: int
    skill_effect: str | None
    skill_effect_next: str | None = None
    skill_icon: str


class CharacterSkill(BaseModel, BaseCharacterSkill):
    """
    角色技能與超技能資訊

    Attributes:
        date (datetime or None): 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        character_class (str or None): 角色職業
        character_skill_grade (str or None): 技能轉職次數
        character_skill (list[CharacterSkillInfo]): 技能資訊
    """
    date: datetime | None
    character_class: str | None
    character_skill_grade: str | None
    character_skill: list[CharacterSkillInfo]

from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_link_skill import CharacterLinkSkillInfo as BaseCharacterLinkSkillInfo
from maplestory_openapi.api.common.dto.character.character_link_skill import CharacterLinkSkill as BaseCharacterLinkSkill


class CharacterLinkSkillInfo(BaseModel, BaseCharacterLinkSkillInfo):
    """
    角色連結技能資訊

    Attributes:
        skill_name (str): 技能名稱
        skill_description (str): 技能描述
        skill_level (int): 技能等級
        skill_effect (str): 技能效果
        skill_effect_next (str or None): 下一等級的技能效果
        skill_icon (str): 技能圖示
    """
    skill_name: str
    skill_description: str
    skill_level: int
    skill_effect: str
    skill_effect_next: str | None = None
    skill_icon: str


class CharacterLinkSkill(BaseModel, BaseCharacterLinkSkill):
    """
    角色已裝備連結技能資訊

    Attributes:
        date (datetime or None): 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        character_class (str or None): 角色職業
        character_link_skill (list[CharacterLinkSkillInfo]): 連結技能資訊
        character_link_skill_preset_1 (list[CharacterLinkSkillInfo]): 連結技能 1 預設資訊
        character_link_skill_preset_2 (list[CharacterLinkSkillInfo]): 連結技能 2 預設資訊
        character_link_skill_preset_3 (list[CharacterLinkSkillInfo]): 連結技能 3 預設資訊
        character_owned_link_skill (CharacterLinkSkillInfo or None): 我的連結技能資訊
        character_owned_link_skill_preset_1 (CharacterLinkSkillInfo or None): 我的連結技能 1 預設資訊
        character_owned_link_skill_preset_2 (CharacterLinkSkillInfo or None): 我的連結技能 2 預設資訊
        character_owned_link_skill_preset_3 (CharacterLinkSkillInfo or None): 我的連結技能 3 預設資訊
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

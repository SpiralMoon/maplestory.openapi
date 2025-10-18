from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.guild.guild_basic import GuildBasic as BaseGuildBasic
from maplestory_openapi.api.common.dto.guild.guild_basic import GuildSkill as BaseGuildSkill


class GuildSkill(BaseModel, BaseGuildSkill):
    """
    公會技能

    Attributes:
        skill_name (str): 技能名稱
        skill_description (str): 技能描述
        skill_level (int): 技能等級
        skill_effect (str): 技能等級的效果
        skill_icon (str): 技能圖示
    """
    skill_name: str
    skill_description: str
    skill_level: int
    skill_effect: str
    skill_icon: str


class GuildBasic(BaseModel, BaseGuildBasic):
    """
    公會基本資訊

    Attributes:
        date (datetime or None): 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        world_name (str): 世界名稱
        guild_name (str): 公會名稱
        guild_level (int): 公會等級
        guild_fame (int): 公會名聲值
        guild_point (int): 公會點數 (GP)
        guild_master_name (str): 公會會長角色名稱
        guild_member_count (int): 公會成員人數
        guild_member (list[str]): 公會成員清單
        guild_skill (list[GuildSkill]): 公會技能清單
        guild_noblesse_skill (list[GuildSkill]): 貴族技能清單
    """
    date: datetime | None
    world_name: str
    guild_name: str
    guild_level: int
    guild_fame: int
    guild_point: int
    guild_master_name: str
    guild_member_count: int
    guild_member: list[str]
    guild_skill: list[GuildSkill]
    guild_noblesse_skill: list[GuildSkill]

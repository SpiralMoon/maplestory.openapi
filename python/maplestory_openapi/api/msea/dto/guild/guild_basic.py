from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.guild.guild_basic import GuildBasic as BaseGuildBasic
from maplestory_openapi.api.common.dto.guild.guild_basic import GuildSkill as BaseGuildSkill


class GuildSkill(BaseModel, BaseGuildSkill):
    """
    Guild skill information

    Attributes:
        skill_name (str): Skill name
        skill_description (str): Skill description
        skill_level (int): Skill level
        skill_effect (str): Effects by skill level
        skill_icon (str): Skill icon
    """
    skill_name: str
    skill_description: str
    skill_level: int
    skill_effect: str
    skill_icon: str


class GuildBasic(BaseModel, BaseGuildBasic):
    """
    Guild basic information

    Attributes:
        date (datetime or None): Reference date for query (SGT, daily data with hours and minutes set to 0)
        world_name (str): World name
        guild_name (str): Guild name
        guild_level (int): Guild level
        guild_fame (int): Honor EXP
        guild_point (int): Guild Points (GP)
        guild_master_name (str): Character name of the Guild Master
        guild_member_count (int): Number of guild members
        guild_member (list[str]): List of guild members
        guild_skill (list[GuildSkill]): List of guild skills
        guild_noblesse_skill (list[GuildSkill]): List of Noblesse Guild Skills
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

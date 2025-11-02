from datetime import datetime


class GuildSkill:
    skill_name: str
    skill_description: str
    skill_level: int
    skill_effect: str
    skill_icon: str


class GuildBasic:
    date: datetime | None
    world_name: str
    guild_name: str
    guild_level: int
    guild_fame: int
    guild_point: int
    guild_master_name: str
    guild_member_count: int
    guild_member: list[str] = []
    guild_skill: list[GuildSkill] = []
    guild_noblesse_skill: list[GuildSkill] = []

from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.guild.guild_basic import GuildBasic as BaseGuildBasic
from maplestory_openapi.api.common.dto.guild.guild_basic import GuildSkill as BaseGuildSkill


class GuildSkill(BaseModel, BaseGuildSkill):
    """
    길드 스킬 정보

    Attributes:
        skill_name (str): 스킬 명
        skill_description (str): 스킬 설명
        skill_level (int): 스킬 레벨
        skill_effect (str): 스킬 레벨 별 효과
        skill_icon (str): 스킬 아이콘
    """
    skill_name: str
    skill_description: str
    skill_level: int
    skill_effect: str
    skill_icon: str


class GuildBasic(BaseModel, BaseGuildBasic):
    """
    길드 기본 정보

    Attributes:
        date (datetime or None): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        world_name (str): 월드 명
        guild_name (str): 길드 명
        guild_level (int): 길드 레벨
        guild_fame (int): 길드 명성치
        guild_point (int): 길드 포인트(GP)
        guild_master_name (str): 길드 마스터 캐릭터 명
        guild_member_count (int): 길드원 수
        guild_member (list[str]): 길드원 목록
        guild_skill (list[GuildSkill]): 길드 스킬 목록
        guild_noblesse_skill (list[GuildSkill]): 노블레스 스킬 목록
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

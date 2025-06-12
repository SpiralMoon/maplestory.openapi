from pydantic import BaseModel

from maplestory_openapi.api.common.dto.guild.guild import Guild as BaseGuild


class Guild(BaseModel, BaseGuild):
    """
    길드 식별자 정보

    Attributes:
        oguild_id (str): 길드 식별자
    """
    oguild_id: str

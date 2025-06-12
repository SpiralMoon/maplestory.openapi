from pydantic import BaseModel

from maplestory_openapi.api.common.dto.guild.guild import Guild as BaseGuild


class Guild(BaseModel, BaseGuild):
    """
    Guild identifier information

    Attributes:
        oguild_id (str): Guild identifier
    """
    oguild_id: str

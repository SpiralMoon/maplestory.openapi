from pydantic import BaseModel

from maplestory_openapi.api.common.dto.guild.guild import Guild as BaseGuild


class Guild(BaseModel, BaseGuild):
    """
    公會識別碼資訊

    Attributes:
        oguild_id (str): 公會識別碼
    """
    oguild_id: str

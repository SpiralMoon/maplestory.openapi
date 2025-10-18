from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character import Character as BaseCharacter


class Character(BaseModel, BaseCharacter):
    """
    角色辨識器資訊

    Attributes:
        ocid (str): 角色辨識器
    """
    ocid: str

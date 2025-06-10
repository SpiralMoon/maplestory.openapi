from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character import Character as BaseCharacter


class Character(BaseModel, BaseCharacter):
    """
   캐릭터 식별자(ocid)

    Attributes:
        ocid (str): 캐릭터 식별자
    """
    ocid: str

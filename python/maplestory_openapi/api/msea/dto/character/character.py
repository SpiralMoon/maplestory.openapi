from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character import Character as BaseCharacter


class Character(BaseModel, BaseCharacter):
    """
    Character identifier information

    Attributes:
        ocid (str): Character identifier
    """
    ocid: str

from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_hexamatrix import CharacterHexaMatrixEquipmentLinkedSkill as BaseCharacterHexaMatrixEquipmentLinkedSkill
from maplestory_openapi.api.common.dto.character.character_hexamatrix import CharacterHexaMatrixCoreEquipment as BaseCharacterHexaMatrixCoreEquipment
from maplestory_openapi.api.common.dto.character.character_hexamatrix import CharacterHexaMatrix as BaseCharacterHexaMatrix


class CharacterHexaMatrixEquipmentLinkedSkill(BaseModel, BaseCharacterHexaMatrixEquipmentLinkedSkill):
    """
    Linked skill

    Attributes:
        hexa_skill_id (str): HEXA Skill name
    """
    hexa_skill_id: str


class CharacterHexaMatrixCoreEquipment(BaseModel, BaseCharacterHexaMatrixCoreEquipment):
    """
    HEXA Node information

    Attributes:
        hexa_core_name (str): Node name
        hexa_core_level (int): Node level
        hexa_core_type (str): Node type
        linked_skill (list[CharacterHexaMatrixEquipmentLinkedSkill]): Linked skill
    """
    hexa_core_name: str
    hexa_core_level: int
    hexa_core_type: str
    linked_skill: list[CharacterHexaMatrixEquipmentLinkedSkill]


class CharacterHexaMatrix(BaseModel, BaseCharacterHexaMatrix):
    """
    Character HEXA Node information

    Attributes:
        date (datetime or None): Reference date for query (SGT, daily data with hours and minutes set to 0)
        character_hexa_core_equipment (list[CharacterHexaMatrixCoreEquipment]): HEXA Node information
    """
    date: datetime | None
    character_hexa_core_equipment: list[CharacterHexaMatrixCoreEquipment]

from datetime import datetime
from pydantic import BaseModel, field_validator

from maplestory_openapi.api.common.dto.character.character_vmatrix import CharacterVMatrixCoreEquipment as BaseCharacterVMatrixCoreEquipment
from maplestory_openapi.api.common.dto.character.character_vmatrix import CharacterVMatrix as BaseCharacterVMatrix


class CharacterVMatrixCoreEquipment(BaseModel, BaseCharacterVMatrixCoreEquipment):
    """
    V Matrix Node information

    Attributes:
        slot_id (str): Slot index
        slot_level (int): Slot level
        v_core_name (str or None): Node name
        v_core_type (str or None): Node type
        v_core_level (int): Node level
        v_core_skill_1 (str or None): Name of the skill that corresponds to the node
        v_core_skill_2 (str or None): Name of the second skill that corresponds to the node (for Boost Nodes)
        v_core_skill_3 (str or None): Name of the third skill that corresponds to the node (for Boost Nodes)
    """
    slot_id: str
    slot_level: int
    v_core_name: str | None
    v_core_type: str | None
    v_core_level: int
    v_core_skill_1: str | None
    v_core_skill_2: str | None
    v_core_skill_3: str | None


class CharacterVMatrix(BaseModel, BaseCharacterVMatrix):
    """
    Character V Matrix information

    Attributes:
        date (datetime or None): Reference date for query (SGT, daily data with hours and minutes set to 0)
        character_class (str): Character job
        character_v_core_equipment (list[CharacterVMatrixCoreEquipment]): V Matrix Node information
        character_v_matrix_remain_slot_upgrade_point (int): Remaining Matrix enhancement points for the character
    """
    date: datetime | None
    character_class: str
    character_v_core_equipment: list[CharacterVMatrixCoreEquipment]
    character_v_matrix_remain_slot_upgrade_point: int

    @field_validator("character_v_core_equipment", mode="before")
    @classmethod
    def null_as_empty(cls, v):
        if v is None:
            return []
        return v

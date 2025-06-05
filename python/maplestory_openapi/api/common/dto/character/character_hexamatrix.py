from datetime import datetime
from pydantic import model_validator


class CharacterHexaMatrixEquipmentLinkedSkill:
    hexa_skill_id: str


class CharacterHexaMatrixCoreEquipment:
    hexa_core_name: str
    hexa_core_level: int
    hexa_core_type: str
    linked_skill: list[CharacterHexaMatrixEquipmentLinkedSkill]


class CharacterHexaMatrix:
    date: datetime | None
    character_hexa_core_equipment: list[CharacterHexaMatrixCoreEquipment]

    @model_validator(mode="before")
    @classmethod
    def set_default(cls, values):
        if values.get("character_hexa_core_equipment") is None:
            values["character_hexa_core_equipment"] = []
        return values


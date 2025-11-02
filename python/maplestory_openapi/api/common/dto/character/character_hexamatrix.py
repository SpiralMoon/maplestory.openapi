from datetime import datetime


class CharacterHexaMatrixEquipmentLinkedSkill:
    hexa_skill_id: str


class CharacterHexaMatrixCoreEquipment:
    hexa_core_name: str
    hexa_core_level: int
    hexa_core_type: str
    linked_skill: list[CharacterHexaMatrixEquipmentLinkedSkill] = []


class CharacterHexaMatrix:
    date: datetime | None
    character_hexa_core_equipment: list[CharacterHexaMatrixCoreEquipment] = []


from datetime import datetime


class CharacterVMatrixCoreEquipment:
    slot_id: str
    slot_level: int
    v_core_name: str | None
    v_core_type: str | None
    v_core_level: int
    v_core_skill_1: str | None
    v_core_skill_2: str | None
    v_core_skill_3: str | None


class CharacterVMatrix:
    date: datetime | None
    character_class: str | None
    character_v_core_equipment: list[CharacterVMatrixCoreEquipment] = []
    character_v_matrix_remain_slot_upgrade_point: int | None

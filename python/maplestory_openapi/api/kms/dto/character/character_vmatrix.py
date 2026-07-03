from datetime import datetime
from pydantic import BaseModel, field_validator, Field

from maplestory_openapi.api.common.dto.character.character_vmatrix import CharacterVMatrixCoreEquipment as BaseCharacterVMatrixCoreEquipment
from maplestory_openapi.api.common.dto.character.character_vmatrix import CharacterVMatrix as BaseCharacterVMatrix

class CharacterVMatrixCoreEquipment(BaseModel, BaseCharacterVMatrixCoreEquipment):
    """
    V코어 정보

    Attributes:
        slot_id (str): 슬롯 인덱스
        slot_level (int): 슬롯 레벨
        v_core_name (str or None): 코어 명
        v_core_type (str or None): 코어 타입
        v_core_level (int): 코어 레벨
        v_core_skill_1 (str or None): 코어에 해당하는 스킬 명
        v_core_skill_2 (str or None): (강화 코어인 경우) 코어에 해당하는 두 번째 스킬 명
        v_core_skill_3 (str or None): (강화 코어인 경우) 코어에 해당하는 세 번째 스킬 명
    """
    slot_id: str
    slot_level: int = Field(deprecated="2025년 12월 18일 점검 이후부터 사용하지 않는 항목입니다.")
    v_core_name: str | None
    v_core_type: str | None
    v_core_level: int
    v_core_skill_1: str | None = Field(deprecated="2025년 12월 18일 점검 이후부터 사용하지 않는 항목입니다.")
    v_core_skill_2: str | None = Field(deprecated="2025년 12월 18일 점검 이후부터 사용하지 않는 항목입니다.")
    v_core_skill_3: str | None = Field(deprecated="2025년 12월 18일 점검 이후부터 사용하지 않는 항목입니다.")



class CharacterVMatrixCoreEquipmentPreset(BaseModel):
    """
    캐릭터 V코어 프리셋 정보

    Attributes:
        v_core_name (str or None): 코어 명
        v_core_type (str or None): 코어 타입
        v_core_level (int): 코어의 레벨
    """
    v_core_name: str | None
    v_core_type: str | None
    v_core_level: int


class CharacterVMatrix(BaseModel, BaseCharacterVMatrix):
    """
    V매트릭스 정보

    Attributes:
        date (datetime or None): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        character_class (str): 캐릭터 직업
        character_v_core_equipment (list[CharacterVMatrixCoreEquipment]): V코어 정보
        character_v_matrix_remain_slot_upgrade_point (int): 캐릭터 잔여 매트릭스 강화 포인트
        character_v_core_equipment_preset_1 (list[CharacterVMatrixCoreEquipmentPreset]): 프리셋 1의 V코어 정보
        character_v_core_equipment_preset_2 (list[CharacterVMatrixCoreEquipmentPreset]): 프리셋 2의 V코어 정보
        character_v_core_equipment_preset_3 (list[CharacterVMatrixCoreEquipmentPreset]): 프리셋 3의 V코어 정보
        character_v_core_equipment_preset_4 (list[CharacterVMatrixCoreEquipmentPreset]): 프리셋 4의 V코어 정보
        character_v_core_equipment_preset_5 (list[CharacterVMatrixCoreEquipmentPreset]): 프리셋 5의 V코어 정보
    """
    date: datetime | None
    character_class: str
    character_v_core_equipment: list[CharacterVMatrixCoreEquipment]
    character_v_matrix_remain_slot_upgrade_point: int
    character_v_core_equipment_preset_1: list[CharacterVMatrixCoreEquipmentPreset]
    character_v_core_equipment_preset_2: list[CharacterVMatrixCoreEquipmentPreset]
    character_v_core_equipment_preset_3: list[CharacterVMatrixCoreEquipmentPreset]
    character_v_core_equipment_preset_4: list[CharacterVMatrixCoreEquipmentPreset]
    character_v_core_equipment_preset_5: list[CharacterVMatrixCoreEquipmentPreset]

    @field_validator("character_v_core_equipment", "character_v_core_equipment_preset_1", "character_v_core_equipment_preset_2", "character_v_core_equipment_preset_3", "character_v_core_equipment_preset_4", "character_v_core_equipment_preset_5", mode="before")
    @classmethod
    def null_as_empty(cls, v):
        if v is None:
            return []
        return v

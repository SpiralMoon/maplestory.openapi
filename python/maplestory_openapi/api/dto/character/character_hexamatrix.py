
from datetime import datetime
from pydantic import BaseModel


class CharacterHexaMatrixEquipmentLinkedSkill(BaseModel):
    """연결된 스킬 정보

    hexa_skill_name(str): HEXA 스킬 명
    """
    hexa_skill_id: str


class CharacterHexaMatrixCoreEquipment(BaseModel):
    """HEXA 코어 상세 정보

    hexa_core_name(str): 코어 명
    hexa_core_level(int): 코어 레벨
    hexa_core_type(str): 코어 타입
    linked_skill(CharacterHexaMatrixEquipmentLinkedSkill): 연결된 스킬
    """
    hexa_core_name: str
    hexa_core_level: int
    hexa_core_type: str
    linked_skill: list[CharacterHexaMatrixEquipmentLinkedSkill]


class CharacterHexaMatrix(BaseModel):
    """HEXA 코어 정보

    date(datetime): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
    character_hexa_core_equipment(list[CharacterHexaMatrixCoreEquipment]): HEXA 코어 정보
    """
    date: datetime | None
    character_hexa_core_equipment: list[CharacterHexaMatrixCoreEquipment]

from datetime import datetime
from pydantic import BaseModel


class CharacterVMatrixCoreEquipment(BaseModel):
    """V코어 정보

    slot_id(str): 슬롯 인덱스
    slot_level(int): 슬롯 레벨
    v_core_name(str): 코어 명
    v_core_type(str): 코어 타입
    v_core_level(int): 코어 레벨
    v_core_skill_1(str): 코어에 해당하는 스킬 명
    v_core_skill_2(str): (강화 코어인 경우) 코어에 해당하는 두 번째 스킬 명
    v_core_skill_3(str): (강화 코어인 경우) 코어에 해당하는 세 번째 스킬 명
    """
    slot_id: str
    slot_level: int
    v_core_name: str | None
    v_core_type: str | None
    v_core_level: int
    v_core_skill_1: str | None
    v_core_skill_2: str | None
    v_core_skill_3: str | None


class CharacterVMatrix(BaseModel):
    """V매트릭스 정보

    date(datetime): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
    character_class(str): 캐릭터 직업
    character_v_core_equipment(list[CharacterVMatrixCoreEquipment]): V코어 정보
    character_v_matrix_remain_slot_upgrade_point(int): 캐릭터 잔여 매트릭스 강화 포인트
    """
    date: datetime | None
    character_class: str
    character_v_core_equipment: list[CharacterVMatrixCoreEquipment]
    character_v_matrix_remain_slot_upgrade_point: int

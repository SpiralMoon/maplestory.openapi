from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_vmatrix import CharacterVMatrixCoreEquipment as BaseCharacterVMatrixCoreEquipment
from maplestory_openapi.api.common.dto.character.character_vmatrix import CharacterVMatrix as BaseCharacterVMatrix


class CharacterVMatrixCoreEquipment(BaseModel, BaseCharacterVMatrixCoreEquipment):
    """
    V 核心資訊

    Attributes:
        slot_id (str): 欄位索引
        slot_level (int): 欄位等級
        v_core_name (str or None): 核心名稱
        v_core_type (str or None): 核心類型
        v_core_level (int): 核心等級
        v_core_skill_1 (str or None): 對應核心的技能名稱
        v_core_skill_2 (str or None): (若為強化核心) 對應核心的第二個技能名稱
        v_core_skill_3 (str or None): (若為強化核心) 對應核心的第三個技能名稱
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
    角色 V 矩陣欄位資訊與已裝備 V 核心資訊

    Attributes:
        date (datetime or None): 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        character_class (str or None): 角色職業
        character_v_core_equipment (list[CharacterVMatrixCoreEquipment]): V 核心資訊
        character_v_matrix_remain_slot_upgrade_point (int or None): 角色剩餘的矩陣強化點數
    """
    date: datetime | None
    character_class: str | None
    character_v_core_equipment: list[CharacterVMatrixCoreEquipment]
    character_v_matrix_remain_slot_upgrade_point: int | None

from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_hexamatrix import CharacterHexaMatrixEquipmentLinkedSkill as BaseCharacterHexaMatrixEquipmentLinkedSkill
from maplestory_openapi.api.common.dto.character.character_hexamatrix import CharacterHexaMatrixCoreEquipment as BaseCharacterHexaMatrixCoreEquipment
from maplestory_openapi.api.common.dto.character.character_hexamatrix import CharacterHexaMatrix as BaseCharacterHexaMatrix


class CharacterHexaMatrixEquipmentLinkedSkill(BaseModel, BaseCharacterHexaMatrixEquipmentLinkedSkill):
    """
    已連接的技能

    Attributes:
        hexa_skill_id (str): HEXA 技能名稱
    """
    hexa_skill_id: str


class CharacterHexaMatrixCoreEquipment(BaseModel, BaseCharacterHexaMatrixCoreEquipment):
    """
    HEXA 核心資訊

    Attributes:
        hexa_core_name (str): 核心名稱
        hexa_core_level (int): 核心等級
        hexa_core_type (str): 核心類型
        linked_skill (list[CharacterHexaMatrixEquipmentLinkedSkill]): 已連接的技能
    """
    hexa_core_name: str
    hexa_core_level: int
    hexa_core_type: str
    linked_skill: list[CharacterHexaMatrixEquipmentLinkedSkill]


class CharacterHexaMatrix(BaseModel, BaseCharacterHexaMatrix):
    """
    角色已裝備於 HEXA 矩陣的 HEXA 核心資訊

    Attributes:
        date (datetime or None): 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        character_hexa_core_equipment (list[CharacterHexaMatrixCoreEquipment]): HEXA 核心資訊
    """
    date: datetime | None
    character_hexa_core_equipment: list[CharacterHexaMatrixCoreEquipment]

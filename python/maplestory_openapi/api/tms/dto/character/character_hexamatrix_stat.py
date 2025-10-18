from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_hexamatrix_stat import CharacterHexaMatrixStatCore as BaseCharacterHexaMatrixStatCore
from maplestory_openapi.api.common.dto.character.character_hexamatrix_stat import CharacterHexaMatrixStat as BaseCharacterHexaMatrixStat


class CharacterHexaMatrixStatCore(BaseModel, BaseCharacterHexaMatrixStatCore):
    """
    HEXA 屬性核心資訊

    Attributes:
        slot_id (str): 欄位索引
        main_stat_name (str): 主要屬性名稱
        sub_stat_name_1 (str): 第一副屬性名稱
        sub_stat_name_2 (str): 第二副屬性名稱
        main_stat_level (int): 主要屬性等級
        sub_stat_level_1 (int): 第一副屬性等級
        sub_stat_level_2 (int): 第二副屬性等級
        stat_grade (int): 屬性核心階級
    """
    slot_id: str
    main_stat_name: str
    sub_stat_name_1: str
    sub_stat_name_2: str
    main_stat_level: int
    sub_stat_level_1: int
    sub_stat_level_2: int
    stat_grade: int


class CharacterHexaMatrixStat(BaseModel, BaseCharacterHexaMatrixStat):
    """
    角色設定於 HEXA 矩陣中的 HEXA 屬性資訊

    Attributes:
        date (datetime or None): 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        character_class (str or None): 角色職業
        character_hexa_stat_core (list[CharacterHexaMatrixStatCore]): HEXA 屬性 I 核心資訊
        character_hexa_stat_core_2 (list[CharacterHexaMatrixStatCore]): HEXA 屬性 II 核心資訊
        character_hexa_stat_core_3 (list[CharacterHexaMatrixStatCore]): HEXA 屬性 III 核心資訊
        preset_hexa_stat_core (list[CharacterHexaMatrixStatCore]): 預設的 HEXA 屬性 I 核心資訊
        preset_hexa_stat_core_2 (list[CharacterHexaMatrixStatCore]): 預設的 HEXA 屬性 II 核心資訊
        preset_hexa_stat_core_3 (list[CharacterHexaMatrixStatCore]): 預設的 HEXA 屬性 III 核心資訊
    """
    date: datetime | None
    character_class: str | None
    character_hexa_stat_core: list[CharacterHexaMatrixStatCore]
    character_hexa_stat_core_2: list[CharacterHexaMatrixStatCore]
    character_hexa_stat_core_3: list[CharacterHexaMatrixStatCore]
    preset_hexa_stat_core: list[CharacterHexaMatrixStatCore]
    preset_hexa_stat_core_2: list[CharacterHexaMatrixStatCore]
    preset_hexa_stat_core_3: list[CharacterHexaMatrixStatCore]

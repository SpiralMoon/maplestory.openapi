from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_hexamatrix_stat import CharacterHexaMatrixStatCore as BaseCharacterHexaMatrixStatCore
from maplestory_openapi.api.common.dto.character.character_hexamatrix_stat import CharacterHexaMatrixStat as BaseCharacterHexaMatrixStat


class CharacterHexaMatrixStatCore(BaseModel, BaseCharacterHexaMatrixStatCore):
    """
    Information for HEXA Stat Node

    Attributes:
        slot_id (str): Slot index
        main_stat_name (str): Main Stat name
        sub_stat_name_1 (str): First sub stat name
        sub_stat_name_2 (str): Second sub stat name
        main_stat_level (int): Main Stat level
        sub_stat_level_1 (int): First sub stat level
        sub_stat_level_2 (int): Second sub stat level
        stat_grade (int): Stat core level
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
    Character HEXA Matrix configured HEXA stats information

    Attributes:
        date (datetime or None): Reference date for query (SGT, daily data with hours and minutes set to 0)
        character_class (str or None): Character job
        character_hexa_stat_core (list[CharacterHexaMatrixStatCore]): Information for HEXA Stat Node I
        character_hexa_stat_core_2 (list[CharacterHexaMatrixStatCore]): Information for HEXA Stat Node II
        character_hexa_stat_core_3 (list[CharacterHexaMatrixStatCore]): Information for HEXA Stat Node III
        preset_hexa_stat_core (list[CharacterHexaMatrixStatCore]): Preset HEXA Stat Node I information
        preset_hexa_stat_core_2 (list[CharacterHexaMatrixStatCore]): Preset HEXA Stat Node II information
        preset_hexa_stat_core_3 (list[CharacterHexaMatrixStatCore]): Preset HEXA Stat Node III information
    """
    date: datetime | None
    character_class: str | None
    character_hexa_stat_core: list[CharacterHexaMatrixStatCore]
    character_hexa_stat_core_2: list[CharacterHexaMatrixStatCore]
    character_hexa_stat_core_3: list[CharacterHexaMatrixStatCore]
    preset_hexa_stat_core: list[CharacterHexaMatrixStatCore]
    preset_hexa_stat_core_2: list[CharacterHexaMatrixStatCore]
    preset_hexa_stat_core_3: list[CharacterHexaMatrixStatCore]

from datetime import datetime


class CharacterHexaMatrixStatCore:
    slot_id: str
    main_stat_name: str
    sub_stat_name_1: str
    sub_stat_name_2: str
    main_stat_level: int
    sub_stat_level_1: int
    sub_stat_level_2: int
    stat_grade: int


class CharacterHexaMatrixStat:
    date: datetime | None
    character_class: str
    character_hexa_stat_core: list[CharacterHexaMatrixStatCore] = []
    character_hexa_stat_core_2: list[CharacterHexaMatrixStatCore] = []
    character_hexa_stat_core_3: list[CharacterHexaMatrixStatCore] = []
    preset_hexa_stat_core: list[CharacterHexaMatrixStatCore] = []
    preset_hexa_stat_core_2: list[CharacterHexaMatrixStatCore] = []
    preset_hexa_stat_core_3: list[CharacterHexaMatrixStatCore] = []

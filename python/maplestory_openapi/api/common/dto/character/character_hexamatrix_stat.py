from datetime import datetime
from pydantic import model_validator


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
    character_class: str | None
    character_hexa_stat_core: list[CharacterHexaMatrixStatCore]
    character_hexa_stat_core_2: list[CharacterHexaMatrixStatCore]
    character_hexa_stat_core_3: list[CharacterHexaMatrixStatCore]
    preset_hexa_stat_core: list[CharacterHexaMatrixStatCore]
    preset_hexa_stat_core_2: list[CharacterHexaMatrixStatCore]
    preset_hexa_stat_core_3: list[CharacterHexaMatrixStatCore]

    @model_validator(mode="before")
    @classmethod
    def set_default(cls, values):
        if values.get("character_hexa_stat_core") is None:
            values["character_hexa_stat_core"] = []
        if values.get("character_hexa_stat_core_2") is None:
            values["character_hexa_stat_core_2"] = []
        if values.get("character_hexa_stat_core_3") is None:
            values["character_hexa_stat_core_3"] = []
        if values.get("preset_hexa_stat_core") is None:
            values["preset_hexa_stat_core"] = []
        if values.get("preset_hexa_stat_core_2") is None:
            values["preset_hexa_stat_core_2"] = []
        if values.get("preset_hexa_stat_core_3") is None:
            values["preset_hexa_stat_core_3"] = []
        return values

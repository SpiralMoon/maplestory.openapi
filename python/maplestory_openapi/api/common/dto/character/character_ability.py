from datetime import datetime


class CharacterAbilityInfo:
    ability_no: str
    ability_grade: str
    ability_value: str


class CharacterAbilityPreset:
    ability_preset_grade: str
    ability_info: list[CharacterAbilityInfo] = []


class CharacterAbility:
    date: datetime | None
    ability_grade: str
    ability_info: list[CharacterAbilityInfo] = []
    remain_fame: int
    preset_no: int | None
    ability_preset_1: CharacterAbilityPreset | None
    ability_preset_2: CharacterAbilityPreset | None
    ability_preset_3: CharacterAbilityPreset | None

from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_ability import CharacterAbilityInfo as BaseCharacterAbilityInfo
from maplestory_openapi.api.common.dto.character.character_ability import CharacterAbilityPreset as BaseCharacterAbilityPreset
from maplestory_openapi.api.common.dto.character.character_ability import CharacterAbility as BaseCharacterAbility


class CharacterAbilityInfo(BaseModel, BaseCharacterAbilityInfo):
    """
    Information for Ability Preset

    Attributes:
        ability_no (str): Ability number
        ability_grade (str): Ability grade
        ability_value (str): Ability option and value
    """
    ability_no: str
    ability_grade: str
    ability_value: str


class CharacterAbilityPreset(BaseModel, BaseCharacterAbilityPreset):
    """
    Character ability preset information

    Attributes:
        ability_preset_grade (str): Ability grade for Preset
        ability_info (list[CharacterAbilityInfo]): Information for Ability Preset
    """
    ability_preset_grade: str
    ability_info: list[CharacterAbilityInfo]


class CharacterAbility(BaseModel, BaseCharacterAbility):
    """
    Character ability information

    Attributes:
        date (datetime or None): Reference date for query (SGT, daily data with hours and minutes set to 0)
        ability_grade (str or None): Ability grade
        ability_info (list[CharacterAbilityInfo]): Ability information
        remain_fame (int or None): Owned Honor EXP
        preset_no (int or None): Active ability preset number
        ability_preset_1 (CharacterAbilityPreset or None): Complete information for Ability Preset 1
        ability_preset_2 (CharacterAbilityPreset or None): Complete information for Ability Preset 2
        ability_preset_3 (CharacterAbilityPreset or None): Complete information for Ability Preset 3
    """
    date: datetime | None | None
    ability_grade: str | None
    ability_info: list[CharacterAbilityInfo]
    remain_fame: int | None
    preset_no: int | None
    ability_preset_1: CharacterAbilityPreset | None
    ability_preset_2: CharacterAbilityPreset | None
    ability_preset_3: CharacterAbilityPreset | None

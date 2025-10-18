from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_ability import CharacterAbilityInfo as BaseCharacterAbilityInfo
from maplestory_openapi.api.common.dto.character.character_ability import CharacterAbilityPreset as BaseCharacterAbilityPreset
from maplestory_openapi.api.common.dto.character.character_ability import CharacterAbility as BaseCharacterAbility


class CharacterAbilityInfo(BaseModel, BaseCharacterAbilityInfo):
    """
    能力資訊

    Attributes:
        ability_no (str): 能力編號
        ability_grade (str): 能力階級
        ability_value (str): 能力選項與數值
    """
    ability_no: str
    ability_grade: str
    ability_value: str


class CharacterAbilityPreset(BaseModel, BaseCharacterAbilityPreset):
    """
    能力預設完整資訊

    Attributes:
        ability_preset_grade (str): 能力預設能力階級
        ability_info (list[CharacterAbilityInfo]): 能力預設資訊
    """
    ability_preset_grade: str
    ability_info: list[CharacterAbilityInfo]


class CharacterAbility(BaseModel, BaseCharacterAbility):
    """
    角色能力資訊

    Attributes:
        date (datetime or None): 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        ability_grade (str or None): 能力階級
        ability_info (list[CharacterAbilityInfo]): 能力資訊
        remain_fame (int or None): 名聲值
        preset_no (int or None): 目前套用的能力預設編號
        ability_preset_1 (CharacterAbilityPreset or None): 能力 1 預設完整資訊
        ability_preset_2 (CharacterAbilityPreset or None): 能力 2 預設完整資訊
        ability_preset_3 (CharacterAbilityPreset or None): 能力 3 預設完整資訊
    """
    date: datetime | None | None
    ability_grade: str | None
    ability_info: list[CharacterAbilityInfo]
    remain_fame: int | None
    preset_no: int | None
    ability_preset_1: CharacterAbilityPreset | None
    ability_preset_2: CharacterAbilityPreset | None
    ability_preset_3: CharacterAbilityPreset | None

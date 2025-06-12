from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_ability import CharacterAbilityInfo as BaseCharacterAbilityInfo
from maplestory_openapi.api.common.dto.character.character_ability import CharacterAbilityPreset as BaseCharacterAbilityPreset
from maplestory_openapi.api.common.dto.character.character_ability import CharacterAbility as BaseCharacterAbility


class CharacterAbilityInfo(BaseModel, BaseCharacterAbilityInfo):
    """
    캐릭터 어빌리티 상세 정보

    Attributes:
        ability_no (str): 어빌리티 번호
        ability_grade (str): 어빌리티 등급
        ability_value (str): 어빌리티 값
    """
    ability_no: str
    ability_grade: str
    ability_value: str


class CharacterAbilityPreset(BaseModel, BaseCharacterAbilityPreset):
    """
    캐릭터 어빌리티 프리셋 정보

    Attributes:
        ability_preset_grade (str): 프리셋의 어빌리티 등급
        ability_info (list[CharacterAbilityInfo]): 프리셋의 어빌리티 정보
    """
    ability_preset_grade: str
    ability_info: list[CharacterAbilityInfo]


class CharacterAbility(BaseModel, BaseCharacterAbility):
    """
    캐릭터 어빌리티 정보

    Attributes:
        date (datetime or None): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        ability_grade (str or None): 어빌리티 등급
        ability_info (list[CharacterAbilityInfo]): 어빌리티 정보
        remain_fame (int or None): 보유 명성치
        preset_no (int or None): 적용 중인 어빌리티 프리셋 번호
        ability_preset_1 (CharacterAbilityPreset or None): 어빌리티 1번 프리셋 전체 정보
        ability_preset_2 (CharacterAbilityPreset or None): 어빌리티 2번 프리셋 전체 정보
        ability_preset_3 (CharacterAbilityPreset or None): 어빌리티 3번 프리셋 전체 정보
    """
    date: datetime | None | None
    ability_grade: str | None
    ability_info: list[CharacterAbilityInfo]
    remain_fame: int | None
    preset_no: int | None
    ability_preset_1: CharacterAbilityPreset | None
    ability_preset_2: CharacterAbilityPreset | None
    ability_preset_3: CharacterAbilityPreset | None

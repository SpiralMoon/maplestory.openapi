from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_set_effect import CharacterSetEffectInfo as BaseCharacterSetEffectInfo
from maplestory_openapi.api.common.dto.character.character_set_effect import CharacterSetEffectOptionFull as BaseCharacterSetEffectOptionFull
from maplestory_openapi.api.common.dto.character.character_set_effect import CharacterSetEffectSet as BaseCharacterSetEffectSet
from maplestory_openapi.api.common.dto.character.character_set_effect import CharacterSetEffect as BaseCharacterSetEffect


class CharacterSetEffectInfo(BaseModel, BaseCharacterSetEffectInfo):
    """
    적용 중인 세트 효과 정보

    Attributes:
        set_count (int): 세트 효과 레벨 (장비 수)
        set_option (str): 세트 효과
    """
    set_count: int
    set_option: str


class CharacterSetEffectOptionFull(BaseModel, BaseCharacterSetEffectOptionFull):
    """
    모든 세트 효과 정보

    Attributes:
        set_count (int): 세트 효과 레벨 (장비 수)
        set_option (str): 세트 효과
    """
    set_count: int
    set_option: str


class CharacterSetEffectSet(BaseModel, BaseCharacterSetEffectSet):
    """
    세트 효과 정보

    Attributes:
        set_name (str): 세트 효과 명
        total_set_count (int): 세트 개수 (럭키 아이템 포함)
        set_effect_info (list[CharacterSetEffectInfo]): 적용 중인 세트 효과 정보
        set_option_full (list[CharacterSetEffectOptionFull]): 모든 세트 효과 정보
    """
    set_name: str
    total_set_count: int
    set_effect_info: list[CharacterSetEffectInfo]
    set_option_full: list[CharacterSetEffectOptionFull]


class CharacterSetEffect(BaseModel, BaseCharacterSetEffect):
    """
    캐릭터 세트 효과 정보

    Attributes:
        date (datetime or None): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        set_effect (list[CharacterSetEffectSet]): 세트 효과 정보
    """
    date: datetime | None
    set_effect: list[CharacterSetEffectSet]

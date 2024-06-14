from datetime import datetime
from pydantic import BaseModel


class CharacterSetEffectInfo(BaseModel):
    """적용 중인 세트 효과 정보

    set_count(int): 세트 효과 레벨 (장비 수)
    set_option(str): 세트 효과
    """
    set_count: int
    set_option: str


class CharacterSetEffectOptionFull(BaseModel):
    """모든 세트 효과 정보

    set_count(int): 세트 효과 레벨 (장비 수)
    set_option(str): 세트 효과
    """
    set_count: int
    set_option: str


class CharacterSetEffectSet(BaseModel):
    """세트 효과 정보

    set_name(str): 세트 효과 명
    total_set_count(int): 세트 개수 (럭키 아이템 포함)
    set_effect_info(list[CharacterSetEffectInfo]): 적용 중인 세트 효과 정보
    set_effect_full_info(list[CharacterSetEffectFullInfo]): 모든 세트 효과 정보
    """
    set_name: str
    total_set_count: int
    set_effect_info: list[CharacterSetEffectInfo]
    set_option_full: list[CharacterSetEffectOptionFull]


class CharacterSetEffect(BaseModel):
    """캐릭터 세트 효과 정보

    date(datetime): 조회 기준일
    set_effect(list[CharacterSetEffectSet]): 세트 효과 정보
    """
    date: datetime | None
    set_effect: list[CharacterSetEffectSet]

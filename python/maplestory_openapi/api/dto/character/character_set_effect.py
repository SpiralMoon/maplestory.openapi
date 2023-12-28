from datetime import datetime
from pydantic import BaseModel


class CharacterSetEffectOptionInfo(BaseModel):
    """캐릭터 세트효과 옵션 정보

    set_count(str): 세트 효과 레벨 (장비 수)
    set_option(str): 적용 중인 세트 효과
    """
    set_count: int
    set_option: str


class CharacterSetEffectInfo(BaseModel):
    """캐릭터 세트 효과 정보

    set_name(str): 세트 효과 명
    total_set_count(int): 세트 개수 (럭키 아이템 포함)
    set_effect_info(list[CharacterSetEffectOptionInfoDto]): 세트 효과 옵션
    """
    set_name: str
    total_set_count: int
    set_effect_info: list[CharacterSetEffectOptionInfo]


class CharacterSetEffect(BaseModel):
    """캐릭터 세트효과 정보

    date(datetime): 조회 기준일
    set_effect(list[CharacterSetEffectInfoDto]): 세트 효과 정보
    """
    date: datetime
    set_effect: list[CharacterSetEffectInfo]

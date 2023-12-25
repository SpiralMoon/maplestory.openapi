from datetime import datetime
from pydantic import BaseModel


class CharacterAbilityInfo(BaseModel):
    """캐릭터 어빌리티 상세 정보

    ability_no(str): 어빌리티 번호
    ability_grade(str): 어빌리티 등급
    ability_value(str): 어빌리티 값
    """
    ability_no: str
    ability_grade: str
    ability_value: str


class CharacterAbility(BaseModel):
    """캐릭터 어빌리티 정보

    date(datetime): 조회 기준일
    ability_grade(str): 어빌리티 등급
    ability_info(list[CharacterAbilityInfo]): 어빌리티 정보
    remain_fame(int): 보유 명성치
    """
    date: datetime
    ability_grade: str
    ability_info: list[CharacterAbilityInfo]
    remain_fame: int

from datetime import datetime
from pydantic import BaseModel


class CharacterAbilityInfo(BaseModel):
    ability_no: str
    ability_grade: str
    ability_value: str


class CharacterAbility(BaseModel):
    date: datetime
    ability_grade: str
    ability_info: list[CharacterAbilityInfo]
    remain_fame: int

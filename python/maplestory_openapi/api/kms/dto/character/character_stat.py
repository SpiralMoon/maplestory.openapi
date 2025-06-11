from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_stat import CharacterStatInfo as BaseCharacterStatInfo
from maplestory_openapi.api.common.dto.character.character_stat import CharacterStat as BaseCharacterStat


class CharacterStatInfo(BaseModel, BaseCharacterStatInfo):
    """
    캐릭터 스탯 상세 정보

    Attributes:
        stat_name (str): 스탯 이름
        stat_value (str): 스탯 값
    """
    stat_name: str
    stat_value: str


class CharacterStat(BaseModel, BaseCharacterStat):
    """
    캐릭터 스탯 정보

    Attributes:
        date (datetime or None): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        character_class (str or None): 직업
        final_stat (list[CharacterStatInfo]): 현재 스탯 정보
        remain_ap (int or None): 잔여 AP
    """
    date: datetime | None
    character_class: str | None
    final_stat: list[CharacterStatInfo]
    remain_ap: int | None

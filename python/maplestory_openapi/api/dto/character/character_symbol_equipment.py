from datetime import datetime
from pydantic import BaseModel


class CharacterSymbolEquipmentInfo(BaseModel):
    """캐릭터 심볼 장비 상세 정보

    symbol_name(str): 심볼 이름
    symbol_icon(str): 심볼 아이콘
    symbol_description(str): 심볼 설명
    symbol_force(str): 심볼 포스 증가 수치
    symbol_level(int): 심볼 레벨
    symbol_str(str): 심볼 STR
    symbol_dex(str): 심볼 DEX
    symbol_int(str): 심볼 INT
    symbol_luk(str): 심볼 LUK
    symbol_hp(str): 심볼 HP
    symbol_growth_count(int): 심볼 보유 성장치
    symbol_require_growth_count(int): 심볼 레벨업 시 필요 성장치
    """
    symbol_name: str
    symbol_icon: str
    symbol_description: str
    symbol_force: str
    symbol_level: int
    symbol_str: str
    symbol_dex: str
    symbol_int: str
    symbol_luk: str
    symbol_hp: str
    symbol_growth_count: int
    symbol_require_growth_count: int


class CharacterSymbolEquipment(BaseModel):
    """캐릭터 심볼 장비 정보

    date(datetime): 조회 기준일
    character_class(str): 직업
    symbol(list[CharacterSymbolEquipmentInfo]): 심볼 장비 정보
    """
    date: datetime | None
    character_class: str
    symbol: list[CharacterSymbolEquipmentInfo]

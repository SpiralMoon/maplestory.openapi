from datetime import datetime
from pydantic import BaseModel


class CharacterRingExchangeSkillEquipment(BaseModel):
    """
    캐릭터 링 익스체인지 스킬 등록 장비 정보

    Attributes:
        date (datetime or None): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        character_class (str or None): 캐릭터 직업
        special_ring_exchange_name (str or None): 링 익스체인지에 등록된 특수 반지
        special_ring_exchange_level (int or None): 링 익스체인지에 등록된 특수 반지 레벨
        special_ring_exchange_icon (str or None): 링 익스체인지에 등록된 특수 반지 아이콘
        special_ring_exchange_description (str or None): 링 익스체인지에 등록된 특수 반지 설명
    """
    date: datetime | None
    character_class: str
    special_ring_exchange_name: str | None
    special_ring_exchange_level: int | None
    special_ring_exchange_icon: str | None
    special_ring_exchange_description: str | None

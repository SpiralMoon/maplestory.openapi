from datetime import datetime
from pydantic import BaseModel


class CharacterRingReserveSkillEquipment(BaseModel):
    """
    캐릭터 예비 특수 반지 장착 정보

    Attributes:
        date (datetime or None): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        character_class (str): 캐릭터 직업
        special_ring_reserve_name (str or None): 예비 특수 반지 슬롯에 장착한 특수 반지
        special_ring_reserve_level (int or None): 예비 특수 반지 슬롯에 장착한 특수 반지 레벨
        special_ring_reserve_icon (str or None): 예비 특수 반지 슬롯에 장착한 특수 반지 아이콘
        special_ring_reserve_description (str or None): 예비 특수 반지 슬롯에 장착한 특수 반지 설명
    """
    date: datetime | None
    character_class: str
    special_ring_reserve_name: str | None
    special_ring_reserve_level: int | None
    special_ring_reserve_icon: str | None
    special_ring_reserve_description: str | None

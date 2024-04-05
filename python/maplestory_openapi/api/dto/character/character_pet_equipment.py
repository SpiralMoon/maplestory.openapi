from datetime import datetime
from pydantic import BaseModel


class CharacterPetEquipmentAutoSkill(BaseModel):
    """캐릭터 펫 버프 자동스킬 정보

    skill_1(str): 첫 번째 슬롯에 등록된 자동 스킬
    skill_1_icon(str): 첫 번째 슬롯에 등록된 자동 스킬 아이콘
    skill_2(str): 두 번째 슬롯에 등록된 자동 스킬
    skill_2_icon(str): 두 번째 슬롯에 등록된 자동 스킬 아이콘
    """
    skill_1: str | None
    skill_1_icon: str | None
    skill_2: str | None
    skill_2_icon: str | None


class CharacterPetEquipmentItemOption(BaseModel):
    """캐릭터 펫 장비 아이템 옵션

    option_type(str): 옵션 타입
    option_value(str): 옵션 값
    """
    option_type: str
    option_value: str


class CharacterPetEquipmentItem(BaseModel):
    """캐릭터 펫 장착 정보

    item_name(str): 아이템 명
    item_icon(str): 아이템 아이콘
    item_description(str): 아이템 설명
    item_option(list[CharacterPetEquipmentItemOption]): 아이템 표기상 옵션
    scroll_upgrade(int): 업그레이드 횟수
    scroll_upgradable(int): 업그레이드 가능 횟수
    item_shape(str): 아이템 외형
    item_shape_icon(str): 아이템 외형 아이콘
    """
    item_name: str | None
    item_icon: str | None
    item_description: str | None
    item_option: list[CharacterPetEquipmentItemOption]
    scroll_upgrade: int
    scroll_upgradable: int
    item_shape: str | None
    item_shape_icon: str | None


class CharacterPetEquipment(BaseModel):
    """캐릭터 펫 장비 정보

    date(datetime): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
    pet_1_name(str): 펫1 명
    pet_1_nickname(str): 펫1 닉네임
    pet_1_icon(str): 펫1 아이콘
    pet_1_description(str): 펫1 설명
    pet_1_equipment(CharacterPetEquipmentItem): 펫1 장착 정보
    pet_1_auto_skill(CharacterPetEquipmentAutoSkill): 펫1 펫 버프 자동스킬 정보
    pet_1_pet_type(str): 펫1 원더 펫 종류
    pet_1_skill(list[str]): 펫1 펫 보유 스킬
    pet_1_date_expire(datetime): 펫1 마법의 시간 (KST)
    pet_1_appearance(str): 펫1 외형
    pet_1_appearance_icon(str): 펫1 외형 아이콘

    pet_2_name(str): 펫2 명
    pet_2_nickname(str): 펫2 닉네임
    pet_2_icon(str): 펫2 아이콘
    pet_2_description(str): 펫2 설명
    pet_2_equipment(CharacterPetEquipmentItem): 펫2 장착 정보
    pet_2_auto_skill(CharacterPetEquipmentAutoSkill): 펫2 펫 버프 자동스킬 정보
    pet_2_pet_type(str): 펫2 원더 펫 종류
    pet_2_skill(list[str]): 펫2 펫 보유 스킬
    pet_2_date_expire(datetime): 펫2 마법의 시간 (KST)
    pet_2_appearance(str): 펫2 외형
    pet_2_appearance_icon(str): 펫2 외형 아이콘

    pet_3_name(str): 펫3 명
    pet_3_nickname(str): 펫3 닉네임
    pet_3_icon(str): 펫3 아이콘
    pet_3_description(str): 펫3 설명
    pet_3_equipment(CharacterPetEquipmentItem): 펫3 장착 정보
    pet_3_auto_skill(CharacterPetEquipmentAutoSkill): 펫3 펫 버프 자동스킬 정보
    pet_3_pet_type(str): 펫3 원더 펫 종류
    pet_3_skill(list[str]): 펫3 펫 보유 스킬
    pet_3_date_expire(datetime): 펫3 마법의 시간 (KST)
    pet_3_appearance(str): 펫3 외형
    pet_3_appearance_icon(str): 펫3 외형 아이콘
    """
    date: datetime | None
    pet_1_name: str | None
    pet_1_nickname: str | None
    pet_1_icon: str | None
    pet_1_description: str | None
    pet_1_equipment: CharacterPetEquipmentItem | None
    pet_1_auto_skill: CharacterPetEquipmentAutoSkill | None
    pet_1_pet_type: str | None
    pet_1_skill: list[str]
    pet_1_date_expire: datetime | None
    pet_1_appearance: str | None
    pet_1_appearance_icon: str | None
    pet_2_name: str | None
    pet_2_nickname: str | None
    pet_2_icon: str | None
    pet_2_description: str | None
    pet_2_equipment: CharacterPetEquipmentItem | None
    pet_2_auto_skill: CharacterPetEquipmentAutoSkill | None
    pet_2_pet_type: str | None
    pet_2_skill: list[str]
    pet_2_date_expire: datetime | None
    pet_2_appearance: str | None
    pet_2_appearance_icon: str | None
    pet_3_name: str | None
    pet_3_nickname: str | None
    pet_3_icon: str | None
    pet_3_description: str | None
    pet_3_equipment: CharacterPetEquipmentItem | None
    pet_3_auto_skill: CharacterPetEquipmentAutoSkill | None
    pet_3_pet_type: str | None
    pet_3_skill: list[str]
    pet_3_date_expire: datetime | None
    pet_3_appearance: str | None
    pet_3_appearance_icon: str | None

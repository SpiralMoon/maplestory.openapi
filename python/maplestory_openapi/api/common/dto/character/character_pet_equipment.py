from datetime import datetime
from pydantic import model_validator


class CharacterPetEquipmentAutoSkill:
    skill_1: str | None
    skill_1_icon: str | None
    skill_2: str | None
    skill_2_icon: str | None


class CharacterPetEquipmentItemOption:
    option_type: str
    option_value: str


class CharacterPetEquipmentItem:
    item_name: str | None
    item_icon: str | None
    item_description: str | None
    item_option: list[CharacterPetEquipmentItemOption]
    scroll_upgrade: int
    scroll_upgradable: int
    item_shape: str | None
    item_shape_icon: str | None


class CharacterPetEquipment:
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
    pet_1_expired: bool | None
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
    pet_2_expired: bool | None
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
    pet_3_expired: bool | None
    pet_3_appearance: str | None
    pet_3_appearance_icon: str | None

from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_pet_equipment import CharacterPetEquipmentAutoSkill as BaseCharacterPetEquipmentAutoSkill
from maplestory_openapi.api.common.dto.character.character_pet_equipment import CharacterPetEquipmentItemOption as BaseCharacterPetEquipmentItemOption
from maplestory_openapi.api.common.dto.character.character_pet_equipment import CharacterPetEquipmentItem as BaseCharacterPetEquipmentItem
from maplestory_openapi.api.common.dto.character.character_pet_equipment import CharacterPetEquipment as BaseCharacterPetEquipment


class CharacterPetEquipmentAutoSkill(BaseModel, BaseCharacterPetEquipmentAutoSkill):
    """
    Auto buff skill information for pet

    Attributes:
        skill_1 (str or None): Auto skill registered in the first slot
        skill_1_icon (str or None): Icon for the auto skill in the first slot
        skill_2 (str or None): Auto skill registered in the second slot
        skill_2_icon (str or None): Icon for the auto skill in the second slot
    """
    skill_1: str | None
    skill_1_icon: str | None
    skill_2: str | None
    skill_2_icon: str | None


class CharacterPetEquipmentItemOption(BaseModel, BaseCharacterPetEquipmentItemOption):
    """
    Displayed pet item options

    Attributes:
        option_type (str): Option type
        option_value (str): Option value
    """
    option_type: str
    option_value: str


class CharacterPetEquipmentItem(BaseModel, BaseCharacterPetEquipmentItem):
    """
    Equipment information for pet

    Attributes:
        item_name (str or None): Item name
        item_icon (str or None): Item icon
        item_description (str or None): Item description
        item_option (list[CharacterPetEquipmentItemOption]): Displayed item options
        scroll_upgrade (int): Number of upgrades
        scroll_upgradable (int): Number of upgrades available
        item_shape (str or None): Item appearance
        item_shape_icon (str or None): Item appearance icon
    """
    item_name: str | None
    item_icon: str | None
    item_description: str | None
    item_option: list[CharacterPetEquipmentItemOption]
    scroll_upgrade: int
    scroll_upgradable: int
    item_shape: str | None
    item_shape_icon: str | None


class CharacterPetEquipment(BaseModel, BaseCharacterPetEquipment):
    """
   Character equipped pet information

    Attributes:
        date (datetime or None): Reference date for query (SGT, daily data with hours and minutes set to 0)
        pet_1_name (str or None): Name of pet 1
        pet_1_nickname (str or None): Nickname of pet 1
        pet_1_icon (str or None): Icon of pet 1
        pet_1_description (str or None): Description of pet 1
        pet_1_equipment (CharacterPetEquipmentItem or None): Equipment information for pet 1
        pet_1_auto_skill (CharacterPetEquipmentAutoSkill or None): Auto buff skill information for pet 1
        pet_1_pet_type (str or None): Wonder pet type of pet 1
        pet_1_skill (list[str]): Skills possessed by pet 1
        pet_1_date_expire (datetime or None): Magic time for pet 1 (SGT, data with minutes set to 0)
        pet_1_expired (bool or None): Whether the magic time for pet 1 is expired
        pet_1_appearance (str or None): Appearance of pet 1
        pet_1_appearance_icon (str or None): Appearance icon of pet 1
        pet_2_name (str or None): Name of pet 2
        pet_2_nickname (str or None): Nickname of pet 2
        pet_2_icon (str or None): Icon of pet 2
        pet_2_description (str or None): Description of pet 2
        pet_2_equipment (CharacterPetEquipmentItem or None): Equipment information for pet 2
        pet_2_auto_skill (CharacterPetEquipmentAutoSkill or None): Auto buff skill information for pet 2
        pet_2_pet_type (str or None): Wonder pet type of pet 2
        pet_2_skill (list[str]): Skills possessed by pet 2
        pet_2_date_expire (datetime or None): Magic time for pet 2 (SGT, data with hours and minutes set to 0)
        pet_2_expired (bool or None): Whether the magic time for pet 2 is expired
        pet_2_appearance (str or None): Appearance of pet 2
        pet_2_appearance_icon (str or None): Appearance icon of pet 2
        pet_3_name (str or None): Name of pet 3
        pet_3_nickname (str or None): Nickname of pet 3
        pet_3_icon (str or None): Icon of pet 3
        pet_3_description (str or None): Description of pet 3
        pet_3_equipment (CharacterPetEquipmentItem or None): Equipment information for pet 3
        pet_3_auto_skill (CharacterPetEquipmentAutoSkill or None): Auto buff skill information for pet 3
        pet_3_pet_type (str or None): Wonder pet type of pet 3
        pet_3_skill (list[str]): Skills possessed by pet 3
        pet_3_date_expire (datetime or None): Magic time for pet 3 (SGT, data with hours and minutes set to 0)
        pet_3_expired (bool or None): Whether the magic time for pet 3 is expired
        pet_3_appearance (str or None): Appearance of pet 3
        pet_3_appearance_icon (str or None): Appearance icon of pet 3
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
    pet_1_expired: bool = False
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
    pet_2_expired: bool = False
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
    pet_3_expired: bool = False
    pet_3_appearance: str | None
    pet_3_appearance_icon: str | None

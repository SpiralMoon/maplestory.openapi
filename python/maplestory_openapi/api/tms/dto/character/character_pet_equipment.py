from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_pet_equipment import CharacterPetEquipmentAutoSkill as BaseCharacterPetEquipmentAutoSkill
from maplestory_openapi.api.common.dto.character.character_pet_equipment import CharacterPetEquipmentItemOption as BaseCharacterPetEquipmentItemOption
from maplestory_openapi.api.common.dto.character.character_pet_equipment import CharacterPetEquipmentItem as BaseCharacterPetEquipmentItem
from maplestory_openapi.api.common.dto.character.character_pet_equipment import CharacterPetEquipment as BaseCharacterPetEquipment


class CharacterPetEquipmentAutoSkill(BaseModel, BaseCharacterPetEquipmentAutoSkill):
    """
    寵物的寵物自動加持技能資訊

    Attributes:
        skill_1 (str or None): 登錄於第一欄位的自動加持技能
        skill_1_icon (str or None): 登錄於第一欄位的自動加持技能圖示
        skill_2 (str or None): 登錄於第二欄位的自動加持技能
        skill_2_icon (str or None): 登錄於第二欄位的自動加持技能圖示
    """
    skill_1: str | None
    skill_1_icon: str | None
    skill_2: str | None
    skill_2_icon: str | None


class CharacterPetEquipmentItemOption(BaseModel, BaseCharacterPetEquipmentItemOption):
    """
    道具顯示選項

    Attributes:
        option_type (str): 選項類型
        option_value (str): 選項數值
    """
    option_type: str
    option_value: str


class CharacterPetEquipmentItem(BaseModel, BaseCharacterPetEquipmentItem):
    """
    寵物道具資訊

    Attributes:
        item_name (str or None): 道具名稱
        item_icon (str or None): 道具圖示
        item_description (str or None): 道具描述
        item_option (list[CharacterPetEquipmentItemOption]): 道具顯示選項
        scroll_upgrade (int): 強化次數
        scroll_upgradable (int): 道具可升級次數
        item_shape (str or None): 道具外型
        item_shape_icon (str or None): 道具外型圖示
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
   角色已裝備寵物資訊

    Attributes:
        date (datetime or None): 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        pet_1_name (str or None): 寵物 1 名稱
        pet_1_nickname (str or None): 寵物 1 暱稱
        pet_1_icon (str or None): 寵物 1 圖示
        pet_1_description (str or None): 寵物 1 描述
        pet_1_equipment (CharacterPetEquipmentItem or None): 寵物 1 道具資訊
        pet_1_auto_skill (CharacterPetEquipmentAutoSkill or None): 寵物 1 的寵物自動加持技能資訊
        pet_1_pet_type (str or None): 寵物 1 神奇寵物類型
        pet_1_skill (list[str]): 寵物 1 技能
        pet_1_date_expire (datetime or None): 寵物 1 魔法時間 (TST，時間單位資料中的分鐘顯示為 0)
        pet_1_expired (bool or None): Whether the magic time for pet 1 is expired
        pet_1_appearance (str or None): 寵物 1 外型
        pet_1_appearance_icon (str or None): 寵物 1 外型圖示
        pet_2_name (str or None): 寵物 2 名稱
        pet_2_nickname (str or None): 寵物 2 暱稱
        pet_2_icon (str or None): 寵物 2 圖示
        pet_2_description (str or None): 寵物 2 描述
        pet_2_equipment (CharacterPetEquipmentItem or None): 寵物 2 道具資訊
        pet_2_auto_skill (CharacterPetEquipmentAutoSkill or None): 寵物 2 的寵物自動加持技能資訊
        pet_2_pet_type (str or None): 寵物 2 神奇寵物類型
        pet_2_skill (list[str]): 寵物 2 技能
        pet_2_date_expire (datetime or None): 寵物 2 魔法時間 (TST，時間單位資料中的分鐘顯示為 0)
        pet_2_expired (bool or None): Whether the magic time for pet 2 is expired
        pet_2_appearance (str or None): 寵物 2 外型
        pet_2_appearance_icon (str or None): 寵物 2 外型圖示
        pet_3_name (str or None): 寵物 3 名稱
        pet_3_nickname (str or None): 寵物 3 暱稱
        pet_3_icon (str or None): 寵物 3 圖示
        pet_3_description (str or None): 寵物 3 描述
        pet_3_equipment (CharacterPetEquipmentItem or None): 寵物 3 道具資訊
        pet_3_auto_skill (CharacterPetEquipmentAutoSkill or None): 寵物 3 的寵物自動加持技能資訊
        pet_3_pet_type (str or None): 寵物 3 神奇寵物類型
        pet_3_skill (list[str]): 寵物 3 技能
        pet_3_date_expire (datetime or None): 寵物 3 魔法時間 (TST，時間單位資料中的分鐘顯示為 0)
        pet_3_expired (bool or None): Whether the magic time for pet 3 is expired
        pet_3_appearance (str or None): 寵物 3 外型
        pet_3_appearance_icon (str or None): 寵物 3 外型圖示
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

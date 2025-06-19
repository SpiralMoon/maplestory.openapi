from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_android_equipment import CharacterAndroidEquipmentHair as BaseCharacterAndroidEquipmentHair
from maplestory_openapi.api.common.dto.character.character_android_equipment import CharacterAndroidEquipmentFace as BaseCharacterAndroidEquipmentFace
from maplestory_openapi.api.common.dto.character.character_android_equipment import CharacterAndroidEquipmentSkin as BaseCharacterAndroidEquipmentSkin
from maplestory_openapi.api.common.dto.character.character_android_equipment import CharacterAndroidEquipmentPreset as BaseCharacterAndroidEquipmentPreset
from maplestory_openapi.api.common.dto.character.character_android_equipment import CharacterAndroidCashItemEquipmentColoringPrism as BaseCharacterAndroidCashItemEquipmentColoringPrism
from maplestory_openapi.api.common.dto.character.character_android_equipment import CharacterAndroidCashItemEquipmentOption as BaseCharacterAndroidCashItemEquipmentOption
from maplestory_openapi.api.common.dto.character.character_android_equipment import CharacterAndroidCashItemEquipment as BaseCharacterAndroidCashItemEquipment
from maplestory_openapi.api.common.dto.character.character_android_equipment import CharacterAndroidEquipment as BaseCharacterAndroidEquipment


class CharacterAndroidEquipmentHair(BaseModel, BaseCharacterAndroidEquipmentHair):
    """
    Android hair information

    Attributes:
        hair_name (str or None): Android hair name
        base_color (str or None): Android hair base color
        mix_color (str or None): Android hair mix color
        mix_rate (str): Hair mix color dyeing rate
    """
    hair_name: str | None
    base_color: str | None
    mix_color: str | None
    mix_rate: str


class CharacterAndroidEquipmentFace(BaseModel, BaseCharacterAndroidEquipmentFace):
    """
    Android face information

    Attributes:
        face_name (str or None): Android face name
        base_color (str or None): Android face base color
        mix_color (str or None): Android face mix color
        mix_rate (str): Face mix color dyeing rate
    """
    face_name: str | None
    base_color: str | None
    mix_color: str | None
    mix_rate: str


class CharacterAndroidEquipmentSkin(BaseModel, BaseCharacterAndroidEquipmentSkin):
    """
    Android skin information

    Attributes:
        skin_name (str): Skin name
        color_style (str or None): Skin tone
        hue (int or None): Skin hue
        saturation (int or None): Skin saturation
        brightness (int or None): Skin brightness
    """
    skin_name: str
    color_style: str | None
    hue: int | None
    saturation: int | None
    brightness: int | None


class CharacterAndroidEquipmentPreset(BaseModel, BaseCharacterAndroidEquipmentPreset):
    """
    Android preset information

    Attributes:
        android_name (str): Android name
        android_nickname (str): Android nickname
        android_icon (str): Android icon
        android_description (str): Android item description
        android_gender (str or None): Android gender
        android_grade (str): Android grade
        android_hair (CharacterAndroidEquipmentHair): Android hair information
        android_face (CharacterAndroidEquipmentFace): Android face information
        android_skin (CharacterAndroidEquipmentSkin or None): Android skin information
        android_ear_sensor_clip_flag (str): Android ear sensor clip usage flag
        android_non_humanoid_flag (str): Non-humanoid android flag
        android_shop_usable_flag (str): Shop usage flag
    """
    android_name: str
    android_nickname: str
    android_icon: str
    android_description: str
    android_gender: str | None
    android_grade: str
    android_hair: CharacterAndroidEquipmentHair
    android_face: CharacterAndroidEquipmentFace
    android_skin: CharacterAndroidEquipmentSkin | None
    android_ear_sensor_clip_flag: str
    android_non_humanoid_flag: str
    android_shop_usable_flag: str


class CharacterAndroidCashItemEquipmentColoringPrism(BaseModel, BaseCharacterAndroidCashItemEquipmentColoringPrism):
    """
    Android cash item coloring prism information

    Attributes:
        color_range (str): Coloring prism color range
        hue (int): Coloring prism hue
        saturation (int): Coloring prism saturation
        value (int): Coloring prism brightness
    """
    color_range: str
    hue: int
    saturation: int
    value: int


class CharacterAndroidCashItemEquipmentOption(BaseModel, BaseCharacterAndroidCashItemEquipmentOption):
    """
    Android cash item options

    Attributes:
        option_type (str): Option type
        option_value (str): Option value
    """
    option_type: str
    option_value: str


class CharacterAndroidCashItemEquipment(BaseModel, BaseCharacterAndroidCashItemEquipment):
    """
    Android cash item equipment information

    Attributes:
        cash_item_equipment_part (str): Cash item part name
        cash_item_equipment_slot (str): Cash item slot
        cash_item_name (str): Cash item name
        cash_item_icon (str): Cash item icon
        cash_item_description (str or None): Cash item description
        cash_item_option (list[CharacterAndroidCashItemEquipmentOption]): Cash item options
        date_expire (datetime or None): Cash item expiration date (SGT)
        is_expired (bool): Cash item expiration status
        date_option_expire (datetime or None): Cash item option expiration date (SGT)
        is_option_expired (bool): Cash item option expiration status
        cash_item_label (str or None): Cash item label
        cash_item_coloring_prism (CharacterAndroidCashItemEquipmentColoringPrism or None): Coloring prism information
        android_item_gender (str or None): Gender compatibility for item equipment
    """
    cash_item_equipment_part: str
    cash_item_equipment_slot: str
    cash_item_name: str
    cash_item_icon: str
    cash_item_description: str | None
    cash_item_option: list[CharacterAndroidCashItemEquipmentOption]
    date_expire: datetime | None
    is_expired: bool = False
    date_option_expire: datetime | None
    is_option_expired: bool = False
    cash_item_label: str | None
    cash_item_coloring_prism: CharacterAndroidCashItemEquipmentColoringPrism | None
    android_item_gender: str | None


class CharacterAndroidEquipment(BaseModel, BaseCharacterAndroidEquipment):
    """
    Character android equipment information

    Attributes:
        date (datetime or None): Reference date for query (SGT)
        android_name (str or None): Android name
        android_nickname (str or None): Android nickname
        android_icon (str or None): Android icon
        android_description (str or None): Android item description
        android_hair (CharacterAndroidEquipmentHair or None): Android hair information
        android_face (CharacterAndroidEquipmentFace or None): Android face information
        android_skin (CharacterAndroidEquipmentSkin or None): Android skin information
        android_cash_item_equipment (list[CharacterAndroidCashItemEquipment]): Cash item equipment
        android_ear_sensor_clip_flag (str or None): Ear sensor clip usage flag
        android_gender (str or None): Android gender
        android_grade (str or None): Android grade
        android_non_humanoid_flag (str or None): Non-humanoid flag
        android_shop_usable_flag (str or None): Shop usage flag
        preset_no (int or None): Equipped preset number
        android_preset_1 (CharacterAndroidEquipmentPreset or None): Preset 1
        android_preset_2 (CharacterAndroidEquipmentPreset or None): Preset 2
        android_preset_3 (CharacterAndroidEquipmentPreset or None): Preset 3
    """
    date: datetime | None
    android_name: str | None
    android_nickname: str | None
    android_icon: str | None
    android_description: str | None
    android_hair: CharacterAndroidEquipmentHair | None
    android_face: CharacterAndroidEquipmentFace | None
    android_skin: CharacterAndroidEquipmentSkin | None
    android_cash_item_equipment: list[CharacterAndroidCashItemEquipment]
    android_ear_sensor_clip_flag: str | None
    android_gender: str | None
    android_grade: str | None
    android_non_humanoid_flag: str | None
    android_shop_usable_flag: str | None
    preset_no: int | None
    android_preset_1: CharacterAndroidEquipmentPreset | None
    android_preset_2: CharacterAndroidEquipmentPreset | None
    android_preset_3: CharacterAndroidEquipmentPreset | None

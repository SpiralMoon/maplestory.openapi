from datetime import datetime
from pydantic import model_validator


class CharacterAndroidEquipmentHair:
    hair_name: str | None
    base_color: str | None
    mix_color: str | None
    mix_rate: str


class CharacterAndroidEquipmentFace:
    face_name: str | None
    base_color: str | None
    mix_color: str | None
    mix_rate: str


class CharacterAndroidEquipmentSkin:
    skin_name: str
    color_style: str | None
    hue: int | None
    saturation: int | None
    brightness: int | None


class CharacterAndroidEquipmentPreset:
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


class CharacterAndroidCashItemEquipmentColoringPrism:
    color_range: str
    hue: int
    saturation: int
    value: int


class CharacterAndroidCashItemEquipmentOption:
    option_type: str
    option_value: str


class CharacterAndroidCashItemEquipment:
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

    @model_validator(mode="before")
    @classmethod
    def set_default(cls, values):
        if values.get("date_expire") == 'expired':
            values["is_expired"] = True
            values["date_expire"] = None
        if values.get("date_option_expire") == 'expired':
            values["is_option_expired"] = True
            values["date_option_expire"] = None
        return values


class CharacterAndroidEquipment:
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

from datetime import datetime


class CharacterBeautyEquipmentHair:
    hair_name: str
    base_color: str
    mix_color: str | None
    mix_rate: str


class CharacterBeautyEquipmentFace:
    face_name: str
    base_color: str
    mix_color: str | None
    mix_rate: str


class CharacterBeautyEquipmentSkin:
    skin_name: str
    color_style: str | None
    hue: int | None
    saturation: int | None
    brightness: int | None


class CharacterBeautyEquipment:
    date: datetime | None
    character_gender: str | None
    character_class: str | None
    character_hair: CharacterBeautyEquipmentHair | None
    character_face: CharacterBeautyEquipmentFace | None
    character_skin: CharacterBeautyEquipmentSkin | None
    additional_character_hair: CharacterBeautyEquipmentHair | None
    additional_character_face: CharacterBeautyEquipmentFace | None
    additional_character_skin: CharacterBeautyEquipmentSkin | None

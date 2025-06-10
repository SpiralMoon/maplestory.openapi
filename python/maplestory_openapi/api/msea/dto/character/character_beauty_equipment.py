from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_beauty_equipment import CharacterBeautyEquipmentHair as BaseCharacterBeautyEquipmentHair
from maplestory_openapi.api.common.dto.character.character_beauty_equipment import CharacterBeautyEquipmentFace as BaseCharacterBeautyEquipmentFace
from maplestory_openapi.api.common.dto.character.character_beauty_equipment import CharacterBeautyEquipmentSkin as BaseCharacterBeautyEquipmentSkin
from maplestory_openapi.api.common.dto.character.character_beauty_equipment import CharacterBeautyEquipment as BaseCharacterBeautyEquipment


class CharacterBeautyEquipmentHair(BaseModel, BaseCharacterBeautyEquipmentHair):
    """
    Character hair information

    Attributes:
        hair_name (str): Hair name
        base_color (str): Base hair color
        mix_color (str or None): Mixed hair color
        mix_rate (str): Dye ratio for mixed hair color
    """
    hair_name: str
    base_color: str
    mix_color: str | None
    mix_rate: str


class CharacterBeautyEquipmentFace(BaseModel, BaseCharacterBeautyEquipmentFace):
    """
    Character face information

    Attributes:
        face_name (str): Face name
        base_color (str): Base face color
        mix_color (str or None): Mixed face color
        mix_rate (str): Dye ratio for mixed face color
    """
    face_name: str
    base_color: str
    mix_color: str | None
    mix_rate: str


class CharacterBeautyEquipmentSkin(BaseModel, BaseCharacterBeautyEquipmentSkin):
    """
    Character skin information

    Attributes:
        skin_name (str): Skin name
        color_style (str or None): Color style
        hue (int or None): Skin hue
        saturation (int or None): Skin saturation
        brightness (int or None): Skin brightness
    """
    skin_name: str
    color_style: str | None
    hue: int | None
    saturation: int | None
    brightness: int | None


class CharacterBeautyEquipment(BaseModel, BaseCharacterBeautyEquipment):
    """
    Character equipped hair, face, and skin information

    Attributes:
        date (datetime or None): Reference date for query (SGT)
        character_gender (str or None): Character gender
        character_class (str or None): Character job
        character_hair (CharacterBeautyEquipmentHair or None): Character hair information (Alpha mode for Zero, Normal mode for Angelic Buster)
        character_face (CharacterBeautyEquipmentFace or None): Character face information (Alpha mode for Zero, Normal mode for Angelic Buster)
        character_skin (CharacterBeautyEquipmentSkin or None): Character skin information (Alpha mode for Zero, Normal mode for Angelic Buster)
        additional_character_hair (CharacterBeautyEquipmentHair or None): Hair information applied in Beta mode for Zero or Dress-up mode for Angelic Buster
        additional_character_face (CharacterBeautyEquipmentFace or None): Face information applied in Beta mode for Zero or Dress-up mode for Angelic Buster
        additional_character_skin (CharacterBeautyEquipmentSkin or None): Skin information applied in Beta mode for Zero or Dress-up mode for Angelic Buster
    """
    date: datetime | None
    character_gender: str | None
    character_class: str | None
    character_hair: CharacterBeautyEquipmentHair | None
    character_face: CharacterBeautyEquipmentFace | None
    character_skin: CharacterBeautyEquipmentSkin | None
    additional_character_hair: CharacterBeautyEquipmentHair | None
    additional_character_face: CharacterBeautyEquipmentFace | None
    additional_character_skin: CharacterBeautyEquipmentSkin | None

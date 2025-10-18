from datetime import datetime
from pydantic import BaseModel

from maplestory_openapi.api.common.dto.character.character_beauty_equipment import CharacterBeautyEquipmentHair as BaseCharacterBeautyEquipmentHair
from maplestory_openapi.api.common.dto.character.character_beauty_equipment import CharacterBeautyEquipmentFace as BaseCharacterBeautyEquipmentFace
from maplestory_openapi.api.common.dto.character.character_beauty_equipment import CharacterBeautyEquipmentSkin as BaseCharacterBeautyEquipmentSkin
from maplestory_openapi.api.common.dto.character.character_beauty_equipment import CharacterBeautyEquipment as BaseCharacterBeautyEquipment


class CharacterBeautyEquipmentHair(BaseModel, BaseCharacterBeautyEquipmentHair):
    """
    角色髮型資訊

    Attributes:
        hair_name (str): 髮型名稱
        base_color (str): 髮型基本顏色
        mix_color (str or None): 髮型混染顏色
        mix_rate (str): 髮型混染顏色比例
    """
    hair_name: str
    base_color: str
    mix_color: str | None
    mix_rate: str


class CharacterBeautyEquipmentFace(BaseModel, BaseCharacterBeautyEquipmentFace):
    """
    角色臉型資訊

    Attributes:
        face_name (str): 臉型名稱
        base_color (str): 臉型基本顏色
        mix_color (str or None): 臉型混染顏色
        mix_rate (str): 臉型混染顏色比例
    """
    face_name: str
    base_color: str
    mix_color: str | None
    mix_rate: str


class CharacterBeautyEquipmentSkin(BaseModel, BaseCharacterBeautyEquipmentSkin):
    """
    角色膚色資訊

    Attributes:
        skin_name (str): 膚色名稱
        color_style (str or None): 色系
        hue (int or None): 膚色色調
        saturation (int or None): 膚色彩度
        brightness (int or None): 膚色明度
    """
    skin_name: str
    color_style: str | None
    hue: int | None
    saturation: int | None
    brightness: int | None


class CharacterBeautyEquipment(BaseModel, BaseCharacterBeautyEquipment):
    """
    角色目前已裝備的髮型、臉型與膚色資訊

    Attributes:
        date (datetime or None): 要搜尋的日期 (TST)
        character_gender (str or None): 角色性別
        character_class (str or None): 角色職業
        character_hair (CharacterBeautyEquipmentHair or None): 角色髮型資訊 (神之子為 Alpha、天使破壞者為一般模式時)
        character_face (CharacterBeautyEquipmentFace or None): 角色臉型資訊 (神之子為 Alpha、天使破壞者為一般模式時)
        character_skin (CharacterBeautyEquipmentSkin or None): 角色膚色資訊 (神之子為 Alpha、天使破壞者為一般模式時)
        additional_character_hair (CharacterBeautyEquipmentHair or None): 神之子為 Beta 及天使破壞者為變裝模式時的目前已裝備髮型資訊
        additional_character_face (CharacterBeautyEquipmentFace or None): 神之子為 Beta 及天使破壞者為變裝模式時的目前已裝備臉型資訊
        additional_character_skin (CharacterBeautyEquipmentSkin or None): 神之子為 Beta 及天使破壞者為變裝模式時的目前已裝備膚色資訊
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

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
    機器人髮型資訊

    Attributes:
        hair_name (str or None): 機器人髮型名稱
        base_color (str or None): 機器人髮型基本顏色
        mix_color (str or None): 機器人髮型混染顏色
        mix_rate (str): 機器人髮型混染顏色比例
    """
    hair_name: str | None
    base_color: str | None
    mix_color: str | None
    mix_rate: str


class CharacterAndroidEquipmentFace(BaseModel, BaseCharacterAndroidEquipmentFace):
    """
    機器人臉型資訊

    Attributes:
        face_name (str or None): 機器人臉型名稱
        base_color (str or None): 機器人臉型基本顏色
        mix_color (str or None): 機器人臉型混染顏色
        mix_rate (str): 機器人臉型混染顏色比例
    """
    face_name: str | None
    base_color: str | None
    mix_color: str | None
    mix_rate: str


class CharacterAndroidEquipmentSkin(BaseModel, BaseCharacterAndroidEquipmentSkin):
    """
    機器人膚色資訊

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


class CharacterAndroidEquipmentPreset(BaseModel, BaseCharacterAndroidEquipmentPreset):
    """
    預設的機器人資訊

    Attributes:
        android_name (str): 機器人名稱
        android_nickname (str): 機器人暱稱
        android_icon (str): 機器人圖示
        android_description (str): 機器人道具描述
        android_gender (str or None): 機器人性別
        android_grade (str): 機器人階級
        android_hair (CharacterAndroidEquipmentHair): 機器人髮型資訊
        android_face (CharacterAndroidEquipmentFace): 機器人臉型資訊
        android_skin (CharacterAndroidEquipmentSkin or None): 機器人膚色資訊
        android_ear_sensor_clip_flag (str): 機器人耳飾感應器
        android_non_humanoid_flag (str): 非人型機器人
        android_shop_usable_flag (str): 是否具備雜貨店功能
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
    機器人現金道具彩色稜鏡資訊

    Attributes:
        color_range (str): 彩色稜鏡顏色範圍
        hue (int): 彩色稜鏡色調
        saturation (int): 彩色稜鏡彩度
        value (int): 彩色稜鏡明度
    """
    color_range: str
    hue: int
    saturation: int
    value: int


class CharacterAndroidCashItemEquipmentOption(BaseModel, BaseCharacterAndroidCashItemEquipmentOption):
    """
    機器人現金道具選項

    Attributes:
        option_type (str): 選項類型
        option_value (str): 選項數值
    """
    option_type: str
    option_value: str


class CharacterAndroidCashItemEquipment(BaseModel, BaseCharacterAndroidCashItemEquipment):
    """
    機器人的已裝備現金道具資訊

    Attributes:
        cash_item_equipment_part (str): 機器人現金道具部位名稱
        cash_item_equipment_slot (str): 機器人現金道具欄位位置
        cash_item_name (str): 機器人現金道具名稱
        cash_item_icon (str): 機器人現金道具圖示
        cash_item_description (str or None): 機器人現金道具描述
        cash_item_option (list[CharacterAndroidCashItemEquipmentOption]): 機器人現金道具選項
        date_expire (datetime or None): 機器人現金道具有效期間 (TST)
        is_expired (bool): Whether the android cash item is expired
        date_option_expire (datetime or None): 機器人現金道具選項有效期間 (TST，時間單位資料中的分鐘顯示為 0)
        is_option_expired (bool): Whether the android cash item option is expired
        cash_item_label (str or None): 機器人現金道具標籤資訊 (特殊標籤、紅標籤、黑標籤、大師標籤)
        cash_item_coloring_prism (CharacterAndroidCashItemEquipmentColoringPrism or None): 機器人現金道具彩色稜鏡資訊
        android_item_gender (str or None): 道具可裝備性別
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
    角色已裝備機器人資訊

    Attributes:
        date (datetime or None): 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        android_name (str or None): 機器人名稱
        android_nickname (str or None): 機器人暱稱
        android_icon (str or None): 機器人圖示
        android_description (str or None): 機器人道具描述
        android_hair (CharacterAndroidEquipmentHair or None): 機器人髮型資訊
        android_face (CharacterAndroidEquipmentFace or None): 機器人臉型資訊
        android_skin (CharacterAndroidEquipmentSkin or None): 機器人膚色資訊
        android_cash_item_equipment (list[CharacterAndroidCashItemEquipment]): 機器人的已裝備現金道具資訊
        android_ear_sensor_clip_flag (str or None): 機器人耳飾感應器
        android_gender (str or None): 機器人性別
        android_grade (str or None): 機器人階級
        android_non_humanoid_flag (str or None): 非人型機器人
        android_shop_usable_flag (str or None): 是否具備雜貨店功能
        preset_no (int or None): 目前套用的道具預設編號
        android_preset_1 (CharacterAndroidEquipmentPreset or None): 預設 1 的機器人資訊
        android_preset_2 (CharacterAndroidEquipmentPreset or None): 預設 2 的機器人資訊
        android_preset_3 (CharacterAndroidEquipmentPreset or None): 預設 3 的機器人資訊
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

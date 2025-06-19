from datetime import datetime
from pydantic import BaseModel, model_validator

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
    안드로이드 헤어 정보

    Attributes:
        hair_name (str or None): 안드로이드 헤어 명
        base_color (str or None): 안드로이드 헤어 베이스 컬러
        mix_color (str or None): 안드로이드 헤어 믹스 컬러
        mix_rate (str): 안드로이드 헤어 믹스 컬러의 염색 비율
        freestyle_flag (str or None): 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
    """
    hair_name: str | None
    base_color: str | None
    mix_color: str | None
    mix_rate: str
    freestyle_flag: str | None

    @property
    def is_freestyle_flag(self) -> bool:
        """
        프리스타일 쿠폰 적용 여부
        """
        return self.freestyle_flag == '1'


class CharacterAndroidEquipmentFace(BaseModel, BaseCharacterAndroidEquipmentFace):
    """
    안드로이드 성형 정보

    Attributes:
        face_name(str): 안드로이드 성형 명
        base_color(str): 안드로이드 성형 베이스 컬러
        mix_color(str): 안드로이드 성형 믹스 컬러
        mix_rate(str): 안드로이드 성형 믹스 컬러의 염색 비율
        freestyle_flag(str or None): 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
    """
    face_name: str | None
    base_color: str | None
    mix_color: str | None
    mix_rate: str
    freestyle_flag: str | None

    @property
    def is_freestyle_flag(self) -> bool:
        """
        프리스타일 쿠폰 적용 여부
        """
        return self.freestyle_flag == '1'


class CharacterAndroidEquipmentSkin(BaseModel, BaseCharacterAndroidEquipmentSkin):
    """
    안드로이드 피부 정보

    Attributes:
        skin_name(str): 피부 명
        color_style(str): 색상 계열
        hue(int): 피부 색조
        saturation(int): 피부 채도
        brightness(int): 피부 명도
    """
    skin_name: str
    color_style: str | None
    hue: int | None
    saturation: int | None
    brightness: int | None


class CharacterAndroidEquipmentPreset(BaseModel, BaseCharacterAndroidEquipmentPreset):
    """
    안드로이드 프리셋 정보

    Attributes:
        android_name(str): 안드로이드 명
        android_nickname(str): 안드로이드 닉네임
        android_icon(str): 안드로이드 아이콘
        android_description(str): 안드로이드 아이템 설명
        android_gender(str): 안드로이드 성별
        android_grade(str): 안드로이드 등급
        android_hair(CharacterAndroidEquipmentHair): 안드로이드 헤어 정보
        android_face(CharacterAndroidEquipmentFace): 안드로이드 성형 정보
        android_skin(CharacterAndroidEquipmentSkin): 안드로이드 피부 정보
        android_ear_sensor_clip_flag(str): 안드로이드 이어센서 클립 적용 여부
        android_non_humanoid_flag(str): 비인간형 안드로이드 여부
        android_shop_usable_flag(str): 잡화상점 기능 이용 가능 여부
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
    안드로이드 캐시아이템 컬러링프리즘 정보

    Attributes:
        color_range(str): 컬러링프리즘 색상 범위
        hue(int): 컬러링프리즘 색조
        saturation(int): 컬러링프리즘 채도
        value(int): 컬러링프리즘 명도
    """
    color_range: str
    hue: int
    saturation: int
    value: int


class CharacterAndroidCashItemEquipmentOption(BaseModel, BaseCharacterAndroidCashItemEquipmentOption):
    """
    안드로이드 캐시아이템 옵션

    Attributes:
        option_type(str): 옵션 타입
        option_value(str): 옵션 값
    """
    option_type: str
    option_value: str


class CharacterAndroidCashItemEquipment(BaseModel, BaseCharacterAndroidCashItemEquipment):
    """
    안드로이드 캐시 아이템 장착 정보

    Attributes:
        cash_item_equipment_part (str): 안드로이드 캐시 아이템 부위 명
        cash_item_equipment_slot (str): 안드로이드 캐시 아이템 슬롯 위치
        cash_item_name (str): 안드로이드 캐시 아이템 명
        cash_item_icon (str): 안드로이드 캐시 아이템 아이콘
        cash_item_description (str or None): 안드로이드 캐시 아이템 설명
        cash_item_option (list[CharacterAndroidCashItemEquipmentOption]): 안드로이드 캐시 아이템 옵션
        date_expire (datetime or None): 안드로이드 캐시 아이템 유효 기간 (KST)
        is_expired (bool): 안드로이드 캐시 아이템 유효 기간 만료 여부
        date_option_expire (datetime or None): 안드로이드 캐시 아이템 옵션 유효 기간 (KST)
        is_option_expired (bool): 안드로이드 캐시 아이템 옵션 유효 기간 만료 여부
        cash_item_label (str or None): 안드로이드 캐시 아이템 라벨 정보
        cash_item_coloring_prism (CharacterAndroidCashItemEquipmentColoringPrism or None): 컬러링프리즘 정보
        android_item_gender (str or None): 아이템 장착 가능 성별
        freestyle_flag (str or None): 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
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
    freestyle_flag: str | None

    @property
    def is_freestyle_flag(self) -> bool:
        """
        프리스타일 쿠폰 적용 여부
        """
        return self.freestyle_flag == '1'

class CharacterAndroidEquipment(BaseModel, BaseCharacterAndroidEquipment):
    """
    안드로이드 장비 정보

    Attributes:
        date (datetime or None): 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        android_name (str or None): 안드로이드 명
        android_nickname (str or None): 안드로이드 닉네임
        android_icon (str or None): 안드로이드 아이콘
        android_description (str or None): 안드로이드 아이템 설명
        android_hair (CharacterAndroidEquipmentHair or None): 안드로이드 헤어 정보
        android_face (CharacterAndroidEquipmentFace or None): 안드로이드 성형 정보
        android_skin (CharacterAndroidEquipmentSkin or None): 안드로이드 피부 정보
        android_cash_item_equipment (list[CharacterAndroidCashItemEquipment]): 캐시 아이템 장착 정보
        android_ear_sensor_clip_flag (str or None): 이어센서 클립 적용 여부
        android_gender (str or None): 안드로이드 성별
        android_grade (str or None): 안드로이드 등급
        android_non_humanoid_flag (str or None): 비인간형 여부
        android_shop_usable_flag (str or None): 잡화상점 기능 이용 가능 여부
        preset_no (int or None): 적용 중인 장비 프리셋 번호
        android_preset_1 (CharacterAndroidEquipmentPreset or None): 1번 프리셋 정보
        android_preset_2 (CharacterAndroidEquipmentPreset or None): 2번 프리셋 정보
        android_preset_3 (CharacterAndroidEquipmentPreset or None): 3번 프리셋 정보
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

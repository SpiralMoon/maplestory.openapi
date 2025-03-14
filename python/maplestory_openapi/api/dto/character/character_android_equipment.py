from datetime import datetime
from pydantic import BaseModel, model_validator


class CharacterAndroidEquipmentHair(BaseModel):
    """안드로이드 헤어 정보

    hair_name(str): 안드로이드 헤어 명
    base_color(str): 안드로이드 헤어 베이스 컬러
    mix_color(str): 안드로이드 헤어 믹스 컬러
    mix_rate(str): 안드로이드 헤어 믹스 컬러의 염색 비율
    """
    hair_name: str | None
    base_color: str | None
    mix_color: str | None
    mix_rate: str


class CharacterAndroidEquipmentFace(BaseModel):
    """안드로이드 성형 정보

    face_name(str): 안드로이드 성형 명
    base_color(str): 안드로이드 성형 베이스 컬러
    mix_color(str): 안드로이드 성형 믹스 컬러
    mix_rate(str): 안드로이드 성형 믹스 컬러의 염색 비율
    """
    face_name: str | None
    base_color: str | None
    mix_color: str | None
    mix_rate: str


class CharacterAndroidEquipmentSkin(BaseModel):
    """안드로이드 피부 정보

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


class CharacterAndroidEquipmentPreset(BaseModel):
    """안드로이드 프리셋 정보

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


class CharacterAndroidCashItemEquipmentColoringPrism(BaseModel):
    """안드로이드 캐시아이템 컬러링프리즘 정보

    color_range(str): 컬러링프리즘 색상 범위
    hue(int): 컬러링프리즘 색조
    saturation(int): 컬러링프리즘 채도
    value(int): 컬러링프리즘 명도
    """
    color_range: str
    hue: int
    saturation: int
    value: int


class CharacterAndroidCashItemEquipmentOption(BaseModel):
    """안드로이드 캐시아이템 옵션

    option_type(str): 옵션 타입
    option_value(str): 옵션 값
    """
    option_type: str
    option_value: str


class CharacterAndroidCashItemEquipment(BaseModel):
    """안드로이드 캐시 아이템 장착 정보
    cash_item_equipment_part(str): 캐시 장비 부위 명
    cash_item_equipment_slot(str): 캐시 장비 슬롯 위치
    cash_item_name(str): 캐시 장비 명
    cash_item_icon(str): 캐시 장비 아이콘
    cash_item_description(str): 캐시 장비 설명
    cash_item_option(list[CharacterCashitemEquipmentOption]): 캐시 장비 옵션
    date_expire(datetime): 캐시 장비 유효기간 (KST)
    date_option_expire(datetime): 캐시 장비 옵션 유효기간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
    is_option_expired(bool): 캐시 장비 옵션 유효 기간 만료 여부
    cash_item_label(str): 캐시 장비 라벨 정보
    cash_item_coloring_prism(CharacterCashitemEquipmentColoringPrism): 캐시 장비 컬러링프리즘 정보
    """
    cash_item_equipment_part: str
    cash_item_equipment_slot: str
    cash_item_name: str
    cash_item_icon: str
    cash_item_description: str | None
    cash_item_option: list[CharacterAndroidCashItemEquipmentOption]
    date_expire: datetime | None
    date_option_expire: datetime | None
    is_option_expired: bool = False
    cash_item_label: str | None
    cash_item_coloring_prism: CharacterAndroidCashItemEquipmentColoringPrism | None

    @model_validator(mode="before")
    @classmethod
    def set_default_date_option_expire(cls, values):
        if values.get("date_option_expire") == 'expired':
            values["is_option_expired"] = True
            values["date_option_expire"] = None
        return values


class CharacterAndroidEquipment(BaseModel):
    """안드로이드 장비 정보

    date(datetime): 조회 기준일 (KST)
    android_name(str): 안드로이드 명
    android_nickname(str): 안드로이드 닉네임
    android_icon(str): 안드로이드 아이콘
    android_description(str): 안드로이드 아이템 설명
    android_hair(CharacterAndroidEquipmentHair): 안드로이드 헤어 정보
    android_face(CharacterAndroidEquipmentFace): 안드로이드 성형 정보
    android_skin(CharacterAndroidEquipmentSkin): 안드로이드 피부 정보
    android_cash_item_equipment(list[CharacterAndroidCashItemEquipment]): 안드로이드 캐시 아이템 장착 정보
    android_ear_sensor_clip_flag(str): 안드로이드 이어센서 클립 적용 여부
    android_gender(str): 안드로이드 성별
    android_grade(str): 안드로이드 등급
    android_non_humanoid_flag(str): 비인간형 안드로이드 여부
    android_shop_usable_flag(str): 잡화상점 기능 이용 가능 여부
    preset_no(int): 적용 중인 장비 프리셋 번호
    android_preset_1(CharacterAndroidEquipmentPreset): 1번 프리셋 안드로이드 정보
    android_preset_2(CharacterAndroidEquipmentPreset): 2번 프리셋 안드로이드 정보
    android_preset_3(CharacterAndroidEquipmentPreset): 3번 프리셋 안드로이드 정보
    """
    date: datetime | None
    android_name: str | None
    android_nickname: str | None
    android_icon: str | None
    android_description: str | None
    android_hair: CharacterAndroidEquipmentHair
    android_face: CharacterAndroidEquipmentFace
    android_skin: CharacterAndroidEquipmentSkin | None
    android_cash_item_equipment: list[CharacterAndroidCashItemEquipment]
    android_ear_sensor_clip_flag: str
    android_gender: str | None
    android_grade: str | None
    android_non_humanoid_flag: str | None
    android_shop_usable_flag: str | None
    preset_no: int | None
    android_preset_1: CharacterAndroidEquipmentPreset | None
    android_preset_2: CharacterAndroidEquipmentPreset | None
    android_preset_3: CharacterAndroidEquipmentPreset | None

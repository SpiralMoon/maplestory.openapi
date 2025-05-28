import {
  CharacterAndroidCashItemEquipmentBody,
  CharacterAndroidCashItemEquipmentColoringPrismBody,
  CharacterAndroidCashItemEquipmentOptionBody,
  CharacterAndroidEquipmentBody,
  CharacterAndroidEquipmentFaceBody,
  CharacterAndroidEquipmentHairBody,
  CharacterAndroidEquipmentPresetBody,
  CharacterAndroidEquipmentSkinBody,
} from '../../response/character/characterAndroidEquipmentBody';

/**
 * 캐릭터 안드로이드 장비 정보
 */
export class CharacterAndroidEquipmentDto {
  /**
   * 조회 기준일
   */
  date: Date | null;

  /**
   * 안드로이드 명
   */
  androidName: string | null;

  /**
   * 안드로이드 닉네임
   */
  androidNickname: string | null;

  /**
   * 안드로이드 아이콘
   */
  androidIcon: string | null;

  /**
   * 안드로이드 아이템 설명
   */
  androidDescription: string | null;

  /**
   * 안드로이드 헤어 정보
   */
  androidHair: CharacterAndroidEquipmentHairDto | null;

  /**
   * 안드로이드 성형 정보
   */
  androidFace: CharacterAndroidEquipmentFaceDto | null;

  /**
   * 안드로이드 피부 정보
   */
  androidSkin: CharacterAndroidEquipmentSkinDto | null;

  /**
   * 안드로이드 캐시 아이템 장착 정보
   */
  androidCashItemEquipment: CharacterAndroidCashItemEquipmentDto[];

  /**
   * 안드로이드 이어센서 클립 적용 여부
   */
  androidEarSensorClipFlag: string | null;

  /**
   * 안드로이드 성별
   */
  androidGender: string | null;

  /**
   * 안드로이드 등급
   */
  androidGrade: string | null;

  /**
   * 비인간형 안드로이드 여부
   */
  androidNonHumanoidFlag: string | null;

  /**
   * 잡화상점 기능 이용 가능 여부
   */
  androidShopUsableFlag: string | null;

  /**
   * 적용 중인 장비 프리셋 번호
   */
  presetNo: number | null;

  /**
   * 1번 프리셋 안드로이드 정보
   */
  androidPreset1: CharacterAndroidEquipmentPresetDto | null;

  /**
   * 2번 프리셋 안드로이드 정보
   */
  androidPreset2: CharacterAndroidEquipmentPresetDto | null;

  /**
   * 3번 프리셋 안드로이드 정보
   */
  androidPreset3: CharacterAndroidEquipmentPresetDto | null;

  constructor(obj: CharacterAndroidEquipmentBody) {
    const {
      date,
      android_name,
      android_nickname,
      android_icon,
      android_description,
      android_hair,
      android_face,
      android_skin,
      android_cash_item_equipment,
      android_ear_sensor_clip_flag,
      android_gender,
      android_grade,
      android_non_humanoid_flag,
      android_shop_usable_flag,
      preset_no,
      android_preset_1,
      android_preset_2,
      android_preset_3,
    } = obj;

    this.date = date ? new Date(date) : null;
    this.androidName = android_name;
    this.androidNickname = android_nickname;
    this.androidIcon = android_icon;
    this.androidDescription = android_description;
    this.androidHair = android_hair ? new CharacterAndroidEquipmentHairDto(android_hair) : null;
    this.androidFace = android_face ? new CharacterAndroidEquipmentFaceDto(android_face) : null;
    this.androidSkin = android_skin ? new CharacterAndroidEquipmentSkinDto(android_skin) : null;
    this.androidCashItemEquipment = android_cash_item_equipment.map(
      (equipment) => new CharacterAndroidCashItemEquipmentDto(equipment),
    );
    this.androidEarSensorClipFlag = android_ear_sensor_clip_flag ?? null;
    this.androidGender = android_gender;
    this.androidGrade = android_grade;
    this.androidNonHumanoidFlag = android_non_humanoid_flag;
    this.androidShopUsableFlag = android_shop_usable_flag;
    this.presetNo = preset_no;
    this.androidPreset1 = android_preset_1 ? new CharacterAndroidEquipmentPresetDto(android_preset_1) : null;
    this.androidPreset2 = android_preset_2 ? new CharacterAndroidEquipmentPresetDto(android_preset_2) : null;
    this.androidPreset3 = android_preset_3 ? new CharacterAndroidEquipmentPresetDto(android_preset_3) : null;
  }
}

/**
 * 캐릭터 안드로이드 성형 정보
 */
export class CharacterAndroidEquipmentFaceDto {
  /**
   * 안드로이드 성형 명
   */
  faceName: string | null;

  /**
   * 안드로이드 성형 베이스 컬러
   */
  baseColor: string | null;

  /**
   * 안드로이드 성형 믹스 컬러
   */
  mixColor: string | null;

  /**
   * 안드로이드 성형 믹스 컬러의 염색 비율
   */
  mixRate: string;

  constructor(obj: CharacterAndroidEquipmentFaceBody) {
    const { face_name, base_color, mix_color, mix_rate } = obj;

    this.faceName = face_name;
    this.baseColor = base_color;
    this.mixColor = mix_color;
    this.mixRate = mix_rate;
  }
}

/**
 * 캐릭터 안드로이드 헤어 정보
 */
export class CharacterAndroidEquipmentHairDto {
  /**
   * 안드로이드 헤어 명
   */
  hairName: string | null;

  /**
   * 안드로이드 헤어 베이스 컬러
   */
  baseColor: string | null;

  /**
   * 안드로이드 헤어 믹스 컬러
   */
  mixColor: string | null;

  /**
   * 안드로이드 헤어 믹스 컬러의 염색 비율
   */
  mixRate: string;

  constructor(obj: CharacterAndroidEquipmentHairBody) {
    const { hair_name, base_color, mix_color, mix_rate } = obj;

    this.hairName = hair_name;
    this.baseColor = base_color;
    this.mixColor = mix_color;
    this.mixRate = mix_rate;
  }
}

/**
 * 캐릭터 안드로이드 피부 정보
 */
export class CharacterAndroidEquipmentSkinDto {
  /**
   * 피부 명
   */
  skinName: string;

  /**
   * 색상 계열
   */
  colorStyle: string | null;

  /**
   * 피부 색조
   */
  hue: number | null;

  /**
   * 피부 채도
   */
  saturation: number | null;

  /**
   * 피부 명도
   */
  brightness: number | null;

  constructor(obj: CharacterAndroidEquipmentSkinBody) {
    const { skin_name, color_style, hue, saturation, brightness } = obj;

    this.skinName = skin_name;
    this.colorStyle = color_style;
    this.hue = hue;
    this.saturation = saturation;
    this.brightness = brightness;
  }
}

/**
 * 캐릭터 안드로이드 프리셋 정보
 */
export class CharacterAndroidEquipmentPresetDto {

  /**
   * 안드로이드 명
   */
  androidName: string;

  /**
   * 안드로이드 닉네임
   */
  androidNickname: string;

  /**
   * 안드로이드 아이콘
   */
  androidIcon: string;

  /**
   * 안드로이드 아이템 설명
   */
  androidDescription: string;

  /**
   * 안드로이드 성별
   */
  androidGender: string | null;

  /**
   * 안드로이드 등급
   */
  androidGrade: string;

  /**
   * 안드로이드 헤어 정보
   */
  androidHair: CharacterAndroidEquipmentHairDto;

  /**
   * 안드로이드 성형 정보
   */
  androidFace: CharacterAndroidEquipmentFaceDto;

  /**
   * 안드로이드 피부 정보
   */
  androidSkin: CharacterAndroidEquipmentSkinDto | null;

  /**
   * 안드로이드 이어센서 클립 적용 여부
   */
  androidEarSensorClipFlag: string;

  /**
   * 비인간형 안드로이드 여부
   */
  androidNonHumanoidFlag: string;

  /**
   * 잡화상점 기능 이용 가능 여부
   */
  androidShopUsableFlag: string;

  constructor(obj: CharacterAndroidEquipmentPresetBody) {
    const {
      android_name,
      android_nickname,
      android_icon,
      android_description,
      android_gender,
      android_grade,
      android_hair,
      android_face,
      android_skin,
      android_ear_sensor_clip_flag,
      android_non_humanoid_flag,
      android_shop_usable_flag,
    } = obj;

    this.androidName = android_name;
    this.androidNickname = android_nickname;
    this.androidIcon = android_icon;
    this.androidDescription = android_description;
    this.androidGender = android_gender;
    this.androidGrade = android_grade;
    this.androidHair = new CharacterAndroidEquipmentHairDto(android_hair);
    this.androidFace = new CharacterAndroidEquipmentFaceDto(android_face);
    this.androidSkin = android_skin ? new CharacterAndroidEquipmentSkinDto(android_skin) : null;
    this.androidEarSensorClipFlag = android_ear_sensor_clip_flag;
    this.androidNonHumanoidFlag = android_non_humanoid_flag;
    this.androidShopUsableFlag = android_shop_usable_flag;
  }
}

/**
 * 캐릭터 안드로이드 캐시 아이템 컬러링프리즘 정보
 */
class CharacterAndroidCashItemEquipmentColoringPrismDto {
  /**
   * 컬러링프리즘 색상 범위
   */
  colorRange: string;

  /**
   * 컬러링프리즘 색조
   */
  hue: number;

  /**
   * 컬러링프리즘 채도
   */
  saturation: number;

  /**
   * 컬러링프리즘 명도
   */
  value: number;

  constructor(obj: CharacterAndroidCashItemEquipmentColoringPrismBody) {
    const { color_range, hue, saturation, value } = obj;

    this.colorRange = color_range;
    this.hue = hue;
    this.saturation = saturation;
    this.value = value;
  }
}

/**
 * 캐릭터 안드로이드 캐시 아이템 옵션 정보
 */
class CharacterAndroidCashItemEquipmentOptionDto {
  /**
   * 옵션 타입
   */
  optionType: string;

  /**
   * 옵션 값
   */
  optionValue: string;

  constructor(obj: CharacterAndroidCashItemEquipmentOptionBody) {
    const { option_type, option_value } = obj;

    this.optionType = option_type;
    this.optionValue = option_value;
  }
}

/**
 * 캐릭터 안드로이드 캐시 아이템 장착 정보
 */
class CharacterAndroidCashItemEquipmentDto {
  /**
   * 안드로이드 캐시 아이템 부위 명
   */
  cashItemEquipmentPart: string;

  /**
   * 안드로이드 캐시 아이템 슬롯 위치
   */
  cashItemEquipmentSlot: string;

  /**
   * 안드로이드 캐시 아이템 명
   */
  cashItemName: string;

  /**
   * 안드로이드 캐시 아이템 아이콘
   */
  cashItemIcon: string;

  /**
   * 안드로이드 캐시 아이템 설명
   */
  cashItemDescription: string | null;

  /**
   * 안드로이드 캐시 아이템 옵션
   */
  cashItemOption: CharacterAndroidCashItemEquipmentOptionDto[];

  /**
   * 안드로이드 캐시 아이템 유효 기간 (KST)
   */
  dateExpire: Date | null = null;

  /**
   * 안드로이드 캐시 아이템 유효 기간 만료 여부
   */
  isExpired: boolean | null = null;

  /**
   * 안드로이드 캐시 아이템 옵션 유효 기간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
   */
  dateOptionExpire: Date | null = null;

  /**
   * 안드로이드 캐시 아이템 옵션 유효 기간 만료 여부
   */
  isOptionExpired: boolean | null = null;

  /**
   * 안드로이드 캐시 아이템 라벨 정보 (스페셜라벨, 레드라벨, 블랙라벨, 마스터라벨)
   */
  cashItemLabel: string | null;

  /**
   * 안드로이드 캐시 아이템 컬러링프리즘 정보
   */
  cashItemColoringPrism: CharacterAndroidCashItemEquipmentColoringPrismDto | null;

  constructor(obj: CharacterAndroidCashItemEquipmentBody) {
    const {
      cash_item_equipment_part,
      cash_item_equipment_slot,
      cash_item_name,
      cash_item_icon,
      cash_item_description,
      cash_item_option,
      date_expire,
      date_option_expire,
      cash_item_label,
      cash_item_coloring_prism,
    } = obj;

    this.cashItemEquipmentPart = cash_item_equipment_part;
    this.cashItemEquipmentSlot = cash_item_equipment_slot;
    this.cashItemName = cash_item_name;
    this.cashItemIcon = cash_item_icon;
    this.cashItemDescription = cash_item_description;
    this.cashItemOption = cash_item_option.map(
      (option) => new CharacterAndroidCashItemEquipmentOptionDto(option),
    );
    this.cashItemLabel = cash_item_label;
    this.cashItemColoringPrism = cash_item_coloring_prism
      ? new CharacterAndroidCashItemEquipmentColoringPrismDto(
        cash_item_coloring_prism,
      )
      : null;

    if (date_expire === 'expired') {
      this.isExpired = true;
    } else if (typeof date_expire === 'string') {
      this.dateExpire = date_expire
        ? new Date(date_expire)
        : null;
    }

    if (date_option_expire === 'expired') {
      this.isOptionExpired = true;
    } else if (typeof date_option_expire === 'string') {
      this.dateOptionExpire = date_option_expire
        ? new Date(date_option_expire)
        : null;
    }
  }
}

import * as base from '../../../common/dto/character/characterAndroidEquipment';
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
export class CharacterAndroidEquipmentDto extends base.CharacterAndroidEquipmentDto {
  /**
   * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
   */
  public override date: Date | null;

  /**
   * 안드로이드 명
   */
  public override androidName: string | null;

  /**
   * 안드로이드 닉네임
   */
  public override androidNickname: string | null;

  /**
   * 안드로이드 아이콘
   */
  public override androidIcon: string | null;

  /**
   * 안드로이드 아이템 설명
   */
  public override androidDescription: string | null;

  /**
   * 안드로이드 헤어 정보
   */
  public override androidHair: CharacterAndroidEquipmentHairDto | null;

  /**
   * 안드로이드 성형 정보
   */
  public override androidFace: CharacterAndroidEquipmentFaceDto | null;

  /**
   * 안드로이드 피부 정보
   */
  public override androidSkin: CharacterAndroidEquipmentSkinDto | null;

  /**
   * 안드로이드 캐시 아이템 장착 정보
   */
  public override androidCashItemEquipment: CharacterAndroidCashItemEquipmentDto[];

  /**
   * 안드로이드 이어센서 클립 적용 여부
   */
  public override androidEarSensorClipFlag: string;

  /**
   * 안드로이드 성별
   */
  public override androidGender: string | null;

  /**
   * 안드로이드 등급
   */
  public override androidGrade: string | null;

  /**
   * 비인간형 안드로이드 여부
   */
  public override androidNonHumanoidFlag: string | null;

  /**
   * 잡화상점 기능 이용 가능 여부
   */
  public override androidShopUsableFlag: string | null;

  /**
   * 적용 중인 장비 프리셋 번호
   */
  public override presetNo: number | null;

  /**
   * 1번 프리셋 안드로이드 정보
   */
  public override androidPreset1: CharacterAndroidEquipmentPresetDto | null;

  /**
   * 2번 프리셋 안드로이드 정보
   */
  public override androidPreset2: CharacterAndroidEquipmentPresetDto | null;

  /**
   * 3번 프리셋 안드로이드 정보
   */
  public override androidPreset3: CharacterAndroidEquipmentPresetDto | null;

  constructor(obj: CharacterAndroidEquipmentBody) {
    super();

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
    this.androidHair = android_hair
      ? new CharacterAndroidEquipmentHairDto(android_hair)
      : null;
    this.androidFace = android_face
      ? new CharacterAndroidEquipmentFaceDto(android_face)
      : null;
    this.androidSkin = android_skin
      ? new CharacterAndroidEquipmentSkinDto(android_skin)
      : null;
    this.androidCashItemEquipment = android_cash_item_equipment.map(
      (equipment) => new CharacterAndroidCashItemEquipmentDto(equipment),
    );
    this.androidEarSensorClipFlag = android_ear_sensor_clip_flag;
    this.androidGender = android_gender;
    this.androidGrade = android_grade;
    this.androidNonHumanoidFlag = android_non_humanoid_flag;
    this.androidShopUsableFlag = android_shop_usable_flag;
    this.presetNo = preset_no;
    this.androidPreset1 = android_preset_1
      ? new CharacterAndroidEquipmentPresetDto(android_preset_1)
      : null;
    this.androidPreset2 = android_preset_2
      ? new CharacterAndroidEquipmentPresetDto(android_preset_2)
      : null;
    this.androidPreset3 = android_preset_3
      ? new CharacterAndroidEquipmentPresetDto(android_preset_3)
      : null;
  }
}

/**
 * 캐릭터 안드로이드 성형 정보
 */
export class CharacterAndroidEquipmentFaceDto extends base.CharacterAndroidEquipmentFaceDto {
  /**
   * 안드로이드 성형 명
   */
  public override faceName: string | null;

  /**
   * 안드로이드 성형 베이스 컬러
   */
  public override baseColor: string | null;

  /**
   * 안드로이드 성형 믹스 컬러
   */
  public override mixColor: string | null;

  /**
   * 안드로이드 성형 믹스 컬러의 염색 비율
   */
  public override mixRate: string;

  /**
   * 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
   */
  public freestyleFlag: string | null;

  constructor(obj: CharacterAndroidEquipmentFaceBody) {
    super();

    const { face_name, base_color, mix_color, mix_rate, freestyle_flag } = obj;

    this.faceName = face_name;
    this.baseColor = base_color;
    this.mixColor = mix_color;
    this.mixRate = mix_rate;
    this.freestyleFlag = freestyle_flag;
  }

  /**
   * 프리스타일 쿠폰 적용 여부
   */
  public get isFreestyleFlag() {
    return this.freestyleFlag === '1';
  }
}

/**
 * 캐릭터 안드로이드 헤어 정보
 */
export class CharacterAndroidEquipmentHairDto extends base.CharacterAndroidEquipmentHairDto {
  /**
   * 안드로이드 헤어 명
   */
  public override hairName: string | null;

  /**
   * 안드로이드 헤어 베이스 컬러
   */
  public override baseColor: string | null;

  /**
   * 안드로이드 헤어 믹스 컬러
   */
  public override mixColor: string | null;

  /**
   * 안드로이드 헤어 믹스 컬러의 염색 비율
   */
  public override mixRate: string;

  /**
   * 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
   */
  public freestyleFlag: string | null;

  constructor(obj: CharacterAndroidEquipmentHairBody) {
    super();

    const { hair_name, base_color, mix_color, mix_rate, freestyle_flag } = obj;

    this.hairName = hair_name;
    this.baseColor = base_color;
    this.mixColor = mix_color;
    this.mixRate = mix_rate;
    this.freestyleFlag = freestyle_flag;
  }

  /**
   * 프리스타일 쿠폰 적용 여부
   */
  public get isFreestyleFlag() {
    return this.freestyleFlag === '1';
  }
}

/**
 * 캐릭터 안드로이드 피부 정보
 */
export class CharacterAndroidEquipmentSkinDto extends base.CharacterAndroidEquipmentSkinDto {
  /**
   * 피부 명
   */
  public override skinName: string;

  /**
   * 색상 계열
   */
  public override colorStyle: string | null;

  /**
   * 피부 색조
   */
  public override hue: number | null;

  /**
   * 피부 채도
   */
  public override saturation: number | null;

  /**
   * 피부 명도
   */
  public override brightness: number | null;

  constructor(obj: CharacterAndroidEquipmentSkinBody) {
    super();

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
export class CharacterAndroidEquipmentPresetDto extends base.CharacterAndroidEquipmentPresetDto {
  /**
   * 안드로이드 명
   */
  public override androidName: string;

  /**
   * 안드로이드 닉네임
   */
  public override androidNickname: string;

  /**
   * 안드로이드 아이콘
   */
  public override androidIcon: string;

  /**
   * 안드로이드 아이템 설명
   */
  public override androidDescription: string;

  /**
   * 안드로이드 성별
   */
  public override androidGender: string | null;

  /**
   * 안드로이드 등급
   */
  public override androidGrade: string;

  /**
   * 안드로이드 헤어 정보
   */
  public override androidHair: CharacterAndroidEquipmentHairDto;

  /**
   * 안드로이드 성형 정보
   */
  public override androidFace: CharacterAndroidEquipmentFaceDto;

  /**
   * 안드로이드 피부 정보
   */
  public override androidSkin: CharacterAndroidEquipmentSkinDto | null;

  /**
   * 안드로이드 이어센서 클립 적용 여부
   */
  public override androidEarSensorClipFlag: string;

  /**
   * 비인간형 안드로이드 여부
   */
  public override androidNonHumanoidFlag: string;

  /**
   * 잡화상점 기능 이용 가능 여부
   */
  public override androidShopUsableFlag: string;

  constructor(obj: CharacterAndroidEquipmentPresetBody) {
    super();

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
    this.androidSkin = android_skin
      ? new CharacterAndroidEquipmentSkinDto(android_skin)
      : null;
    this.androidEarSensorClipFlag = android_ear_sensor_clip_flag;
    this.androidNonHumanoidFlag = android_non_humanoid_flag;
    this.androidShopUsableFlag = android_shop_usable_flag;
  }
}

/**
 * 캐릭터 안드로이드 캐시 아이템 컬러링프리즘 정보
 */
export class CharacterAndroidCashItemEquipmentColoringPrismDto extends base.CharacterAndroidCashItemEquipmentColoringPrismDto {
  /**
   * 컬러링프리즘 색상 범위
   */
  public override colorRange: string;

  /**
   * 컬러링프리즘 색조
   */
  public override hue: number;

  /**
   * 컬러링프리즘 채도
   */
  public override saturation: number;

  /**
   * 컬러링프리즘 명도
   */
  public override value: number;

  constructor(obj: CharacterAndroidCashItemEquipmentColoringPrismBody) {
    super();

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
export class CharacterAndroidCashItemEquipmentOptionDto extends base.CharacterAndroidCashItemEquipmentOptionDto {
  /**
   * 옵션 타입
   */
  public override optionType: string;

  /**
   * 옵션 값
   */
  public override optionValue: string;

  constructor(obj: CharacterAndroidCashItemEquipmentOptionBody) {
    super();

    const { option_type, option_value } = obj;

    this.optionType = option_type;
    this.optionValue = option_value;
  }
}

/**
 * 캐릭터 안드로이드 캐시 아이템 장착 정보
 */
export class CharacterAndroidCashItemEquipmentDto extends base.CharacterAndroidCashItemEquipmentDto {
  /**
   * 안드로이드 캐시 아이템 부위 명
   */
  public override cashItemEquipmentPart: string;

  /**
   * 안드로이드 캐시 아이템 슬롯 위치
   */
  public override cashItemEquipmentSlot: string;

  /**
   * 안드로이드 캐시 아이템 명
   */
  public override cashItemName: string;

  /**
   * 안드로이드 캐시 아이템 아이콘
   */
  public override cashItemIcon: string;

  /**
   * 안드로이드 캐시 아이템 설명
   */
  public override cashItemDescription: string | null;

  /**
   * 안드로이드 캐시 아이템 옵션
   */
  public override cashItemOption: CharacterAndroidCashItemEquipmentOptionDto[];

  /**
   * 안드로이드 캐시 아이템 유효 기간 (KST)
   */
  public override dateExpire: Date | null = null;

  /**
   * 안드로이드 캐시 아이템 유효 기간 만료 여부
   */
  public override isExpired: boolean | null = null;

  /**
   * 안드로이드 캐시 아이템 옵션 유효 기간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
   */
  public override dateOptionExpire: Date | null = null;

  /**
   * 안드로이드 캐시 아이템 옵션 유효 기간 만료 여부
   */
  public override isOptionExpired: boolean | null = null;

  /**
   * 안드로이드 캐시 아이템 라벨 정보 (스페셜라벨, 레드라벨, 블랙라벨, 마스터라벨)
   */
  public override cashItemLabel: string | null;

  /**
   * 안드로이드 캐시 아이템 컬러링프리즘 정보
   */
  public override cashItemColoringPrism: CharacterAndroidCashItemEquipmentColoringPrismDto | null;

  /**
   * 아이템 장착 가능 성별
   */
  public override androidItemGender: string | null;

  /**
   * 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
   */
  public freestyleFlag: string | null;

  constructor(obj: CharacterAndroidCashItemEquipmentBody) {
    super();

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
      android_item_gender,
      freestyle_flag,
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
    this.androidItemGender = android_item_gender;
    this.freestyleFlag = freestyle_flag;

    if (date_expire === 'expired') {
      this.isExpired = true;
    } else if (typeof date_expire === 'string') {
      this.dateExpire = date_expire ? new Date(date_expire) : null;
    }

    if (date_option_expire === 'expired') {
      this.isOptionExpired = true;
    } else if (typeof date_option_expire === 'string') {
      this.dateOptionExpire = date_option_expire
        ? new Date(date_option_expire)
        : null;
    }
  }

  /**
   * 프리스타일 쿠폰 적용 여부
   */
  public get isFreestyleFlag() {
    return this.freestyleFlag === '1';
  }
}

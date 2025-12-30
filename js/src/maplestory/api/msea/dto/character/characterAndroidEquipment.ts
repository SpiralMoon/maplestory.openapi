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
 * Character android equipment information
 */
export class CharacterAndroidEquipmentDto extends base.CharacterAndroidEquipmentDto {
  /**
   * Reference date for query (SGT, daily data with hours and minutes set to 0)
   */
  public override date: Date | null;

  /**
   * Android name
   */
  public override androidName: string | null;

  /**
   * Android nickname
   */
  public override androidNickname: string | null;

  /**
   * Android icon
   */
  public override androidIcon: string | null;

  /**
   * Android item description
   */
  public override androidDescription: string | null;

  /**
   * Android hair information
   */
  public override androidHair: CharacterAndroidEquipmentHairDto | null;

  /**
   * Android face information
   */
  public override androidFace: CharacterAndroidEquipmentFaceDto | null;

  /**
   * Android skin information
   */
  public override androidSkin: CharacterAndroidEquipmentSkinDto | null;

  /**
   * Android cash item equipment information
   */
  public override androidCashItemEquipment: CharacterAndroidCashItemEquipmentDto[];

  /**
   * Whether the Android ear sensor clip is applied
   */
  public override androidEarSensorClipFlag: string | null;

  /**
   * Android gender
   */
  public override androidGender: string | null;

  /**
   * Android grade
   */
  public override androidGrade: string | null;

  /**
   * Whether the Android is non-humanoid
   */
  public override androidNonHumanoidFlag: string | null;

  /**
   * Whether the Android can use the general store functionality
   */
  public override androidShopUsableFlag: string | null;

  /**
   * Active equipment preset number
   */
  public override presetNo: number | null;

  /**
   * Android information for preset 1
   */
  public override androidPreset1: CharacterAndroidEquipmentPresetDto | null;

  /**
   * Android information for preset 2
   */
  public override androidPreset2: CharacterAndroidEquipmentPresetDto | null;

  /**
   * Android information for preset 3
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
    this.androidEarSensorClipFlag = android_ear_sensor_clip_flag ?? null;
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
 * Android face information
 */
export class CharacterAndroidEquipmentFaceDto extends base.CharacterAndroidEquipmentFaceDto {
  /**
   * Android face name
   */
  public override faceName: string | null;

  /**
   * Android base face color
   */
  public override baseColor: string | null;

  /**
   * Android mixed face color
   */
  public override mixColor: string | null;

  /**
   * Dye ratio for Android mixed face color
   */
  public override mixRate: string;

  /**
   * Freestyle Coupon application status (0:not applied, 1:applied)
   */
  public override freestyleFlag: string | null;

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
   * Freestyle Coupon application status
   */
  public get isFreestyleFlag() {
    return this.freestyleFlag === '1';
  }
}

/**
 * Android hair information
 */
export class CharacterAndroidEquipmentHairDto extends base.CharacterAndroidEquipmentHairDto {
  /**
   * Android hair name
   */
  public override hairName: string | null;

  /**
   * Android base hair color
   */
  public override baseColor: string | null;

  /**
   * Android mixed hair color
   */
  public override mixColor: string | null;

  /**
   * Dye ratio for Android mixed hair color
   */
  public override mixRate: string;

  /**
   * Freestyle Coupon application status (0:not applied, 1:applied)
   */
  public override freestyleFlag: string | null;

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
   * Freestyle Coupon application status
   */
  public get isFreestyleFlag() {
    return this.freestyleFlag === '1';
  }
}

/**
 * Android skin information
 */
export class CharacterAndroidEquipmentSkinDto extends base.CharacterAndroidEquipmentSkinDto {
  /**
   * Skin name
   */
  public override skinName: string;

  /**
   * Color style
   */
  public override colorStyle: string | null;

  /**
   * Skin hue
   */
  public override hue: number | null;

  /**
   * Skin saturation
   */
  public override saturation: number | null;

  /**
   * Skin brightness
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
 * Android preset information
 */
export class CharacterAndroidEquipmentPresetDto extends base.CharacterAndroidEquipmentPresetDto {
  /**
   * Android name
   */
  public override androidName: string;

  /**
   * Android nickname
   */
  public override androidNickname: string;

  /**
   * Android icon
   */
  public override androidIcon: string;

  /**
   * Android item description
   */
  public override androidDescription: string;

  /**
   * Android gender
   */
  public override androidGender: string | null;

  /**
   * Android grade
   */
  public override androidGrade: string;

  /**
   *
   * Android hair information
   */
  public override androidHair: CharacterAndroidEquipmentHairDto;

  /**
   * Android face information
   */
  public override androidFace: CharacterAndroidEquipmentFaceDto;

  /**
   * Android skin information
   */
  public override androidSkin: CharacterAndroidEquipmentSkinDto | null;

  /**
   * Whether the Android ear sensor clip is applied
   */
  public override androidEarSensorClipFlag: string;

  /**
   * Whether the Android is non-humanoid
   */
  public override androidNonHumanoidFlag: string;

  /**
   * Whether the Android can use the general store functionality
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
 * Android cash item coloring prism information
 */
export class CharacterAndroidCashItemEquipmentColoringPrismDto extends base.CharacterAndroidCashItemEquipmentColoringPrismDto {
  /**
   * Coloring prism color range
   */
  public override colorRange: string;

  /**
   * Coloring prism hue
   */
  public override hue: number;

  /**
   * Coloring prism saturation
   */
  public override saturation: number;

  /**
   * Coloring prism brightness
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
 * Android cash item options
 */
export class CharacterAndroidCashItemEquipmentOptionDto extends base.CharacterAndroidCashItemEquipmentOptionDto {
  /**
   * Option type
   */
  public override optionType: string;

  /**
   * Option value
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
 * Android cash item equipment information
 */
export class CharacterAndroidCashItemEquipmentDto extends base.CharacterAndroidCashItemEquipmentDto {
  /**
   * Android cash item part name
   */
  public override cashItemEquipmentPart: string;

  /**
   * Android cash item slot position
   */
  public override cashItemEquipmentSlot: string;

  /**
   * Android cash item name
   */
  public override cashItemName: string;

  /**
   * Android cash item icon
   */
  public override cashItemIcon: string;

  /**
   * Android cash item description
   */
  public override cashItemDescription: string | null;

  /**
   * Android cash item options
   */
  public override cashItemOption: CharacterAndroidCashItemEquipmentOptionDto[];

  /**
   * Android cash item validity period (SGT)
   */
  public override dateExpire: Date | null = null;

  /**
   * Whether the android cash item is expired
   */
  public override isExpired: boolean | null = null;

  /**
   * Android cash item option validity period (SGT, data with minutes set to 0)
   */
  public override dateOptionExpire: Date | null = null;

  /**
   * Whether the android cash item option is expired
   */
  public override isOptionExpired: boolean | null = null;

  /**
   * Android cash item label information (e.g., Special Label, Red Label, Black Label, Master Label)
   */
  public override cashItemLabel: string | null;

  /**
   * Android cash item coloring prism information
   */
  public override cashItemColoringPrism: CharacterAndroidCashItemEquipmentColoringPrismDto | null;

  /**
   * Gender compatibility for item equipment
   */
  public override androidItemGender: string | null;

  /**
   * Freestyle Coupon application status (0:not applied, 1:applied)
   */
  public override freestyleFlag: string | null;

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
   * Freestyle Coupon application status
   */
  public get isFreestyleFlag() {
    return this.freestyleFlag === '1';
  }
}

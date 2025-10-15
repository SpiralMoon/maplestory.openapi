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
 * 角色已裝備機器人資訊
 */
export class CharacterAndroidEquipmentDto extends base.CharacterAndroidEquipmentDto {
  /**
   * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
   */
  public override date: Date | null;

  /**
   * 機器人名稱
   */
  public override androidName: string | null;

  /**
   * 機器人暱稱
   */
  public override androidNickname: string | null;

  /**
   * 機器人圖示
   */
  public override androidIcon: string | null;

  /**
   * 機器人道具描述
   */
  public override androidDescription: string | null;

  /**
   * 機器人髮型資訊
   */
  public override androidHair: CharacterAndroidEquipmentHairDto | null;

  /**
   * 機器人臉型資訊
   */
  public override androidFace: CharacterAndroidEquipmentFaceDto | null;

  /**
   * 機器人膚色資訊
   */
  public override androidSkin: CharacterAndroidEquipmentSkinDto | null;

  /**
   * 機器人的已裝備現金道具資訊
   */
  public override androidCashItemEquipment: CharacterAndroidCashItemEquipmentDto[];

  /**
   * 機器人耳飾感應器
   */
  public override androidEarSensorClipFlag: string | null;

  /**
   * 機器人性別
   */
  public override androidGender: string | null;

  /**
   * 機器人階級
   */
  public override androidGrade: string | null;

  /**
   * 非人型機器人
   */
  public override androidNonHumanoidFlag: string | null;

  /**
   * 是否具備雜貨店功能
   */
  public override androidShopUsableFlag: string | null;

  /**
   * 目前套用的道具預設編號
   */
  public override presetNo: number | null;

  /**
   * 預設 1 的機器人資訊
   */
  public override androidPreset1: CharacterAndroidEquipmentPresetDto | null;

  /**
   * 預設 2 的機器人資訊
   */
  public override androidPreset2: CharacterAndroidEquipmentPresetDto | null;

  /**
   * 預設 3 的機器人資訊
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
 * 機器人臉型資訊
 */
export class CharacterAndroidEquipmentFaceDto extends base.CharacterAndroidEquipmentFaceDto {
  /**
   * 機器人臉型名稱
   */
  public override faceName: string | null;

  /**
   * 機器人臉型基本顏色
   */
  public override baseColor: string | null;

  /**
   * 機器人臉型混染顏色
   */
  public override mixColor: string | null;

  /**
   * 機器人臉型混染顏色比例
   */
  public override mixRate: string;

  constructor(obj: CharacterAndroidEquipmentFaceBody) {
    super();

    const { face_name, base_color, mix_color, mix_rate } = obj;

    this.faceName = face_name;
    this.baseColor = base_color;
    this.mixColor = mix_color;
    this.mixRate = mix_rate;
  }
}

/**
 * 機器人髮型資訊
 */
export class CharacterAndroidEquipmentHairDto extends base.CharacterAndroidEquipmentHairDto {
  /**
   * 機器人髮型名稱
   */
  public override hairName: string | null;

  /**
   * 機器人髮型基本顏色
   */
  public override baseColor: string | null;

  /**
   * 機器人髮型混染顏色
   */
  public override mixColor: string | null;

  /**
   * 機器人髮型混染顏色比例
   */
  public override mixRate: string;

  constructor(obj: CharacterAndroidEquipmentHairBody) {
    super();

    const { hair_name, base_color, mix_color, mix_rate } = obj;

    this.hairName = hair_name;
    this.baseColor = base_color;
    this.mixColor = mix_color;
    this.mixRate = mix_rate;
  }
}

/**
 * 機器人膚色資訊
 */
export class CharacterAndroidEquipmentSkinDto extends base.CharacterAndroidEquipmentSkinDto {
  /**
   * 膚色名稱
   */
  public override skinName: string;

  /**
   * 色系
   */
  public override colorStyle: string | null;

  /**
   * 膚色色調
   */
  public override hue: number | null;

  /**
   * 膚色彩度
   */
  public override saturation: number | null;

  /**
   * 膚色明度
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
 * 預設的機器人資訊
 */
export class CharacterAndroidEquipmentPresetDto extends base.CharacterAndroidEquipmentPresetDto {
  /**
   * 機器人名稱
   */
  public override androidName: string;

  /**
   * 機器人暱稱
   */
  public override androidNickname: string;

  /**
   * 機器人圖示
   */
  public override androidIcon: string;

  /**
   * 機器人道具描述
   */
  public override androidDescription: string;

  /**
   * 機器人性別
   */
  public override androidGender: string | null;

  /**
   * 機器人階級
   */
  public override androidGrade: string;

  /**
   *
   * 機器人髮型資訊
   */
  public override androidHair: CharacterAndroidEquipmentHairDto;

  /**
   * 機器人臉型資訊
   */
  public override androidFace: CharacterAndroidEquipmentFaceDto;

  /**
   * 機器人膚色資訊
   */
  public override androidSkin: CharacterAndroidEquipmentSkinDto | null;

  /**
   * 機器人耳飾感應器
   */
  public override androidEarSensorClipFlag: string;

  /**
   * 非人型機器人
   */
  public override androidNonHumanoidFlag: string;

  /**
   * 是否具備雜貨店功能
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
 * 機器人現金道具彩色稜鏡資訊
 */
export class CharacterAndroidCashItemEquipmentColoringPrismDto extends base.CharacterAndroidCashItemEquipmentColoringPrismDto {
  /**
   * 彩色稜鏡顏色範圍
   */
  public override colorRange: string;

  /**
   * 彩色稜鏡色調
   */
  public override hue: number;

  /**
   * 彩色稜鏡彩度
   */
  public override saturation: number;

  /**
   * 彩色稜鏡明度
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
 * 機器人現金道具選項
 */
export class CharacterAndroidCashItemEquipmentOptionDto extends base.CharacterAndroidCashItemEquipmentOptionDto {
  /**
   * 選項類型
   */
  public override optionType: string;

  /**
   * 選項數值
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
 * 機器人的已裝備現金道具資訊
 */
export class CharacterAndroidCashItemEquipmentDto extends base.CharacterAndroidCashItemEquipmentDto {
  /**
   * 機器人現金道具部位名稱
   */
  public override cashItemEquipmentPart: string;

  /**
   * 機器人現金道具欄位位置
   */
  public override cashItemEquipmentSlot: string;

  /**
   * 機器人現金道具名稱
   */
  public override cashItemName: string;

  /**
   * 機器人現金道具圖示
   */
  public override cashItemIcon: string;

  /**
   * 機器人現金道具描述
   */
  public override cashItemDescription: string | null;

  /**
   * 機器人現金道具選項
   */
  public override cashItemOption: CharacterAndroidCashItemEquipmentOptionDto[];

  /**
   * 機器人現金道具有效期間 (TST)
   */
  public override dateExpire: Date | null = null;

  /**
   * Whether the android cash item is expired
   */
  public override isExpired: boolean | null = null;

  /**
   * 機器人現金道具選項有效期間 (TST，時間單位資料中的分鐘顯示為 0)
   */
  public override dateOptionExpire: Date | null = null;

  /**
   * Whether the android cash item option is expired
   */
  public override isOptionExpired: boolean | null = null;

  /**
   * 機器人現金道具標籤資訊 (特殊標籤、紅標籤、黑標籤、大師標籤)
   */
  public override cashItemLabel: string | null;

  /**
   * 機器人現金道具彩色稜鏡資訊
   */
  public override cashItemColoringPrism: CharacterAndroidCashItemEquipmentColoringPrismDto | null;

  /**
   * 道具可裝備性別
   */
  public override androidItemGender: string | null;

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
}

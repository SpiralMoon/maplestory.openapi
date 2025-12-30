import * as base from '../../../common/dto/character/characterBeautyEquipment';
import {
  CharacterBeautyEquipmentBody,
  CharacterBeautyEquipmentFaceBody,
  CharacterBeautyEquipmentHairBody,
  CharacterBeautyEquipmentSkinBody,
} from '../../response/character/characterBeautyEquipmentBody';

/**
 * 角色目前已裝備的髮型、臉型與膚色資訊
 */
export class CharacterBeautyEquipmentDto extends base.CharacterBeautyEquipmentDto {
  /**
   * 要搜尋的日期 (TST)
   */
  public override date: Date | null;

  /**
   * 角色性別
   */
  public override characterGender: string;

  /**
   * 角色職業
   */
  public override characterClass: string;

  /**
   * 角色髮型資訊<br>
   * (神之子為 Alpha、天使破壞者為一般模式時)
   */
  public override characterHair: CharacterBeautyEquipmentHairDto | null;

  /**
   * 角色臉型資訊<br>
   * (神之子為 Alpha、天使破壞者為一般模式時)
   */
  public override characterFace: CharacterBeautyEquipmentFaceDto | null;

  /**
   * 角色膚色資訊<br>
   * (神之子為 Alpha、天使破壞者為一般模式時)
   */
  public override characterSkin: CharacterBeautyEquipmentSkinDto | null;

  /**
   * 神之子為 Beta 及天使破壞者為變裝模式時的目前已裝備髮型資訊
   */
  public override additionalCharacterHair: CharacterBeautyEquipmentHairDto | null;

  /**
   * 神之子為 Beta 及天使破壞者為變裝模式時的目前已裝備臉型資訊
   */
  public override additionalCharacterFace: CharacterBeautyEquipmentFaceDto | null;

  /**
   * 神之子為 Beta 及天使破壞者為變裝模式時的目前已裝備膚色資訊
   */
  public override additionalCharacterSkin: CharacterBeautyEquipmentSkinDto | null;

  constructor(obj: CharacterBeautyEquipmentBody) {
    super();

    const {
      date,
      character_gender,
      character_class,
      character_hair,
      character_face,
      character_skin,
      additional_character_hair,
      additional_character_face,
      additional_character_skin,
    } = obj;

    this.date = date ? new Date(date) : null;
    this.characterGender = character_gender;
    this.characterClass = character_class;
    this.characterHair = character_hair
      ? new CharacterBeautyEquipmentHairDto(character_hair)
      : null;
    this.characterFace = character_face
      ? new CharacterBeautyEquipmentFaceDto(character_face)
      : null;
    this.characterSkin = character_skin
      ? new CharacterBeautyEquipmentSkinDto(character_skin)
      : null;
    this.additionalCharacterHair = additional_character_hair
      ? new CharacterBeautyEquipmentHairDto(additional_character_hair)
      : null;
    this.additionalCharacterFace = additional_character_face
      ? new CharacterBeautyEquipmentFaceDto(additional_character_face)
      : null;
    this.additionalCharacterSkin = additional_character_skin
      ? new CharacterBeautyEquipmentSkinDto(additional_character_skin)
      : null;
  }
}

/**
 * 角色臉型資訊
 */
export class CharacterBeautyEquipmentFaceDto extends base.CharacterBeautyEquipmentFaceDto {
  /**
   * 臉型名稱
   */
  public override faceName: string;

  /**
   * 臉型基本顏色
   */
  public override baseColor: string;

  /**
   * 臉型混染顏色
   */
  public override mixColor: string | null;

  /**
   * 臉型混染顏色比例
   */
  public override mixRate: string;

  /**
   * 自由造型券 使用狀態（0：未使用，1：已使用）
   */
  public override freestyleFlag: string | null;

  constructor(obj: CharacterBeautyEquipmentFaceBody) {
    super();

    const { face_name, base_color, mix_color, mix_rate, freestyle_flag } = obj;

    this.faceName = face_name;
    this.baseColor = base_color;
    this.mixColor = mix_color;
    this.mixRate = mix_rate;
    this.freestyleFlag = freestyle_flag;
  }

  /**
   * 自由造型券 使用狀態
   */
  public get isFreestyleFlag() {
    return this.freestyleFlag === '1';
  }
}

/**
 * 角色髮型資訊
 */
export class CharacterBeautyEquipmentHairDto extends base.CharacterBeautyEquipmentHairDto {
  /**
   * 髮型名稱
   */
  public override hairName: string;

  /**
   * 髮型基本顏色
   */
  public override baseColor: string;

  /**
   * 髮型混染顏色
   */
  public override mixColor: string | null;

  /**
   * 髮型混染顏色比例
   */
  public override mixRate: string;

  /**
   * 自由造型券 使用狀態（0：未使用，1：已使用）
   */
  public override freestyleFlag: string | null;

  constructor(obj: CharacterBeautyEquipmentHairBody) {
    super();

    const { hair_name, base_color, mix_color, mix_rate, freestyle_flag } = obj;

    this.hairName = hair_name;
    this.baseColor = base_color;
    this.mixColor = mix_color;
    this.mixRate = mix_rate;
    this.freestyleFlag = freestyle_flag;
  }

  /**
   * 自由造型券 使用狀態
   */
  public get isFreestyleFlag() {
    return this.freestyleFlag === '1';
  }
}

/**
 * 角色膚色資訊
 */
export class CharacterBeautyEquipmentSkinDto extends base.CharacterBeautyEquipmentSkinDto {
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

  constructor(obj: CharacterBeautyEquipmentSkinBody) {
    super();

    const { skin_name, color_style, hue, saturation, brightness } = obj;

    this.skinName = skin_name;
    this.colorStyle = color_style;
    this.hue = hue;
    this.saturation = saturation;
    this.brightness = brightness;
  }
}

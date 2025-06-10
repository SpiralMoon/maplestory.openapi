import * as base from '../../../common/dto/character/characterBeautyEquipment';
import {
  CharacterBeautyEquipmentBody,
  CharacterBeautyEquipmentFaceBody,
  CharacterBeautyEquipmentHairBody,
  CharacterBeautyEquipmentSkinBody,
} from '../../response/character/characterBeautyEquipmentBody';

/**
 * Character equipped hair, face, and skin information
 */
export class CharacterBeautyEquipmentDto extends base.CharacterBeautyEquipmentDto {
  /**
   * Reference date for query (SGT)
   */
  public override date: Date | null;

  /**
   * Character gender
   */
  public override characterGender: string;

  /**
   * Character job
   */
  public override characterClass: string;

  /**
   * Character hair information<br>
   * (Alpha mode for Zero, Normal mode for Angelic Buster)
   */
  public override characterHair: CharacterBeautyEquipmentHairDto | null;

  /**
   * Character face information<br>
   * (Alpha mode for Zero, Normal mode for Angelic Buster)
   */
  public override characterFace: CharacterBeautyEquipmentFaceDto | null;

  /**
   * Character skin information<br>
   * (Alpha mode for Zero, Normal mode for Angelic Buster)
   */
  public override characterSkin: CharacterBeautyEquipmentSkinDto | null;

  /**
   * Hair information applied in Beta mode for Zero or Dress-up mode for Angelic Buster
   */
  public override additionalCharacterHair: CharacterBeautyEquipmentHairDto | null;

  /**
   * Face information applied in Beta mode for Zero or Dress-up mode for Angelic Buster
   */
  public override additionalCharacterFace: CharacterBeautyEquipmentFaceDto | null;

  /**
   * Skin information applied in Beta mode for Zero or Dress-up mode for Angelic Buster
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
 * Character face information
 */
export class CharacterBeautyEquipmentFaceDto extends base.CharacterBeautyEquipmentFaceDto {
  /**
   * Face name
   */
  public override faceName: string;

  /**
   * Base face color
   */
  public override baseColor: string;

  /**
   * Mixed face color
   */
  public override mixColor: string | null;

  /**
   * Dye ratio for mixed face color
   */
  public override mixRate: string;

  constructor(obj: CharacterBeautyEquipmentFaceBody) {
    super();

    const { face_name, base_color, mix_color, mix_rate } = obj;

    this.faceName = face_name;
    this.baseColor = base_color;
    this.mixColor = mix_color;
    this.mixRate = mix_rate;
  }
}

/**
 * Character hair information
 */
export class CharacterBeautyEquipmentHairDto extends base.CharacterBeautyEquipmentHairDto {
  /**
   * Hair name
   */
  public override hairName: string;

  /**
   * Base hair color
   */
  public override baseColor: string;

  /**
   * Mixed hair color
   */
  public override mixColor: string | null;

  /**
   * Dye ratio for mixed hair color
   */
  public override mixRate: string;

  constructor(obj: CharacterBeautyEquipmentHairBody) {
    super();

    const { hair_name, base_color, mix_color, mix_rate } = obj;

    this.hairName = hair_name;
    this.baseColor = base_color;
    this.mixColor = mix_color;
    this.mixRate = mix_rate;
  }
}

/**
 * Character skin information
 */
export class CharacterBeautyEquipmentSkinDto extends base.CharacterBeautyEquipmentSkinDto {
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

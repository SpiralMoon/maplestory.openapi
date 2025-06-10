import * as base from '../../../common/dto/character/characterBeautyEquipment';
import {
  CharacterBeautyEquipmentBody,
  CharacterBeautyEquipmentFaceBody,
  CharacterBeautyEquipmentHairBody,
  CharacterBeautyEquipmentSkinBody,
} from '../../response/character/characterBeautyEquipmentBody';

/**
 * 캐릭터 헤어, 성형, 피부 정보
 */
export class CharacterBeautyEquipmentDto extends base.CharacterBeautyEquipmentDto {
  /**
   * 조회 기준일
   */
  public override date: Date | null;

  /**
   * 캐릭터 성별
   */
  public override characterGender: string;

  /**
   * 캐릭터 직업
   */
  public override characterClass: string;

  /**
   * 캐릭터 헤어 정보<br>
   * (제로인 경우 알파, 엔젤릭버스터인 경우 일반 모드)
   */
  public override characterHair: CharacterBeautyEquipmentHairDto | null;

  /**
   * 캐릭터 성형 정보<br>
   * (제로인 경우 알파, 엔젤릭버스터인 경우 일반 모드)
   */
  public override characterFace: CharacterBeautyEquipmentFaceDto | null;

  /**
   * 캐릭터 피부 정보<br>
   * (제로인 경우 알파, 엔젤릭버스터인 경우 일반 모드)
   */
  public override characterSkin: CharacterBeautyEquipmentSkinDto | null;

  /**
   * 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에 적용 중인 헤어 정보
   */
  public override additionalCharacterHair: CharacterBeautyEquipmentHairDto | null;

  /**
   * 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에 적용 중인 성형 정보
   */
  public override additionalCharacterFace: CharacterBeautyEquipmentFaceDto | null;

  /**
   * 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에 적용 중인 피부 정보
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
 * 캐릭터 성형 정보
 */
export class CharacterBeautyEquipmentFaceDto extends base.CharacterBeautyEquipmentFaceDto {
  /**
   * 성형 명
   */
  public override faceName: string;

  /**
   * 성형 베이스 컬러
   */
  public override baseColor: string;

  /**
   * 성형 믹스 컬러
   */
  public override mixColor: string | null;

  /**
   * 성형 믹스 컬러의 염색 비율
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
 * 캐릭터 헤어 정보
 */
export class CharacterBeautyEquipmentHairDto extends base.CharacterBeautyEquipmentHairDto {
  /**
   * 헤어 명
   */
  public override hairName: string;

  /**
   * 헤어 베이스 컬러
   */
  public override baseColor: string;

  /**
   * 헤어 믹스 컬러
   */
  public override mixColor: string | null;

  /**
   * 헤어 믹스 컬러의 염색 비율
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
 * 캐릭터 피부 정보
 */
export class CharacterBeautyEquipmentSkinDto extends base.CharacterBeautyEquipmentSkinDto {
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

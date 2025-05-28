import {
  CharacterBeautyEquipmentBody,
  CharacterBeautyEquipmentFaceBody,
  CharacterBeautyEquipmentHairBody,
  CharacterBeautyEquipmentSkinBody,
} from '../../response/character/characterBeautyEquipmentBody';

/**
 * 캐릭터 헤어, 성형, 피부 정보
 */
export class CharacterBeautyEquipmentDto {
  /**
   * 조회 기준일
   */
  date: Date | null;

  /**
   * 캐릭터 성별
   */
  characterGender: string;

  /**
   * 캐릭터 직업
   */
  characterClass: string;

  /**
   * 캐릭터 헤어 정보<br>
   * (제로인 경우 알파, 엔젤릭버스터인 경우 일반 모드)
   */
  characterHair: CharacterBeautyEquipmentHairDto | null;

  /**
   * 캐릭터 성형 정보<br>
   * (제로인 경우 알파, 엔젤릭버스터인 경우 일반 모드)
   */
  characterFace: CharacterBeautyEquipmentFaceDto | null;

  /**
   * 캐릭터 피부 정보<br>
   * (제로인 경우 알파, 엔젤릭버스터인 경우 일반 모드)
   */
  characterSkin: CharacterBeautyEquipmentSkinDto | null;

  /**
   * 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에 적용 중인 헤어 정보
   */
  additionalCharacterHair: CharacterBeautyEquipmentHairDto | null;

  /**
   * 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에 적용 중인 성형 정보
   */
  additionalCharacterFace: CharacterBeautyEquipmentFaceDto | null;

  /**
   * 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에 적용 중인 피부 정보
   */
  additionalCharacterSkin: CharacterBeautyEquipmentSkinDto | null;

  constructor(obj: CharacterBeautyEquipmentBody) {
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
    this.characterHair = character_hair ? new CharacterBeautyEquipmentHairDto(character_hair) : null;
    this.characterFace = character_face ? new CharacterBeautyEquipmentFaceDto(character_face) : null;
    this.characterSkin = character_skin ? new CharacterBeautyEquipmentSkinDto(character_skin) : null;
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
export class CharacterBeautyEquipmentFaceDto {
  /**
   * 성형 명
   */
  faceName: string;

  /**
   * 성형 베이스 컬러
   */
  baseColor: string;

  /**
   * 성형 믹스 컬러
   */
  mixColor: string | null;

  /**
   * 성형 믹스 컬러의 염색 비율
   */
  mixRate: string;

  constructor(obj: CharacterBeautyEquipmentFaceBody) {
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
export class CharacterBeautyEquipmentHairDto {
  /**
   * 헤어 명
   */
  hairName: string;

  /**
   * 헤어 베이스 컬러
   */
  baseColor: string;

  /**
   * 헤어 믹스 컬러
   */
  mixColor: string | null;

  /**
   * 헤어 믹스 컬러의 염색 비율
   */
  mixRate: string;

  constructor(obj: CharacterBeautyEquipmentHairBody) {
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
export class CharacterBeautyEquipmentSkinDto {
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

  constructor(obj: CharacterBeautyEquipmentSkinBody) {
    const { skin_name, color_style, hue, saturation, brightness } = obj;

    this.skinName = skin_name;
    this.colorStyle = color_style;
    this.hue = hue;
    this.saturation = saturation;
    this.brightness = brightness;
  }
}

import {
  CharacterAndroidEquipmentHairDtoBody
} from '@src/maplestory/api/response/character/characterAndroidEquipmentDtoBody';

/**
 * 캐릭터 안드로이드 헤어 정보
 */
class CharacterAndroidEquipmentHairDto {
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

  constructor(obj: CharacterAndroidEquipmentHairDtoBody) {
    const { hair_name, base_color, mix_color, mix_rate } = obj;

    this.hairName = hair_name;
    this.baseColor = base_color;
    this.mixColor = mix_color;
    this.mixRate = mix_rate;
  }
}

export { CharacterAndroidEquipmentHairDto };

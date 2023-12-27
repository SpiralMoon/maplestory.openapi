import { CharacterBeautyEquipmentHairDtoBody } from '../response/characterBeautyEquipmentDtoBody';

/**
 * 캐릭터 헤어 정보
 */
class CharacterBeautyEquipmentHairDto {
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
  mixColor: string;

  /**
   * 헤어 믹스 컬러의 염색 비율
   */
  mixRate: string;

  constructor(obj: CharacterBeautyEquipmentHairDtoBody) {
    const { hair_name, base_color, mix_color, mix_rate } = obj;

    this.hairName = hair_name;
    this.baseColor = base_color;
    this.mixColor = mix_color;
    this.mixRate = mix_rate;
  }
}

export { CharacterBeautyEquipmentHairDto };

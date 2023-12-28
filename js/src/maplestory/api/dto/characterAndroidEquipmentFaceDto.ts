import { CharacterAndroidEquipmentFaceDtoBody } from '../response/characterAndroidEquipmentDtoBody';

/**
 * 캐릭터 안드로이드 성형 정보
 */
class CharacterAndroidEquipmentFaceDto {
  /**
   * 안드로이드 성형 명
   */
  faceName: string;

  /**
   * 안드로이드 성형 베이스 컬러
   */
  baseColor: string;

  /**
   * 안드로이드 성형 믹스 컬러
   */
  mixColor: string | null;

  /**
   * 안드로이드 성형 믹스 컬러의 염색 비율
   */
  mixRate: string;

  constructor(obj: CharacterAndroidEquipmentFaceDtoBody) {
    const { face_name, base_color, mix_color, mix_rate } = obj;

    this.faceName = face_name;
    this.baseColor = base_color;
    this.mixColor = mix_color;
    this.mixRate = mix_rate;
  }
}

export { CharacterAndroidEquipmentFaceDto };

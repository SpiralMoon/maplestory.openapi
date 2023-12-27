import { CharacterAndroidCashItemEquipmentColoringPrismDtoBody } from '../response/characterAndroidEquipmentDtoBody';

/**
 * 캐릭터 안드로이드 캐시 아이템 컬러링프리즘 정보
 */
class CharacterAndroidCashItemEquipmentColoringPrismDto {
  /**
   * 컬러링프리즘 색상 범위
   */
  colorRange: string;

  /**
   * 컬러링프리즘 색조
   */
  hue: number;

  /**
   * 컬러링프리즘 채도
   */
  saturation: number;

  /**
   * 컬러링프리즘 명도
   */
  value: number;

  constructor(obj: CharacterAndroidCashItemEquipmentColoringPrismDtoBody) {
    const { color_range, hue, saturation, value } = obj;

    this.colorRange = color_range;
    this.hue = hue;
    this.saturation = saturation;
    this.value = value;
  }
}

export { CharacterAndroidCashItemEquipmentColoringPrismDto };

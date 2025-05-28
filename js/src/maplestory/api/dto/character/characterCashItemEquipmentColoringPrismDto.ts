import {
  CharacterCashItemEquipmentColoringPrismBody
} from '../../response/character/characterCashItemEquipmentBody';

/**
 * 캐릭터 캐시 장비 컬러링프리즘
 */
class CharacterCashItemEquipmentColoringPrismDto {
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

  constructor(obj: CharacterCashItemEquipmentColoringPrismBody) {
    const { color_range, hue, saturation, value } = obj;

    this.colorRange = color_range;
    this.hue = hue;
    this.saturation = saturation;
    this.value = value;
  }
}

export { CharacterCashItemEquipmentColoringPrismDto };

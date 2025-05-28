import {
  CharacterBeautyEquipmentSkinBody,
} from '../../response/character/characterBeautyEquipmentBody';

/**
 * 캐릭터 피부 정보
 */
class CharacterBeautyEquipmentSkinDto {
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

export { CharacterBeautyEquipmentSkinDto };

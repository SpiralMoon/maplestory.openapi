import {
  CharacterAndroidCashItemEquipmentOptionDtoBody
} from '../../response/character/characterAndroidEquipmentDtoBody';

/**
 * 캐릭터 안드로이드 캐시 아이템 옵션 정보
 */
class CharacterAndroidCashItemEquipmentOptionDto {
  /**
   * 옵션 타입
   */
  optionType: string;

  /**
   * 옵션 값
   */
  optionValue: string;

  constructor(obj: CharacterAndroidCashItemEquipmentOptionDtoBody) {
    const { option_type, option_value } = obj;

    this.optionType = option_type;
    this.optionValue = option_value;
  }
}

export { CharacterAndroidCashItemEquipmentOptionDto };

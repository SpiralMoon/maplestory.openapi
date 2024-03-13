import {
  CharacterCashItemEquipmentOptionDtoBody
} from '@src/maplestory/api/response/character/characterCashItemEquipmentDtoBody';

/**
 * 캐릭터 캐시 장비 옵션
 */
class CharacterCashItemEquipmentOptionDto {
  /**
   * 옵션 타입
   */
  optionType: string;

  /**
   * 옵션 값
   */
  optionValue: string;

  constructor(obj: CharacterCashItemEquipmentOptionDtoBody) {
    const { option_type, option_value } = obj;

    this.optionType = option_type;
    this.optionValue = option_value;
  }
}

export { CharacterCashItemEquipmentOptionDto };

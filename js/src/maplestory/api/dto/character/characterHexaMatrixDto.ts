import { CharacterHexaMatrixEquipmentDto } from './characterHexaMatrixEquipmentDto';
import { CharacterHexaMatrixBody } from '../../response/character/characterHexaMatrixBody';

/**
 * 캐릭터 HEXA 코어 정보
 */
class CharacterHexaMatrixDto {
  /**
   * 조회 기준일
   */
  date: Date | null;

  /**
   * HEXA 코어 정보
   */
  characterHexaCoreEquipment: CharacterHexaMatrixEquipmentDto[];

  constructor(obj: CharacterHexaMatrixBody) {
    const { date, character_hexa_core_equipment } = obj;

    this.date = date ? new Date(date) : null;
    this.characterHexaCoreEquipment = character_hexa_core_equipment?.map(
      (equipment) => new CharacterHexaMatrixEquipmentDto(equipment),
    ) ?? [];
  }
}

export { CharacterHexaMatrixDto };

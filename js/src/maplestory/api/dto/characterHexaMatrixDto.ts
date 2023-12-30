import { CharacterHexaMatrixEquipmentDto } from './characterHexaMatrixEquipmentDto';
import { CharacterHexaMatrixDtoBody } from '../response/characterHexaMatrixDtoBody';

/**
 * 캐릭터 HEXA 코어 정보
 */
class CharacterHexaMatrixDto {
  /**
   * 조회 기준일
   */
  date: Date;

  /**
   * HEXA 코어 정보
   */
  characterHexaCoreEquipment: CharacterHexaMatrixEquipmentDto[] | null;

  constructor(obj: CharacterHexaMatrixDtoBody) {
    const { date, character_hexa_core_equipment } = obj;

    this.date = new Date(date);
    this.characterHexaCoreEquipment = character_hexa_core_equipment.map(
      (equipment) => new CharacterHexaMatrixEquipmentDto(equipment),
    );
  }
}

export { CharacterHexaMatrixDto };

import { CharacterHexaMatrixEquipmentDto } from '@src/maplestory/api/dto/character/characterHexaMatrixEquipmentDto';
import { CharacterHexaMatrixDtoBody } from '@src/maplestory/api/response/character/characterHexaMatrixDtoBody';

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
  characterHexaCoreEquipment: CharacterHexaMatrixEquipmentDto[] | null;

  constructor(obj: CharacterHexaMatrixDtoBody) {
    const { date, character_hexa_core_equipment } = obj;

    this.date = date ? new Date(date) : null;
    this.characterHexaCoreEquipment = character_hexa_core_equipment.map(
      (equipment) => new CharacterHexaMatrixEquipmentDto(equipment),
    );
  }
}

export { CharacterHexaMatrixDto };

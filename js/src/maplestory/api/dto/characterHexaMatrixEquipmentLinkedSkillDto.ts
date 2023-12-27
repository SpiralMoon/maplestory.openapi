import { CharacterHexaMatrixEquipmentLinkedSkillDtoBody } from '../response/characterHexaMatrixDtoBody';

/**
 * 연결된 HEXA 스킬 정보
 */
class CharacterHexaMatrixEquipmentLinkedSkillDto {
  /**
   * HEXA 스킬 명
   */
  hexaSkillId: string;

  constructor(obj: CharacterHexaMatrixEquipmentLinkedSkillDtoBody) {
    const { hexa_skill_id } = obj;

    this.hexaSkillId = hexa_skill_id;
  }
}

export { CharacterHexaMatrixEquipmentLinkedSkillDto };

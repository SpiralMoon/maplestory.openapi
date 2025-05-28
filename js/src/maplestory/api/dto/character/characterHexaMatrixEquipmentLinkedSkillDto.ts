import { CharacterHexaMatrixEquipmentLinkedSkillBody } from '../../response/character/characterHexaMatrixBody';

/**
 * 연결된 HEXA 스킬 정보
 */
class CharacterHexaMatrixEquipmentLinkedSkillDto {
  /**
   * HEXA 스킬 명
   */
  hexaSkillId: string;

  constructor(obj: CharacterHexaMatrixEquipmentLinkedSkillBody) {
    const { hexa_skill_id } = obj;

    this.hexaSkillId = hexa_skill_id;
  }
}

export { CharacterHexaMatrixEquipmentLinkedSkillDto };

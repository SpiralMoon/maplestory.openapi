import { CharacterHexaMatrixEquipmentLinkedSkillDto } from './characterHexaMatrixEquipmentLinkedSkillDto';
import { CharacterHexaMatrixEquipmentDtoBody } from '../response/characterHexaMatrixDtoBody';

/**
 * 캐릭터 HEXA 코어 정보
 */
class CharacterHexaMatrixEquipmentDto {
  /**
   * 코어 명
   */
  hexaCoreName: string;

  /**
   * 코어 레벨
   */
  hexaCoreLevel: number;

  /**
   * 코어 타입
   */
  hexaCoreType: string;

  /**
   * 연결된 스킬 목록
   */
  linkedSkill: CharacterHexaMatrixEquipmentLinkedSkillDto[];

  constructor(obj: CharacterHexaMatrixEquipmentDtoBody) {
    const { hexa_core_name, hexa_core_level, hexa_core_type, linked_skill } =
      obj;

    this.hexaCoreName = hexa_core_name;
    this.hexaCoreLevel = hexa_core_level;
    this.hexaCoreType = hexa_core_type;
    this.linkedSkill = linked_skill.map(
      (skill) => new CharacterHexaMatrixEquipmentLinkedSkillDto(skill),
    );
  }
}

export { CharacterHexaMatrixEquipmentDto };

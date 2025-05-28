import {
  CharacterHexaMatrixBody,
  CharacterHexaMatrixEquipmentBody,
  CharacterHexaMatrixEquipmentLinkedSkillBody,
} from '../../response/character/characterHexaMatrixBody';

/**
 * 캐릭터 HEXA 코어 정보
 */
export class CharacterHexaMatrixDto {
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

/**
 * 연결된 HEXA 스킬 정보
 */
export class CharacterHexaMatrixEquipmentLinkedSkillDto {
  /**
   * HEXA 스킬 명
   */
  hexaSkillId: string;

  constructor(obj: CharacterHexaMatrixEquipmentLinkedSkillBody) {
    const { hexa_skill_id } = obj;

    this.hexaSkillId = hexa_skill_id;
  }
}

/**
 * 캐릭터 HEXA 코어 정보
 */
export class CharacterHexaMatrixEquipmentDto {
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

  constructor(obj: CharacterHexaMatrixEquipmentBody) {
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

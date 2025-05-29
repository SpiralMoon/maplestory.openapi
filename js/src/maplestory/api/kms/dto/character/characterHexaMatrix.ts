import * as base from '../../../common/dto/character/characterHexaMatrix';
import {
  CharacterHexaMatrixBody,
  CharacterHexaMatrixEquipmentBody,
  CharacterHexaMatrixEquipmentLinkedSkillBody,
} from '../../response/character/characterHexaMatrixBody';

/**
 * 캐릭터 HEXA 코어 정보
 */
export class CharacterHexaMatrixDto extends base.CharacterHexaMatrixDto {
  /**
   * 조회 기준일
   */
  public override date: Date | null;

  /**
   * HEXA 코어 정보
   */
  public override characterHexaCoreEquipment: CharacterHexaMatrixEquipmentDto[];

  constructor(obj: CharacterHexaMatrixBody) {
    super();

    const { date, character_hexa_core_equipment } = obj;

    this.date = date ? new Date(date) : null;
    this.characterHexaCoreEquipment =
      character_hexa_core_equipment?.map(
        (equipment) => new CharacterHexaMatrixEquipmentDto(equipment),
      ) ?? [];
  }
}

/**
 * 연결된 HEXA 스킬 정보
 */
export class CharacterHexaMatrixEquipmentLinkedSkillDto extends base.CharacterHexaMatrixEquipmentLinkedSkillDto {
  /**
   * HEXA 스킬 명
   */
  public override hexaSkillId: string;

  constructor(obj: CharacterHexaMatrixEquipmentLinkedSkillBody) {
    super();

    const { hexa_skill_id } = obj;

    this.hexaSkillId = hexa_skill_id;
  }
}

/**
 * 캐릭터 HEXA 코어 정보
 */
export class CharacterHexaMatrixEquipmentDto extends base.CharacterHexaMatrixEquipmentDto {
  /**
   * 코어 명
   */
  public override hexaCoreName: string;

  /**
   * 코어 레벨
   */
  public override hexaCoreLevel: number;

  /**
   * 코어 타입
   */
  public override hexaCoreType: string;

  /**
   * 연결된 스킬 목록
   */
  public override linkedSkill: CharacterHexaMatrixEquipmentLinkedSkillDto[];

  constructor(obj: CharacterHexaMatrixEquipmentBody) {
    super();

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

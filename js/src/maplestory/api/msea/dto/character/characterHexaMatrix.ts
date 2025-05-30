import * as base from '../../../common/dto/character/characterHexaMatrix';
import {
  CharacterHexaMatrixBody,
  CharacterHexaMatrixEquipmentBody,
  CharacterHexaMatrixEquipmentLinkedSkillBody,
} from '../../response/character/characterHexaMatrixBody';

/**
 * Character HEXA Node information
 */
export class CharacterHexaMatrixDto extends base.CharacterHexaMatrixDto {
  /**
   * Reference date for query (SGT, daily data with hours and minutes set to 0)
   */
  public override date: Date | null;

  /**
   * HEXA Node information
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
 * Linked skill
 */
export class CharacterHexaMatrixEquipmentLinkedSkillDto extends base.CharacterHexaMatrixEquipmentLinkedSkillDto {
  /**
   * HEXA Skill name
   */
  public override hexaSkillId: string;

  constructor(obj: CharacterHexaMatrixEquipmentLinkedSkillBody) {
    super();

    const { hexa_skill_id } = obj;

    this.hexaSkillId = hexa_skill_id;
  }
}

/**
 * HEXA Node information
 */
export class CharacterHexaMatrixEquipmentDto extends base.CharacterHexaMatrixEquipmentDto {
  /**
   * Node name
   */
  public override hexaCoreName: string;

  /**
   * Node level
   */
  public override hexaCoreLevel: number;

  /**
   * Node type
   */
  public override hexaCoreType: string;

  /**
   * Linked skill
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

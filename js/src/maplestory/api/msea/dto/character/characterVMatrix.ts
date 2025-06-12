import * as base from '../../../common/dto/character/characterVMatrix';
import {
  CharacterVMatrixBody,
  CharacterVMatrixCoreEquipmentDtoBody,
} from '../../response/character/characterVMatrixBody';

/**
 * Character V Matrix information
 */
export class CharacterVMatrixDto extends base.CharacterVMatrixDto {
  /**
   * Reference date for query (SGT, daily data with hours and minutes set to 0)
   */
  public override date: Date | null;

  /**
   * Character job
   */
  public override characterClass: string | null;

  /**
   * V Matrix Node information
   */
  public override characterVCoreEquipment: CharacterVMatrixCodeEquipmentDto[];

  /**
   * Remaining Matrix enhancement points for the character
   */
  public override characterVMatrixRemainSlotUpgradePoint: number | null;

  constructor(obj: CharacterVMatrixBody) {
    super();

    const {
      date,
      character_class,
      character_v_core_equipment,
      character_v_matrix_remain_slot_upgrade_point,
    } = obj;

    this.date = date ? new Date(date) : null;
    this.characterClass = character_class;
    this.characterVCoreEquipment = character_v_core_equipment.map(
      (equipment) => new CharacterVMatrixCodeEquipmentDto(equipment),
    );
    this.characterVMatrixRemainSlotUpgradePoint =
      character_v_matrix_remain_slot_upgrade_point;
  }
}

/**
 * V Matrix Node information
 */
export class CharacterVMatrixCodeEquipmentDto extends base.CharacterVMatrixCodeEquipmentDto {
  /**
   * Slot index
   */
  public override slotId: string;

  /**
   * Slot level
   */
  public override slotLevel: number;

  /**
   * Node name
   */
  public override vCoreName: string | null;

  /**
   * Node type
   */
  public override vCoreType: string | null;

  /**
   * Node level
   */
  public override vCoreLevel: number;

  /**
   * Name of the skill that corresponds to the node
   */
  public override vCoreSkill1: string;

  /**
   * Name of the second skill that corresponds to the node (for Boost Nodes)
   */
  public override vCoreSkill2: string | null;

  /**
   * Name of the third skill that corresponds to the node (for Boost Nodes)
   */
  public override vCoreSkill3: string | null;

  constructor(obj: CharacterVMatrixCoreEquipmentDtoBody) {
    super();

    const {
      slot_id,
      slot_level,
      v_core_name,
      v_core_type,
      v_core_level,
      v_core_skill_1,
      v_core_skill_2,
      v_core_skill_3,
    } = obj;

    this.slotId = slot_id;
    this.slotLevel = slot_level;
    this.vCoreName = v_core_name;
    this.vCoreType = v_core_type;
    this.vCoreLevel = v_core_level;
    this.vCoreSkill1 = v_core_skill_1;
    this.vCoreSkill2 = v_core_skill_2;
    this.vCoreSkill3 = v_core_skill_3;
  }
}

import * as base from '../../../common/dto/character/characterVMatrix';
import {
  CharacterVMatrixBody,
  CharacterVMatrixCoreEquipmentDtoBody,
} from '../../response/character/characterVMatrixBody';

/**
 * 角色 V 矩陣欄位資訊與已裝備 V 核心資訊
 */
export class CharacterVMatrixDto extends base.CharacterVMatrixDto {
  /**
   * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
   */
  public override date: Date | null;

  /**
   * 角色職業
   */
  public override characterClass: string | null;

  /**
   * V 核心資訊
   */
  public override characterVCoreEquipment: CharacterVMatrixCodeEquipmentDto[];

  /**
   * 角色剩餘的矩陣強化點數
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
 * V 核心資訊
 */
export class CharacterVMatrixCodeEquipmentDto extends base.CharacterVMatrixCodeEquipmentDto {
  /**
   * 欄位索引
   */
  public override slotId: string;

  /**
   * 欄位等級
   */
  public override slotLevel: number;

  /**
   * 核心名稱
   */
  public override vCoreName: string | null;

  /**
   * 核心類型
   */
  public override vCoreType: string | null;

  /**
   * 核心等級
   */
  public override vCoreLevel: number;

  /**
   * 對應核心的技能名稱
   */
  public override vCoreSkill1: string;

  /**
   * (若為強化核心) 對應核心的第二個技能名稱
   */
  public override vCoreSkill2: string | null;

  /**
   * (若為強化核心) 對應核心的第三個技能名稱
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

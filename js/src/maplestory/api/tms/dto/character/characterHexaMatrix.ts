import * as base from '../../../common/dto/character/characterHexaMatrix';
import {
  CharacterHexaMatrixBody,
  CharacterHexaMatrixEquipmentBody,
  CharacterHexaMatrixEquipmentLinkedSkillBody,
} from '../../response/character/characterHexaMatrixBody';

/**
 * 角色已裝備於 HEXA 矩陣的 HEXA 核心資訊
 */
export class CharacterHexaMatrixDto extends base.CharacterHexaMatrixDto {
  /**
   * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
   */
  public override date: Date | null;

  /**
   * HEXA 核心資訊
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
 * 已連接的技能
 */
export class CharacterHexaMatrixEquipmentLinkedSkillDto extends base.CharacterHexaMatrixEquipmentLinkedSkillDto {
  /**
   * HEXA 技能名稱
   */
  public override hexaSkillId: string;

  constructor(obj: CharacterHexaMatrixEquipmentLinkedSkillBody) {
    super();

    const { hexa_skill_id } = obj;

    this.hexaSkillId = hexa_skill_id;
  }
}

/**
 * HEXA 核心資訊
 */
export class CharacterHexaMatrixEquipmentDto extends base.CharacterHexaMatrixEquipmentDto {
  /**
   * 核心名稱
   */
  public override hexaCoreName: string;

  /**
   * 核心等級
   */
  public override hexaCoreLevel: number;

  /**
   * 核心類型
   */
  public override hexaCoreType: string;

  /**
   * 已連接的技能
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

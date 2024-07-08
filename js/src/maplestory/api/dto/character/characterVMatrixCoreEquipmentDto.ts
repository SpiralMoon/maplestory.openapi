import { CharacterVMatrixCoreEquipmentDtoBody } from '@src/maplestory/api/response/character/characterVMatrixDtoBody';

/**
 * 캐릭터 V코어 정보
 */
class CharacterVMatrixCodeEquipmentDto {
  /**
   * 슬롯 인덱스
   */
  slotId: string;

  /**
   * 슬롯 레벨
   */
  slotLevel: number;

  /**
   * 코어 명
   */
  vCoreName: string | null;

  /**
   * 코어 타입
   */
  vCoreType: string | null;

  /**
   * 코어 레벨
   */
  vCoreLevel: number;

  /**
   * 코어에 해당하는 스킬 명
   */
  vCoreSkill1: string;

  /**
   * (강화 코어인 경우) 코어에 해당하는 두 번째 스킬 명
   */
  vCoreSkill2: string | null;

  /**
   * (강화 코어인 경우) 코어에 해당하는 세 번째 스킬 명
   */
  vCoreSkill3: string | null;

  constructor(obj: CharacterVMatrixCoreEquipmentDtoBody) {
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

export { CharacterVMatrixCodeEquipmentDto };

import * as base from '../../../common/dto/character/characterVMatrix';
import {
  CharacterVMatrixBody,
  CharacterVMatrixCoreEquipmentDtoBody,
  CharacterVMatrixCoreEquipmentPresetBody,
} from '../../response/character/characterVMatrixBody';

/**
 * 캐릭터 V매트릭스 정보
 */
export class CharacterVMatrixDto extends base.CharacterVMatrixDto {
  /**
   * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
   */
  public override date: Date | null;

  /**
   * 캐릭터 직업
   */
  public override characterClass: string;

  /**
   * V코어 정보
   */
  public override characterVCoreEquipment: CharacterVMatrixCodeEquipmentDto[];

  /**
   * 캐릭터 잔여 매트릭스 강화 포인트
   */
  public override characterVMatrixRemainSlotUpgradePoint: number;

  /**
   * 프리셋 1의 V코어 정보
   */
  public characterVCoreEquipmentPreset1: CharacterVMatrixCoreEquipmentPresetDto[];

  /**
   * 프리셋 2의 V코어 정보
   */
  public characterVCoreEquipmentPreset2: CharacterVMatrixCoreEquipmentPresetDto[];

  /**
   * 프리셋 3의 V코어 정보
   */
  public characterVCoreEquipmentPreset3: CharacterVMatrixCoreEquipmentPresetDto[];

  /**
   * 프리셋 4의 V코어 정보
   */
  public characterVCoreEquipmentPreset4: CharacterVMatrixCoreEquipmentPresetDto[];

  /**
   * 프리셋 5의 V코어 정보
   */
  public characterVCoreEquipmentPreset5: CharacterVMatrixCoreEquipmentPresetDto[];

  constructor(obj: CharacterVMatrixBody) {
    super();

    const {
      date,
      character_class,
      character_v_core_equipment,
      character_v_matrix_remain_slot_upgrade_point,
      character_v_core_equipment_preset_1,
      character_v_core_equipment_preset_2,
      character_v_core_equipment_preset_3,
      character_v_core_equipment_preset_4,
      character_v_core_equipment_preset_5,
    } = obj;

    this.date = date ? new Date(date) : null;
    this.characterClass = character_class!;
    this.characterVCoreEquipment = character_v_core_equipment.map(
      (equipment) => new CharacterVMatrixCodeEquipmentDto(equipment),
    );
    this.characterVMatrixRemainSlotUpgradePoint =
      character_v_matrix_remain_slot_upgrade_point!;
    this.characterVCoreEquipmentPreset1 = (character_v_core_equipment_preset_1 ?? []).map((core) => new CharacterVMatrixCoreEquipmentPresetDto(core));
    this.characterVCoreEquipmentPreset2 = (character_v_core_equipment_preset_2 ?? []).map((core) => new CharacterVMatrixCoreEquipmentPresetDto(core));
    this.characterVCoreEquipmentPreset3 = (character_v_core_equipment_preset_3 ?? []).map((core) => new CharacterVMatrixCoreEquipmentPresetDto(core));
    this.characterVCoreEquipmentPreset4 = (character_v_core_equipment_preset_4 ?? []).map((core) => new CharacterVMatrixCoreEquipmentPresetDto(core));
    this.characterVCoreEquipmentPreset5 = (character_v_core_equipment_preset_5 ?? []).map((core) => new CharacterVMatrixCoreEquipmentPresetDto(core));
  }
}

/**
 * 캐릭터 V코어 프리셋 정보
 */
export class CharacterVMatrixCoreEquipmentPresetDto {
  /**
   * 코어 명
   */
  public vCoreName: string | null;

  /**
   * 코어 타입
   */
  public vCoreType: string | null;

  /**
   * 코어의 레벨
   */
  public vCoreLevel: number;

  constructor(obj: CharacterVMatrixCoreEquipmentPresetBody) {
    const { v_core_name, v_core_type, v_core_level } = obj;

    this.vCoreName = v_core_name;
    this.vCoreType = v_core_type;
    this.vCoreLevel = v_core_level;
  }
}

/**
 * 캐릭터 V코어 정보
 */
export class CharacterVMatrixCodeEquipmentDto extends base.CharacterVMatrixCodeEquipmentDto {
  /**
   * 슬롯 인덱스
   */
  public override slotId: string;

  /**
   * 슬롯 레벨
   * @deprecated 2025년 12월 18일 점검 이후부터 사용하지 않는 항목입니다.
   */
  public override slotLevel: number;

  /**
   * 코어 명
   */
  public override vCoreName: string | null;

  /**
   * 코어 타입
   */
  public override vCoreType: string | null;

  /**
   * 코어 레벨
   */
  public override vCoreLevel: number;

  /**
   * 코어에 해당하는 스킬 명
   * @deprecated 2025년 12월 18일 점검 이후부터 사용하지 않는 항목입니다.
   */
  public override vCoreSkill1: string | null;

  /**
   * (강화 코어인 경우) 코어에 해당하는 두 번째 스킬 명
   * @deprecated 2025년 12월 18일 점검 이후부터 사용하지 않는 항목입니다.
   */
  public override vCoreSkill2: string | null;

  /**
   * (강화 코어인 경우) 코어에 해당하는 세 번째 스킬 명
   * @deprecated 2025년 12월 18일 점검 이후부터 사용하지 않는 항목입니다.
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

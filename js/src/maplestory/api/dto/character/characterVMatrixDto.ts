import { CharacterVMatrixCodeEquipmentDto } from './characterVMatrixCoreEquipmentDto';
import { CharacterVMatrixDtoBody } from '../../response/character/characterVMatrixDtoBody';

/**
 * 캐릭터 V매트릭스 정보
 */
class CharacterVMatrixDto {
  /**
   * 조회 기준일
   */
  date: Date | null;

  /**
   * 캐릭터 직업
   */
  characterClass: string | null;

  /**
   * V코어 정보
   */
  characterVCoreEquipment: CharacterVMatrixCodeEquipmentDto[];

  /**
   * 캐릭터 잔여 매트릭스 강화 포인트
   */
  characterVMatrixRemainSlotUpgradePoint: number | null;

  constructor(obj: CharacterVMatrixDtoBody) {
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

export { CharacterVMatrixDto };

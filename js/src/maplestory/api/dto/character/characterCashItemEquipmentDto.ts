import {
  CharacterCashItemEquipmentPresetDto
} from '@src/maplestory/api/dto/character/characterCashItemEquipmentPresetDto';
import {
  CharacterCashItemEquipmentDtoBody
} from '@src/maplestory/api/response/character/characterCashItemEquipmentDtoBody';

/**
 * 캐릭터 캐시 장비 아이템 정보
 */
class CharacterCashItemEquipmentDto {
  /**
   * 조회 기준일
   */
  date: Date;

  /**
   * 캐릭터 성별
   */
  characterGender: string;

  /**
   * 캐릭터 직업
   */
  characterClass: string;

  /**
   * 적용 중인 캐시 장비 프리셋 번호
   */
  presetNo: number;

  /**
   * 장착 중인 캐시 장비
   */
  cashItemEquipmentBase: CharacterCashItemEquipmentPresetDto[];

  /**
   * 1번 코디 프리셋
   */
  cashItemEquipmentPreset1: CharacterCashItemEquipmentPresetDto[];

  /**
   * 2번 코디 프리셋
   */
  cashItemEquipmentPreset2: CharacterCashItemEquipmentPresetDto[];

  /**
   * 3번 코디 프리셋
   */
  cashItemEquipmentPreset3: CharacterCashItemEquipmentPresetDto[];

  /**
   * 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에서 장착 중인 캐시 장비
   */
  additionalCashItemEquipmentBase: CharacterCashItemEquipmentPresetDto[];

  /**
   * 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드의 1번 코디 프리셋
   */
  additionalCashItemEquipmentPreset1: CharacterCashItemEquipmentPresetDto[];

  /**
   * 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드의 2번 코디 프리셋
   */
  additionalCashItemEquipmentPreset2: CharacterCashItemEquipmentPresetDto[];

  /**
   * 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드의 3번 코디 프리셋
   */
  additionalCashItemEquipmentPreset3: CharacterCashItemEquipmentPresetDto[];

  constructor(obj: CharacterCashItemEquipmentDtoBody) {
    const {
      date,
      character_gender,
      character_class,
      preset_no,
      cash_item_equipment_base,
      cash_item_equipment_preset_1,
      cash_item_equipment_preset_2,
      cash_item_equipment_preset_3,
      additional_cash_item_equipment_base,
      additional_cash_item_equipment_preset_1,
      additional_cash_item_equipment_preset_2,
      additional_cash_item_equipment_preset_3,
    } = obj;

    this.date = new Date(date);
    this.characterGender = character_gender;
    this.characterClass = character_class;
    this.presetNo = preset_no;
    this.cashItemEquipmentBase = cash_item_equipment_base.map(
      (preset) => new CharacterCashItemEquipmentPresetDto(preset),
    );
    this.cashItemEquipmentPreset1 = cash_item_equipment_preset_1.map(
      (preset) => new CharacterCashItemEquipmentPresetDto(preset),
    );
    this.cashItemEquipmentPreset2 = cash_item_equipment_preset_2.map(
      (preset) => new CharacterCashItemEquipmentPresetDto(preset),
    );
    this.cashItemEquipmentPreset3 = cash_item_equipment_preset_3.map(
      (preset) => new CharacterCashItemEquipmentPresetDto(preset),
    );
    this.additionalCashItemEquipmentBase =
      additional_cash_item_equipment_base.map(
        (preset) => new CharacterCashItemEquipmentPresetDto(preset),
      );
    this.additionalCashItemEquipmentPreset1 =
      additional_cash_item_equipment_preset_1.map(
        (preset) => new CharacterCashItemEquipmentPresetDto(preset),
      );
    this.additionalCashItemEquipmentPreset2 =
      additional_cash_item_equipment_preset_2.map(
        (preset) => new CharacterCashItemEquipmentPresetDto(preset),
      );
    this.additionalCashItemEquipmentPreset3 =
      additional_cash_item_equipment_preset_3.map(
        (preset) => new CharacterCashItemEquipmentPresetDto(preset),
      );
  }
}

export { CharacterCashItemEquipmentDto };

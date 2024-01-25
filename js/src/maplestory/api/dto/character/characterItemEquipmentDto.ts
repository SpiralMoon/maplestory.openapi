import { CharacterItemEquipmentInfoDto } from './characterItemEquipmentInfoDto';
import { CharacterItemEquipmentTitleDto } from './characterItemEquipmentTitleDto';
import { CharacterItemEquipmentDtoBody } from '../../response/character/characterItemEquipmentDtoBody';
import { CharacterItemEquipmentDragonInfoDto } from './characterItemEquipmentDragonInfoDto'
import { CharacterItemEquipmentMechanicInfoDto } from './characterItemEquipmentMechanicInfoDto'

/**
 * 캐릭터 장비 아이템 정보
 */
class CharacterItemEquipmentDto {
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
   * 적용 중인 장비 프리셋 번호
   */
  presetNo: number | null;

  /**
   * 장비 정보
   */
  itemEquipment: CharacterItemEquipmentInfoDto[];

  /**
   * 1번 프리셋 장비 정보
   */
  itemEquipmentPreset1: CharacterItemEquipmentInfoDto[] | null;

  /**
   * 2번 프리셋 장비 정보
   */
  itemEquipmentPreset2: CharacterItemEquipmentInfoDto[] | null;

  /**
   * 3번 프리셋 장비 정보
   */
  itemEquipmentPreset3: CharacterItemEquipmentInfoDto[] | null;

  /**
   * 칭호 정보
   */
  title: CharacterItemEquipmentTitleDto | null;

  /**
   * 에반 드래곤 장비 정보 (에반인 경우 응답)
   */
  dragonEquipment: CharacterItemEquipmentDragonInfoDto[];

  /**
   * 메카닉 장비 정보 (메카닉인 경우 응답)
   */
  mechanicEquipment: CharacterItemEquipmentMechanicInfoDto[];

  constructor(obj: CharacterItemEquipmentDtoBody) {
    const {
      date,
      character_gender,
      character_class,
      preset_no,
      item_equipment,
      item_equipment_preset_1,
      item_equipment_preset_2,
      item_equipment_preset_3,
      title,
      dragon_equipment,
      mechanic_equipment,
    } = obj;

    this.date = new Date(date);
    this.characterGender = character_gender;
    this.characterClass = character_class;
    this.presetNo = preset_no;
    this.itemEquipment = item_equipment.map(
      (equipment) => new CharacterItemEquipmentInfoDto(equipment),
    );
    this.itemEquipmentPreset1 = item_equipment_preset_1 ? item_equipment_preset_1.map(
      (equipment) => new CharacterItemEquipmentInfoDto(equipment),
    ) : null;
    this.itemEquipmentPreset2 = item_equipment_preset_2 ? item_equipment_preset_2.map(
      (equipment) => new CharacterItemEquipmentInfoDto(equipment),
    ): null;
    this.itemEquipmentPreset3 = item_equipment_preset_3 ? item_equipment_preset_3.map(
      (equipment) => new CharacterItemEquipmentInfoDto(equipment),
    ): null;
    this.title = title ? new CharacterItemEquipmentTitleDto(title) : null;
    this.dragonEquipment = dragon_equipment.map(
      (equipment) => new CharacterItemEquipmentDragonInfoDto(equipment),
    );
    this.mechanicEquipment = mechanic_equipment.map(
      (equipment) => new CharacterItemEquipmentMechanicInfoDto(equipment),
    );
  }
}

export { CharacterItemEquipmentDto };

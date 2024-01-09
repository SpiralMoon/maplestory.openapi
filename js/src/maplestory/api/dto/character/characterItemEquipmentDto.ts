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
   * 장비 정보 배열
   */
  itemEquipment: CharacterItemEquipmentInfoDto[];

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
      item_equipment,
      title,
      dragon_equipment,
      mechanic_equipment,
    } = obj;

    this.date = new Date(date);
    this.characterGender = character_gender;
    this.characterClass = character_class;
    this.itemEquipment = item_equipment.map(
      (equipment) => new CharacterItemEquipmentInfoDto(equipment),
    );
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

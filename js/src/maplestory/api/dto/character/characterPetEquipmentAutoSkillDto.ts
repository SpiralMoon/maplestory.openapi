import { CharacterPetEquipmentAutoSkillBody } from '../../response/character/characterPetEquipmentBody';

/**
 * 캐릭터 펫 장비 자동 스킬 정보
 */
class CharacterPetEquipmentAutoSkillDto {
  /**
   * 첫 번째 슬롯에 등록된 자동 스킬
   */
  skill1: string | null;

  /**
   * 첫 번째 슬롯에 등록된 자동 아이콘
   */
  skill1Icon: string | null;

  /**
   * 두 번째 슬롯에 등록된 자동 스킬
   */
  skill2: string | null;

  /**
   * 두 번째 슬롯에 등록된 자동 아이콘
   */
  skill2Icon: string | null;

  constructor(obj: CharacterPetEquipmentAutoSkillBody) {
    const { skill_1, skill_1_icon, skill_2, skill_2_icon } = obj;

    this.skill1 = skill_1;
    this.skill1Icon = skill_1_icon;
    this.skill2 = skill_2;
    this.skill2Icon = skill_2_icon;
  }
}

export { CharacterPetEquipmentAutoSkillDto };

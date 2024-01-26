import { CharacterPetEquipmentAutoSkillDto } from './characterPetEquipmentAutoSkillDto';
import { CharacterPetEquipmentItemDto } from './characterPetEquipmentItemDto';
import { CharacterPetEquipmentDtoBody } from '../../response/character/characterPetEquipmentDtoBody';

/**
 * 캐릭터 펫 장비 정보
 */
class CharacterPetEquipmentDto {
  /**
   * 조회 기준일
   */
  date: Date;

  /**
   * 펫1 명
   */
  pet1Name: string | null;

  /**
   * 펫1 닉네임
   */
  pet1Nickname: string | null;

  /**
   * 펫1 아이콘
   */
  pet1Icon: string | null;

  /**
   * 펫1 설명
   */
  pet1Description: string | null;

  /**
   * 펫1 장착 정보
   */
  pet1Equipment: CharacterPetEquipmentItemDto | null;

  /**
   * 펫1 펫 버프 자동스킬 정보
   */
  pet1AutoSkill: CharacterPetEquipmentAutoSkillDto | null;

  /**
   * 펫1 원더 펫 종류
   */
  pet1PetType: string | null;

  /**
   * 펫1 펫 보유 스킬
   */
  pet1Skill: string[];

  /**
   * 펫1 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
   */
  pet1DateExpire: Date | null;

  /**
   * 펫1 외형
   */
  pet1Appearance: string | null;

  /**
   * 펫1 외형 아이콘
   */
  pet1AppearanceIcon: string | null;

  /**
   * 펫2 명
   */
  pet2Name: string | null;

  /**
   * 펫2 닉네임
   */
  pet2Nickname: string | null;

  /**
   * 펫2 아이콘
   */
  pet2Icon: string | null;

  /**
   * 펫2 설명
   */
  pet2Description: string | null;

  /**
   * 펫2 장착 정보
   */
  pet2Equipment: CharacterPetEquipmentItemDto | null;

  /**
   * 펫2 펫 버프 자동스킬 정보
   */
  pet2AutoSkill: CharacterPetEquipmentAutoSkillDto | null;

  /**
   * 펫2 원더 펫 종류
   */
  pet2PetType: string | null;

  /**
   * 펫2 펫 보유 스킬
   */
  pet2Skill: string[];

  /**
   * 펫2 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
   */
  pet2DateExpire: Date | null;

  /**
   * 펫2 외형
   */
  pet2Appearance: string | null;

  /**
   * 펫2 외형 아이콘
   */
  pet2AppearanceIcon: string | null;

  /**
   * 펫3 명
   */
  pet3Name: string | null;

  /**
   * 펫3 닉네임
   */
  pet3Nickname: string | null;

  /**
   * 펫3 아이콘
   */
  pet3Icon: string | null;

  /**
   * 펫3 설명
   */
  pet3Description: string | null;

  /**
   * 펫3 장착 정보
   */
  pet3Equipment: CharacterPetEquipmentItemDto | null;

  /**
   * 펫3 펫 버프 자동스킬 정보
   */
  pet3AutoSkill: CharacterPetEquipmentAutoSkillDto | null;

  /**
   * 펫3 원더 펫 종류
   */
  pet3PetType: string | null;

  /**
   * 펫3 펫 보유 스킬
   */
  pet3Skill: string[];

  /**
   * 펫3 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
   */
  pet3DateExpire: Date | null;

  /**
   * 펫3 외형
   */
  pet3Appearance: string | null;

  /**
   * 펫3 외형 아이콘
   */
  pet3AppearanceIcon: string | null;

  constructor(obj: CharacterPetEquipmentDtoBody) {
    const {
      date,
      pet_1_name,
      pet_1_nickname,
      pet_1_icon,
      pet_1_description,
      pet_1_equipment,
      pet_1_auto_skill,
      pet_1_pet_type,
      pet_1_skill,
      pet_1_date_expire,
      pet_1_appearance,
      pet_1_appearance_icon,
      pet_2_name,
      pet_2_nickname,
      pet_2_icon,
      pet_2_description,
      pet_2_equipment,
      pet_2_auto_skill,
      pet_2_pet_type,
      pet_2_skill,
      pet_2_date_expire,
      pet_2_appearance,
      pet_2_appearance_icon,
      pet_3_name,
      pet_3_nickname,
      pet_3_icon,
      pet_3_description,
      pet_3_equipment,
      pet_3_auto_skill,
      pet_3_pet_type,
      pet_3_skill,
      pet_3_date_expire,
      pet_3_appearance,
      pet_3_appearance_icon,
    } = obj;

    this.date = new Date(date);
    this.pet1Name = pet_1_name;
    this.pet1Nickname = pet_1_nickname;
    this.pet1Icon = pet_1_icon;
    this.pet1Description = pet_1_description;
    this.pet1Equipment = pet_1_equipment ? new CharacterPetEquipmentItemDto(pet_1_equipment) : null;
    this.pet1AutoSkill = pet_1_auto_skill ? new CharacterPetEquipmentAutoSkillDto(
      pet_1_auto_skill,
    ) : null;
    this.pet1PetType = pet_1_pet_type;
    this.pet1Skill = pet_1_skill;
    this.pet1DateExpire = pet_1_date_expire ? new Date(pet_1_date_expire) : null;
    this.pet1Appearance = pet_1_appearance;
    this.pet1AppearanceIcon = pet_1_appearance_icon;
    this.pet2Name = pet_2_name;
    this.pet2Nickname = pet_2_nickname;
    this.pet2Icon = pet_2_icon;
    this.pet2Description = pet_2_description;
    this.pet2Equipment = pet_2_equipment ? new CharacterPetEquipmentItemDto(pet_2_equipment) : null;
    this.pet2AutoSkill = pet_2_auto_skill ? new CharacterPetEquipmentAutoSkillDto(
      pet_2_auto_skill,
    ) : null;
    this.pet2PetType = pet_2_pet_type;
    this.pet2Skill = pet_2_skill;
    this.pet2DateExpire = pet_2_date_expire ? new Date(pet_2_date_expire) : null;
    this.pet2Appearance = pet_2_appearance;
    this.pet2AppearanceIcon = pet_2_appearance_icon;
    this.pet3Name = pet_3_name;
    this.pet3Nickname = pet_3_nickname;
    this.pet3Icon = pet_3_icon;
    this.pet3Description = pet_3_description;
    this.pet3Equipment = pet_3_equipment ? new CharacterPetEquipmentItemDto(pet_3_equipment) : null;
    this.pet3AutoSkill = pet_3_auto_skill ? new CharacterPetEquipmentAutoSkillDto(
      pet_3_auto_skill,
    ) : null;
    this.pet3PetType = pet_3_pet_type;
    this.pet3Skill = pet_3_skill;
    this.pet3DateExpire = pet_3_date_expire ? new Date(pet_3_date_expire) : null;
    this.pet3Appearance = pet_3_appearance;
    this.pet3AppearanceIcon = pet_3_appearance_icon;
  }
}

export { CharacterPetEquipmentDto };

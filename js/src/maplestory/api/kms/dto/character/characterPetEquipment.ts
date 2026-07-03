import * as base from '../../../common/dto/character/characterPetEquipment';
import {
  CharacterPetEquipmentAutoSkillBody,
  CharacterPetEquipmentBody,
  CharacterPetEquipmentItemBody,
  CharacterPetEquipmentItemOptionBody,
  CharacterPetEquipmentPetiteLunaPetSkillBody,
} from '../../response/character/characterPetEquipmentBody';

/**
 * 캐릭터 펫 장비 정보
 */
export class CharacterPetEquipmentDto extends base.CharacterPetEquipmentDto {
  /**
   * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
   */
  public override date: Date | null;

  /**
   * 활성화된 펫 유형 (0:캐릭터 펫, 1:월드 공유 펫)
   */
  public petActivateFlag: string | null;

  /**
   * 펫1 명
   */
  public override pet1Name: string | null;

  /**
   * 펫1 닉네임
   */
  public override pet1Nickname: string | null;

  /**
   * 펫1 아이콘
   */
  public override pet1Icon: string | null;

  /**
   * 펫1 설명
   */
  public override pet1Description: string | null;

  /**
   * 펫1 장착 정보
   */
  public override pet1Equipment: CharacterPetEquipmentItemDto | null;

  /**
   * 펫1 펫 버프 자동스킬 정보
   */
  public override pet1AutoSkill: CharacterPetEquipmentAutoSkillDto | null;

  /**
   * 펫1 원더 펫 종류
   */
  public override pet1PetType: string | null;

  /**
   * 펫1 펫 보유 스킬
   */
  public override pet1Skill: string[];

  /**
   * 펫1 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
   */
  public override pet1DateExpire: Date | null = null;

  /**
   * 펫1 마법의 시간 만료 여부
   */
  public override pet1Expired: boolean | null = null;

  /**
   * 펫1 외형
   */
  public override pet1Appearance: string | null;

  /**
   * 펫1 외형 아이콘
   */
  public override pet1AppearanceIcon: string | null;

  /**
   * 펫2 명
   */
  public override pet2Name: string | null;

  /**
   * 펫2 닉네임
   */
  public override pet2Nickname: string | null;

  /**
   * 펫2 아이콘
   */
  public override pet2Icon: string | null;

  /**
   * 펫2 설명
   */
  public override pet2Description: string | null;

  /**
   * 펫2 장착 정보
   */
  public override pet2Equipment: CharacterPetEquipmentItemDto | null;

  /**
   * 펫2 펫 버프 자동스킬 정보
   */
  public override pet2AutoSkill: CharacterPetEquipmentAutoSkillDto | null;

  /**
   * 펫2 원더 펫 종류
   */
  public override pet2PetType: string | null;

  /**
   * 펫2 펫 보유 스킬
   */
  public override pet2Skill: string[];

  /**
   * 펫2 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
   */
  public override pet2DateExpire: Date | null = null;

  /**
   * 펫2 마법의 시간 만료 여부
   */
  public override pet2Expired: boolean | null = null;

  /**
   * 펫2 외형
   */
  public override pet2Appearance: string | null;

  /**
   * 펫2 외형 아이콘
   */
  public override pet2AppearanceIcon: string | null;

  /**
   * 펫3 명
   */
  public override pet3Name: string | null;

  /**
   * 펫3 닉네임
   */
  public override pet3Nickname: string | null;

  /**
   * 펫3 아이콘
   */
  public override pet3Icon: string | null;

  /**
   * 펫3 설명
   */
  public override pet3Description: string | null;

  /**
   * 펫3 장착 정보
   */
  public override pet3Equipment: CharacterPetEquipmentItemDto | null;

  /**
   * 펫3 펫 버프 자동스킬 정보
   */
  public override pet3AutoSkill: CharacterPetEquipmentAutoSkillDto | null;

  /**
   * 펫3 원더 펫 종류
   */
  public override pet3PetType: string | null;

  /**
   * 펫3 펫 보유 스킬
   */
  public override pet3Skill: string[];

  /**
   * 펫3 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
   */
  public override pet3DateExpire: Date | null = null;

  /**
   * 펫3 마법의 시간 만료 여부
   */
  public override pet3Expired: boolean | null = null;

  /**
   * 펫3 외형
   */
  public override pet3Appearance: string | null;

  /**
   * 펫3 외형 아이콘
   */
  public override pet3AppearanceIcon: string | null;

  /**
   * 월드 공유 펫1 명
   */
  public worldSharePet1Name: string | null;

  /**
   * 월드 공유 펫1 닉네임
   */
  public worldSharePet1Nickname: string | null;

  /**
   * 월드 공유 펫1 아이콘
   */
  public worldSharePet1Icon: string | null;

  /**
   * 월드 공유 펫1 설명
   */
  public worldSharePet1Description: string | null;

  /**
   * 월드 공유 펫1 원더 펫 종류
   */
  public worldSharePet1PetType: string | null;

  /**
   * 월드 공유 펫1 장착 정보
   */
  public worldSharePet1Equipment: CharacterPetEquipmentItemDto | null;

  /**
   * 월드 공유 펫1 버프 자동스킬 정보
   */
  public worldSharePet1AutoSkill: CharacterPetEquipmentAutoSkillDto | null;

  /**
   * 월드 공유 펫1 펫 보유 스킬
   */
  public worldSharePet1Skill: string[];

  /**
   * 월드 공유 펫1 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
   */
  public worldSharePet1DateExpire: Date | null;

  /**
   * 월드 공유 펫1 외형 명
   */
  public worldSharePet1Appearance: string | null;

  /**
   * 월드 공유 펫1 외형 아이콘
   */
  public worldSharePet1AppearanceIcon: string | null;

  /**
   * 월드 공유 펫2 명
   */
  public worldSharePet2Name: string | null;

  /**
   * 월드 공유 펫2 닉네임
   */
  public worldSharePet2Nickname: string | null;

  /**
   * 월드 공유 펫2 아이콘
   */
  public worldSharePet2Icon: string | null;

  /**
   * 월드 공유 펫2 설명
   */
  public worldSharePet2Description: string | null;

  /**
   * 월드 공유 펫2 원더 펫 종류
   */
  public worldSharePet2PetType: string | null;

  /**
   * 월드 공유 펫2 장착 정보
   */
  public worldSharePet2Equipment: CharacterPetEquipmentItemDto | null;

  /**
   * 월드 공유 펫2 버프 자동스킬 정보
   */
  public worldSharePet2AutoSkill: CharacterPetEquipmentAutoSkillDto | null;

  /**
   * 월드 공유 펫2 펫 보유 스킬
   */
  public worldSharePet2Skill: string[];

  /**
   * 월드 공유 펫2 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
   */
  public worldSharePet2DateExpire: Date | null;

  /**
   * 월드 공유 펫2 외형 명
   */
  public worldSharePet2Appearance: string | null;

  /**
   * 월드 공유 펫2 외형 아이콘
   */
  public worldSharePet2AppearanceIcon: string | null;

  /**
   * 월드 공유 펫3 명
   */
  public worldSharePet3Name: string | null;

  /**
   * 월드 공유 펫3 닉네임
   */
  public worldSharePet3Nickname: string | null;

  /**
   * 월드 공유 펫3 아이콘
   */
  public worldSharePet3Icon: string | null;

  /**
   * 월드 공유 펫3 설명
   */
  public worldSharePet3Description: string | null;

  /**
   * 월드 공유 펫3 원더 펫 종류
   */
  public worldSharePet3PetType: string | null;

  /**
   * 월드 공유 펫3 장착 정보
   */
  public worldSharePet3Equipment: CharacterPetEquipmentItemDto | null;

  /**
   * 월드 공유 펫3 버프 자동스킬 정보
   */
  public worldSharePet3AutoSkill: CharacterPetEquipmentAutoSkillDto | null;

  /**
   * 월드 공유 펫3 펫 보유 스킬
   */
  public worldSharePet3Skill: string[];

  /**
   * 월드 공유 펫3 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
   */
  public worldSharePet3DateExpire: Date | null;

  /**
   * 월드 공유 펫3 외형 명
   */
  public worldSharePet3Appearance: string | null;

  /**
   * 월드 공유 펫3 외형 아이콘
   */
  public worldSharePet3AppearanceIcon: string | null;

  /**
   * 루나 쁘띠 펫 스킬 정보
   */
  public petiteLunaPetSkill: CharacterPetEquipmentPetiteLunaPetSkillDto[];

  constructor(obj: CharacterPetEquipmentBody) {
    super();

    const {
      date,
      pet_activate_flag,
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
      world_share_pet_1_name,
      world_share_pet_1_nickname,
      world_share_pet_1_icon,
      world_share_pet_1_description,
      world_share_pet_1_pet_type,
      world_share_pet_1_equipment,
      world_share_pet_1_auto_skill,
      world_share_pet_1_skill,
      world_share_pet_1_date_expire,
      world_share_pet_1_appearance,
      world_share_pet_1_appearance_icon,
      world_share_pet_2_name,
      world_share_pet_2_nickname,
      world_share_pet_2_icon,
      world_share_pet_2_description,
      world_share_pet_2_pet_type,
      world_share_pet_2_equipment,
      world_share_pet_2_auto_skill,
      world_share_pet_2_skill,
      world_share_pet_2_date_expire,
      world_share_pet_2_appearance,
      world_share_pet_2_appearance_icon,
      world_share_pet_3_name,
      world_share_pet_3_nickname,
      world_share_pet_3_icon,
      world_share_pet_3_description,
      world_share_pet_3_pet_type,
      world_share_pet_3_equipment,
      world_share_pet_3_auto_skill,
      world_share_pet_3_skill,
      world_share_pet_3_date_expire,
      world_share_pet_3_appearance,
      world_share_pet_3_appearance_icon,
      petite_luna_pet_skill,
    } = obj;

    this.date = date ? new Date(date) : null;
    this.petActivateFlag = pet_activate_flag;
    this.pet1Name = pet_1_name;
    this.pet1Nickname = pet_1_nickname;
    this.pet1Icon = pet_1_icon;
    this.pet1Description = pet_1_description;
    this.pet1Equipment = pet_1_equipment
      ? new CharacterPetEquipmentItemDto(pet_1_equipment)
      : null;
    this.pet1AutoSkill = pet_1_auto_skill
      ? new CharacterPetEquipmentAutoSkillDto(pet_1_auto_skill)
      : null;
    this.pet1PetType = pet_1_pet_type;
    this.pet1Skill = pet_1_skill;
    this.pet1Appearance = pet_1_appearance;
    this.pet1AppearanceIcon = pet_1_appearance_icon;
    this.pet2Name = pet_2_name;
    this.pet2Nickname = pet_2_nickname;
    this.pet2Icon = pet_2_icon;
    this.pet2Description = pet_2_description;
    this.pet2Equipment = pet_2_equipment
      ? new CharacterPetEquipmentItemDto(pet_2_equipment)
      : null;
    this.pet2AutoSkill = pet_2_auto_skill
      ? new CharacterPetEquipmentAutoSkillDto(pet_2_auto_skill)
      : null;
    this.pet2PetType = pet_2_pet_type;
    this.pet2Skill = pet_2_skill;
    this.pet2Appearance = pet_2_appearance;
    this.pet2AppearanceIcon = pet_2_appearance_icon;
    this.pet3Name = pet_3_name;
    this.pet3Nickname = pet_3_nickname;
    this.pet3Icon = pet_3_icon;
    this.pet3Description = pet_3_description;
    this.pet3Equipment = pet_3_equipment
      ? new CharacterPetEquipmentItemDto(pet_3_equipment)
      : null;
    this.pet3AutoSkill = pet_3_auto_skill
      ? new CharacterPetEquipmentAutoSkillDto(pet_3_auto_skill)
      : null;
    this.pet3PetType = pet_3_pet_type;
    this.pet3Skill = pet_3_skill;
    this.pet3Appearance = pet_3_appearance;
    this.pet3AppearanceIcon = pet_3_appearance_icon;

    if (pet_1_date_expire === 'expired') {
      this.pet1Expired = true;
    } else if (typeof pet_1_date_expire === 'string') {
      this.pet1DateExpire = pet_1_date_expire
        ? new Date(pet_1_date_expire)
        : null;
    }

    if (pet_2_date_expire === 'expired') {
      this.pet2Expired = true;
    } else if (typeof pet_2_date_expire === 'string') {
      this.pet2DateExpire = pet_2_date_expire
        ? new Date(pet_2_date_expire)
        : null;
    }

    if (pet_3_date_expire === 'expired') {
      this.pet3Expired = true;
    } else if (typeof pet_3_date_expire === 'string') {
      this.pet3DateExpire = pet_3_date_expire
        ? new Date(pet_3_date_expire)
        : null;
    }

    this.worldSharePet1Name = world_share_pet_1_name;
    this.worldSharePet1Nickname = world_share_pet_1_nickname;
    this.worldSharePet1Icon = world_share_pet_1_icon;
    this.worldSharePet1Description = world_share_pet_1_description;
    this.worldSharePet1PetType = world_share_pet_1_pet_type;
    this.worldSharePet1Equipment = world_share_pet_1_equipment
      ? new CharacterPetEquipmentItemDto(world_share_pet_1_equipment)
      : null;
    this.worldSharePet1AutoSkill = world_share_pet_1_auto_skill
      ? new CharacterPetEquipmentAutoSkillDto(world_share_pet_1_auto_skill)
      : null;
    this.worldSharePet1Skill = world_share_pet_1_skill;
    this.worldSharePet1DateExpire = world_share_pet_1_date_expire
      ? new Date(world_share_pet_1_date_expire)
      : null;
    this.worldSharePet1Appearance = world_share_pet_1_appearance;
    this.worldSharePet1AppearanceIcon = world_share_pet_1_appearance_icon;

    this.worldSharePet2Name = world_share_pet_2_name;
    this.worldSharePet2Nickname = world_share_pet_2_nickname;
    this.worldSharePet2Icon = world_share_pet_2_icon;
    this.worldSharePet2Description = world_share_pet_2_description;
    this.worldSharePet2PetType = world_share_pet_2_pet_type;
    this.worldSharePet2Equipment = world_share_pet_2_equipment
      ? new CharacterPetEquipmentItemDto(world_share_pet_2_equipment)
      : null;
    this.worldSharePet2AutoSkill = world_share_pet_2_auto_skill
      ? new CharacterPetEquipmentAutoSkillDto(world_share_pet_2_auto_skill)
      : null;
    this.worldSharePet2Skill = world_share_pet_2_skill;
    this.worldSharePet2DateExpire = world_share_pet_2_date_expire
      ? new Date(world_share_pet_2_date_expire)
      : null;
    this.worldSharePet2Appearance = world_share_pet_2_appearance;
    this.worldSharePet2AppearanceIcon = world_share_pet_2_appearance_icon;

    this.worldSharePet3Name = world_share_pet_3_name;
    this.worldSharePet3Nickname = world_share_pet_3_nickname;
    this.worldSharePet3Icon = world_share_pet_3_icon;
    this.worldSharePet3Description = world_share_pet_3_description;
    this.worldSharePet3PetType = world_share_pet_3_pet_type;
    this.worldSharePet3Equipment = world_share_pet_3_equipment
      ? new CharacterPetEquipmentItemDto(world_share_pet_3_equipment)
      : null;
    this.worldSharePet3AutoSkill = world_share_pet_3_auto_skill
      ? new CharacterPetEquipmentAutoSkillDto(world_share_pet_3_auto_skill)
      : null;
    this.worldSharePet3Skill = world_share_pet_3_skill;
    this.worldSharePet3DateExpire = world_share_pet_3_date_expire
      ? new Date(world_share_pet_3_date_expire)
      : null;
    this.worldSharePet3Appearance = world_share_pet_3_appearance;
    this.worldSharePet3AppearanceIcon = world_share_pet_3_appearance_icon;

    this.petiteLunaPetSkill = (petite_luna_pet_skill ?? []).map(
      (skill) => new CharacterPetEquipmentPetiteLunaPetSkillDto(skill),
    );
  }
}

/**
 * 캐릭터 펫 장비 자동 스킬 정보
 */
export class CharacterPetEquipmentAutoSkillDto extends base.CharacterPetEquipmentAutoSkillDto {
  /**
   * 첫 번째 슬롯에 등록된 자동 스킬
   */
  public override skill1: string | null;

  /**
   * 첫 번째 슬롯에 등록된 자동 아이콘
   */
  public override skill1Icon: string | null;

  /**
   * 두 번째 슬롯에 등록된 자동 스킬
   */
  public override skill2: string | null;

  /**
   * 두 번째 슬롯에 등록된 자동 아이콘
   */
  public override skill2Icon: string | null;

  constructor(obj: CharacterPetEquipmentAutoSkillBody) {
    super();

    const { skill_1, skill_1_icon, skill_2, skill_2_icon } = obj;

    this.skill1 = skill_1;
    this.skill1Icon = skill_1_icon;
    this.skill2 = skill_2;
    this.skill2Icon = skill_2_icon;
  }
}

/**
 * 캐릭터 펫 장비 아이템 옵션 정보
 */
export class CharacterPetEquipmentItemOptionDto extends base.CharacterPetEquipmentItemOptionDto {
  /**
   * 옵션 정보
   */
  public override optionType: string;

  /**
   * 옵션 값
   */
  public override optionValue: string;

  constructor(obj: CharacterPetEquipmentItemOptionBody) {
    super();

    const { option_type, option_value } = obj;

    this.optionType = option_type;
    this.optionValue = option_value;
  }
}

/**
 * 캐릭터 펫 루나 쁘띠 펫 스킬 정보
 */
export class CharacterPetEquipmentPetiteLunaPetSkillDto {
  /**
   * 스킬 명
   */
  public skillName: string | null;

  /**
   * 스킬 설명
   */
  public skillDescription: string | null;

  /**
   * 스킬 효과 설명
   */
  public skillEffect: string | null;

  /**
   * 스킬 아이콘
   */
  public skillIcon: string | null;

  constructor(obj: CharacterPetEquipmentPetiteLunaPetSkillBody) {
    const { skill_name, skill_description, skill_effect, skill_icon } = obj;

    this.skillName = skill_name;
    this.skillDescription = skill_description;
    this.skillEffect = skill_effect;
    this.skillIcon = skill_icon;
  }
}

/**
 * 캐릭터 펫 장비 아이템 정보
 */
export class CharacterPetEquipmentItemDto extends base.CharacterPetEquipmentItemDto {
  /**
   * 아이템 명
   */
  public override itemName: string | null;

  /**
   * 아이템 아이콘
   */
  public override itemIcon: string | null;

  /**
   * 아이템 설명
   */
  public override itemDescription: string | null;

  /**
   * 아이템 표기상 옵션
   */
  public override itemOption: CharacterPetEquipmentItemOptionDto[];

  /**
   * 업그레이드 횟수
   */
  public override scrollUpgrade: number;

  /**
   * 업그레이드 가능 횟수
   */
  public override scrollUpgradable: number;

  /**
   * 아이템 외형
   */
  public override itemShape: string | null;

  /**
   * 아이템 외형 아이콘
   */
  public override itemShapeIcon: string | null;

  /**
   * 아이템 만료시간 (KST, 분 단위는 일괄 0으로 표기, null:무제한, -1:미착용)
   */
  public itemDateExpire: Date | null;

  constructor(obj: CharacterPetEquipmentItemBody) {
    super();

    const {
      item_name,
      item_icon,
      item_description,
      item_option,
      scroll_upgrade,
      scroll_upgradable,
      item_shape,
      item_shape_icon,
      item_date_expire,
    } = obj;

    this.itemName = item_name;
    this.itemIcon = item_icon;
    this.itemDescription = item_description;
    this.itemOption = item_option.map(
      (option) => new CharacterPetEquipmentItemOptionDto(option),
    );
    this.scrollUpgrade = scroll_upgrade;
    this.scrollUpgradable = scroll_upgradable;
    this.itemShape = item_shape;
    this.itemShapeIcon = item_shape_icon;
    this.itemDateExpire = item_date_expire ? new Date(item_date_expire) : null;
  }
}

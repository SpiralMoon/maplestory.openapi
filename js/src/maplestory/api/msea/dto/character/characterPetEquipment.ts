import * as base from '../../../common/dto/character/characterPetEquipment';
import {
  CharacterPetEquipmentAutoSkillBody,
  CharacterPetEquipmentBody,
  CharacterPetEquipmentItemBody,
  CharacterPetEquipmentItemOptionBody,
} from '../../response/character/characterPetEquipmentBody';

/**
 * Character equipped pet information
 */
export class CharacterPetEquipmentDto extends base.CharacterPetEquipmentDto {
  /**
   * Reference date for query (SGT, daily data with hours and minutes set to 0)
   */
  public override date: Date | null;

  /**
   * Name of pet 1
   */
  public override pet1Name: string | null;

  /**
   * Nickname of pet 1
   */
  public override pet1Nickname: string | null;

  /**
   * Icon of pet 1
   */
  public override pet1Icon: string | null;

  /**
   * Description of pet 1
   */
  public override pet1Description: string | null;

  /**
   * Equipment information for pet 1
   */
  public override pet1Equipment: CharacterPetEquipmentItemDto | null;

  /**
   * Auto buff skill information for pet 1
   */
  public override pet1AutoSkill: CharacterPetEquipmentAutoSkillDto | null;

  /**
   * Wonder pet type of pet 1
   */
  public override pet1PetType: string | null;

  /**
   * Skills possessed by pet 1
   */
  public override pet1Skill: string[];

  /**
   * Magic time for pet 1 (SGT, data with minutes set to 0)
   */
  public override pet1DateExpire: Date | null = null;

  /**
   * Whether the magic time for pet 1 is expired
   */
  public override pet1Expired: boolean | null = null;

  /**
   * Appearance of pet 1
   */
  public override pet1Appearance: string | null;

  /**
   * Appearance icon of pet 1
   */
  public override pet1AppearanceIcon: string | null;

  /**
   * Name of pet 2
   */
  public override pet2Name: string | null;

  /**
   * Nickname of pet 2
   */
  public override pet2Nickname: string | null;

  /**
   * Icon of pet 2
   */
  public override pet2Icon: string | null;

  /**
   * Description of pet 2
   */
  public override pet2Description: string | null;

  /**
   * Equipment information for pet 2
   */
  public override pet2Equipment: CharacterPetEquipmentItemDto | null;

  /**
   * Auto buff skill information for pet 2
   */
  public override pet2AutoSkill: CharacterPetEquipmentAutoSkillDto | null;

  /**
   * Wonder pet type of pet 2
   */
  public override pet2PetType: string | null;

  /**
   * Skills possessed by pet 2
   */
  public override pet2Skill: string[];

  /**
   * Magic time for pet 2 (SGT, data with minutes set to 0)
   */
  public override pet2DateExpire: Date | null = null;

  /**
   * Whether the magic time for pet 2 is expired
   */
  public override pet2Expired: boolean | null = null;

  /**
   * Appearance of pet 2
   */
  public override pet2Appearance: string | null;

  /**
   * Appearance icon of pet 2
   */
  public override pet2AppearanceIcon: string | null;

  /**
   * Name of pet 3
   */
  public override pet3Name: string | null;

  /**
   * Nickname of pet 3
   */
  public override pet3Nickname: string | null;

  /**
   * Icon of pet 3
   */
  public override pet3Icon: string | null;

  /**
   * Description of pet 3
   */
  public override pet3Description: string | null;

  /**
   * Equipment information for pet 3
   */
  public override pet3Equipment: CharacterPetEquipmentItemDto | null;

  /**
   * Auto buff skill information for pet 3
   */
  public override pet3AutoSkill: CharacterPetEquipmentAutoSkillDto | null;

  /**
   * Wonder pet type of pet 3
   */
  public override pet3PetType: string | null;

  /**
   * Skills possessed by pet 3
   */
  public override pet3Skill: string[];

  /**
   * Magic time for pet 3 (SGT, data with minutes set to 0)
   */
  public override pet3DateExpire: Date | null = null;

  /**
   * Whether the magic time for pet 3 is expired
   */
  public override pet3Expired: boolean | null = null;

  /**
   * Appearance of pet 3
   */
  public override pet3Appearance: string | null;

  /**
   * Appearance icon of pet 3
   */
  public override pet3AppearanceIcon: string | null;

  constructor(obj: CharacterPetEquipmentBody) {
    super();

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

    this.date = date ? new Date(date) : null;
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
  }
}

/**
 * Auto buff skill information for pet
 */
export class CharacterPetEquipmentAutoSkillDto extends base.CharacterPetEquipmentAutoSkillDto {
  /**
   * Auto skill registered in the first slot
   */
  public override skill1: string | null;

  /**
   * Icon for the auto skill in the first slot
   */
  public override skill1Icon: string | null;

  /**
   * Auto skill registered in the second slot
   */
  public override skill2: string | null;

  /**
   * Icon for the auto skill in the second slot
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
 * Displayed pet item options
 */
export class CharacterPetEquipmentItemOptionDto extends base.CharacterPetEquipmentItemOptionDto {
  /**
   * Option type
   */
  public override optionType: string;

  /**
   * Option value
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
 * Equipment information for pet
 */
export class CharacterPetEquipmentItemDto extends base.CharacterPetEquipmentItemDto {
  /**
   * Item name
   */
  public override itemName: string | null;

  /**
   * Item icon
   */
  public override itemIcon: string | null;

  /**
   * Item description
   */
  public override itemDescription: string | null;

  /**
   * Displayed item options
   */
  public override itemOption: CharacterPetEquipmentItemOptionDto[];

  /**
   * Number of upgrades
   */
  public override scrollUpgrade: number;

  /**
   * Number of upgrades available
   */
  public override scrollUpgradable: number;

  /**
   * Item appearance
   */
  public override itemShape: string | null;

  /**
   * Item appearance icon
   */
  public override itemShapeIcon: string | null;

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
  }
}

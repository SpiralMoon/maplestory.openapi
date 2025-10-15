import * as base from '../../../common/dto/character/characterPetEquipment';
import {
  CharacterPetEquipmentAutoSkillBody,
  CharacterPetEquipmentBody,
  CharacterPetEquipmentItemBody,
  CharacterPetEquipmentItemOptionBody,
} from '../../response/character/characterPetEquipmentBody';

/**
 * 角色已裝備寵物資訊
 */
export class CharacterPetEquipmentDto extends base.CharacterPetEquipmentDto {
  /**
   * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
   */
  public override date: Date | null;

  /**
   * 寵物 1 名稱
   */
  public override pet1Name: string | null;

  /**
   * 寵物 1 暱稱
   */
  public override pet1Nickname: string | null;

  /**
   * 寵物 1 圖示
   */
  public override pet1Icon: string | null;

  /**
   * 寵物 1 描述
   */
  public override pet1Description: string | null;

  /**
   * 寵物 1 道具資訊
   */
  public override pet1Equipment: CharacterPetEquipmentItemDto | null;

  /**
   * 寵物 1 的寵物自動加持技能資訊
   */
  public override pet1AutoSkill: CharacterPetEquipmentAutoSkillDto | null;

  /**
   * 寵物 1 神奇寵物類型
   */
  public override pet1PetType: string | null;

  /**
   * 寵物 1 技能
   */
  public override pet1Skill: string[];

  /**
   * 寵物 1 魔法時間 (TST，時間單位資料中的分鐘顯示為 0)
   */
  public override pet1DateExpire: Date | null = null;

  /**
   * Whether the magic time for pet 1 is expired
   */
  public override pet1Expired: boolean | null = null;

  /**
   * 寵物 1 外型
   */
  public override pet1Appearance: string | null;

  /**
   * 寵物 1 外型圖示
   */
  public override pet1AppearanceIcon: string | null;

  /**
   * 寵物 2 名稱
   */
  public override pet2Name: string | null;

  /**
   * 寵物 2 暱稱
   */
  public override pet2Nickname: string | null;

  /**
   * 寵物 2 圖示
   */
  public override pet2Icon: string | null;

  /**
   * 寵物 2 描述
   */
  public override pet2Description: string | null;

  /**
   * 寵物 2 道具資訊
   */
  public override pet2Equipment: CharacterPetEquipmentItemDto | null;

  /**
   * 寵物 2 的寵物自動加持技能資訊
   */
  public override pet2AutoSkill: CharacterPetEquipmentAutoSkillDto | null;

  /**
   * 寵物 2 神奇寵物類型
   */
  public override pet2PetType: string | null;

  /**
   * 寵物 2 技能
   */
  public override pet2Skill: string[];

  /**
   * 寵物 2 魔法時間 (TST，時間單位資料中的分鐘顯示為 0)
   */
  public override pet2DateExpire: Date | null = null;

  /**
   * Whether the magic time for pet 2 is expired
   */
  public override pet2Expired: boolean | null = null;

  /**
   * 寵物 2 外型
   */
  public override pet2Appearance: string | null;

  /**
   * 寵物 2 外型圖示
   */
  public override pet2AppearanceIcon: string | null;

  /**
   * 寵物 3 名稱
   */
  public override pet3Name: string | null;

  /**
   * 寵物 3 暱稱
   */
  public override pet3Nickname: string | null;

  /**
   * 寵物 3 圖示
   */
  public override pet3Icon: string | null;

  /**
   * 寵物 3 描述
   */
  public override pet3Description: string | null;

  /**
   * 寵物 3 道具資訊
   */
  public override pet3Equipment: CharacterPetEquipmentItemDto | null;

  /**
   * 寵物 3 的寵物自動加持技能資訊
   */
  public override pet3AutoSkill: CharacterPetEquipmentAutoSkillDto | null;

  /**
   * 寵物 3 神奇寵物類型
   */
  public override pet3PetType: string | null;

  /**
   * 寵物 3 技能
   */
  public override pet3Skill: string[];

  /**
   * 寵物 3 魔法時間 (TST，時間單位資料中的分鐘顯示為 0)
   */
  public override pet3DateExpire: Date | null = null;

  /**
   * Whether the magic time for pet 3 is expired
   */
  public override pet3Expired: boolean | null = null;

  /**
   * 寵物 3 外型
   */
  public override pet3Appearance: string | null;

  /**
   * 寵物 3 外型圖示
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
 * 寵物的寵物自動加持技能資訊
 */
export class CharacterPetEquipmentAutoSkillDto extends base.CharacterPetEquipmentAutoSkillDto {
  /**
   * 登錄於第一欄位的自動加持技能
   */
  public override skill1: string | null;

  /**
   * 登錄於第一欄位的自動加持技能圖示
   */
  public override skill1Icon: string | null;

  /**
   * 登錄於第二欄位的自動加持技能
   */
  public override skill2: string | null;

  /**
   * 登錄於第二欄位的自動加持技能圖示
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
 * 道具顯示選項
 */
export class CharacterPetEquipmentItemOptionDto extends base.CharacterPetEquipmentItemOptionDto {
  /**
   * 選項類型
   */
  public override optionType: string;

  /**
   * 選項數值
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
 * 寵物道具資訊
 */
export class CharacterPetEquipmentItemDto extends base.CharacterPetEquipmentItemDto {
  /**
   * 道具名稱
   */
  public override itemName: string | null;

  /**
   * 道具圖示
   */
  public override itemIcon: string | null;

  /**
   * 道具描述
   */
  public override itemDescription: string | null;

  /**
   * 道具顯示選項
   */
  public override itemOption: CharacterPetEquipmentItemOptionDto[];

  /**
   * 強化次數
   */
  public override scrollUpgrade: number;

  /**
   * 道具可升級次數
   */
  public override scrollUpgradable: number;

  /**
   * 道具外型
   */
  public override itemShape: string | null;

  /**
   * 道具外型圖示
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

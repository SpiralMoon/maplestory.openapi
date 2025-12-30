import * as base from '../../../common/dto/character/characterItemEquipment';
import {
  CharacterItemEquipmentAddOptionBody,
  CharacterItemEquipmentBaseOptionBody,
  CharacterItemEquipmentBody,
  CharacterItemEquipmentDragonInfoBody,
  CharacterItemEquipmentEtcOptionBody,
  CharacterItemEquipmentExceptionalOptionBody,
  CharacterItemEquipmentInfoBody,
  CharacterItemEquipmentMechanicInfoBody,
  CharacterItemEquipmentMedalShapeBody,
  CharacterItemEquipmentStarforceOptionBody,
  CharacterItemEquipmentTitleBody,
  CharacterItemEquipmentTotalOptionBody,
} from '../../response/character/characterItemEquipmentBody';

/**
 * Character equipped equipment information
 */
export class CharacterItemEquipmentDto extends base.CharacterItemEquipmentDto {
  /**
   * Reference date for query (SGT, daily data with hours and minutes set to 0)
   */
  public override date: Date | null;

  /**
   * Character gender
   */
  public override characterGender: string;

  /**
   * Character job
   */
  public override characterClass: string;

  /**
   * Active equipment preset number
   */
  public override presetNo: number | null;

  /**
   * Equipment information
   */
  public override itemEquipment: CharacterItemEquipmentInfoDto[];

  /**
   * Equipment information for Preset 1
   */
  public override itemEquipmentPreset1: CharacterItemEquipmentInfoDto[];

  /**
   * Equipment information for Preset 2
   */
  public override itemEquipmentPreset2: CharacterItemEquipmentInfoDto[];

  /**
   * Equipment information for Preset 3
   */
  public override itemEquipmentPreset3: CharacterItemEquipmentInfoDto[];

  /**
   * Title information
   */
  public override title: CharacterItemEquipmentTitleDto | null;

  /**
   * Medal appearance information registered in the appearance settings
   */
  public override medalShape: CharacterItemEquipmentMedalShapeDto | null;

  /**
   * Evan Dragon equipment information (response provided if the character is Evan)
   */
  public override dragonEquipment: CharacterItemEquipmentDragonInfoDto[];

  /**
   * Mechanic equipment information (response provided if the character is a Mechanic)
   */
  public override mechanicEquipment: CharacterItemEquipmentMechanicInfoDto[];

  constructor(obj: CharacterItemEquipmentBody) {
    super();

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
      medal_shape,
      dragon_equipment,
      mechanic_equipment,
    } = obj;

    this.date = date ? new Date(date) : null;
    this.characterGender = character_gender!;
    this.characterClass = character_class!;
    this.presetNo = preset_no;
    this.itemEquipment = item_equipment.map(
      (equipment) => new CharacterItemEquipmentInfoDto(equipment),
    );
    this.itemEquipmentPreset1 =
      item_equipment_preset_1?.map(
        (equipment) => new CharacterItemEquipmentInfoDto(equipment),
      ) ?? [];
    this.itemEquipmentPreset2 =
      item_equipment_preset_2?.map(
        (equipment) => new CharacterItemEquipmentInfoDto(equipment),
      ) ?? [];
    this.itemEquipmentPreset3 =
      item_equipment_preset_3?.map(
        (equipment) => new CharacterItemEquipmentInfoDto(equipment),
      ) ?? [];
    this.title = title ? new CharacterItemEquipmentTitleDto(title) : null;
    this.medalShape = medal_shape
      ? new CharacterItemEquipmentMedalShapeDto(medal_shape)
      : null;
    this.dragonEquipment = dragon_equipment.map(
      (equipment) => new CharacterItemEquipmentDragonInfoDto(equipment),
    );
    this.mechanicEquipment = mechanic_equipment.map(
      (equipment) => new CharacterItemEquipmentMechanicInfoDto(equipment),
    );
  }
}

/**
 * Title information
 */
export class CharacterItemEquipmentTitleDto extends base.CharacterItemEquipmentTitleDto {
  /**
   * Title name
   */
  public override titleName: string | null;

  /**
   * Title icon
   */
  public override titleIcon: string | null;

  /**
   * Title description
   */
  public override titleDescription: string | null;

  /**
   * Title validity period (SGT)
   */
  public override dateExpire: Date | null = null;

  /**
   * Whether the title is expired
   */
  public override isExpired: boolean | null = null;

  /**
   * Title option validity period (expired:expired, null unlimited) (SGT)
   */
  public override dateOptionExpire: Date | null = null;

  /**
   * Whether the title option is expired
   */
  public override isOptionExpired: boolean | null = null;

  /**
   * Title equipment name registered in the appearance settings
   */
  public override titleShapeName: string | null;

  /**
   * Title icon registered in the appearance settings
   */
  public override titleShapeIcon: string | null;

  /**
   * Title description registered in the appearance settings
   */
  public override titleShapeDescription: string | null;

  constructor(obj: CharacterItemEquipmentTitleBody) {
    super();

    const {
      title_name,
      title_icon,
      title_description,
      date_expire,
      date_option_expire,
      title_shape_name,
      title_shape_icon,
      title_shape_description,
    } = obj;

    this.titleName = title_name;
    this.titleIcon = title_icon;
    this.titleDescription = title_description;
    this.titleShapeName = title_shape_name;
    this.titleShapeIcon = title_shape_icon;
    this.titleShapeDescription = title_shape_description;

    if (date_expire === 'expired') {
      this.isExpired = true;
    } else if (typeof date_expire === 'string') {
      this.dateExpire = date_expire ? new Date(date_expire) : null;
    }

    if (date_option_expire === 'expired') {
      this.isOptionExpired = true;
    } else if (typeof date_option_expire === 'string') {
      this.dateOptionExpire = date_option_expire
        ? new Date(date_option_expire)
        : null;
    }
  }
}

/**
 * Medal appearance information
 */
export class CharacterItemEquipmentMedalShapeDto extends base.CharacterItemEquipmentMedalShapeDto {
  /**
   * Medal equipment name registered in the appearance settings
   */
  public override medalShapeName: string;

  /**
   * Medal icon registered in the appearance settings
   */
  public override medalShapeIcon: string;

  /**
   * Medal description registered in the appearance settings
   */
  public override medalShapeDescription: string;

  /**
   * Fusion Anvil-applied medal equipment name registered in the appearance settings
   */
  public override medalShapeChangedName: string;

  /**
   * Fusion Anvil-applied medal icon registered in the appearance settings
   */
  public override medalShapeChangedIcon: string;

  /**
   * Fusion Anvil-applied medal description registered in the appearance settings
   */
  public override medalShapeChangedDescription: string;

  constructor(obj: CharacterItemEquipmentMedalShapeBody) {
    super();

    const {
      medal_shape_name,
      medal_shape_icon,
      medal_shape_description,
      medal_shape_changed_name,
      medal_shape_changed_icon,
      medal_shape_changed_description,
    } = obj;

    this.medalShapeName = medal_shape_name;
    this.medalShapeIcon = medal_shape_icon;
    this.medalShapeDescription = medal_shape_description;
    this.medalShapeChangedName = medal_shape_changed_name;
    this.medalShapeChangedIcon = medal_shape_changed_icon;
    this.medalShapeChangedDescription = medal_shape_changed_description;
  }
}

/**
 * Additional equipment options
 */
export class CharacterItemEquipmentAddOptionDto extends base.CharacterItemEquipmentAddOptionDto {
  /**
   * STR
   */
  public override str: string;

  /**
   * DEX
   */
  public override dex: string;

  /**
   * INT
   */
  public override int: string;

  /**
   * LUK
   */
  public override luk: string;

  /**
   * Max HP
   */
  public override maxHp: string;

  /**
   * Max MP
   */
  public override maxMp: string;

  /**
   * Attack Power
   */
  public override attackPower: string;

  /**
   * Magic ATT
   */
  public override magicPower: string;

  /**
   * Defense
   */
  public override armor: string;

  /**
   * Speed
   */
  public override speed: string;

  /**
   * Jump
   */
  public override jump: string;

  /**
   * Boss Damage (%)
   */
  public override bossDamage: string;

  /**
   * Damage (%)
   */
  public override damage: string;

  /**
   * All Stats (%)
   */
  public override allStat: string;

  /**
   * Equipment level decrease
   */
  public override equipmentLevelDecrease: number;

  constructor(obj: CharacterItemEquipmentAddOptionBody) {
    super();

    const {
      str,
      dex,
      int,
      luk,
      max_hp,
      max_mp,
      attack_power,
      magic_power,
      armor,
      speed,
      jump,
      boss_damage,
      damage,
      all_stat,
      equipment_level_decrease,
    } = obj;

    this.str = str;
    this.dex = dex;
    this.int = int;
    this.luk = luk;
    this.maxHp = max_hp;
    this.maxMp = max_mp;
    this.attackPower = attack_power;
    this.magicPower = magic_power;
    this.armor = armor;
    this.speed = speed;
    this.jump = jump;
    this.bossDamage = boss_damage;
    this.damage = damage;
    this.allStat = all_stat;
    this.equipmentLevelDecrease = equipment_level_decrease;
  }
}

/**
 * Basic equipment option information
 */
export class CharacterItemEquipmentBaseOptionDto extends base.CharacterItemEquipmentBaseOptionDto {
  /**
   * STR
   */
  public override str: string;

  /**
   * DEX
   */
  public override dex: string;

  /**
   * INT
   */
  public override int: string;

  /**
   * LUK
   */
  public override luk: string;

  /**
   * Max HP
   */
  public override maxHp: string;

  /**
   * Max MP
   */
  public override maxMp: string;

  /**
   * Attack Power
   */
  public override attackPower: string;

  /**
   * Magic ATT
   */
  public override magicPower: string;

  /**
   * Defense
   */
  public override armor: string;

  /**
   * Speed
   */
  public override speed: string;

  /**
   * Jump
   */
  public override jump: string;

  /**
   * Boss Damage (%)
   */
  public override bossDamage: string;

  /**
   * Ignore Enemy Defense (%)
   */
  public override ignoreMonsterArmor: string;

  /**
   * All Stats (%)
   */
  public override allStat: string;

  /**
   * Max HP (%)
   */
  public override maxHpRate: string;

  /**
   * Max MP (%)
   */
  public override maxMpRate: string;

  /**
   * Basic equipment level
   */
  public override baseEquipmentLevel: number;

  constructor(obj: CharacterItemEquipmentBaseOptionBody) {
    super();

    const {
      str,
      dex,
      int,
      luk,
      max_hp,
      max_mp,
      attack_power,
      magic_power,
      armor,
      speed,
      jump,
      boss_damage,
      ignore_monster_armor,
      all_stat,
      max_hp_rate,
      max_mp_rate,
      base_equipment_level,
    } = obj;

    this.str = str;
    this.dex = dex;
    this.int = int;
    this.luk = luk;
    this.maxHp = max_hp;
    this.maxMp = max_mp;
    this.attackPower = attack_power;
    this.magicPower = magic_power;
    this.armor = armor;
    this.speed = speed;
    this.jump = jump;
    this.bossDamage = boss_damage;
    this.ignoreMonsterArmor = ignore_monster_armor;
    this.allStat = all_stat;
    this.maxHpRate = max_hp_rate;
    this.maxMpRate = max_mp_rate;
    this.baseEquipmentLevel = base_equipment_level;
  }
}

/**
 * Miscellaneous equipment option information
 */
export class CharacterItemEquipmentEtcOptionDto extends base.CharacterItemEquipmentEtcOptionDto {
  /**
   * STR
   */
  public override str: string;

  /**
   * DEX
   */
  public override dex: string;

  /**
   * INT
   */
  public override int: string;

  /**
   * LUK
   */
  public override luk: string;

  /**
   * Max HP
   */
  public override maxHp: string;

  /**
   * Max MP
   */
  public override maxMp: string;

  /**
   * Attack Power
   */
  public override attackPower: string;

  /**
   * Magic ATT
   */
  public override magicPower: string;

  /**
   * Defense
   */
  public override armor: string;

  /**
   * Speed
   */
  public override speed: string;

  /**
   * Jump
   */
  public override jump: string;

  constructor(obj: CharacterItemEquipmentEtcOptionBody) {
    super();

    const {
      str,
      dex,
      int,
      luk,
      max_hp,
      max_mp,
      attack_power,
      magic_power,
      armor,
      speed,
      jump,
    } = obj;

    this.str = str;
    this.dex = dex;
    this.int = int;
    this.luk = luk;
    this.maxHp = max_hp;
    this.maxMp = max_mp;
    this.attackPower = attack_power;
    this.magicPower = magic_power;
    this.armor = armor;
    this.speed = speed;
    this.jump = jump;
  }
}

/**
 * Exceptional equipment option information
 */
export class CharacterItemEquipmentExceptionalOptionDto extends base.CharacterItemEquipmentExceptionalOptionDto {
  /**
   * STR
   */
  public override str: string;

  /**
   * DEX
   */
  public override dex: string;

  /**
   * INT
   */
  public override int: string;

  /**
   * LUK
   */
  public override luk: string;

  /**
   * Max HP
   */
  public override maxHp: string;

  /**
   * Max MP
   */
  public override maxMp: string;

  /**
   * Attack Power
   */
  public override attackPower: string;

  /**
   * Magic ATT
   */
  public override magicPower: string;

  /**
   * Number of exceptional boost applications
   */
  public override exceptionalUpgrade: number;

  constructor(obj: CharacterItemEquipmentExceptionalOptionBody) {
    super();

    const {
      str,
      dex,
      int,
      luk,
      max_hp,
      max_mp,
      attack_power,
      magic_power,
      exceptional_upgrade,
    } = obj;

    this.str = str;
    this.dex = dex;
    this.int = int;
    this.luk = luk;
    this.maxHp = max_hp;
    this.maxMp = max_mp;
    this.attackPower = attack_power;
    this.magicPower = magic_power;
    this.exceptionalUpgrade = exceptional_upgrade ?? 0;
  }
}

/**
 * Equipment Star Force option information
 */
export class CharacterItemEquipmentStarforceOptionDto extends base.CharacterItemEquipmentStarforceOptionDto {
  /**
   * STR
   */
  public override str: string;

  /**
   * DEX
   */
  public override dex: string;

  /**
   * INT
   */
  public override int: string;

  /**
   * LUK
   */
  public override luk: string;

  /**
   * Max HP
   */
  public override maxHp: string;

  /**
   * Max MP
   */
  public override maxMp: string;

  /**
   * Attack Power
   */
  public override attackPower: string;

  /**
   * Magic ATT
   */
  public override magicPower: string;

  /**
   * Defense
   */
  public override armor: string;

  /**
   * Speed
   */
  public override speed: string;

  /**
   * Jump
   */
  public override jump: string;

  constructor(obj: CharacterItemEquipmentStarforceOptionBody) {
    super();

    const {
      str,
      dex,
      int,
      luk,
      max_hp,
      max_mp,
      attack_power,
      magic_power,
      armor,
      speed,
      jump,
    } = obj;

    this.str = str;
    this.dex = dex;
    this.int = int;
    this.luk = luk;
    this.maxHp = max_hp;
    this.maxMp = max_mp;
    this.attackPower = attack_power;
    this.magicPower = magic_power;
    this.armor = armor;
    this.speed = speed;
    this.jump = jump;
  }
}

/**
 * Final equipment option information
 */
export class CharacterItemEquipmentTotalOptionDto extends base.CharacterItemEquipmentTotalOptionDto {
  /**
   * STR
   */
  public override str: string;

  /**
   * DEX
   */
  public override dex: string;

  /**
   * INT
   */
  public override int: string;

  /**
   * LUK
   */
  public override luk: string;

  /**
   * Max HP
   */
  public override maxHp: string;

  /**
   * Max MP
   */
  public override maxMp: string;

  /**
   * Attack Power
   */
  public override attackPower: string;

  /**
   * Magic ATT
   */
  public override magicPower: string;

  /**
   * Defense
   */
  public override armor: string;

  /**
   * Speed
   */
  public override speed: string;

  /**
   * Jump
   */
  public override jump: string;

  /**
   * Boss Damage (%)
   */
  public override bossDamage: string;

  /**
   * Ignore Enemy Defense (%)
   */
  public override ignoreMonsterArmor: string;

  /**
   * All Stats (%)
   */
  public override allStat: string;

  /**
   * Damage (%)
   */
  public override damage: string;

  /**
   * Equipment level decreases
   */
  public override equipmentLevelDecrease: number;

  /**
   * Max HP (%)
   */
  public override maxHpRate: string;

  /**
   * Max MP (%)
   */
  public override maxMpRate: string;

  constructor(obj: CharacterItemEquipmentTotalOptionBody) {
    super();

    const {
      str,
      dex,
      int,
      luk,
      max_hp,
      max_mp,
      attack_power,
      magic_power,
      armor,
      speed,
      jump,
      boss_damage,
      ignore_monster_armor,
      all_stat,
      damage,
      equipment_level_decrease,
      max_hp_rate,
      max_mp_rate,
    } = obj;

    this.str = str;
    this.dex = dex;
    this.int = int;
    this.luk = luk;
    this.maxHp = max_hp;
    this.maxMp = max_mp;
    this.attackPower = attack_power;
    this.magicPower = magic_power;
    this.armor = armor;
    this.speed = speed;
    this.jump = jump;
    this.bossDamage = boss_damage;
    this.ignoreMonsterArmor = ignore_monster_armor;
    this.allStat = all_stat;
    this.damage = damage;
    this.equipmentLevelDecrease = equipment_level_decrease;
    this.maxHpRate = max_hp_rate;
    this.maxMpRate = max_mp_rate;
  }
}

/**
 * Evan Dragon equipment information
 */
export class CharacterItemEquipmentDragonInfoDto extends base.CharacterItemEquipmentDragonInfoDto {
  /**
   * Equipment part name
   */
  public override itemEquipmentPart: string;

  /**
   * Equipment slot position
   */
  public override itemEquipmentSlot: string;

  /**
   * Equipment name
   */
  public override itemName: string;

  /**
   * Equipment icon
   */
  public override itemIcon: string;

  /**
   * Equipment description
   */
  public override itemDescription: string | null;

  /**
   * Equipment type
   */
  public override itemShapeName: string;

  /**
   * Equipment type icon
   */
  public override itemShapeIcon: string;

  /**
   * Gender-specific equipment
   */
  public override itemGender: string | null;

  /**
   * Final equipment option information
   */
  public override itemTotalOption: CharacterItemEquipmentTotalOptionDto;

  /**
   * Basic equipment option information
   */
  public override itemBaseOption: CharacterItemEquipmentBaseOptionDto;

  /**
   * Equipment level increases
   */
  public override equipmentLevelIncrease: number;

  /**
   * Exceptional equipment option information
   */
  public override itemExceptionalOption: CharacterItemEquipmentExceptionalOptionDto;

  /**
   * Additional equipment options
   */
  public override itemAddOption: CharacterItemEquipmentAddOptionDto;

  /**
   * Growth EXP
   */
  public override growthExp: number;

  /**
   * Growth level
   */
  public override growthLevel: number;

  /**
   * Number of upgrades
   */
  public override scrollUpgrade: string;

  /**
   * Number of scissors usage available (Untradable, 255 for equipment without scissors usage count)
   */
  public override cuttableCount: string;

  /**
   * Golden Hammer refinement applied (true:applied, false:not applied)
   */
  public override goldenHammerFlag: string;

  /**
   * Number of restoration attempts available
   */
  public override scrollResilienceCount: string;

  /**
   * Number of upgrades available
   */
  public override scrollUpgradeableCount: string;

  /**
   * Soul name
   */
  public override soulName: string | null;

  /**
   * Soul option
   */
  public override soulOption: string | null;

  /**
   * Miscellaneous equipment option information
   */
  public override itemEtcOption: CharacterItemEquipmentEtcOptionDto;

  /**
   * Enhancement level
   */
  public override starforce: string;

  /**
   * Usage status of Miraculous Equip Enhancement Scroll (true:used, false:not used)
   */
  public override starforceScrollFlag: string;

  /**
   * Equipment Star Force option information
   */
  public override itemStarforceOption: CharacterItemEquipmentStarforceOptionDto;

  /**
   * Special Skill Ring
   */
  public override specialRingLevel: number;

  /**
   * Equipment expiration date (SGT)
   */
  public override dateExpire: Date | null = null;

  /**
   * Whether the equipment is expired
   */
  public override isExpired: boolean | null = null;

  /**
   * Freestyle Coupon application status (0:not applied, 1:applied)
   */
  public override freestyleFlag: string | null;

  constructor(obj: CharacterItemEquipmentDragonInfoBody) {
    super();

    const {
      item_equipment_part,
      item_equipment_slot,
      item_name,
      item_icon,
      item_description,
      item_shape_name,
      item_shape_icon,
      item_gender,
      item_total_option,
      item_base_option,
      equipment_level_increase,
      item_exceptional_option,
      item_add_option,
      growth_exp,
      growth_level,
      scroll_upgrade,
      cuttable_count,
      golden_hammer_flag,
      scroll_resilience_count,
      scroll_upgradeable_count,
      soul_name,
      soul_option,
      item_etc_option,
      starforce,
      starforce_scroll_flag,
      item_starforce_option,
      special_ring_level,
      date_expire,
      freestyle_flag,
    } = obj;

    this.itemEquipmentPart = item_equipment_part;
    this.itemEquipmentSlot = item_equipment_slot;
    this.itemName = item_name;
    this.itemIcon = item_icon;
    this.itemDescription = item_description;
    this.itemShapeName = item_shape_name;
    this.itemShapeIcon = item_shape_icon;
    this.itemGender = item_gender;
    this.itemTotalOption = new CharacterItemEquipmentTotalOptionDto(
      item_total_option,
    );
    this.itemBaseOption = new CharacterItemEquipmentBaseOptionDto(
      item_base_option,
    );
    this.equipmentLevelIncrease = equipment_level_increase;
    this.itemExceptionalOption = new CharacterItemEquipmentExceptionalOptionDto(
      item_exceptional_option,
    );
    this.itemAddOption = new CharacterItemEquipmentAddOptionDto(
      item_add_option,
    );
    this.growthExp = growth_exp;
    this.growthLevel = growth_level;
    this.scrollUpgrade = scroll_upgrade;
    this.cuttableCount = cuttable_count;
    this.goldenHammerFlag = golden_hammer_flag;
    this.scrollResilienceCount = scroll_resilience_count;
    this.scrollUpgradeableCount = scroll_upgradeable_count;
    this.soulName = soul_name;
    this.soulOption = soul_option;
    this.itemEtcOption = new CharacterItemEquipmentEtcOptionDto(
      item_etc_option,
    );
    this.starforce = starforce;
    this.starforceScrollFlag = starforce_scroll_flag;
    this.itemStarforceOption = new CharacterItemEquipmentStarforceOptionDto(
      item_starforce_option,
    );
    this.specialRingLevel = special_ring_level;
    this.freestyleFlag = freestyle_flag;

    if (date_expire === 'expired') {
      this.isExpired = true;
    } else if (typeof date_expire === 'string') {
      this.dateExpire = date_expire ? new Date(date_expire) : null;
    }
  }

  /**
   * Freestyle Coupon application status
   */
  public get isFreestyleFlag() {
    return this.freestyleFlag === '1';
  }
}

/**
 * Mechanic equipment information
 */
export class CharacterItemEquipmentMechanicInfoDto extends base.CharacterItemEquipmentMechanicInfoDto {
  /**
   * Equipment part name
   */
  public override itemEquipmentPart: string;

  /**
   * Equipment slot position
   */
  public override itemEquipmentSlot: string;

  /**
   * Equipment name
   */
  public override itemName: string;

  /**
   * Equipment icon
   */
  public override itemIcon: string;

  /**
   * Equipment description
   */
  public override itemDescription: string | null;

  /**
   * Equipment type
   */
  public override itemShapeName: string;

  /**
   * Equipment type icon
   */
  public override itemShapeIcon: string;

  /**
   * Gender-specific equipment
   */
  public override itemGender: string | null;

  /**
   * Final equipment option information
   */
  public override itemTotalOption: CharacterItemEquipmentTotalOptionDto;

  /**
   * Basic equipment option information
   */
  public override itemBaseOption: CharacterItemEquipmentBaseOptionDto;

  /**
   * Equipment level increases
   */
  public override equipmentLevelIncrease: number;

  /**
   * Exceptional equipment option information
   */
  public override itemExceptionalOption: CharacterItemEquipmentExceptionalOptionDto;

  /**
   * Additional equipment options
   */
  public override itemAddOption: CharacterItemEquipmentAddOptionDto;

  /**
   * Growth EXP
   */
  public override growthExp: number;

  /**
   * Growth level
   */
  public override growthLevel: number;

  /**
   * Number of upgrades
   */
  public override scrollUpgrade: string;

  /**
   * Number of scissors usage available (Untradable, 255 for equipment without scissors usage count)
   */
  public override cuttableCount: string;

  /**
   * Golden Hammer refinement applied (true:applied, false:not applied)
   */
  public override goldenHammerFlag: string;

  /**
   * Number of restoration attempts available
   */
  public override scrollResilienceCount: string;

  /**
   * Number of upgrades available
   */
  public override scrollUpgradeableCount: string;

  /**
   * Soul name
   */
  public override soulName: string | null;

  /**
   * Soul option
   */
  public override soulOption: string | null;

  /**
   * Miscellaneous equipment option information
   */
  public override itemEtcOption: CharacterItemEquipmentEtcOptionDto;

  /**
   * Enhancement level
   */
  public override starforce: string;

  /**
   * Usage status of Miraculous Equip Enhancement Scroll (true:used, false:not used)
   */
  public override starforceScrollFlag: string;

  /**
   * Equipment Star Force option information
   */
  public override itemStarforceOption: CharacterItemEquipmentStarforceOptionDto;

  /**
   * Special Skill Ring
   */
  public override specialRingLevel: number;

  /**
   * Equipment expiration date (SGT)
   */
  public override dateExpire: Date | null = null;

  /**
   * Whether the equipment is expired
   */
  public override isExpired: boolean | null = null;

  /**
   * Freestyle Coupon application status (0:not applied, 1:applied)
   */
  public override freestyleFlag: string | null;

  constructor(obj: CharacterItemEquipmentMechanicInfoBody) {
    super();

    const {
      item_equipment_part,
      item_equipment_slot,
      item_name,
      item_icon,
      item_description,
      item_shape_name,
      item_shape_icon,
      item_gender,
      item_total_option,
      item_base_option,
      equipment_level_increase,
      item_exceptional_option,
      item_add_option,
      growth_exp,
      growth_level,
      scroll_upgrade,
      cuttable_count,
      golden_hammer_flag,
      scroll_resilience_count,
      scroll_upgradeable_count,
      soul_name,
      soul_option,
      item_etc_option,
      starforce,
      starforce_scroll_flag,
      item_starforce_option,
      special_ring_level,
      date_expire,
      freestyle_flag,
    } = obj;

    this.itemEquipmentPart = item_equipment_part;
    this.itemEquipmentSlot = item_equipment_slot;
    this.itemName = item_name;
    this.itemIcon = item_icon;
    this.itemDescription = item_description;
    this.itemShapeName = item_shape_name;
    this.itemShapeIcon = item_shape_icon;
    this.itemGender = item_gender;
    this.itemTotalOption = new CharacterItemEquipmentTotalOptionDto(
      item_total_option,
    );
    this.itemBaseOption = new CharacterItemEquipmentBaseOptionDto(
      item_base_option,
    );
    this.equipmentLevelIncrease = equipment_level_increase;
    this.itemExceptionalOption = new CharacterItemEquipmentExceptionalOptionDto(
      item_exceptional_option,
    );
    this.itemAddOption = new CharacterItemEquipmentAddOptionDto(
      item_add_option,
    );
    this.growthExp = growth_exp;
    this.growthLevel = growth_level;
    this.scrollUpgrade = scroll_upgrade;
    this.cuttableCount = cuttable_count;
    this.goldenHammerFlag = golden_hammer_flag;
    this.scrollResilienceCount = scroll_resilience_count;
    this.scrollUpgradeableCount = scroll_upgradeable_count;
    this.soulName = soul_name;
    this.soulOption = soul_option;
    this.itemEtcOption = new CharacterItemEquipmentEtcOptionDto(
      item_etc_option,
    );
    this.starforce = starforce;
    this.starforceScrollFlag = starforce_scroll_flag;
    this.itemStarforceOption = new CharacterItemEquipmentStarforceOptionDto(
      item_starforce_option,
    );
    this.specialRingLevel = special_ring_level;
    this.freestyleFlag = freestyle_flag;

    if (date_expire === 'expired') {
      this.isExpired = true;
    } else if (typeof date_expire === 'string') {
      this.dateExpire = date_expire ? new Date(date_expire) : null;
    }
  }

  /**
   * Freestyle Coupon application status
   */
  public get isFreestyleFlag() {
    return this.freestyleFlag === '1';
  }
}

/**
 * Equipment information
 */
export class CharacterItemEquipmentInfoDto extends base.CharacterItemEquipmentInfoDto {
  /**
   * Equipment part name
   */
  public override itemEquipmentPart: string;

  /**
   * Equipment slot position
   */
  public override itemEquipmentSlot: string;

  /**
   * Equipment name
   */
  public override itemName: string;

  /**
   * Equipment icon
   */
  public override itemIcon: string;

  /**
   * Equipment description
   */
  public override itemDescription: string | null;

  /**
   * Equipment type
   */
  public override itemShapeName: string;

  /**
   * Equipment type icon
   */
  public override itemShapeIcon: string;

  /**
   * Gender-specific equipment
   */
  public override itemGender: string | null;

  /**
   * Final equipment option information
   */
  public override itemTotalOption: CharacterItemEquipmentTotalOptionDto;

  /**
   * Basic equipment option information
   */
  public override itemBaseOption: CharacterItemEquipmentBaseOptionDto;

  /**
   * Potential seal status (true:sealed, false:not sealed)
   */
  public override potentialOptionFlag: string | null;

  /**
   * Additional potential seal status (true:sealed, false:not sealed)
   */
  public override additionalPotentialOptionFlag: string | null;

  /**
   * Potential grade
   */
  public override potentialOptionGrade: string | null;

  /**
   * Additional potential grade
   */
  public override additionalPotentialOptionGrade: string | null;

  /**
   * First Potential option
   */
  public override potentialOption1: string | null;

  /**
   * Second Potential option
   */
  public override potentialOption2: string | null;

  /**
   * Third Potential option
   */
  public override potentialOption3: string | null;

  /**
   * First additional Potential option
   */
  public override additionalPotentialOption1: string | null;

  /**
   * Second additional Potential option
   */
  public override additionalPotentialOption2: string | null;

  /**
   * Third additional Potential option
   */
  public override additionalPotentialOption3: string | null;

  /**
   * Equipment level increase
   */
  public override equipmentLevelIncrease: number;

  /**
   * Exceptional equipment option information
   */
  public override itemExceptionalOption: CharacterItemEquipmentExceptionalOptionDto;

  /**
   * Additional equipment options
   */
  public override itemAddOption: CharacterItemEquipmentAddOptionDto;

  /**
   * Growth EXP
   */
  public override growthExp: number;

  /**
   * Growth level
   */
  public override growthLevel: number;

  /**
   * Number of upgrade attempts
   */
  public override scrollUpgrade: string;

  /**
   * Number of scissors usage available (Untradable, 255 for equipment without scissors usage count)
   */
  public override cuttableCount: string;

  /**
   * Golden Hammer refinement applied (true:applied, false:not applied)
   */
  public override goldenHammerFlag: string;

  /**
   * Number of restoration attempts available
   */
  public override scrollResilienceCount: string;

  /**
   * Number of upgrades available
   */
  public override scrollUpgradeableCount: string;

  /**
   * Soul name
   */
  public override soulName: string | null;

  /**
   * Soul option
   */
  public override soulOption: string | null;

  /**
   * Miscellaneous equipment option information
   */
  public override itemEtcOption: CharacterItemEquipmentEtcOptionDto;

  /**
   * Enhancement level
   */
  public override starforce: string;

  /**
   * Usage status of Miraculous Equip Enhancement Scroll (true:used, false:not used)
   */
  public override starforceScrollFlag: string;

  /**
   * Equipment Star Force option information
   */
  public override itemStarforceOption: CharacterItemEquipmentStarforceOptionDto;

  /**
   * Special Skill Ring
   */
  public override specialRingLevel: number;

  /**
   * Equipment expiration date (SGT)
   */
  public override dateExpire: Date | null = null;

  /**
   * Whether the equipment is expired
   */
  public override isExpired: boolean | null = null;

  /**
   * Freestyle Coupon application status (0:not applied, 1:applied)
   */
  public override freestyleFlag: string | null;

  constructor(obj: CharacterItemEquipmentInfoBody) {
    super();

    const {
      item_equipment_part,
      item_equipment_slot,
      item_name,
      item_icon,
      item_description,
      item_shape_name,
      item_shape_icon,
      item_gender,
      item_total_option,
      item_base_option,
      potential_option_flag,
      additional_potential_option_flag,
      potential_option_grade,
      additional_potential_option_grade,
      potential_option_1,
      potential_option_2,
      potential_option_3,
      additional_potential_option_1,
      additional_potential_option_2,
      additional_potential_option_3,
      equipment_level_increase,
      item_exceptional_option,
      item_add_option,
      growth_exp,
      growth_level,
      scroll_upgrade,
      cuttable_count,
      golden_hammer_flag,
      scroll_resilience_count,
      scroll_upgradeable_count,
      soul_name,
      soul_option,
      item_etc_option,
      starforce,
      starforce_scroll_flag,
      item_starforce_option,
      special_ring_level,
      date_expire,
      freestyle_flag,
    } = obj;

    this.itemEquipmentPart = item_equipment_part;
    this.itemEquipmentSlot = item_equipment_slot;
    this.itemName = item_name;
    this.itemIcon = item_icon;
    this.itemDescription = item_description;
    this.itemShapeName = item_shape_name;
    this.itemShapeIcon = item_shape_icon;
    this.itemGender = item_gender;
    this.itemTotalOption = new CharacterItemEquipmentTotalOptionDto(
      item_total_option,
    );
    this.itemBaseOption = new CharacterItemEquipmentBaseOptionDto(
      item_base_option,
    );
    this.potentialOptionFlag  = potential_option_flag;
    this.additionalPotentialOptionFlag = additional_potential_option_flag;
    this.potentialOptionGrade = potential_option_grade;
    this.additionalPotentialOptionGrade = additional_potential_option_grade;
    this.potentialOption1 = potential_option_1;
    this.potentialOption2 = potential_option_2;
    this.potentialOption3 = potential_option_3;
    this.additionalPotentialOption1 = additional_potential_option_1;
    this.additionalPotentialOption2 = additional_potential_option_2;
    this.additionalPotentialOption3 = additional_potential_option_3;
    this.equipmentLevelIncrease = equipment_level_increase;
    this.itemExceptionalOption = new CharacterItemEquipmentExceptionalOptionDto(
      item_exceptional_option,
    );
    this.itemAddOption = new CharacterItemEquipmentAddOptionDto(
      item_add_option,
    );
    this.growthExp = growth_exp;
    this.growthLevel = growth_level;
    this.scrollUpgrade = scroll_upgrade;
    this.cuttableCount = cuttable_count;
    this.goldenHammerFlag = golden_hammer_flag;
    this.scrollResilienceCount = scroll_resilience_count;
    this.scrollUpgradeableCount = scroll_upgradeable_count;
    this.soulName = soul_name;
    this.soulOption = soul_option;
    this.itemEtcOption = new CharacterItemEquipmentEtcOptionDto(
      item_etc_option,
    );
    this.starforce = starforce;
    this.starforceScrollFlag = starforce_scroll_flag;
    this.itemStarforceOption = new CharacterItemEquipmentStarforceOptionDto(
      item_starforce_option,
    );
    this.specialRingLevel = special_ring_level;
    this.freestyleFlag = freestyle_flag;

    if (date_expire === 'expired') {
      this.isExpired = true;
    } else if (typeof date_expire === 'string') {
      this.dateExpire = date_expire ? new Date(date_expire) : null;
    }
  }

  /**
   * Freestyle Coupon application status
   */
  public get isFreestyleFlag() {
    return this.freestyleFlag === '1';
  }
}

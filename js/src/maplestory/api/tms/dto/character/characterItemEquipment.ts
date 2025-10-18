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
  CharacterItemEquipmentStarforceOptionBody,
  CharacterItemEquipmentTitleBody,
  CharacterItemEquipmentTotalOptionBody,
} from '../../response/character/characterItemEquipmentBody';

/**
 * 角色已裝備道具資訊
 */
export class CharacterItemEquipmentDto extends base.CharacterItemEquipmentDto {
  /**
   * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
   */
  public override date: Date | null;

  /**
   * 角色性別
   */
  public override characterGender: string | null;

  /**
   * 角色職業
   */
  public override characterClass: string | null;

  /**
   * 目前套用的道具預設編號
   */
  public override presetNo: number | null;

  /**
   * 道具資訊
   */
  public override itemEquipment: CharacterItemEquipmentInfoDto[];

  /**
   * 預設 1 的道具資訊
   */
  public override itemEquipmentPreset1: CharacterItemEquipmentInfoDto[];

  /**
   * 預設 2 的道具資訊
   */
  public override itemEquipmentPreset2: CharacterItemEquipmentInfoDto[];

  /**
   * 預設 3 的道具資訊
   */
  public override itemEquipmentPreset3: CharacterItemEquipmentInfoDto[];

  /**
   * 稱號資訊
   */
  public override title: CharacterItemEquipmentTitleDto | null;

  /**
   * 龍魔導士的龍道具資訊 (僅在龍魔導士時回應)
   */
  public override dragonEquipment: CharacterItemEquipmentDragonInfoDto[];

  /**
   * 機甲戰神道具資訊 (僅在機甲戰神時回應)
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
      dragon_equipment,
      mechanic_equipment,
    } = obj;

    this.date = date ? new Date(date) : null;
    this.characterGender = character_gender;
    this.characterClass = character_class;
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
    this.dragonEquipment = dragon_equipment.map(
      (equipment) => new CharacterItemEquipmentDragonInfoDto(equipment),
    );
    this.mechanicEquipment = mechanic_equipment.map(
      (equipment) => new CharacterItemEquipmentMechanicInfoDto(equipment),
    );
  }
}

/**
 * 稱號資訊
 */
export class CharacterItemEquipmentTitleDto extends base.CharacterItemEquipmentTitleDto {
  /**
   * 稱號道具名稱
   */
  public override titleName: string | null;

  /**
   * 稱號圖示
   */
  public override titleIcon: string | null;

  /**
   * 稱號描述
   */
  public override titleDescription: string | null;

  /**
   * 稱號有效期間 (TST)
   */
  public override dateExpire: Date | null = null;

  /**
   * Whether the title is expired
   */
  public override isExpired: boolean | null = null;

  /**
   * 稱號選項有效期間 (expired：已到期，null：無限期) (TST)
   */
  public override dateOptionExpire: Date | null = null;

  /**
   * Whether the title option is expired
   */
  public override isOptionExpired: boolean | null = null;

  /**
   * 外型設定中已登錄稱號的道具名稱
   */
  public titleShapeName: string | null;

  /**
   * 外型設定中已登錄稱號的圖示
   */
  public titleShapeIcon: string | null;

  /**
   * 外型設定中已登錄稱號的描述
   */
  public titleShapeDescription: string | null;

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
 * 附加道具選項
 */
export class CharacterItemEquipmentAddOptionDto extends base.CharacterItemEquipmentAddOptionDto {
  /**
   * 力量 (STR)
   */
  public override str: string;

  /**
   * 敏捷 (DEX)
   */
  public override dex: string;

  /**
   * 智力 (INT)
   */
  public override int: string;

  /**
   * 幸運 (LUK)
   */
  public override luk: string;

  /**
   * 最大體力 (HP)
   */
  public override maxHp: string;

  /**
   * 最大 MP
   */
  public override maxMp: string;

  /**
   * 攻擊力
   */
  public override attackPower: string;

  /**
   * 魔力
   */
  public override magicPower: string;

  /**
   * 防禦力
   */
  public override armor: string;

  /**
   * 移動速度
   */
  public override speed: string;

  /**
   * 跳躍力
   */
  public override jump: string;

  /**
   * 對首領傷害增加 (%)
   */
  public override bossDamage: string;

  /**
   * 傷害 (%)
   */
  public override damage: string;

  /**
   * 全部能力值 (%)
   */
  public override allStat: string;

  /**
   * 裝備等級減少
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
 * 道具基本選項資訊
 */
export class CharacterItemEquipmentBaseOptionDto extends base.CharacterItemEquipmentBaseOptionDto {
  /**
   * 力量 (STR)
   */
  public override str: string;

  /**
   * 敏捷 (DEX)
   */
  public override dex: string;

  /**
   * 智力 (INT)
   */
  public override int: string;

  /**
   * 幸運 (LUK)
   */
  public override luk: string;

  /**
   * 最大體力 (HP)
   */
  public override maxHp: string;

  /**
   * 最大 MP
   */
  public override maxMp: string;

  /**
   * 攻擊力
   */
  public override attackPower: string;

  /**
   * 魔力
   */
  public override magicPower: string;

  /**
   * 防禦力
   */
  public override armor: string;

  /**
   * 移動速度
   */
  public override speed: string;

  /**
   * 跳躍力
   */
  public override jump: string;

  /**
   * 對首領傷害增加 (%)
   */
  public override bossDamage: string;

  /**
   * 無視怪物防禦力 (%)
   */
  public override ignoreMonsterArmor: string;

  /**
   * 全部能力值 (%)
   */
  public override allStat: string;

  /**
   * 最大體力 (HP) (%)
   */
  public override maxHpRate: string;

  /**
   * 最大 MP (%)
   */
  public override maxMpRate: string;

  /**
   * 裝備基本等級
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
 * 道具其他選項資訊
 */
export class CharacterItemEquipmentEtcOptionDto extends base.CharacterItemEquipmentEtcOptionDto {
  /**
   * 力量 (STR)
   */
  public override str: string;

  /**
   * 敏捷 (DEX)
   */
  public override dex: string;

  /**
   * 智力 (INT)
   */
  public override int: string;

  /**
   * 幸運 (LUK)
   */
  public override luk: string;

  /**
   * 最大體力 (HP)
   */
  public override maxHp: string;

  /**
   * 最大 MP
   */
  public override maxMp: string;

  /**
   * 攻擊力
   */
  public override attackPower: string;

  /**
   * 魔力
   */
  public override magicPower: string;

  /**
   * 防禦力
   */
  public override armor: string;

  /**
   * 移動速度
   */
  public override speed: string;

  /**
   * 跳躍力
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
 * 道具特殊選項資訊
 */
export class CharacterItemEquipmentExceptionalOptionDto extends base.CharacterItemEquipmentExceptionalOptionDto {
  /**
   * 力量 (STR)
   */
  public override str: string;

  /**
   * 敏捷 (DEX)
   */
  public override dex: string;

  /**
   * 智力 (INT)
   */
  public override int: string;

  /**
   * 幸運 (LUK)
   */
  public override luk: string;

  /**
   * 最大體力 (HP)
   */
  public override maxHp: string;

  /**
   * 最大 MP
   */
  public override maxMp: string;

  /**
   * 攻擊力
   */
  public override attackPower: string;

  /**
   * 魔力
   */
  public override magicPower: string;

  /**
   * 已套用的卓越強化次數
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
 * 道具星星力量資訊
 */
export class CharacterItemEquipmentStarforceOptionDto extends base.CharacterItemEquipmentStarforceOptionDto {
  /**
   * 力量 (STR)
   */
  public override str: string;

  /**
   * 敏捷 (DEX)
   */
  public override dex: string;

  /**
   * 智力 (INT)
   */
  public override int: string;

  /**
   * 幸運 (LUK)
   */
  public override luk: string;

  /**
   * 最大體力 (HP)
   */
  public override maxHp: string;

  /**
   * 最大 MP
   */
  public override maxMp: string;

  /**
   * 攻擊力
   */
  public override attackPower: string;

  /**
   * 魔力
   */
  public override magicPower: string;

  /**
   * 防禦力
   */
  public override armor: string;

  /**
   * 移動速度
   */
  public override speed: string;

  /**
   * 跳躍力
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
 * 道具最終選項資訊
 */
export class CharacterItemEquipmentTotalOptionDto extends base.CharacterItemEquipmentTotalOptionDto {
  /**
   * 力量 (STR)
   */
  public override str: string;

  /**
   * 敏捷 (DEX)
   */
  public override dex: string;

  /**
   * 智力 (INT)
   */
  public override int: string;

  /**
   * 幸運 (LUK)
   */
  public override luk: string;

  /**
   * 最大體力 (HP)
   */
  public override maxHp: string;

  /**
   * 最大 MP
   */
  public override maxMp: string;

  /**
   * 攻擊力
   */
  public override attackPower: string;

  /**
   * 魔力
   */
  public override magicPower: string;

  /**
   * 防禦力
   */
  public override armor: string;

  /**
   * 移動速度
   */
  public override speed: string;

  /**
   * 跳躍力
   */
  public override jump: string;

  /**
   * 對首領傷害增加 (%)
   */
  public override bossDamage: string;

  /**
   * 無視怪物防禦力 (%)
   */
  public override ignoreMonsterArmor: string;

  /**
   * 全部能力值 (%)
   */
  public override allStat: string;

  /**
   * 傷害 (%)
   */
  public override damage: string;

  /**
   * 裝備等級減少
   */
  public override equipmentLevelDecrease: number;

  /**
   * 最大體力 (HP) (%)
   */
  public override maxHpRate: string;

  /**
   * 最大 MP (%)
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
 * 龍魔導士的龍道具資訊
 */
export class CharacterItemEquipmentDragonInfoDto extends base.CharacterItemEquipmentDragonInfoDto {
  /**
   * 道具部位名稱
   */
  public override itemEquipmentPart: string;

  /**
   * 道具欄位位置
   */
  public override itemEquipmentSlot: string;

  /**
   * 道具名稱
   */
  public override itemName: string;

  /**
   * 道具圖示
   */
  public override itemIcon: string;

  /**
   * 道具描述
   */
  public override itemDescription: string | null;

  /**
   * 道具外型
   */
  public override itemShapeName: string;

  /**
   * 道具外型圖示
   */
  public override itemShapeIcon: string;

  /**
  * 性別限定
   */
  public override itemGender: string | null;

  /**
   * 道具最終選項資訊
   */
  public override itemTotalOption: CharacterItemEquipmentTotalOptionDto;

  /**
   * 道具基本選項資訊
   */
  public override itemBaseOption: CharacterItemEquipmentBaseOptionDto;

  /**
   * 裝備等級增加
   */
  public override equipmentLevelIncrease: number;

  /**
   * 道具特殊選項資訊
   */
  public override itemExceptionalOption: CharacterItemEquipmentExceptionalOptionDto;

  /**
   * 附加道具選項
   */
  public override itemAddOption: CharacterItemEquipmentAddOptionDto;

  /**
   * 成長經驗值
   */
  public override growthExp: number;

  /**
   * 成長等級
   */
  public override growthLevel: number;

  /**
   * 強化次數
   */
  public override scrollUpgrade: string;

  /**
   * 可使用剪刀的次數 (不可交易道具、可交易但從未使用剪刀的道具：255)
   */
  public override cuttableCount: string;

  /**
   * 黃金鐵鎚精煉 (true：已套用，false：未套用)
   */
  public override goldenHammerFlag: string;

  /**
   * 道具可復原次數
   */
  public override scrollResilienceCount: string;

  /**
   * 道具可升級次數
   */
  public override scrollUpgradeableCount: string;

  /**
  * 靈魂名稱
   */
  public override soulName: string | null;

  /**
   * 靈魂選項
   */
  public override soulOption: string | null;

  /**
   * 道具其他選項資訊
   */
  public override itemEtcOption: CharacterItemEquipmentEtcOptionDto;

  /**
   * 強化階級
   */
  public override starforce: string;

  /**
   * 驚異道具強化卷軸 (true：已使用，false：未使用)
   */
  public override starforceScrollFlag: string;

  /**
   * 道具星星力量資訊
   */
  public override itemStarforceOption: CharacterItemEquipmentStarforceOptionDto;

  /**
   * 特殊戒指等級
   */
  public override specialRingLevel: number;

  /**
   * 道具有效期間 (TST)
   */
  public override dateExpire: Date | null = null;

  /**
   * Whether the equipment is expired
   */
  public override isExpired: boolean | null = null;

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

    if (date_expire === 'expired') {
      this.isExpired = true;
    } else if (typeof date_expire === 'string') {
      this.dateExpire = date_expire ? new Date(date_expire) : null;
    }
  }
}

/**
 * 機甲戰神道具資訊
 */
export class CharacterItemEquipmentMechanicInfoDto extends base.CharacterItemEquipmentMechanicInfoDto {
  /**
   * 道具部位名稱
   */
  public override itemEquipmentPart: string;

  /**
   * 道具欄位位置
   */
  public override itemEquipmentSlot: string;

  /**
   * 道具名稱
   */
  public override itemName: string;

  /**
   * 道具圖示
   */
  public override itemIcon: string;

  /**
   * 道具描述
   */
  public override itemDescription: string | null;

  /**
   * 道具外型
   */
  public override itemShapeName: string;

  /**
   * 道具外型圖示
   */
  public override itemShapeIcon: string;

  /**
  * 性別限定
   */
  public override itemGender: string | null;

  /**
   * 道具最終選項資訊
   */
  public override itemTotalOption: CharacterItemEquipmentTotalOptionDto;

  /**
   * 道具基本選項資訊
   */
  public override itemBaseOption: CharacterItemEquipmentBaseOptionDto;

  /**
   * 裝備等級增加
   */
  public override equipmentLevelIncrease: number;

  /**
   * 道具特殊選項資訊
   */
  public override itemExceptionalOption: CharacterItemEquipmentExceptionalOptionDto;

  /**
   * 附加道具選項
   */
  public override itemAddOption: CharacterItemEquipmentAddOptionDto;

  /**
   * 成長經驗值
   */
  public override growthExp: number;

  /**
   * 成長等級
   */
  public override growthLevel: number;

  /**
   * 強化次數
   */
  public override scrollUpgrade: string;

  /**
   * 可使用剪刀的次數 (不可交易道具、可交易但從未使用剪刀的道具：255)
   */
  public override cuttableCount: string;

  /**
   * 黃金鐵鎚精煉 (true：已套用，false：未套用)
   */
  public override goldenHammerFlag: string;

  /**
   * 道具可復原次數
   */
  public override scrollResilienceCount: string;

  /**
   * 道具可升級次數
   */
  public override scrollUpgradeableCount: string;

  /**
  * 靈魂名稱
   */
  public override soulName: string | null;

  /**
   * 靈魂選項
   */
  public override soulOption: string | null;

  /**
   * 道具其他選項資訊
   */
  public override itemEtcOption: CharacterItemEquipmentEtcOptionDto;

  /**
   * 強化階級
   */
  public override starforce: string;

  /**
   * 驚異道具強化卷軸 (true：已使用，false：未使用)
   */
  public override starforceScrollFlag: string;

  /**
   * 道具星星力量資訊
   */
  public override itemStarforceOption: CharacterItemEquipmentStarforceOptionDto;

  /**
   * 特殊戒指等級
   */
  public override specialRingLevel: number;

  /**
   * 道具有效期間 (TST)
   */
  public override dateExpire: Date | null = null;

  /**
   * Whether the equipment is expired
   */
  public override isExpired: boolean | null = null;

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

    if (date_expire === 'expired') {
      this.isExpired = true;
    } else if (typeof date_expire === 'string') {
      this.dateExpire = date_expire ? new Date(date_expire) : null;
    }
  }
}

/**
 * 道具資訊
 */
export class CharacterItemEquipmentInfoDto extends base.CharacterItemEquipmentInfoDto {
  /**
   * 道具部位名稱
   */
  public override itemEquipmentPart: string;

  /**
   * 道具欄位位置
   */
  public override itemEquipmentSlot: string;

  /**
   * 道具名稱
   */
  public override itemName: string;

  /**
   * 道具圖示
   */
  public override itemIcon: string;

  /**
   * 道具描述
   */
  public override itemDescription: string | null;

  /**
   * 道具外型
   */
  public override itemShapeName: string;

  /**
   * 道具外型圖示
   */
  public override itemShapeIcon: string;

  /**
   * 性別限定
   */
  public override itemGender: string | null;

  /**
   * 道具最終選項資訊
   */
  public override itemTotalOption: CharacterItemEquipmentTotalOptionDto;

  /**
   * 道具基本選項資訊
   */
  public override itemBaseOption: CharacterItemEquipmentBaseOptionDto;

  /**
   * 潛在能力封印狀態 (true：已封印，false：未封印)
   */
  public override potentialOptionFlag: string | null;

  /**
   * 附加潛在能力封印狀態 (true：已封印，false：未封印)
   */
  public override additionalPotentialOptionFlag: string | null;

  /**
   * 潛在能力階級
   */
  public override potentialOptionGrade: string | null;

  /**
   * 附加潛在能力階級
   */
  public override additionalPotentialOptionGrade: string | null;

  /**
   * 第一潛在能力選項
   */
  public override potentialOption1: string | null;

  /**
   * 第二潛在能力選項
   */
  public override potentialOption2: string | null;

  /**
   * 第三潛在能力選項
   */
  public override potentialOption3: string | null;

  /**
   * 第一附加潛在能力選項
   */
  public override additionalPotentialOption1: string | null;

  /**
   * 第二附加潛在能力選項
   */
  public override additionalPotentialOption2: string | null;

  /**
   * 第三附加潛在能力選項
   */
  public override additionalPotentialOption3: string | null;

  /**
   * 裝備等級增加
   */
  public override equipmentLevelIncrease: number;

  /**
   * 道具特殊選項資訊
   */
  public override itemExceptionalOption: CharacterItemEquipmentExceptionalOptionDto;

  /**
   * 附加道具選項
   */
  public override itemAddOption: CharacterItemEquipmentAddOptionDto;

  /**
   * 成長經驗值
   */
  public override growthExp: number;

  /**
   * 成長等級
   */
  public override growthLevel: number;

  /**
   * 強化次數
   */
  public override scrollUpgrade: string;

  /**
   * 可使用剪刀的次數 (不可交易道具、可交易但從未使用剪刀的道具：255)
   */
  public override cuttableCount: string;

  /**
   * 黃金鐵鎚精煉 (true：已套用，false：未套用)
   */
  public override goldenHammerFlag: string;

  /**
   * 道具可復原次數
   */
  public override scrollResilienceCount: string;

  /**
   * 道具可升級次數
   */
  public override scrollUpgradeableCount: string;

  /**
   * 靈魂名稱
   */
  public override soulName: string | null;

  /**
   * 靈魂選項
   */
  public override soulOption: string | null;

  /**
   * 道具其他選項資訊
   */
  public override itemEtcOption: CharacterItemEquipmentEtcOptionDto;

  /**
   * 強化階級
   */
  public override starforce: string;

  /**
   * 驚奇裝備強化卷軸 (true：已使用，false：未使用)
   */
  public override starforceScrollFlag: string;

  /**
   * 道具星星力量資訊
   */
  public override itemStarforceOption: CharacterItemEquipmentStarforceOptionDto;

  /**
   * 特殊戒指等級
   */
  public override specialRingLevel: number;

  /**
   * 道具有效期間 (TST)
   */
  public override dateExpire: Date | null = null;

  /**
   * Whether the equipment is expired
   */
  public override isExpired: boolean | null = null;

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
    this.potentialOptionFlag = potential_option_flag;
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

    if (date_expire === 'expired') {
      this.isExpired = true;
    } else if (typeof date_expire === 'string') {
      this.dateExpire = date_expire ? new Date(date_expire) : null;
    }
  }
}

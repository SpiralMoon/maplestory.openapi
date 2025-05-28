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
 * 캐릭터 장비 아이템 정보
 */
export class CharacterItemEquipmentDto {
  /**
   * 조회 기준일
   */
  date: Date | null;

  /**
   * 캐릭터 성별
   */
  characterGender: string | null;

  /**
   * 캐릭터 직업
   */
  characterClass: string | null;

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
  itemEquipmentPreset1: CharacterItemEquipmentInfoDto[];

  /**
   * 2번 프리셋 장비 정보
   */
  itemEquipmentPreset2: CharacterItemEquipmentInfoDto[];

  /**
   * 3번 프리셋 장비 정보
   */
  itemEquipmentPreset3: CharacterItemEquipmentInfoDto[];

  /**
   * 칭호 정보
   */
  title: CharacterItemEquipmentTitleDto | null;

  /**
   * 외형 설정에 등록한 훈장 외형 정보
   */
  medalShape: CharacterItemEquipmentMedalShapeDto | null;

  /**
   * 에반 드래곤 장비 정보 (에반인 경우 응답)
   */
  dragonEquipment: CharacterItemEquipmentDragonInfoDto[];

  /**
   * 메카닉 장비 정보 (메카닉인 경우 응답)
   */
  mechanicEquipment: CharacterItemEquipmentMechanicInfoDto[];

  constructor(obj: CharacterItemEquipmentBody) {
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
    this.characterGender = character_gender;
    this.characterClass = character_class;
    this.presetNo = preset_no;
    this.itemEquipment = item_equipment.map(
      (equipment) => new CharacterItemEquipmentInfoDto(equipment),
    );
    this.itemEquipmentPreset1 = item_equipment_preset_1?.map(
      (equipment) => new CharacterItemEquipmentInfoDto(equipment),
    ) ?? [];
    this.itemEquipmentPreset2 = item_equipment_preset_2?.map(
      (equipment) => new CharacterItemEquipmentInfoDto(equipment),
    ) ?? [];
    this.itemEquipmentPreset3 = item_equipment_preset_3?.map(
      (equipment) => new CharacterItemEquipmentInfoDto(equipment),
    ) ?? [];
    this.title = title ? new CharacterItemEquipmentTitleDto(title) : null;
    this.medalShape = medal_shape ? new CharacterItemEquipmentMedalShapeDto(medal_shape) : null;
    this.dragonEquipment = dragon_equipment.map(
      (equipment) => new CharacterItemEquipmentDragonInfoDto(equipment),
    );
    this.mechanicEquipment = mechanic_equipment.map(
      (equipment) => new CharacterItemEquipmentMechanicInfoDto(equipment),
    );
  }
}

/**
 * 캐릭터 칭호 아이템 정보
 */
export class CharacterItemEquipmentTitleDto {
  /**
   * 칭호 장비 명
   */
  titleName: string | null;

  /**
   * 칭호 아이콘
   */
  titleIcon: string | null;

  /**
   * 칭호 설명
   */
  titleDescription: string | null;

  /**
   * 칭호 유효 기간
   */
  dateExpire: Date | null = null;

  /**
   * 칭호 유효 기간 만료 여부
   */
  isExpired: boolean | null = null;

  /**
   * 칭호 옵션 유효 기간
   */
  dateOptionExpire: Date | null = null;

  /**
   * 칭호 옵션 유효 기간 만료 여부
   */
  isOptionExpired: boolean | null = null;

  /**
   * 외형 설정에 등록한 칭호 장비 명
   */
  titleShapeName: string | null;

  /**
   * 외형 설정에 등록한 칭호 아이콘
   */
  titleShapeIcon: string | null;

  /**
   * 외형 설정에 등록한 칭호 설명
   */
  titleShapeDescription: string | null;

  constructor(obj: CharacterItemEquipmentTitleBody) {
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
      this.dateExpire = date_expire
        ? new Date(date_expire)
        : null;
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
 * 캐릭터 외형 설정에 등록한 훈장 외형 정보
 */
export class CharacterItemEquipmentMedalShapeDto {
  /**
   * 외형 설정에 등록한 훈장 장비 명
   */
  medalShapeName: string;

  /**
   * 외형 설정에 등록한 훈장 아이콘
   */
  medalShapeIcon: string;

  /**
   * 외형 설정에 등록한 훈장 설명
   */
  medalShapeDescription: string;

  /**
   * 외형 설정에 등록한 훈장의 모루 적용 장비 명
   */
  medalShapeChangedName: string;

  /**
   * 외형 설정에 등록한 훈장의 모루 적용 아이콘
   */
  medalShapeChangedIcon: string;

  /**
   * 외형 설정에 등록한 훈장의 모루 적용 훈장 설명
   */
  medalShapeChangedDescription: string;

  constructor(obj: CharacterItemEquipmentMedalShapeBody) {
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
 * 캐릭터 장비 추가 옵션 정보
 */
export class CharacterItemEquipmentAddOptionDto {
  /**
   * STR
   */
  str: string;

  /**
   * DEX
   */
  dex: string;

  /**
   * INT
   */
  int: string;

  /**
   * LUK
   */
  luk: string;

  /**
   * 최대 HP
   */
  maxHp: string;

  /**
   * 최대 MP
   */
  maxMp: string;

  /**
   * 공격력
   */
  attackPower: string;

  /**
   * 마력
   */
  magicPower: string;

  /**
   * 방어력
   */
  armor: string;

  /**
   * 이동속도
   */
  speed: string;

  /**
   * 점프력
   */
  jump: string;

  /**
   * 보스 공격 시 데미지 증가(%)
   */
  bossDamage: string;

  /**
   * 데미지(%)
   */
  damage: string;

  /**
   * 올스탯(%)
   */
  allStat: string;

  /**
   * 착용 레벨 감소
   */
  equipmentLevelDecrease: number;

  constructor(obj: CharacterItemEquipmentAddOptionBody) {
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
 * 캐릭터 장비 기본 옵션 정보
 */
export class CharacterItemEquipmentBaseOptionDto {
  /**
   * STR
   */
  str: string;

  /**
   * DEX
   */
  dex: string;

  /**
   * INT
   */
  int: string;

  /**
   * LUK
   */
  luk: string;

  /**
   * 최대 HP
   */
  maxHp: string;

  /**
   * 최대 MP
   */
  maxMp: string;

  /**
   * 공격력
   */
  attackPower: string;

  /**
   * 마력
   */
  magicPower: string;

  /**
   * 방어력
   */
  armor: string;

  /**
   * 이동속도
   */
  speed: string;

  /**
   * 점프력
   */
  jump: string;

  /**
   * 보스 공격 시 데미지 증가(%)
   */
  bossDamage: string;

  /**
   * 몬스터 방어율 무시(%)
   */
  ignoreMonsterArmor: string;

  /**
   * 올스탯(%)
   */
  allStat: string;

  /**
   * 최대 HP(%)
   */
  maxHpRate: string;

  /**
   * 최대 MP(%)
   */
  maxMpRate: string;

  /**
   * 기본 착용 레벨
   */
  baseEquipmentLevel: number;

  constructor(obj: CharacterItemEquipmentBaseOptionBody) {
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
 * 캐릭터 장비 기타 옵션 정보
 */
export class CharacterItemEquipmentEtcOptionDto {
  /**
   * STR
   */
  str: string;

  /**
   * DEX
   */
  dex: string;

  /**
   * INT
   */
  int: string;

  /**
   * LUK
   */
  luk: string;

  /**
   * 최대 HP
   */
  maxHp: string;

  /**
   * 최대 MP
   */
  maxMp: string;

  /**
   * 공격력
   */
  attackPower: string;

  /**
   * 마력
   */
  magicPower: string;

  /**
   * 방어력
   */
  armor: string;

  /**
   * 이동속도
   */
  speed: string;

  /**
   * 점프력
   */
  jump: string;

  constructor(obj: CharacterItemEquipmentEtcOptionBody) {
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
 * 캐릭터 장비 특별 옵션 정보
 */
export class CharacterItemEquipmentExceptionalOptionDto {
  /**
   * STR
   */
  str: string;

  /**
   * DEX
   */
  dex: string;

  /**
   * INT
   */
  int: string;

  /**
   * LUK
   */
  luk: string;

  /**
   * 최대 HP
   */
  maxHp: string;

  /**
   * 최대 MP
   */
  maxMp: string;

  /**
   * 공격력
   */
  attackPower: string;

  /**
   * 마력
   */
  magicPower: string;

  /**
   * 익셉셔널 강화 적용 횟수
   */
  exceptionalUpgrade: number;

  constructor(obj: CharacterItemEquipmentExceptionalOptionBody) {
    const { str, dex, int, luk, max_hp, max_mp, attack_power, magic_power, exceptional_upgrade } =
      obj;

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
 * 캐릭터 장비 스타포스 옵션 정보
 */
export class CharacterItemEquipmentStarforceOptionDto {
  /**
   * STR
   */
  str: string;

  /**
   * DEX
   */
  dex: string;

  /**
   * INT
   */
  int: string;

  /**
   * LUK
   */
  luk: string;

  /**
   * 최대 HP
   */
  maxHp: string;

  /**
   * 최대 MP
   */
  maxMp: string;

  /**
   * 공격력
   */
  attackPower: string;

  /**
   * 마력
   */
  magicPower: string;

  /**
   * 방어력
   */
  armor: string;

  /**
   * 이동속도
   */
  speed: string;

  /**
   * 점프력
   */
  jump: string;

  constructor(obj: CharacterItemEquipmentStarforceOptionBody) {
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
 * 캐릭터 장비 최종 옵션 정보
 */
export class CharacterItemEquipmentTotalOptionDto {
  /**
   * STR
   */
  str: string;

  /**
   * DEX
   */
  dex: string;

  /**
   * INT
   */
  int: string;

  /**
   * LUK
   */
  luk: string;

  /**
   * 최대 HP
   */
  maxHp: string;

  /**
   * 최대 MP
   */
  maxMp: string;

  /**
   * 공격력
   */
  attackPower: string;

  /**
   * 마력
   */
  magicPower: string;

  /**
   * 방어력
   */
  armor: string;

  /**
   * 이동속도
   */
  speed: string;

  /**
   * 점프력
   */
  jump: string;

  /**
   * 보스 공격 시 데미지 증가(%)
   */
  bossDamage: string;

  /**
   * 몬스터 방어율 무시(%)
   */
  ignoreMonsterArmor: string;

  /**
   * 올스탯(%)
   */
  allStat: string;

  /**
   * 데미지(%)
   */
  damage: string;

  /**
   * 착용 레벨 감소
   */
  equipmentLevelDecrease: number;

  /**
   * 최대 HP(%)
   */
  maxHpRate: string;

  /**
   * 최대 MP(%)
   */
  maxMpRate: string;

  constructor(obj: CharacterItemEquipmentTotalOptionBody) {
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
 * 에반 드래곤 장비 정보
 */
export class CharacterItemEquipmentDragonInfoDto {
  /**
   * 장비 부위 명
   */
  itemEquipmentPart: string;

  /**
   * 장비 슬롯 위치
   */
  itemEquipmentSlot: string;

  /**
   * 장비 명
   */
  itemName: string;

  /**
   * 장비 아이콘
   */
  itemIcon: string;

  /**
   * 장비 설명
   */
  itemDescription: string | null;

  /**
   * 장비 외형
   */
  itemShapeName: string;

  /**
   * 장비 외형 아이콘
   */
  itemShapeIcon: string;

  /**
   * 전용 성별
   */
  itemGender: string | null;

  /**
   * 장비 최종 옵션
   */
  itemTotalOption: CharacterItemEquipmentTotalOptionDto;

  /**
   * 장비 기본 옵션
   */
  itemBaseOption: CharacterItemEquipmentBaseOptionDto;

  /**
   * 착용 레벨 증가
   */
  equipmentLevelIncrease: number;

  /**
   * 장비 특별 옵션
   */
  itemExceptionalOption: CharacterItemEquipmentExceptionalOptionDto;

  /**
   * 장비 추가 옵션
   */
  itemAddOption: CharacterItemEquipmentAddOptionDto;

  /**
   * 성장 경험치
   */
  growthExp: number;

  /**
   * 성장 레벨
   */
  growthLevel: number;

  /**
   * 업그레이드 횟수
   */
  scrollUpgrade: string;

  /**
   * 가위 사용 가능 횟수 (교환 불가 장비, 가위 횟수가 없는 교환 가능 장비는 255)
   */
  cuttableCount: string;

  /**
   * 황금 망치 재련 적용 (1:적용, 이외 미 적용)
   */
  goldenHammerFlag: string;

  /**
   * 복구 가능 횟수
   */
  scrollResilienceCount: string;

  /**
   * 업그레이드 가능 횟수
   */
  scrollUpgradeableCount: string;

  /**
   * 소울 명
   */
  soulName: string | null;

  /**
   * 소울 옵션
   */
  soulOption: string | null;

  /**
   * 장비 기타 옵션
   */
  itemEtcOption: CharacterItemEquipmentEtcOptionDto;

  /**
   * 강화 단계
   */
  starforce: string;

  /**
   * 놀라운 장비 강화 주문서 사용 여부 (0:미사용, 1:사용)
   */
  starforceScrollFlag: string;

  /**
   * 장비 스타포스 옵션
   */
  itemStarforceOption: CharacterItemEquipmentStarforceOptionDto;

  /**
   * 특수 반지 레벨
   */
  specialRingLevel: number;

  /**
   * 장비 유효 기간
   */
  dateExpire: Date | null = null;

  /**
   * 장비 유효 기간 만료 여부
   */
  isExpired: boolean | null = null;

  constructor(obj: CharacterItemEquipmentDragonInfoBody) {
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
      this.dateExpire = date_expire
        ? new Date(date_expire)
        : null;
    }
  }
}

/**
 * 메카닉 장비 정보
 */
export class CharacterItemEquipmentMechanicInfoDto {
  /**
   * 장비 부위 명
   */
  itemEquipmentPart: string;

  /**
   * 장비 슬롯 위치
   */
  itemEquipmentSlot: string;

  /**
   * 장비 명
   */
  itemName: string;

  /**
   * 장비 아이콘
   */
  itemIcon: string;

  /**
   * 장비 설명
   */
  itemDescription: string | null;

  /**
   * 장비 외형
   */
  itemShapeName: string;

  /**
   * 장비 외형 아이콘
   */
  itemShapeIcon: string;

  /**
   * 전용 성별
   */
  itemGender: string | null;

  /**
   * 장비 최종 옵션
   */
  itemTotalOption: CharacterItemEquipmentTotalOptionDto;

  /**
   * 장비 기본 옵션
   */
  itemBaseOption: CharacterItemEquipmentBaseOptionDto;

  /**
   * 착용 레벨 증가
   */
  equipmentLevelIncrease: number;

  /**
   * 장비 특별 옵션
   */
  itemExceptionalOption: CharacterItemEquipmentExceptionalOptionDto;

  /**
   * 장비 추가 옵션
   */
  itemAddOption: CharacterItemEquipmentAddOptionDto;

  /**
   * 성장 경험치
   */
  growthExp: number;

  /**
   * 성장 레벨
   */
  growthLevel: number;

  /**
   * 업그레이드 횟수
   */
  scrollUpgrade: string;

  /**
   * 가위 사용 가능 횟수 (교환 불가 장비, 가위 횟수가 없는 교환 가능 장비는 255)
   */
  cuttableCount: string;

  /**
   * 황금 망치 재련 적용 (1:적용, 이외 미 적용)
   */
  goldenHammerFlag: string;

  /**
   * 복구 가능 횟수
   */
  scrollResilienceCount: string;

  /**
   * 업그레이드 가능 횟수
   */
  scrollUpgradeableCount: string;

  /**
   * 소울 명
   */
  soulName: string | null;

  /**
   * 소울 옵션
   */
  soulOption: string | null;

  /**
   * 장비 기타 옵션
   */
  itemEtcOption: CharacterItemEquipmentEtcOptionDto;

  /**
   * 강화 단계
   */
  starforce: string;

  /**
   * 놀라운 장비 강화 주문서 사용 여부 (0:미사용, 1:사용)
   */
  starforceScrollFlag: string;

  /**
   * 장비 스타포스 옵션
   */
  itemStarforceOption: CharacterItemEquipmentStarforceOptionDto;

  /**
   * 특수 반지 레벨
   */
  specialRingLevel: number;

  /**
   * 장비 유효 기간
   */
  dateExpire: Date | null = null;

  /**
   * 장비 유효 기간 만료 여부
   */
  isExpired: boolean | null = null;

  constructor(obj: CharacterItemEquipmentMechanicInfoBody) {
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
      this.dateExpire = date_expire
        ? new Date(date_expire)
        : null;
    }
  }
}

/**
 * 캐릭터 장비 아이템 상세 정보
 */
export class CharacterItemEquipmentInfoDto {
  /**
   * 장비 부위 명
   */
  itemEquipmentPart: string;

  /**
   * 장비 슬롯 위치
   */
  itemEquipmentSlot: string;

  /**
   * 장비 명
   */
  itemName: string;

  /**
   * 장비 아이콘
   */
  itemIcon: string;

  /**
   * 장비 설명
   */
  itemDescription: string | null;

  /**
   * 장비 외형
   */
  itemShapeName: string;

  /**
   * 장비 외형 아이콘
   */
  itemShapeIcon: string;

  /**
   * 전용 성별
   */
  itemGender: string | null;

  /**
   * 장비 최종 옵션
   */
  itemTotalOption: CharacterItemEquipmentTotalOptionDto;

  /**
   * 장비 기본 옵션
   */
  itemBaseOption: CharacterItemEquipmentBaseOptionDto;

  /**
   * 잠재능력 등급
   */
  potentialOptionGrade: string | null;

  /**
   * 에디셔널 잠재능력 등급
   */
  additionalPotentialOptionGrade: string | null;

  /**
   * 잠재능력 첫 번째 옵션
   */
  potentialOption1: string | null;

  /**
   * 잠재능력 두 번째 옵션
   */
  potentialOption2: string | null;

  /**
   * 잠재능력 세 번째 옵션
   */
  potentialOption3: string | null;

  /**
   * 에디셔널 잠재능력 첫 번째 옵션
   */
  additionalPotentialOption1: string | null;

  /**
   * 에디셔널 잠재능력 두 번째 옵션
   */
  additionalPotentialOption2: string | null;

  /**
   * 에디셔널 잠재능력 세 번째 옵션
   */
  additionalPotentialOption3: string | null;

  /**
   * 착용 레벨 증가
   */
  equipmentLevelIncrease: number;

  /**
   * 장비 특별 옵션
   */
  itemExceptionalOption: CharacterItemEquipmentExceptionalOptionDto;

  /**
   * 장비 추가 옵션
   */
  itemAddOption: CharacterItemEquipmentAddOptionDto;

  /**
   * 성장 경험치
   */
  growthExp: number;

  /**
   * 성장 레벨
   */
  growthLevel: number;

  /**
   * 업그레이드 횟수
   */
  scrollUpgrade: string;

  /**
   * 가위 사용 가능 횟수 (교환 불가 장비, 가위 횟수가 없는 교환 가능 장비는 255)
   */
  cuttableCount: string;

  /**
   * 황금 망치 재련 적용 (1:적용, 이외 미 적용)
   */
  goldenHammerFlag: string;

  /**
   * 복구 가능 횟수
   */
  scrollResilienceCount: string;

  /**
   * 업그레이드 가능 횟수
   */
  scrollUpgradeableCount: string;

  /**
   * 소울 명
   */
  soulName: string | null;

  /**
   * 소울 옵션
   */
  soulOption: string | null;

  /**
   * 장비 기타 옵션
   */
  itemEtcOption: CharacterItemEquipmentEtcOptionDto;

  /**
   * 강화 단계
   */
  starforce: string;

  /**
   * 놀라운 장비 강화 주문서 사용 여부 (0:미사용, 1:사용)
   */
  starforceScrollFlag: string;

  /**
   * 장비 스타포스 옵션
   */
  itemStarforceOption: CharacterItemEquipmentStarforceOptionDto;

  /**
   * 특수 반지 레벨
   */
  specialRingLevel: number;

  /**
   * 장비 유효 기간
   */
  dateExpire: Date | null = null;

  /**
   * 장비 유효 기간 만료 여부
   */
  isExpired: boolean | null = null;

  constructor(obj: CharacterItemEquipmentInfoBody) {
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
      this.dateExpire = date_expire
        ? new Date(date_expire)
        : null;
    }
  }
}

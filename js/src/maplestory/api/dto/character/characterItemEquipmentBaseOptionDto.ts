import { CharacterItemEquipmentBaseOptionDtoBody } from '../../response/character/characterItemEquipmentDtoBody';

/**
 * 캐릭터 장비 기본 옵션 정보
 */
class CharacterItemEquipmentBaseOptionDto {
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

  constructor(obj: CharacterItemEquipmentBaseOptionDtoBody) {
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

export { CharacterItemEquipmentBaseOptionDto };

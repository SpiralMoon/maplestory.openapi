import { CharacterItemEquipmentAddOptionBody } from '../../response/character/characterItemEquipmentBody';

/**
 * 캐릭터 장비 추가 옵션 정보
 */
class CharacterItemEquipmentAddOptionDto {
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

export { CharacterItemEquipmentAddOptionDto };

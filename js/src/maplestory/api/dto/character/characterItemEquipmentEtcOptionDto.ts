import { CharacterItemEquipmentEtcOptionBody } from '../../response/character/characterItemEquipmentBody';

/**
 * 캐릭터 장비 기타 옵션 정보
 */
class CharacterItemEquipmentEtcOptionDto {
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

export { CharacterItemEquipmentEtcOptionDto };

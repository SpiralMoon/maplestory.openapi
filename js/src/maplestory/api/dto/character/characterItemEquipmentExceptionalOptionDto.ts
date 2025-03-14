import { CharacterItemEquipmentExceptionalOptionDtoBody } from '../../response/character/characterItemEquipmentDtoBody';

/**
 * 캐릭터 장비 특별 옵션 정보
 */
class CharacterItemEquipmentExceptionalOptionDto {
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

  constructor(obj: CharacterItemEquipmentExceptionalOptionDtoBody) {
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

export { CharacterItemEquipmentExceptionalOptionDto };

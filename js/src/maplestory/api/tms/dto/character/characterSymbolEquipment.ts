import * as base from '../../../common/dto/character/characterSymbolEquipment';
import {
  CharacterSymbolEquipmentBody,
  CharacterSymbolEquipmentInfoBody,
} from '../../response/character/characterSymbolEquipmentBody';

/**
 * 角色已裝備符文資訊
 */
export class CharacterSymbolEquipmentDto extends base.CharacterSymbolEquipmentDto {
  /**
   * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
   */
  public override date: Date | null;

  /**
   * 角色職業
   */
  public override characterClass: string | null;

  /**
   * 符文資訊
   */
  public override symbol: CharacterSymbolEquipmentInfoDto[];

  constructor(obj: CharacterSymbolEquipmentBody) {
    super();

    const { date, character_class, symbol } = obj;

    this.date = date ? new Date(date) : null;
    this.characterClass = character_class;
    this.symbol = symbol.map((s) => new CharacterSymbolEquipmentInfoDto(s));
  }
}

/**
 * 符文資訊
 */
export class CharacterSymbolEquipmentInfoDto extends base.CharacterSymbolEquipmentInfoDto {
  /**
   * 符文名稱
   */
  public override symbolName: string;

  /**
   * 符文圖示
   */
  public override symbolIcon: string;

  /**
   * 符文描述
   */
  public override symbolDescription: string;

  /**
   * 因符文增加的數值
   */
  public override symbolForce: string;

  /**
   * 符文等級
   */
  public override symbolLevel: number;

  /**
   * 符文增加的力量 (STR)
   */
  public override symbolStr: string;

  /**
   * 符文增加的敏捷 (DEX)
   */
  public override symbolDex: string;

  /**
   * 符文增加的智力 (INT)
   */
  public override symbolInt: string;

  /**
   * 符文增加的幸運 (LUK)
   */
  public override symbolLuk: string;

  /**
   * 符文增加的體力 (HP)
   */
  public override symbolHp: string;

  /**
   * 符文增加的道具掉落率
   */
  public override symbolDropRate: string;

  /**
   * 符文增加的楓幣掉落率
   */
  public override symbolMesoRate: string;

  /**
   * 符文增加的經驗值獲得量
   */
  public override symbolExpRate: string;

  /**
   * 現有成長值
   */
  public override symbolGrowthCount: number;

  /**
   * 成長所需的成長值
   */
  public override symbolRequireGrowthCount: number;

  constructor(obj: CharacterSymbolEquipmentInfoBody) {
    super();

    const {
      symbol_name,
      symbol_icon,
      symbol_description,
      symbol_force,
      symbol_level,
      symbol_str,
      symbol_dex,
      symbol_int,
      symbol_luk,
      symbol_hp,
      symbol_drop_rate,
      symbol_meso_rate,
      symbol_exp_rate,
      symbol_growth_count,
      symbol_require_growth_count,
    } = obj;

    this.symbolName = symbol_name;
    this.symbolIcon = symbol_icon;
    this.symbolDescription = symbol_description;
    this.symbolForce = symbol_force;
    this.symbolLevel = symbol_level;
    this.symbolStr = symbol_str;
    this.symbolDex = symbol_dex;
    this.symbolInt = symbol_int;
    this.symbolLuk = symbol_luk;
    this.symbolHp = symbol_hp;
    this.symbolDropRate = symbol_drop_rate ?? '0%';
    this.symbolMesoRate = symbol_meso_rate ?? '0%';
    this.symbolExpRate = symbol_exp_rate ?? '0%';
    this.symbolHp = symbol_hp;
    this.symbolHp = symbol_hp;
    this.symbolGrowthCount = symbol_growth_count;
    this.symbolRequireGrowthCount = symbol_require_growth_count;
  }
}

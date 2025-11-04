import * as base from '../../../common/dto/character/characterSymbolEquipment';
import {
  CharacterSymbolEquipmentBody,
  CharacterSymbolEquipmentInfoBody,
} from '../../response/character/characterSymbolEquipmentBody';

/**
 * Character equipped symbol information
 */
export class CharacterSymbolEquipmentDto extends base.CharacterSymbolEquipmentDto {
  /**
   * Reference date for query (SGT, daily data with hours and minutes set to 0)
   */
  public override date: Date | null;

  /**
   * Character job
   */
  public override characterClass: string;

  /**
   * Symbol information
   */
  public override symbol: CharacterSymbolEquipmentInfoDto[];

  constructor(obj: CharacterSymbolEquipmentBody) {
    super();

    const { date, character_class, symbol } = obj;

    this.date = date ? new Date(date) : null;
    this.characterClass = character_class!;
    this.symbol = symbol.map((s) => new CharacterSymbolEquipmentInfoDto(s));
  }
}

/**
 * Symbol information
 */
export class CharacterSymbolEquipmentInfoDto extends base.CharacterSymbolEquipmentInfoDto {
  /**
   * Symbol name
   */
  public override symbolName: string;

  /**
   * Symbol icon
   */
  public override symbolIcon: string;

  /**
   * Symbol description
   */
  public override symbolDescription: string;

  /**
   * Increase in stats due to the symbol
   */
  public override symbolForce: string;

  /**
   * Symbol level
   */
  public override symbolLevel: number;

  /**
   * Increase in Strength due to the symbol
   */
  public override symbolStr: string;

  /**
   * Increase in Dexterity due to the symbol
   */
  public override symbolDex: string;

  /**
   * Increase in Intelligence due to the symbol
   */
  public override symbolInt: string;

  /**
   * Increase in Luck due to the symbol
   */
  public override symbolLuk: string;

  /**
   * Increase in HP due to the symbol
   */
  public override symbolHp: string;

  /**
   * Increase in item drop rate due to the symbol
   */
  public override symbolDropRate: string;

  /**
   * Increase in Meso acquisition rate due to the symbol
   */
  public override symbolMesoRate: string;

  /**
   * Increase in EXP acquisition rate due to the symbol
   */
  public override symbolExpRate: string;

  /**
   * Current growth points
   */
  public override symbolGrowthCount: number;

  /**
   * Growth points required for the next level
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

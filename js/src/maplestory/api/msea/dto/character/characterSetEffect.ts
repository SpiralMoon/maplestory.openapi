import * as base from '../../../common/dto/character/characterSetEffect';
import {
  CharacterSetEffectBody,
  CharacterSetEffectInfoBody,
  CharacterSetEffectOptionFullBody,
  CharacterSetEffectSetBody,
} from '../../response/character/characterSetEffectBody';

/**
 * Character information about equipped set item effects
 */
export class CharacterSetEffectDto extends base.CharacterSetEffectDto {
  /**
   * Reference date for query (SGT, daily data with hours and minutes set to 0)
   */
  public override date: Date | null;

  /**
   * Set Item effect information
   */
  public override setEffect: CharacterSetEffectSetDto[];

  constructor(obj: CharacterSetEffectBody) {
    super();

    const { date, set_effect } = obj;
    this.date = date ? new Date(date) : null;
    this.setEffect = set_effect.map(
      (effect) => new CharacterSetEffectSetDto(effect),
    );
  }
}

/**
 * Active Set Item effect information
 */
export class CharacterSetEffectInfoDto extends base.CharacterSetEffectInfoDto {
  /**
   * Set Item effect level (number of equipped items)
   */
  public override setCount: number;

  /**
   * Set Item effect
   */
  public override setOption: string;

  constructor(obj: CharacterSetEffectInfoBody) {
    super();

    const { set_count, set_option } = obj;

    this.setCount = set_count;
    this.setOption = set_option;
  }
}

/**
 * All Set Item effect information
 */
export class CharacterSetEffectOptionFullDto extends base.CharacterSetEffectOptionFullDto {
  /**
   * Set Item effect level (number of equipped items)
   */
  public override setCount: number;

  /**
   * Set Item effect
   */
  public override setOption: string;

  constructor(obj: CharacterSetEffectOptionFullBody) {
    super();

    const { set_count, set_option } = obj;

    this.setCount = set_count;
    this.setOption = set_option;
  }
}

/**
 * Set Item effect information
 */
export class CharacterSetEffectSetDto extends base.CharacterSetEffectSetDto {
  /**
   * Set Item effect name
   */
  public override setName: string;

  /**
   * Number of Set Items (including Lucky Items)
   */
  public override totalSetCount: number;

  /**
   * Active Set Item effect information
   */
  public override setEffectInfo: CharacterSetEffectInfoDto[];

  /**
   * All Set Item effect information
   */
  public override setOptionFull: CharacterSetEffectOptionFullDto[];

  constructor(obj: CharacterSetEffectSetBody) {
    super();

    const { set_name, total_set_count, set_effect_info, set_option_full } = obj;

    this.setName = set_name;
    this.totalSetCount = total_set_count;
    this.setEffectInfo = set_effect_info.map(
      (info) => new CharacterSetEffectInfoDto(info),
    );
    this.setOptionFull = set_option_full.map(
      (info) => new CharacterSetEffectOptionFullDto(info),
    );
  }
}

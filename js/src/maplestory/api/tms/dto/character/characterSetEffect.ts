import * as base from '../../../common/dto/character/characterSetEffect';
import {
  CharacterSetEffectBody,
  CharacterSetEffectInfoBody,
  CharacterSetEffectOptionFullBody,
  CharacterSetEffectSetBody,
} from '../../response/character/characterSetEffectBody';

/**
 * 角色目前套用的套裝效果資訊
 */
export class CharacterSetEffectDto extends base.CharacterSetEffectDto {
  /**
   * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
   */
  public override date: Date | null;

  /**
   * 套裝效果資訊
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
 * 目前已裝備的套裝效果資訊
 */
export class CharacterSetEffectInfoDto extends base.CharacterSetEffectInfoDto {
  /**
   * 套裝效果等級 (裝備件數)
   */
  public override setCount: number;

  /**
   * 套裝效果
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
 * 全部套裝效果資訊
 */
export class CharacterSetEffectOptionFullDto extends base.CharacterSetEffectOptionFullDto {
  /**
   * 套裝效果等級 (裝備件數)
   */
  public override setCount: number;

  /**
   * 套裝效果
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
 * 套裝效果資訊
 */
export class CharacterSetEffectSetDto extends base.CharacterSetEffectSetDto {
  /**
   * 套裝效果名稱
   */
  public override setName: string;

  /**
   * 套裝件數 (包含幸運道具)
   */
  public override totalSetCount: number;

  /**
   * 目前已裝備的套裝效果資訊
   */
  public override setEffectInfo: CharacterSetEffectInfoDto[];

  /**
   * 全部套裝效果資訊
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

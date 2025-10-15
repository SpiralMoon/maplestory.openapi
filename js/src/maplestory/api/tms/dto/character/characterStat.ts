import * as base from '../../../common/dto/character/characterStat';
import {
  CharacterFinalStatBody,
  CharacterStatBody,
} from '../../response/character/characterStatBody';

/**
 * 角色綜合能力值資訊
 */
export class CharacterStatDto extends base.CharacterStatDto {
  /**
   * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
   */
  public override date: Date | null;

  /**
   * 角色職業
   */
  public override characterClass: string | null;

  /**
   * 當前能力值資訊
   */
  public override finalStat: CharacterFinalStatDto[];

  /**
   * 剩餘 AP
   */
  public override remainAP: number | null;

  constructor(obj: CharacterStatBody) {
    super();

    const { date, character_class, final_stat, remain_ap } = obj;

    this.date = date ? new Date(date) : null;
    this.characterClass = character_class;
    this.finalStat = final_stat.map((stat) => new CharacterFinalStatDto(stat));
    this.remainAP = remain_ap;
  }
}

/**
 * 當前能力值資訊
 */
export class CharacterFinalStatDto extends base.CharacterFinalStatDto {
  /**
   * 能力值名稱
   */
  public override statName: string;

  /**
   * 能力值數值
   */
  public override statValue: string;

  constructor(obj: CharacterFinalStatBody) {
    super();

    const { stat_name, stat_value } = obj;

    this.statName = stat_name;
    this.statValue = stat_value;
  }
}

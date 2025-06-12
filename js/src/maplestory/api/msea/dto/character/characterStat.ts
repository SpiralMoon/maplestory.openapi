import * as base from '../../../common/dto/character/characterStat';
import {
  CharacterFinalStatBody,
  CharacterStatBody,
} from '../../response/character/characterStatBody';

/**
 * Character comprehensive stats information
 */
export class CharacterStatDto extends base.CharacterStatDto {
  /**
   * Reference date for query (SGT, daily data with hours and minutes set to 0)
   */
  public override date: Date | null;

  /**
   * Character job
   */
  public override characterClass: string | null;

  /**
   * Current stat information
   */
  public override finalStat: CharacterFinalStatDto[];

  /**
   * Remaining AP
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
 * Current stat information
 */
export class CharacterFinalStatDto extends base.CharacterFinalStatDto {
  /**
   * Stat name
   */
  public override statName: string;

  /**
   * Stat value
   */
  public override statValue: string;

  constructor(obj: CharacterFinalStatBody) {
    super();

    const { stat_name, stat_value } = obj;

    this.statName = stat_name;
    this.statValue = stat_value;
  }
}

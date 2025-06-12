import * as base from '../../../common/dto/character/characterStat';
import {
  CharacterFinalStatBody,
  CharacterStatBody,
} from '../../response/character/characterStatBody';

/**
 * 캐릭터 스탯 정보
 */
export class CharacterStatDto extends base.CharacterStatDto {
  /**
   * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
   */
  public override date: Date | null;

  /**
   * 캐릭터 직업
   */
  public override characterClass: string | null;

  /**
   * 현재 스탯 정보
   */
  public override finalStat: CharacterFinalStatDto[];

  /**
   * 잔여 AP
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
 * 캐릭터 현재 스탯 정보
 */
export class CharacterFinalStatDto extends base.CharacterFinalStatDto {
  /**
   * 스탯 명
   */
  public override statName: string;

  /**
   * 스탯 값
   */
  public override statValue: string;

  constructor(obj: CharacterFinalStatBody) {
    super();

    const { stat_name, stat_value } = obj;

    this.statName = stat_name;
    this.statValue = stat_value;
  }
}

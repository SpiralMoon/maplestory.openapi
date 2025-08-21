import {
  CharacterOtherStatBody,
  CharacterOtherStatDetailBody,
  CharacterOtherStatInfoBody,
} from '../../response/character/characterOtherStatBody';

/**
 * 캐릭터 기타 능력치 영향 요소 정보
 */
export class CharacterOtherStatDto {
  /**
   * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
   */
  public date: Date | null;

  /**
   * 능력치에 영향을 주는 요소 및 스탯 정보
   */
  public otherStat: CharacterOtherStatDetailDto[];

  constructor(obj: CharacterOtherStatBody) {
    const { date, other_stat } = obj;

    this.date = date ? new Date(date) : null;
    this.otherStat = other_stat?.map((stat) => new CharacterOtherStatDetailDto(stat)) ?? [];
  }
}

/**
 * 능력치에 영향을 주는 요소 및 스탯 정보
 */
export class CharacterOtherStatDetailDto {
  /**
   * 스탯 타입
   */
  public otherStatType: string;

  /**
   * 스탯 정보
   */
  public statInfo: CharacterOtherStatInfoDto[];

  constructor(obj: CharacterOtherStatDetailBody) {
    const { other_stat_type, stat_info } = obj;

    this.otherStatType = other_stat_type;
    this.statInfo = stat_info.map((info) => new CharacterOtherStatInfoDto(info));
  }
}

/**
 * 스탯 정보
 */
export class CharacterOtherStatInfoDto {
  /**
   * 스탯 명
   */
  public statName: string;

  /**
   * 스탯 값
   */
  public statValue: string;

  constructor(obj: CharacterOtherStatInfoBody) {
    const { stat_name, stat_value } = obj;

    this.statName = stat_name;
    this.statValue = stat_value;
  }
}

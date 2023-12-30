import { CharacterHyperStatInfoDtoBody } from '../response/characterHyperStatDtoBody';

/**
 * 캐릭터 하이퍼 스탯 상세 정보
 */
class CharacterHyperStatInfoDto {
  /**
   * 스탯 종류
   */
  statType: string;

  /**
   * 스탯 투자 포인트
   */
  statPoint: number | null;

  /**
   * 스탯 레벨
   */
  statLevel: number;

  /**
   * 스탯 상승량
   */
  statIncrease: string | null;

  constructor(obj: CharacterHyperStatInfoDtoBody) {
    const { stat_type, stat_point, stat_level, stat_increase } = obj;

    this.statType = stat_type;
    this.statPoint = stat_point;
    this.statLevel = stat_level;
    this.statIncrease = stat_increase;
  }
}

export { CharacterHyperStatInfoDto };

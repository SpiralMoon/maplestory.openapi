import * as base from '../../../common/dto/character/characterPopularity';
import { CharacterPopularityBody } from '../../response/character/characterPopularityBody';

/**
 * 캐릭터 인기도 정보
 */
export class CharacterPopularityDto extends base.CharacterPopularityDto {
  /**
   * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
   */
  public override date: Date | null;

  /**
   * 캐릭터 인기도
   */
  public override popularity: number;

  constructor(obj: CharacterPopularityBody) {
    super();

    const { date, popularity } = obj;

    this.date = date ? new Date(date) : null;
    this.popularity = popularity!;
  }
}

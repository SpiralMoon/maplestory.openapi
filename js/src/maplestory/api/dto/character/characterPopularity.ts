import { CharacterPopularityBody } from '../../response/character/characterPopularityBody';

/**
 * 캐릭터 인기도 정보
 */
export class CharacterPopularityDto {
  /**
   * 조회 기준일
   */
  date: Date | null;

  /**
   * 캐릭터 인기도
   */
  popularity: number;

  constructor(obj: CharacterPopularityBody) {
    const { date, popularity } = obj;

    this.date = date ? new Date(date) : null;
    this.popularity = popularity;
  }
}

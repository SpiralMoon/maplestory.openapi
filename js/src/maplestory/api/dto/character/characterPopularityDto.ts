import { CharacterPopularityDtoBody } from '@src/maplestory/api/response/character/characterPopularityDtoBody';

/**
 * 캐릭터 인기도 정보
 */
class CharacterPopularityDto {
  /**
   * 조회 기준일
   */
  date: Date | null;

  /**
   * 캐릭터 인기도
   */
  popularity: number;

  constructor(obj: CharacterPopularityDtoBody) {
    const { date, popularity } = obj;

    this.date = date ? new Date(date) : null;
    this.popularity = popularity;
  }
}

export { CharacterPopularityDto };

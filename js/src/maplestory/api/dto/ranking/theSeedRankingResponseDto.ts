import { TheSeedRankingDto } from './theSeedRankingDto';
import { TheSeedRankingResponseBody } from '../../response/ranking/theSeedRankingBody';

/**
 * 더 시드 랭킹 응답 정보
 */
class TheSeedRankingResponseDto {
  /**
   * 더 시드 랭킹 정보
   */
  ranking: TheSeedRankingDto[];

  constructor(obj: TheSeedRankingResponseBody) {
    const { ranking } = obj;

    this.ranking = ranking.map((rank) => new TheSeedRankingDto(rank));
  }
}

export { TheSeedRankingResponseDto };

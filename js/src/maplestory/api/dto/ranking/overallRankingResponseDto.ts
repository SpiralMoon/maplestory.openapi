import { OverallRankingDto } from './overallRankingDto';
import { OverallRankingResponseBody } from '../../response/ranking/overallRankingBody';

/**
 * 종합 랭킹 응답 정보
 */
class OverallRankingResponseDto {
  /**
   * 종합 랭킹 정보
   */
  ranking: OverallRankingDto[];

  constructor(obj: OverallRankingResponseBody) {
    const { ranking } = obj;

    this.ranking = ranking.map((rank) => new OverallRankingDto(rank));
  }
}

export { OverallRankingResponseDto };

import { DojangRankingDto } from './dojangRankingDto';
import { DojangRankingResponseBody } from '../../response/ranking/dojangRankingBody';

/**
 * 무릉도장 랭킹 응답 정보
 */
class DojangRankingResponseDto {
  /**
   * 길드 랭킹 정보
   */
  ranking: DojangRankingDto[];

  constructor(obj: DojangRankingResponseBody) {
    const { ranking } = obj;

    this.ranking = ranking.map((rank) => new DojangRankingDto(rank));
  }
}

export { DojangRankingResponseDto };

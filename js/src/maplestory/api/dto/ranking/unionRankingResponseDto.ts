import { UnionRankingDto } from './unionRankingDto';
import { UnionRankingResponseBody } from '../../response/ranking/unionRankingBody';

/**
 * 유니온 랭킹 응답 정보
 */
class UnionRankingResponseDto {
  /**
   * 유니온 랭킹 정보
   */
  ranking: UnionRankingDto[];

  constructor(obj: UnionRankingResponseBody) {
    const { ranking } = obj;

    this.ranking = ranking.map((rank) => new UnionRankingDto(rank));
  }
}

export { UnionRankingResponseDto };

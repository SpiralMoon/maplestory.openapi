import { UnionRankingDto } from '@src/maplestory/api/dto/ranking/unionRankingDto';
import { UnionRankingResponseDtoBody } from '@src/maplestory/api/response/ranking/unionRankingResponseDtoBody';

/**
 * 유니온 랭킹 응답 정보
 */
class UnionRankingResponseDto {
  /**
   * 유니온 랭킹 정보
   */
  ranking: UnionRankingDto[];

  constructor(obj: UnionRankingResponseDtoBody) {
    const { ranking } = obj;

    this.ranking = ranking.map((rank) => new UnionRankingDto(rank));
  }
}

export { UnionRankingResponseDto };

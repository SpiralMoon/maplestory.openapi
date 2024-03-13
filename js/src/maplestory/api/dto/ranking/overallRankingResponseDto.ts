import { OverallRankingDto } from '@src/maplestory/api/dto/ranking/overallRankingDto';
import { OverallRankingResponseDtoBody } from '@src/maplestory/api/response/ranking/overallRankingResponseDtoBody';

/**
 * 종합 랭킹 응답 정보
 */
class OverallRankingResponseDto {
  /**
   * 종합 랭킹 정보
   */
  ranking: OverallRankingDto[];

  constructor(obj: OverallRankingResponseDtoBody) {
    const { ranking } = obj;

    this.ranking = ranking.map((rank) => new OverallRankingDto(rank));
  }
}

export { OverallRankingResponseDto };

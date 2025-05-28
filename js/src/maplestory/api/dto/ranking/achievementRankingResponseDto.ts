import { AchievementRankingDto } from './achievementRankingDto';
import { AchievementRankingResponseBody } from '../../response/ranking/achievementRankingBody';

/**
 * 업적 랭킹 응답 정보
 */
class AchievementRankingResponseDto {
  /**
   * 업적 랭킹 정보
   */
  ranking: AchievementRankingDto[];

  constructor(obj: AchievementRankingResponseBody) {
    const { ranking } = obj;

    this.ranking = ranking.map((rank) => new AchievementRankingDto(rank));
  }
}

export { AchievementRankingResponseDto };

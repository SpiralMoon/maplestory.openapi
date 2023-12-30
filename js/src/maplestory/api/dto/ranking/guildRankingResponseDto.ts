import { GuildRankingDto } from './guildRankingDto';
import { GuildRankingResponseDtoBody } from '../../response/ranking/guildRankingResponseDtoBody';

/**
 * 길드 랭킹 응답 정보
 */
class GuildRankingResponseDto {
  /**
   * 길드 랭킹 정보
   */
  ranking: GuildRankingDto[];

  constructor(obj: GuildRankingResponseDtoBody) {
    const { ranking } = obj;

    this.ranking = ranking.map((rank) => new GuildRankingDto(rank));
  }
}

export { GuildRankingResponseDto };

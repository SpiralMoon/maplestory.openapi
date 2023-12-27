import { GuildRankingDtoBody } from '../response/guildRankingResponseDtoBody';

/**
 * 길드 랭킹 정보
 */
class GuildRankingDto {
  /**
   * 랭킹 업데이트 일자 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
   */
  date: Date;

  /**
   * 길드 랭킹 순위
   */
  ranking: number;

  /**
   * 길드 명
   */
  guildName: string;

  /**
   * 월드 명
   */
  worldName: string;

  /**
   * 길드 레벨
   */
  guildLevel: number;

  /**
   * 길드 마스터 캐릭터 명
   */
  guildMasterName: string;

  /**
   * 길드 마크
   */
  guildMark: string;

  /**
   * 길드 포인트
   */
  guildPoint: number;

  constructor(obj: GuildRankingDtoBody) {
    const {
      date,
      ranking,
      guild_name,
      world_name,
      guild_level,
      guild_master_name,
      guild_mark,
      guild_point,
    } = obj;

    this.date = new Date(date);
    this.ranking = ranking;
    this.guildName = guild_name;
    this.worldName = world_name;
    this.guildLevel = guild_level;
    this.guildMasterName = guild_master_name;
    this.guildMark = guild_mark;
    this.guildPoint = guild_point;
  }
}

export { GuildRankingDto };

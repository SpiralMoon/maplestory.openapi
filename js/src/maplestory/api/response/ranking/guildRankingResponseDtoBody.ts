import { RankingResponseDtoBody } from './rankingResponseDtoBody';

export type GuildRankingResponseDtoBody = RankingResponseDtoBody<GuildRankingDtoBody>;

export type GuildRankingDtoBody = {
  date: string;
  ranking: number;
  guild_name: string;
  world_name: string;
  guild_level: number;
  guild_master_name: string;
  guild_mark: string;
  guild_point: number;
};

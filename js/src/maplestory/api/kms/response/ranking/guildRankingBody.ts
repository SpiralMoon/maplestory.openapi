import { RankingResponseBody } from './rankingResponseBody';

export type GuildRankingBody = {
  date: string;
  ranking: number;
  guild_name: string;
  world_name: string;
  guild_level: number;
  guild_master_name: string;
  guild_mark: string;
  guild_point: number;
};

export type GuildRankingResponseBody = RankingResponseBody<GuildRankingBody>;

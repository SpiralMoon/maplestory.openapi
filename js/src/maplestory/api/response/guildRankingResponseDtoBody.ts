import { RankingResponseDtoBody } from './rankingResponseDtoBody';

type GuildRankingResponseDtoBody = RankingResponseDtoBody<GuildRankingDtoBody>;

type GuildRankingDtoBody = {
  date: string;
  ranking: number;
  guild_name: string;
  world_name: string;
  guild_level: number;
  guild_master_name: string;
  guild_mark: string;
  guild_point: number;
};

export type { GuildRankingResponseDtoBody, GuildRankingDtoBody };

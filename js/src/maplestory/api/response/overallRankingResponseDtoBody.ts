import { RankingResponseDtoBody } from './rankingResponseDtoBody';

type OverallRankingResponseDtoBody =
  RankingResponseDtoBody<OverallRankingDtoBody>;

type OverallRankingDtoBody = {
  date: string;
  ranking: number;
  character_name: string;
  world_name: string;
  class_name: string;
  sub_class_name: string;
  character_level: number;
  character_exp: number;
  character_popularity: number;
  character_guildname: string;
};

export type { OverallRankingResponseDtoBody, OverallRankingDtoBody };

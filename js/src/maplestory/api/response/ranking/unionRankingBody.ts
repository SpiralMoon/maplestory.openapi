import { RankingResponseBody } from './rankingResponseBody';

export type UnionRankingBody = {
  date: string;
  ranking: number;
  character_name: string;
  world_name: string;
  class_name: string;
  sub_class_name: string;
  union_level: number;
  union_power: number;
};

export type UnionRankingResponseBody = RankingResponseBody<UnionRankingBody>;

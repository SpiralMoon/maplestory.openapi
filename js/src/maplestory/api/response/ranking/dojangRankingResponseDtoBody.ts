import { RankingResponseDtoBody } from './rankingResponseDtoBody';

export type DojangRankingResponseDtoBody =
  RankingResponseDtoBody<DojangRankingDtoBody>;

export type DojangRankingDtoBody = {
  date: string;
  ranking: number;
  character_name: string;
  world_name: string;
  class_name: string;
  sub_class_name: string;
  character_level: number;
  dojang_floor: number;
  dojang_time_record: number;
};

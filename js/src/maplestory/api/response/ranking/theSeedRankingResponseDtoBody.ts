import { RankingResponseDtoBody } from './rankingResponseDtoBody';

export type TheSeedRankingResponseDtoBody = RankingResponseDtoBody<TheSeedRankingDtoBody>;

export type TheSeedRankingDtoBody = {
  date: string;
  ranking: number;
  character_name: string;
  world_name: string;
  class_name: string;
  sub_class_name: string;
  character_level: number;
  theseed_floor: number;
  theseed_time_record: number;
};

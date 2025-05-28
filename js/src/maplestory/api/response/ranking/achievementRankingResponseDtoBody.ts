import { RankingResponseDtoBody } from './rankingResponseDtoBody';

export type AchievementRankingResponseDtoBody =
  RankingResponseDtoBody<AchievementRankingDtoBody>;

export type AchievementRankingDtoBody = {
  date: string;
  ranking: number;
  character_name: string;
  world_name: string;
  class_name: string;
  sub_class_name: string;
  trophy_grade: string;
  trophy_score: number;
};

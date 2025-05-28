import { RankingResponseBody } from './rankingResponseBody';

export type AchievementRankingBody = {
  date: string;
  ranking: number;
  character_name: string;
  world_name: string;
  class_name: string;
  sub_class_name: string;
  trophy_grade: string;
  trophy_score: number;
};

export type AchievementRankingResponseBody =
  RankingResponseBody<AchievementRankingBody>;

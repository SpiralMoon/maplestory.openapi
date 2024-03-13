import { RankingResponseDtoBody } from '@src/maplestory/api/response/ranking/rankingResponseDtoBody';

type AchievementRankingResponseDtoBody =
  RankingResponseDtoBody<AchievementRankingDtoBody>;

type AchievementRankingDtoBody = {
  date: string;
  ranking: number;
  character_name: string;
  world_name: string;
  class_name: string;
  sub_class_name: string;
  trophy_grade: string;
  trophy_score: number;
};

export type { AchievementRankingResponseDtoBody, AchievementRankingDtoBody };

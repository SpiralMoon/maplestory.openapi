export type RankingResponseBody<Ranking extends { date: string; ranking: number }> =
  {
    ranking: Ranking[];
  };

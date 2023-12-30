type RankingResponseDtoBody<Ranking extends { date: string; ranking: number }> =
  {
    ranking: Ranking[];
  };

export { RankingResponseDtoBody };

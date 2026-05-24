export type BattlePracticeReplayIdBody = {
  replay_list: BattlePracticeReplayBody[];
};

export type BattlePracticeReplayBody = {
  period_no: number;
  register_date: string;
  replay_id: string;
};

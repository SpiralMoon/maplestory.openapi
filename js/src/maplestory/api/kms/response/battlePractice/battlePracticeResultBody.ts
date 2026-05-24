export type BattlePracticeResultBody = {
  register_date: string;
  total_play_time: number;
  total_damage: number;
  total_dps: number;
  end_type: string;
  like_count: number;
  skill_statistic: BattlePracticeSkillStatisticBody[];
};

export type BattlePracticeSkillStatisticBody = {
  skill_name: string;
  damage: number;
  damage_percent: string;
  dps: number;
  use_count: number;
  damage_per_use: number;
  attack_count: number;
  max_damage: number;
  min_damage: number;
};

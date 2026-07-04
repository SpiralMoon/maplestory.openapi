export type SchedulerCharacterStateBody = {
  date: string | null;
  character_name: string;
  world_name: string;
  character_level: number;
  character_class: string;
  daily_contents: SchedulerDailyContentBody[];
  weekly_contents: SchedulerWeeklyContentBody[];
  boss_contents: SchedulerBossContentBody[];
  weekly_boss_clear_count: number;
  weekly_boss_clear_limit_count: number;
};

export type SchedulerDailyContentBody = {
  content_name: string;
  type: string;
  registration_flag: string;
  now_count: number;
  max_count: number;
  quest_state: string | null;
};

export type SchedulerWeeklyContentBody = {
  content_name: string;
  type: string;
  registration_flag: string;
  now_count: number;
  max_count: number;
  quest_state: string | null;
};

export type SchedulerBossContentBody = {
  content_name: string;
  difficulty: string;
  cycle: string;
  list_order_no: number;
  registration_flag: string;
  complete_flag: string;
};

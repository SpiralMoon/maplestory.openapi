export type PotentialHistoryResponseBody = {
  count: number;
  potential_history: PotentialHistoryBody[];
  next_cursor: string | null;
};

export type PotentialHistoryBody = {
  id: string;
  character_name: string;
  date_create: string;
  potential_type: string;
  item_upgrade_result: string;
  miracle_time_flag: string;
  item_equipment_part: string;
  item_level: number;
  target_item: string;
  potential_option_grade: string;
  additional_potential_option_grade: string;
  upgrade_guarantee: boolean;
  upgrade_guarantee_count: number;
  before_potential_option: PotentialResultOptionBody[];
  before_additional_potential_option: PotentialResultOptionBody[];
  after_potential_option: PotentialResultOptionBody[];
  after_additional_potential_option: PotentialResultOptionBody[];
};

export type PotentialResultOptionBody = {
  value: string;
  grade: string;
};

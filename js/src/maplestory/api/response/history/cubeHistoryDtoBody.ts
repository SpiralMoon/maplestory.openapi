import { CubeResultOptionDtoBody } from './cubeResultOptionDtoBody';

export type CubeHistoryDtoBody = {
  id: string;
  character_name: string;
  world_name: string;
  date_create: string;
  cube_type: string;
  item_upgrade_result: string;
  miracle_time_flag: string;
  item_equipment_part: string;
  item_level: number;
  target_item: string;
  potential_option_grade: string;
  additional_potential_option_grade: string;
  upgrade_guarantee: boolean;
  upgrade_guarantee_count: number;
  before_potential_option: CubeResultOptionDtoBody[];
  before_additional_potential_option: CubeResultOptionDtoBody[];
  after_potential_option: CubeResultOptionDtoBody[];
  after_additional_potential_option: CubeResultOptionDtoBody[];
};

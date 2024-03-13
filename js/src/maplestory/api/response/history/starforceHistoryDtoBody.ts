import { StarforceEventDtoBody } from '@src/maplestory/api/response/history/starforceEventDtoBody';

type StarforceHistoryDtoBody = {
  id: string;
  item_upgrade_result: string;
  before_starforce_count: number;
  after_starforce_count: number;
  starcatch_result: string;
  superior_item_flag: string;
  destroy_defence: string;
  chance_time: string;
  event_field_flag: string;
  upgrade_item: string;
  protect_shield: string;
  bonus_stat_upgrade: string;
  character_name: string;
  world_name: string;
  target_item: string;
  date_create: string;
  starforce_event_list: StarforceEventDtoBody[];
};

export type { StarforceHistoryDtoBody };

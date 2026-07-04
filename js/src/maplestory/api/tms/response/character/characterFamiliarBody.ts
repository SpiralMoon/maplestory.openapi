export type CharacterFamiliarBody = {
  date: string | null;
  familiar_link_slot: CharacterFamiliarLinkSlotBody[];
  familiar_info: CharacterFamiliarInfoBody[];
};

export type CharacterFamiliarLinkSlotBody = {
  slot_id: string | null;
  familiar_name: string | null;
  active_flag: string | null;
  expire_date: string | null;
};

export type CharacterFamiliarInfoBody = {
  familiar_name: string | null;
  familiar_nickname: string | null;
  familiar_special_flag: string | null;
  familiar_state: string | null;
  familiar_level: number;
  familiar_exp: number;
  skill_name: string | null;
  option_level: number;
  option: CharacterFamiliarInfoOptionBody[];
  familiar_grade: string | null;
  look_name: string | null;
  summoned_flag: string | null;
  slot_id: string | null;
};

export type CharacterFamiliarInfoOptionBody = {
  option_no: number;
  option_name: string | null;
  option_value: string | null;
};

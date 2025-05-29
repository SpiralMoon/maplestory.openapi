export type CharacterItemEquipmentBody = {
  date: string | null;
  character_gender: string | null;
  character_class: string | null;
  preset_no: number | null;
  item_equipment: CharacterItemEquipmentInfoBody[];
  item_equipment_preset_1: CharacterItemEquipmentInfoBody[] | null;
  item_equipment_preset_2: CharacterItemEquipmentInfoBody[] | null;
  item_equipment_preset_3: CharacterItemEquipmentInfoBody[] | null;
  title: CharacterItemEquipmentTitleBody | null;
  medal_shape: CharacterItemEquipmentMedalShapeBody | null;
  dragon_equipment: CharacterItemEquipmentDragonInfoBody[];
  mechanic_equipment: CharacterItemEquipmentMechanicInfoBody[];
};

export type CharacterItemEquipmentInfoBody = {
  item_equipment_part: string;
  item_equipment_slot: string;
  item_name: string;
  item_icon: string;
  item_description: string | null;
  item_shape_name: string;
  item_shape_icon: string;
  item_gender: string | null;
  item_total_option: CharacterItemEquipmentOptionBody;
  item_base_option: CharacterItemEquipmentBaseOptionBody;
  potential_option_grade: string | null;
  additional_potential_option_grade: string | null;
  potential_option_1: string | null;
  potential_option_2: string | null;
  potential_option_3: string | null;
  additional_potential_option_1: string | null;
  additional_potential_option_2: string | null;
  additional_potential_option_3: string | null;
  equipment_level_increase: number;
  item_exceptional_option: CharacterItemEquipmentExceptionalOptionBody;
  item_add_option: CharacterItemEquipmentAddOptionBody;
  growth_exp: number;
  growth_level: number;
  scroll_upgrade: string;
  cuttable_count: string;
  golden_hammer_flag: string;
  scroll_resilience_count: string;
  scroll_upgradeable_count: string;
  soul_name: string | null;
  soul_option: string | null;
  item_etc_option: CharacterItemEquipmentOptionBody;
  starforce: string;
  starforce_scroll_flag: string;
  item_starforce_option: CharacterItemEquipmentOptionBody;
  special_ring_level: number;
  date_expire: string | null;
};

export type CharacterItemEquipmentMechanicInfoBody = {
  item_equipment_part: string;
  item_equipment_slot: string;
  item_name: string;
  item_icon: string;
  item_description: string | null;
  item_shape_name: string;
  item_shape_icon: string;
  item_gender: string | null;
  item_total_option: CharacterItemEquipmentOptionBody;
  item_base_option: CharacterItemEquipmentBaseOptionBody;
  equipment_level_increase: number;
  item_exceptional_option: CharacterItemEquipmentExceptionalOptionBody;
  item_add_option: CharacterItemEquipmentAddOptionBody;
  growth_exp: number;
  growth_level: number;
  scroll_upgrade: string;
  cuttable_count: string;
  golden_hammer_flag: string;
  scroll_resilience_count: string;
  scroll_upgradeable_count: string;
  soul_name: string | null;
  soul_option: string | null;
  item_etc_option: CharacterItemEquipmentOptionBody;
  starforce: string;
  starforce_scroll_flag: string;
  item_starforce_option: CharacterItemEquipmentOptionBody;
  special_ring_level: number;
  date_expire: string | null;
};

export type CharacterItemEquipmentDragonInfoBody =
  CharacterItemEquipmentMechanicInfoBody;

export type CharacterItemEquipmentOptionBody = {
  str: string;
  dex: string;
  int: string;
  luk: string;
  max_hp: string;
  max_mp: string;
  attack_power: string;
  magic_power: string;
  armor: string;
  speed: string;
  jump: string;
  boss_damage: string;
  ignore_monster_armor: string;
  all_stat: string;
  damage: string;
  equipment_level_decrease: number;
  max_hp_rate: string;
  max_mp_rate: string;
};

export type CharacterItemEquipmentExceptionalOptionBody = {
  str: string;
  dex: string;
  int: string;
  luk: string;
  max_hp: string;
  max_mp: string;
  attack_power: string;
  magic_power: string;
  exceptional_upgrade: number | null;
};

export type CharacterItemEquipmentTotalOptionBody = {
  str: string;
  dex: string;
  int: string;
  luk: string;
  max_hp: string;
  max_mp: string;
  attack_power: string;
  magic_power: string;
  armor: string;
  speed: string;
  jump: string;
  boss_damage: string;
  ignore_monster_armor: string;
  all_stat: string;
  damage: string;
  equipment_level_decrease: number;
  max_hp_rate: string;
  max_mp_rate: string;
};

export type CharacterItemEquipmentBaseOptionBody = {
  str: string;
  dex: string;
  int: string;
  luk: string;
  max_hp: string;
  max_mp: string;
  attack_power: string;
  magic_power: string;
  armor: string;
  speed: string;
  jump: string;
  boss_damage: string;
  ignore_monster_armor: string;
  all_stat: string;
  max_hp_rate: string;
  max_mp_rate: string;
  base_equipment_level: number;
};

export type CharacterItemEquipmentAddOptionBody = {
  str: string;
  dex: string;
  int: string;
  luk: string;
  max_hp: string;
  max_mp: string;
  attack_power: string;
  magic_power: string;
  armor: string;
  speed: string;
  jump: string;
  boss_damage: string;
  damage: string;
  all_stat: string;
  equipment_level_decrease: number;
};

export type CharacterItemEquipmentEtcOptionBody = {
  str: string;
  dex: string;
  int: string;
  luk: string;
  max_hp: string;
  max_mp: string;
  attack_power: string;
  magic_power: string;
  armor: string;
  speed: string;
  jump: string;
};

export type CharacterItemEquipmentStarforceOptionBody =
  CharacterItemEquipmentEtcOptionBody;

export type CharacterItemEquipmentTitleBody = {
  title_name: string | null;
  title_icon: string | null;
  title_description: string | null;
  date_expire: string | null;
  date_option_expire: string | null;
  title_shape_name: string | null;
  title_shape_icon: string | null;
  title_shape_description: string | null;
};

export type CharacterItemEquipmentMedalShapeBody = {
  medal_shape_name: string;
  medal_shape_icon: string;
  medal_shape_description: string;
  medal_shape_changed_name: string;
  medal_shape_changed_icon: string;
  medal_shape_changed_description: string;
};

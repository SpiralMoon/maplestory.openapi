export type BattlePracticeCharacterInfoBody = {
  basic_object: BattlePracticeCharacterBasicBody | null;
  stat_object: BattlePracticeCharacterStatBody | null;
  hyper_stat_object: BattlePracticeCharacterHyperStatObjectBody | null;
  propensity_object: BattlePracticeCharacterPropensityBody | null;
  ability_object: BattlePracticeCharacterAbilityObjectBody | null;
  item_object: BattlePracticeCharacterItemObjectBody | null;
  cash_item_object: BattlePracticeCharacterCashItemObjectBody | null;
  pet_object: BattlePracticeCharacterPetObjectBody | null;
  skill_object: BattlePracticeCharacterSkillObjectBody | null;
  link_skill_object: BattlePracticeCharacterLinkSkillObjectBody | null;
  v_matrix_object: BattlePracticeCharacterVMatrixObjectBody | null;
  hexa_matrix_object: BattlePracticeCharacterHexaMatrixObjectBody | null;
  ring_reserve_skill_object: BattlePracticeCharacterRingReserveSkillObjectBody | null;
  union_raider_object: BattlePracticeUnionRaiderObjectBody | null;
  union_artifact_object: BattlePracticeUnionArtifactObjectBody | null;
  union_champion_object: BattlePracticeUnionChampionObjectBody | null;
  guild_object: BattlePracticeGuildObjectBody | null;
};

export type BattlePracticeCharacterBasicBody = {
  character_name: string;
  character_level: number;
  character_class: string;
  character_class_level: string;
  character_image: string;
};

export type BattlePracticeCharacterStatBody = {
  basic_stat_object: BattlePracticeCharacterBasicStatBody;
  symbol_stat_object: BattlePracticeCharacterSymbolStatBody;
  other_stat_object: BattlePracticeCharacterOtherStatBody;
};

export type BattlePracticeCharacterBasicStatBody = {
  final_stat: BattlePracticeCharacterFinalStatBody[];
};

export type BattlePracticeCharacterFinalStatBody = {
  stat_name: string;
  stat_value: string;
};

export type BattlePracticeCharacterSymbolStatBody = {
  symbol: BattlePracticeCharacterSymbolBody[];
};

export type BattlePracticeCharacterSymbolBody = {
  symbol_name: string;
  symbol_icon: string;
  symbol_description: string;
  symbol_other_effect_description: string | null;
  symbol_force: string;
  symbol_level: number;
  symbol_str: string;
  symbol_dex: string;
  symbol_int: string;
  symbol_luk: string;
  symbol_hp: string;
  symbol_drop_rate: string;
  symbol_meso_rate: string;
  symbol_exp_rate: string;
  symbol_growth_count: number;
  symbol_require_growth_count: number;
};

export type BattlePracticeCharacterOtherStatBody = {
  other_stat: BattlePracticeCharacterOtherStatDetailBody[];
};

export type BattlePracticeCharacterOtherStatDetailBody = {
  other_stat_type: string;
  stat_info: BattlePracticeCharacterOtherStatInfoBody[];
};

export type BattlePracticeCharacterOtherStatInfoBody = {
  stat_name: string;
  stat_value: string;
};

export type BattlePracticeCharacterHyperStatObjectBody = {
  hyper_stat: BattlePracticeCharacterHyperStatBody[];
};

export type BattlePracticeCharacterHyperStatBody = {
  stat_type: string;
  stat_level: number;
  stat_increase: string;
};

export type BattlePracticeCharacterPropensityBody = {
  charisma_level: number;
  sensibility_level: number;
  insight_level: number;
  willingness_level: number;
  handicraft_level: number;
  charm_level: number;
};

export type BattlePracticeCharacterAbilityObjectBody = {
  ability_info: BattlePracticeCharacterAbilityInfoBody[];
};

export type BattlePracticeCharacterAbilityInfoBody = {
  ability_no: string;
  ability_grade: string;
  ability_value: string;
};

export type BattlePracticeCharacterItemObjectBody = {
  item_equipment_object: BattlePracticeCharacterItemEquipmentObjectBody;
  set_effect_object: BattlePracticeCharacterSetEffectObjectBody;
};

export type BattlePracticeCharacterItemEquipmentObjectBody = {
  item_equipment: BattlePracticeCharacterItemEquipmentBody[];
  title: BattlePracticeCharacterItemTitleBody | null;
  dragon_equipment: BattlePracticeCharacterItemDragonEquipmentBody[];
  mechanic_equipment: BattlePracticeCharacterItemMechanicEquipmentBody[];
};

export type BattlePracticeCharacterItemEquipmentBody = {
  item_equipment_part: string;
  item_equipment_slot: string;
  item_name: string;
  item_icon: string;
  item_description: string | null;
  item_shape_name: string;
  item_shape_icon: string;
  item_gender: string | null;
  item_total_option: BattlePracticeCharacterItemTotalOptionBody;
  item_base_option: BattlePracticeCharacterItemBaseOptionBody;
  potential_option_flag: string | null;
  additional_potential_option_flag: string | null;
  potential_option_grade: string | null;
  additional_potential_option_grade: string | null;
  potential_option_1: string | null;
  potential_option_2: string | null;
  potential_option_3: string | null;
  additional_potential_option_1: string | null;
  additional_potential_option_2: string | null;
  additional_potential_option_3: string | null;
  equipment_level_increase: number;
  item_exceptional_option: BattlePracticeCharacterItemExceptionalOptionBody;
  item_add_option: BattlePracticeCharacterItemAddOptionBody;
  growth_exp: number;
  growth_level: number;
  scroll_upgrade: string;
  cuttable_count: string;
  golden_hammer_flag: string;
  scroll_resilience_count: string;
  scroll_upgrade_able_count: string;
  soul_name: string | null;
  soul_option: string | null;
  item_etc_option: BattlePracticeCharacterItemEtcOptionBody;
  starforce: string;
  starforce_scroll_flag: string;
  item_starforce_option: BattlePracticeCharacterItemStarforceOptionBody;
  special_ring_level: number;
  date_expire: string | null;
  freestyle_flag: string | null;
};

export type BattlePracticeCharacterItemDragonEquipmentBody = {
  item_equipment_part: string;
  item_equipment_slot: string;
  item_name: string;
  item_icon: string;
  item_description: string | null;
  item_shape_name: string;
  item_shape_icon: string;
  item_gender: string | null;
  item_total_option: BattlePracticeCharacterItemTotalOptionBody;
  item_base_option: BattlePracticeCharacterItemBaseOptionBody;
  equipment_level_increase: number;
  item_exceptional_option: BattlePracticeCharacterItemExceptionalOptionBody;
  item_add_option: BattlePracticeCharacterItemAddOptionBody;
  growth_exp: number;
  growth_level: number;
  scroll_upgrade: string;
  cuttable_count: string;
  golden_hammer_flag: string;
  scroll_resilience_count: string;
  scroll_upgrade_able_count: string;
  soul_name: string | null;
  soul_option: string | null;
  item_etc_option: BattlePracticeCharacterItemEtcOptionBody;
  starforce: string;
  starforce_scroll_flag: string;
  item_starforce_option: BattlePracticeCharacterItemStarforceOptionBody;
  special_ring_level: number;
  date_expire: string | null;
  freestyle_flag: string | null;
};

export type BattlePracticeCharacterItemMechanicEquipmentBody = {
  item_equipment_part: string;
  item_equipment_slot: string;
  item_name: string;
  item_icon: string;
  item_description: string | null;
  item_shape_name: string;
  item_shape_icon: string;
  item_gender: string | null;
  item_total_option: BattlePracticeCharacterItemTotalOptionBody;
  item_base_option: BattlePracticeCharacterItemBaseOptionBody;
  equipment_level_increase: number;
  item_exceptional_option: BattlePracticeCharacterItemExceptionalOptionBody;
  item_add_option: BattlePracticeCharacterItemAddOptionBody;
  growth_exp: number;
  growth_level: number;
  scroll_upgrade: string;
  cuttable_count: string;
  golden_hammer_flag: string;
  scroll_resilience_count: string;
  scroll_upgrade_able_count: string;
  soul_name: string | null;
  soul_option: string | null;
  item_etc_option: BattlePracticeCharacterItemEtcOptionBody;
  starforce: string;
  starforce_scroll_flag: string;
  item_starforce_option: BattlePracticeCharacterItemStarforceOptionBody;
  special_ring_level: number;
  date_expire: string | null;
  freestyle_flag: string | null;
};

export type BattlePracticeCharacterItemTotalOptionBody = {
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

export type BattlePracticeCharacterItemBaseOptionBody = {
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

export type BattlePracticeCharacterItemExceptionalOptionBody = {
  str: string;
  dex: string;
  int: string;
  luk: string;
  max_hp: string;
  max_mp: string;
  attack_power: string;
  magic_power: string;
  exceptional_upgrade: number;
};

export type BattlePracticeCharacterItemAddOptionBody = {
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

export type BattlePracticeCharacterItemEtcOptionBody = {
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

export type BattlePracticeCharacterItemStarforceOptionBody = {
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

export type BattlePracticeCharacterItemTitleBody = {
  title_name: string;
  title_icon: string;
  title_description: string;
  date_expire: string | null;
  date_option_expire: string | null;
  title_shape_name: string | null;
  title_shape_icon: string | null;
  title_shape_description: string | null;
};

export type BattlePracticeCharacterSetEffectObjectBody = {
  set_effect: BattlePracticeCharacterSetEffectBody[];
};

export type BattlePracticeCharacterSetEffectBody = {
  set_name: string;
  total_set_count: number;
  set_effect_info: BattlePracticeCharacterSetEffectInfoBody[];
};

export type BattlePracticeCharacterSetEffectInfoBody = {
  set_count: number;
  set_option: string;
};

export type BattlePracticeCharacterCashItemObjectBody = {
  cash_item_equipment_base: BattlePracticeCharacterCashItemEquipmentBody[];
  additional_cash_item_equipment_base: BattlePracticeCharacterCashItemEquipmentBody[];
};

export type BattlePracticeCharacterCashItemEquipmentBody = {
  cash_item_equipment_part: string;
  cash_item_equipment_slot: string;
  cash_item_name: string;
  cash_item_icon: string;
  cash_item_description: string | null;
  cash_item_option: BattlePracticeCharacterCashItemOptionBody[];
  date_expire: string | null;
  date_option_expire: string | null;
};

export type BattlePracticeCharacterCashItemOptionBody = {
  option_type: string;
  option_value: string;
};

export type BattlePracticeCharacterPetObjectBody = {
  pet_1_name: string | null;
  pet_1_nickname: string | null;
  pet_1_icon: string | null;
  pet_1_description: string | null;
  pet_1_equipment: BattlePracticeCharacterPetEquipmentBody | null;
  pet_1_auto_skill: BattlePracticeCharacterPetAutoSkillBody | null;
  pet_1_pet_type: string | null;
  pet_1_skill: string[];
  pet_1_date_expire: string | null;
  pet_2_name: string | null;
  pet_2_nickname: string | null;
  pet_2_icon: string | null;
  pet_2_description: string | null;
  pet_2_equipment: BattlePracticeCharacterPetEquipmentBody | null;
  pet_2_auto_skill: BattlePracticeCharacterPetAutoSkillBody | null;
  pet_2_pet_type: string | null;
  pet_2_skill: string[];
  pet_2_date_expire: string | null;
  pet_3_name: string | null;
  pet_3_nickname: string | null;
  pet_3_icon: string | null;
  pet_3_description: string | null;
  pet_3_equipment: BattlePracticeCharacterPetEquipmentBody | null;
  pet_3_auto_skill: BattlePracticeCharacterPetAutoSkillBody | null;
  pet_3_pet_type: string | null;
  pet_3_skill: string[];
  pet_3_date_expire: string | null;
};

export type BattlePracticeCharacterPetEquipmentBody = {
  item_name: string;
  item_icon: string;
  item_description: string | null;
  item_option: BattlePracticeCharacterPetEquipmentOptionBody[];
  scroll_upgrade: number;
  scroll_upgradable: number;
  item_shape: string | null;
  item_shape_icon: string | null;
  item_date_expire: string | null;
};

export type BattlePracticeCharacterPetEquipmentOptionBody = {
  option_type: string;
  option_value: string;
};

export type BattlePracticeCharacterPetAutoSkillBody = {
  skill_1: string | null;
  skill_1_icon: string | null;
  skill_2: string | null;
  skill_2_icon: string | null;
};

export type BattlePracticeCharacterSkillObjectBody = {
  character_skill: BattlePracticeCharacterSkillInfoBody[];
};

export type BattlePracticeCharacterSkillInfoBody = {
  skill_name: string;
  skill_description: string;
  skill_level: number;
  skill_effect: string | null;
  skill_icon: string;
};

export type BattlePracticeCharacterLinkSkillObjectBody = {
  character_link_skill: BattlePracticeCharacterSkillInfoBody[];
  character_owned_link_skill: BattlePracticeCharacterSkillInfoBody | null;
};

export type BattlePracticeCharacterVMatrixObjectBody = {
  character_v_core_equipment: BattlePracticeCharacterVCoreBody[];
};

export type BattlePracticeCharacterVCoreBody = {
  slot_id: string;
  slot_level: number;
  v_core_name: string;
  v_core_type: string;
  v_core_level: number;
  v_core_skill_1: string | null;
  v_core_skill_2: string | null;
  v_core_skill_3: string | null;
};

export type BattlePracticeCharacterHexaMatrixObjectBody = {
  hexa_core_object: BattlePracticeCharacterHexaCoreObjectBody;
  hexa_matrix_stat_object: BattlePracticeCharacterHexaMatrixStatObjectBody;
};

export type BattlePracticeCharacterHexaCoreObjectBody = {
  character_hexa_core_equipment: BattlePracticeCharacterHexaCoreEquipmentBody[];
};

export type BattlePracticeCharacterHexaCoreEquipmentBody = {
  hexa_core_name: string;
  hexa_core_level: number;
  hexa_core_type: string;
  linked_skill: BattlePracticeCharacterHexaLinkedSkillBody[];
};

export type BattlePracticeCharacterHexaLinkedSkillBody = {
  hexa_skill_id: string;
};

export type BattlePracticeCharacterHexaMatrixStatObjectBody = {
  character_hexa_stat_core: BattlePracticeCharacterHexaStatCoreBody[];
  character_hexa_stat_core_2: BattlePracticeCharacterHexaStatCoreBody[];
  character_hexa_stat_core_3: BattlePracticeCharacterHexaStatCoreBody[];
};

export type BattlePracticeCharacterHexaStatCoreBody = {
  slot_id: string;
  main_stat_name: string;
  sub_stat_name_1: string;
  sub_stat_name_2: string;
  main_stat_level: number;
  sub_stat_level_1: number;
  sub_stat_level_2: number;
  stat_grade: number;
};

export type BattlePracticeCharacterRingReserveSkillObjectBody = {
  special_ring_reserve_name: string | null;
  special_ring_reserve_level: number | null;
  special_ring_reserve_icon: string | null;
  special_ring_reserve_description: string | null;
};

export type BattlePracticeUnionRaiderObjectBody = {
  union_raider_stat: string[];
  union_occupied_stat: string[];
};

export type BattlePracticeUnionArtifactObjectBody = {
  union_artifact_effect: BattlePracticeUnionArtifactEffectBody[];
};

export type BattlePracticeUnionArtifactEffectBody = {
  name: string;
  level: number;
};

export type BattlePracticeUnionChampionObjectBody = {
  champion_badge_total_info: BattlePracticeUnionChampionBadgeBody[];
};

export type BattlePracticeUnionChampionBadgeBody = {
  stat: string;
};

export type BattlePracticeGuildObjectBody = {
  guild_skill: BattlePracticeGuildSkillBody[];
  guild_noblesse_skill: BattlePracticeGuildSkillBody[];
};

export type BattlePracticeGuildSkillBody = {
  skill_name: string;
  skill_description: string;
  skill_level: number;
  skill_effect: string;
  skill_icon: string;
};

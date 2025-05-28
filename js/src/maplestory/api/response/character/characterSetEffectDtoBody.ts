export type CharacterSetEffectDtoBody = {
  date: string | null;
  set_effect: CharacterSetEffectSetDtoBody[];
};

export type CharacterSetEffectSetDtoBody = {
  set_name: string;
  total_set_count: number;
  set_effect_info: CharacterSetEffectInfoDtoBody[];
  set_option_full: CharacterSetEffectOptionFullDtoBody[];
};

export type CharacterSetEffectInfoDtoBody = {
  set_count: number;
  set_option: string;
};

export type CharacterSetEffectOptionFullDtoBody = {
  set_count: number;
  set_option: string;
};

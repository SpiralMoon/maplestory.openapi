export type CharacterSetEffectBody = {
  date: string | null;
  set_effect: CharacterSetEffectSetBody[];
};

export type CharacterSetEffectSetBody = {
  set_name: string;
  total_set_count: number;
  set_effect_info: CharacterSetEffectInfoBody[];
  set_option_full: CharacterSetEffectOptionFullBody[];
};

export type CharacterSetEffectInfoBody = {
  set_count: number;
  set_option: string;
};

export type CharacterSetEffectOptionFullBody = {
  set_count: number;
  set_option: string;
};

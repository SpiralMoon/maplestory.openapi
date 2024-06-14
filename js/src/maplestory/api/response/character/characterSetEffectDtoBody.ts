type CharacterSetEffectDtoBody = {
  date: string | null;
  set_effect: CharacterSetEffectSetDtoBody[];
};

type CharacterSetEffectSetDtoBody = {
  set_name: string;
  total_set_count: number;
  set_effect_info: CharacterSetEffectInfoDtoBody[];
  set_option_full: CharacterSetEffectOptionFullDtoBody[];
};

type CharacterSetEffectInfoDtoBody = {
  set_count: number;
  set_option: string;
};

type CharacterSetEffectOptionFullDtoBody = {
  set_count: number;
  set_option: string;
};

export {
  CharacterSetEffectDtoBody,
  CharacterSetEffectSetDtoBody,
  CharacterSetEffectInfoDtoBody,
  CharacterSetEffectOptionFullDtoBody,
};

type CharacterSetEffectDtoBody = {
  date: string | null;
  set_effect: CharacterSetEffectSetDtoBody[];
};

type CharacterSetEffectSetDtoBody = {
  set_name: string;
  total_set_count: number;
  set_effect_info: CharacterSetEffectInfoDtoBody[];
  set_effect_full_info: CharacterSetEffectFullInfoDtoBody[];
};

type CharacterSetEffectInfoDtoBody = {
  set_count: number;
  set_option: string;
};

type CharacterSetEffectFullInfoDtoBody = {
  set_count: number;
  set_option: string;
};

export {
  CharacterSetEffectDtoBody,
  CharacterSetEffectSetDtoBody,
  CharacterSetEffectInfoDtoBody,
  CharacterSetEffectFullInfoDtoBody,
};

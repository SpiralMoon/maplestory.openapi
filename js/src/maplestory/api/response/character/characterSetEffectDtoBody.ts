type CharacterSetEffectDtoBody = {
  date: string | null;
  set_effect: CharacterSetEffectInfoDtoBody[];
};

type CharacterSetEffectInfoDtoBody = {
  set_name: string;
  total_set_count: number;
  set_effect_info: CharacterSetEffectOptionInfoDtoBody[];
};

type CharacterSetEffectOptionInfoDtoBody = {
  set_count: number;
  set_option: string;
};

export {
  CharacterSetEffectDtoBody,
  CharacterSetEffectInfoDtoBody,
  CharacterSetEffectOptionInfoDtoBody,
};

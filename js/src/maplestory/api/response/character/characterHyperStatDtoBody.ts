type CharacterHyperStatDtoBody = {
  date: string | null;
  character_class: string;
  use_preset_no: string;
  use_available_hyper_stat: number;
  hyper_stat_preset_1: CharacterHyperStatPresetDtoBody[];
  hyper_stat_preset_1_remain_point: number;
  hyper_stat_preset_2: CharacterHyperStatPresetDtoBody[];
  hyper_stat_preset_2_remain_point: number;
  hyper_stat_preset_3: CharacterHyperStatPresetDtoBody[];
  hyper_stat_preset_3_remain_point: number;
};

type CharacterHyperStatPresetDtoBody = {
  stat_type: string;
  stat_point: number | null;
  stat_level: number;
  stat_increase: string | null;
};

export type { CharacterHyperStatDtoBody, CharacterHyperStatPresetDtoBody };

export type CharacterHyperStatBody = {
  date: string | null;
  character_class: string | null;
  use_preset_no: string | null;
  use_available_hyper_stat: number | null;
  hyper_stat_preset_1: CharacterHyperStatPresetBody[];
  hyper_stat_preset_1_remain_point: number | null;
  hyper_stat_preset_2: CharacterHyperStatPresetBody[];
  hyper_stat_preset_2_remain_point: number | null;
  hyper_stat_preset_3: CharacterHyperStatPresetBody[];
  hyper_stat_preset_3_remain_point: number | null;
};

export type CharacterHyperStatPresetBody = {
  stat_type: string;
  stat_point: number | null;
  stat_level: number;
  stat_increase: string | null;
};

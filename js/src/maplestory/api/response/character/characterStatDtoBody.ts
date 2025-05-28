export type CharacterStatDtoBody = {
  date: string | null;
  character_class: string | null;
  final_stat: CharacterFinalStatDtoBody[];
  remain_ap: number | null;
};

export type CharacterFinalStatDtoBody = {
  stat_name: string;
  stat_value: string;
};

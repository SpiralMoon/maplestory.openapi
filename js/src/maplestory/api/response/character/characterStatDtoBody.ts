type CharacterStatDtoBody = {
  date: string | null;
  character_class: string | null;
  final_stat: {
    stat_name: string;
    stat_value: string;
  }[];
  remain_ap: number | null;
};

export type { CharacterStatDtoBody };

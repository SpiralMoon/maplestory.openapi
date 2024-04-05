type CharacterStatDtoBody = {
  date: string | null;
  character_class: string;
  final_stat: {
    stat_name: string;
    stat_value: string;
  }[];
  remain_ap: number;
};

export type { CharacterStatDtoBody };

export type CharacterStatBody = {
  date: string | null;
  character_class: string | null;
  final_stat: CharacterFinalStatBody[];
  remain_ap: number | null;
};

export type CharacterFinalStatBody = {
  stat_name: string;
  stat_value: string;
};

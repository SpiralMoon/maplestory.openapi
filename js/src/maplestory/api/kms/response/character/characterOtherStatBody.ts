export interface CharacterOtherStatBody {
  date: string | null;
  other_stat: CharacterOtherStatDetailBody[] | null;
}

export interface CharacterOtherStatDetailBody {
  other_stat_type: string;
  stat_info: CharacterOtherStatInfoBody[];
}

export interface CharacterOtherStatInfoBody {
  stat_name: string;
  stat_value: string;
}

type CharacterHexaMatrixStatDtoBody = {
  date: string;
  character_class: string;
  character_hexa_stat_core: CharacterHexaMatrixStatCoreDtoBody[];
  preset_hexa_stat_core: CharacterHexaMatrixStatCoreDtoBody[];
};

type CharacterHexaMatrixStatCoreDtoBody = {
  slot_id: string;
  main_stat_name: string;
  sub_stat_name_1: string;
  sub_stat_name_2: string;
  main_stat_level: number;
  sub_stat_level_1: number;
  sub_stat_level_2: number;
  stat_grade: number;
};

export type {
  CharacterHexaMatrixStatDtoBody,
  CharacterHexaMatrixStatCoreDtoBody,
};

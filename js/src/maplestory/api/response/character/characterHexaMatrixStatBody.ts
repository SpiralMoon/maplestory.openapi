export type CharacterHexaMatrixStatBody = {
  date: string | null;
  character_class: string | null;
  character_hexa_stat_core: CharacterHexaMatrixStatCoreBody[] | null;
  character_hexa_stat_core_2: CharacterHexaMatrixStatCoreBody[] | null;
  character_hexa_stat_core_3: CharacterHexaMatrixStatCoreBody[] | null;
  preset_hexa_stat_core: CharacterHexaMatrixStatCoreBody[] | null;
  preset_hexa_stat_core_2: CharacterHexaMatrixStatCoreBody[] | null;
  preset_hexa_stat_core_3: CharacterHexaMatrixStatCoreBody[] | null;
};

export type CharacterHexaMatrixStatCoreBody = {
  slot_id: string;
  main_stat_name: string;
  sub_stat_name_1: string;
  sub_stat_name_2: string;
  main_stat_level: number;
  sub_stat_level_1: number;
  sub_stat_level_2: number;
  stat_grade: number;
};

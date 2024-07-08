type CharacterVMatrixDtoBody = {
  date: string | null;
  character_class: string;
  character_v_core_equipment: CharacterVMatrixCoreEquipmentDtoBody[];
  character_v_matrix_remain_slot_upgrade_point: number;
};

type CharacterVMatrixCoreEquipmentDtoBody = {
  slot_id: string;
  slot_level: number;
  v_core_name: string | null;
  v_core_type: string | null;
  v_core_level: number;
  v_core_skill_1: string;
  v_core_skill_2: string | null;
  v_core_skill_3: string | null;
};

export type { CharacterVMatrixDtoBody, CharacterVMatrixCoreEquipmentDtoBody };

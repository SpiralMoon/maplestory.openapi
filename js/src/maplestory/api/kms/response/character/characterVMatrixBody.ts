export type CharacterVMatrixBody = {
  date: string | null;
  character_class: string | null;
  character_v_core_equipment: CharacterVMatrixCoreEquipmentDtoBody[];
  character_v_matrix_remain_slot_upgrade_point: number | null;
  character_v_core_equipment_preset_1: CharacterVMatrixCoreEquipmentPresetBody[];
  character_v_core_equipment_preset_2: CharacterVMatrixCoreEquipmentPresetBody[];
  character_v_core_equipment_preset_3: CharacterVMatrixCoreEquipmentPresetBody[];
  character_v_core_equipment_preset_4: CharacterVMatrixCoreEquipmentPresetBody[];
  character_v_core_equipment_preset_5: CharacterVMatrixCoreEquipmentPresetBody[];
};

export type CharacterVMatrixCoreEquipmentDtoBody = {
  slot_id: string;
  slot_level: number;
  v_core_name: string | null;
  v_core_type: string | null;
  v_core_level: number;
  v_core_skill_1: string | null;
  v_core_skill_2: string | null;
  v_core_skill_3: string | null;
};

export type CharacterVMatrixCoreEquipmentPresetBody = {
  v_core_name: string | null;
  v_core_type: string | null;
  v_core_level: number;
};

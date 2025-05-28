export type CharacterHexaMatrixBody = {
  date: string | null;
  character_hexa_core_equipment: CharacterHexaMatrixEquipmentBody[] | null;
};

export type CharacterHexaMatrixEquipmentBody = {
  hexa_core_name: string;
  hexa_core_level: number;
  hexa_core_type: string;
  linked_skill: CharacterHexaMatrixEquipmentLinkedSkillBody[];
};

export type CharacterHexaMatrixEquipmentLinkedSkillBody = {
  hexa_skill_id: string;
};

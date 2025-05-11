type CharacterHexaMatrixDtoBody = {
  date: string | null;
  character_hexa_core_equipment: CharacterHexaMatrixEquipmentDtoBody[] | null;
};

type CharacterHexaMatrixEquipmentDtoBody = {
  hexa_core_name: string;
  hexa_core_level: number;
  hexa_core_type: string;
  linked_skill: CharacterHexaMatrixEquipmentLinkedSkillDtoBody[];
};

type CharacterHexaMatrixEquipmentLinkedSkillDtoBody = {
  hexa_skill_id: string;
};

export type {
  CharacterHexaMatrixDtoBody,
  CharacterHexaMatrixEquipmentDtoBody,
  CharacterHexaMatrixEquipmentLinkedSkillDtoBody,
};

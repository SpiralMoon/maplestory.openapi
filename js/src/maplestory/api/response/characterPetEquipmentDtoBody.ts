type CharacterPetEquipmentDtoBody = {
  date: string;
  pet_1_name: string;
  pet_1_nickname: string;
  pet_1_icon: string;
  pet_1_description: string;
  pet_1_equipment: CharacterPetEquipmentItemDtoBody;
  pet_1_auto_skill: CharacterPetEquipmentAutoSkillDtoBody;
  pet_1_pet_type: string | null;
  pet_1_skill: string[];
  pet_1_date_expire: string;
  pet_2_name: string;
  pet_2_nickname: string;
  pet_2_icon: string;
  pet_2_description: string;
  pet_2_equipment: CharacterPetEquipmentItemDtoBody;
  pet_2_auto_skill: CharacterPetEquipmentAutoSkillDtoBody;
  pet_2_pet_type: string | null;
  pet_2_skill: string[];
  pet_2_date_expire: string;
  pet_3_name: string;
  pet_3_nickname: string;
  pet_3_icon: string;
  pet_3_description: string;
  pet_3_equipment: CharacterPetEquipmentItemDtoBody;
  pet_3_auto_skill: CharacterPetEquipmentAutoSkillDtoBody;
  pet_3_pet_type: string | null;
  pet_3_skill: string[];
  pet_3_date_expire: string;
};

type CharacterPetEquipmentItemDtoBody = {
  item_name: string | null;
  item_icon: string | null;
  item_description: string | null;
  item_option: CharacterPetEquipmentItemOptionDtoBody[];
  scroll_upgrade: number;
  scroll_upgradeable: number;
};

type CharacterPetEquipmentItemOptionDtoBody = {
  option_type: string;
  option_value: string;
};

type CharacterPetEquipmentAutoSkillDtoBody = {
  skill_1: string | null;
  skill_1_icon: string | null;
  skill_2: string | null;
  skill_2_icon: string | null;
};

export type {
  CharacterPetEquipmentDtoBody,
  CharacterPetEquipmentItemDtoBody,
  CharacterPetEquipmentItemOptionDtoBody,
  CharacterPetEquipmentAutoSkillDtoBody,
};

export type CharacterPetEquipmentBody = {
  date: string | null;
  pet_1_name: string | null;
  pet_1_nickname: string | null;
  pet_1_icon: string | null;
  pet_1_description: string | null;
  pet_1_equipment: CharacterPetEquipmentItemBody | null;
  pet_1_auto_skill: CharacterPetEquipmentAutoSkillBody | null;
  pet_1_pet_type: string | null;
  pet_1_skill: string[];
  pet_1_date_expire: string | null;
  pet_1_appearance: string | null;
  pet_1_appearance_icon: string | null;
  pet_2_name: string | null;
  pet_2_nickname: string | null;
  pet_2_icon: string | null;
  pet_2_description: string | null;
  pet_2_equipment: CharacterPetEquipmentItemBody | null;
  pet_2_auto_skill: CharacterPetEquipmentAutoSkillBody | null;
  pet_2_pet_type: string | null;
  pet_2_skill: string[];
  pet_2_date_expire: string | null;
  pet_2_appearance: string | null;
  pet_2_appearance_icon: string | null;
  pet_3_name: string | null;
  pet_3_nickname: string | null;
  pet_3_icon: string | null;
  pet_3_description: string | null;
  pet_3_equipment: CharacterPetEquipmentItemBody | null;
  pet_3_auto_skill: CharacterPetEquipmentAutoSkillBody | null;
  pet_3_pet_type: string | null;
  pet_3_skill: string[];
  pet_3_date_expire: string | null;
  pet_3_appearance: string | null;
  pet_3_appearance_icon: string | null;
};

export type CharacterPetEquipmentItemBody = {
  item_name: string | null;
  item_icon: string | null;
  item_description: string | null;
  item_option: CharacterPetEquipmentItemOptionBody[];
  scroll_upgrade: number;
  scroll_upgradable: number;
  item_shape: string | null;
  item_shape_icon: string | null;
};

export type CharacterPetEquipmentItemOptionBody = {
  option_type: string;
  option_value: string;
};

export type CharacterPetEquipmentAutoSkillBody = {
  skill_1: string | null;
  skill_1_icon: string | null;
  skill_2: string | null;
  skill_2_icon: string | null;
};

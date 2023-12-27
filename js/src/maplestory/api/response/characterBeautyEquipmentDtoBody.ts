type CharacterBeautyEquipmentDtoBody = {
  date: string;
  character_gender: string;
  character_class: string;
  character_hair: CharacterBeautyEquipmentHairDtoBody;
  character_face: CharacterBeautyEquipmentFaceDtoBody;
  character_skin_name: string;
  additional_character_hair: CharacterBeautyEquipmentHairDtoBody;
  additional_character_face: CharacterBeautyEquipmentFaceDtoBody;
  additional_character_skin_name: string;
};

type CharacterBeautyEquipmentHairDtoBody = {
  hair_name: string;
  base_color: string;
  mix_color: string;
  mix_rate: string;
};

type CharacterBeautyEquipmentFaceDtoBody = {
  face_name: string;
  base_color: string;
  mix_color: string;
  mix_rate: string;
};

export type {
  CharacterBeautyEquipmentDtoBody,
  CharacterBeautyEquipmentHairDtoBody,
  CharacterBeautyEquipmentFaceDtoBody,
};

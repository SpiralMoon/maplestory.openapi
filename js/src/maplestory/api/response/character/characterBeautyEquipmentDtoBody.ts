type CharacterBeautyEquipmentDtoBody = {
  date: string | null;
  character_gender: string;
  character_class: string;
  character_hair: CharacterBeautyEquipmentHairDtoBody;
  character_face: CharacterBeautyEquipmentFaceDtoBody;
  character_skin_name: string;
  additional_character_hair: CharacterBeautyEquipmentHairDtoBody | null;
  additional_character_face: CharacterBeautyEquipmentFaceDtoBody | null;
  additional_character_skin_name: string | null;
};

type CharacterBeautyEquipmentHairDtoBody = {
  hair_name: string;
  base_color: string;
  mix_color: string | null;
  mix_rate: string;
};

type CharacterBeautyEquipmentFaceDtoBody = {
  face_name: string;
  base_color: string;
  mix_color: string | null;
  mix_rate: string;
};

export type {
  CharacterBeautyEquipmentDtoBody,
  CharacterBeautyEquipmentHairDtoBody,
  CharacterBeautyEquipmentFaceDtoBody,
};

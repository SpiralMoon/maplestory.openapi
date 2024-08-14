type CharacterBeautyEquipmentDtoBody = {
  date: string | null;
  character_gender: string;
  character_class: string;
  character_hair: CharacterBeautyEquipmentHairDtoBody;
  character_face: CharacterBeautyEquipmentFaceDtoBody;
  character_skin: CharacterBeautyEquipmentSkinDtoBody;
  additional_character_hair: CharacterBeautyEquipmentHairDtoBody | null;
  additional_character_face: CharacterBeautyEquipmentFaceDtoBody | null;
  additional_character_skin: CharacterBeautyEquipmentSkinDtoBody | null;
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

type CharacterBeautyEquipmentSkinDtoBody = {
  skin_name: string;
  color_style: string | null;
  hue: number | null;
  saturation: number | null;
  brightness: number | null;
};

export type {
  CharacterBeautyEquipmentDtoBody,
  CharacterBeautyEquipmentHairDtoBody,
  CharacterBeautyEquipmentFaceDtoBody,
  CharacterBeautyEquipmentSkinDtoBody,
};

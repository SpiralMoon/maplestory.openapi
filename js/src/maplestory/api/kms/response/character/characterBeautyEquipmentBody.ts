export type CharacterBeautyEquipmentBody = {
  date: string | null;
  character_gender: string;
  character_class: string;
  character_hair: CharacterBeautyEquipmentHairBody | null;
  character_face: CharacterBeautyEquipmentFaceBody | null;
  character_skin: CharacterBeautyEquipmentSkinBody | null;
  additional_character_hair: CharacterBeautyEquipmentHairBody | null;
  additional_character_face: CharacterBeautyEquipmentFaceBody | null;
  additional_character_skin: CharacterBeautyEquipmentSkinBody | null;
};

export type CharacterBeautyEquipmentHairBody = {
  hair_name: string;
  base_color: string;
  mix_color: string | null;
  mix_rate: string;
};

export type CharacterBeautyEquipmentFaceBody = {
  face_name: string;
  base_color: string;
  mix_color: string | null;
  mix_rate: string;
};

export type CharacterBeautyEquipmentSkinBody = {
  skin_name: string;
  color_style: string | null;
  hue: number | null;
  saturation: number | null;
  brightness: number | null;
};

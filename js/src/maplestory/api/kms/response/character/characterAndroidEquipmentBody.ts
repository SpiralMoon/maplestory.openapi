export type CharacterAndroidEquipmentBody = {
  date: string | null;
  android_name: string | null;
  android_nickname: string | null;
  android_icon: string | null;
  android_description: string | null;
  android_hair: CharacterAndroidEquipmentHairBody | null;
  android_face: CharacterAndroidEquipmentFaceBody | null;
  android_skin: CharacterAndroidEquipmentSkinBody | null;
  android_cash_item_equipment: CharacterAndroidCashItemEquipmentBody[];
  android_ear_sensor_clip_flag: string | null;
  android_gender: string | null;
  android_grade: string | null;
  android_non_humanoid_flag: string | null;
  android_shop_usable_flag: string | null;
  preset_no: number | null;
  android_preset_1: CharacterAndroidEquipmentPresetBody | null;
  android_preset_2: CharacterAndroidEquipmentPresetBody | null;
  android_preset_3: CharacterAndroidEquipmentPresetBody | null;
};

export type CharacterAndroidEquipmentHairBody = {
  hair_name: string | null;
  base_color: string | null;
  mix_color: string | null;
  mix_rate: string;
  freestyle_flag: string | null;
};

export type CharacterAndroidEquipmentFaceBody = {
  face_name: string | null;
  base_color: string | null;
  mix_color: string | null;
  mix_rate: string;
  freestyle_flag: string | null;
};

export type CharacterAndroidEquipmentSkinBody = {
  skin_name: string;
  color_style: string | null;
  hue: number | null;
  saturation: number | null;
  brightness: number | null;
};

export type CharacterAndroidEquipmentPresetBody = {
  android_name: string;
  android_nickname: string;
  android_icon: string;
  android_description: string;
  android_gender: string | null;
  android_grade: string;
  android_hair: CharacterAndroidEquipmentHairBody;
  android_face: CharacterAndroidEquipmentFaceBody;
  android_skin: CharacterAndroidEquipmentSkinBody | null;
  android_ear_sensor_clip_flag: string;
  android_non_humanoid_flag: string;
  android_shop_usable_flag: string;
};

export type CharacterAndroidCashItemEquipmentBody = {
  cash_item_equipment_part: string;
  cash_item_equipment_slot: string;
  cash_item_name: string;
  cash_item_icon: string;
  cash_item_description: string | null;
  cash_item_option: CharacterAndroidCashItemEquipmentOptionBody[];
  date_expire: string | null;
  date_option_expire: string | null;
  cash_item_label: string | null;
  cash_item_coloring_prism: CharacterAndroidCashItemEquipmentColoringPrismBody | null;
  android_item_gender: string;
  freestyle_flag: string | null;
};

export type CharacterAndroidCashItemEquipmentOptionBody = {
  option_type: string;
  option_value: string;
};

export type CharacterAndroidCashItemEquipmentColoringPrismBody = {
  color_range: string;
  hue: number;
  saturation: number;
  value: number;
};

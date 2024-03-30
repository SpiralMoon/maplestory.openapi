type CharacterAndroidEquipmentDtoBody = {
  date: string | null;
  android_name: string | null;
  android_nickname: string | null;
  android_icon: string | null;
  android_description: string | null;
  android_hair: CharacterAndroidEquipmentHairDtoBody;
  android_face: CharacterAndroidEquipmentFaceDtoBody;
  android_skin_name: string | null;
  android_cash_item_equipment: CharacterAndroidCashItemEquipmentDtoBody[];
  android_ear_sensor_clip_flag: string | null;
  android_gender: string | null;
  android_grade: string | null;
  android_non_humanoid_flag : string | null;
  android_shop_usable_flag : string | null;
  preset_no: number | null;
  android_preset_1: CharacterAndroidEquipmentPresetDtoBody | null;
  android_preset_2: CharacterAndroidEquipmentPresetDtoBody | null;
  android_preset_3: CharacterAndroidEquipmentPresetDtoBody | null;
};

type CharacterAndroidEquipmentHairDtoBody = {
  hair_name: string | null;
  base_color: string | null;
  mix_color: string | null;
  mix_rate: string;
};

type CharacterAndroidEquipmentFaceDtoBody = {
  face_name: string | null;
  base_color: string | null;
  mix_color: string | null;
  mix_rate: string;
};

type CharacterAndroidEquipmentPresetDtoBody = {
  android_name: string;
  android_nickname: string;
  android_icon: string;
  android_description: string;
  android_gender: string | null;
  android_grade: string;
  android_skin_name: string;
  android_hair: CharacterAndroidEquipmentHairDtoBody;
  android_face: CharacterAndroidEquipmentFaceDtoBody;
  android_ear_sensor_clip_flag: string;
  android_non_humanoid_flag: string;
  android_shop_usable_flag: string;
};

type CharacterAndroidCashItemEquipmentDtoBody = {
  cash_item_equipment_part: string;
  cash_item_equipment_slot: string;
  cash_item_name: string;
  cash_item_icon: string;
  cash_item_description: string | null;
  cash_item_option: CharacterAndroidCashItemEquipmentOptionDtoBody[];
  date_expire: string | null;
  date_option_expire: string | null;
  cash_item_label: string | null;
  cash_item_coloring_prism: CharacterAndroidCashItemEquipmentColoringPrismDtoBody | null;
};

type CharacterAndroidCashItemEquipmentOptionDtoBody = {
  option_type: string;
  option_value: string;
};

type CharacterAndroidCashItemEquipmentColoringPrismDtoBody = {
  color_range: string;
  hue: number;
  saturation: number;
  value: number;
};

export type {
  CharacterAndroidEquipmentDtoBody,
  CharacterAndroidEquipmentHairDtoBody,
  CharacterAndroidEquipmentFaceDtoBody,
  CharacterAndroidEquipmentPresetDtoBody,
  CharacterAndroidCashItemEquipmentDtoBody,
  CharacterAndroidCashItemEquipmentOptionDtoBody,
  CharacterAndroidCashItemEquipmentColoringPrismDtoBody,
};

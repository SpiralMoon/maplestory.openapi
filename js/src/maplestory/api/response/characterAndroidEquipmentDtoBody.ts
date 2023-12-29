type CharacterAndroidEquipmentDtoBody = {
  date: string;
  android_name: string | null;
  android_nickname: string | null;
  android_icon: string | null;
  android_description: string | null;
  android_hair: CharacterAndroidEquipmentHairDtoBody;
  android_face: CharacterAndroidEquipmentFaceDtoBody;
  android_skin_name: string | null;
  android_cash_item_equipment: CharacterAndroidCashItemEquipmentDtoBody[];
  android_ear_sensor_clip_flag: string | null;
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
  CharacterAndroidCashItemEquipmentDtoBody,
  CharacterAndroidCashItemEquipmentOptionDtoBody,
  CharacterAndroidCashItemEquipmentColoringPrismDtoBody,
};

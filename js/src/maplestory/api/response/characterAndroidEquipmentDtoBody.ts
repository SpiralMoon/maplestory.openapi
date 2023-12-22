type CharacterAndroidEquipmentDtoBody = {
    date: string;
    android_name: string;
    android_nickname: string;
    android_icon: string;
    android_description: string;
    android_hair: CharacterAndroidEquipmentHairDtoBody;
    android_face: CharacterAndroidEquipmentFaceDtoBody;
    android_skin_name: string;
    android_cash_item_equipment: CharacterAndroidCashItemEquipmentDtoBody[];
    android_ear_sensor_clip_flag: string;
};

type CharacterAndroidEquipmentHairDtoBody = {
    hair_name: string;
    base_color: string;
    mix_color: string;
    mix_rate: string;
};

type CharacterAndroidEquipmentFaceDtoBody = {
    face_name: string;
    base_color: string;
    mix_color: string;
    mix_rate: string;
};

type CharacterAndroidCashItemEquipmentDtoBody = {
    cash_item_equipment_part: string;
    cash_item_equipment_slot: string;
    cash_item_name: string;
    cash_item_icon: string;
    cash_item_description: string;
    cash_item_option: CharacterAndroidCashItemEquipmentOptionDtoBody[];
    date_expire: string;
    date_option_expire: string;
    cash_item_label: string;
    cash_item_coloring_prism: CharacterAndroidCashItemEquipmentColoringPrismDtoBody;
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

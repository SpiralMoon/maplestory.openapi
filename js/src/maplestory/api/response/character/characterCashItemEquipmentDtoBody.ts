type CharacterCashItemEquipmentDtoBody = {
  date: string;
  character_gender: string;
  character_class: string;
  preset_no: number;
  cash_item_equipment_preset_1: CharacterCashItemEquipmentPresetDtoBody[];
  cash_item_equipment_preset_2: CharacterCashItemEquipmentPresetDtoBody[];
  cash_item_equipment_preset_3: CharacterCashItemEquipmentPresetDtoBody[];
  additional_cash_item_equipment_preset_1: CharacterCashItemEquipmentPresetDtoBody[];
  additional_cash_item_equipment_preset_2: CharacterCashItemEquipmentPresetDtoBody[];
  additional_cash_item_equipment_preset_3: CharacterCashItemEquipmentPresetDtoBody[];
};

type CharacterCashItemEquipmentPresetDtoBody = {
  cash_item_equipment_part: string;
  cash_item_equipment_slot: string;
  cash_item_name: string;
  cash_item_icon: string;
  cash_item_description: string | null;
  cash_item_option: CharacterCashItemEquipmentOptionDtoBody[];
  date_expire: string | null;
  date_option_expire: string | null;
  cash_item_label: string | null;
  cash_item_coloring_prism: CharacterCashItemEquipmentColoringPrismDtoBody | null;
  base_preset_item_disable_flag: string;
};

type CharacterCashItemEquipmentOptionDtoBody = {
  option_type: string;
  option_value: string;
};

type CharacterCashItemEquipmentColoringPrismDtoBody = {
  color_range: string;
  hue: number;
  saturation: number;
  value: number;
};

export type {
  CharacterCashItemEquipmentDtoBody,
  CharacterCashItemEquipmentPresetDtoBody,
  CharacterCashItemEquipmentOptionDtoBody,
  CharacterCashItemEquipmentColoringPrismDtoBody,
};

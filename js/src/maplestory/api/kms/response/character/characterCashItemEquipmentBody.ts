export type CharacterCashItemEquipmentBody = {
  date: string | null;
  character_gender: string | null;
  character_class: string | null;
  character_look_mode: string | null;
  preset_no: number | null;
  cash_item_equipment_base: CharacterCashItemEquipmentPresetBody[];
  cash_item_equipment_preset_1: CharacterCashItemEquipmentPresetBody[];
  cash_item_equipment_preset_2: CharacterCashItemEquipmentPresetBody[];
  cash_item_equipment_preset_3: CharacterCashItemEquipmentPresetBody[];
  additional_cash_item_equipment_base: CharacterCashItemEquipmentPresetBody[];
  additional_cash_item_equipment_preset_1: CharacterCashItemEquipmentPresetBody[];
  additional_cash_item_equipment_preset_2: CharacterCashItemEquipmentPresetBody[];
  additional_cash_item_equipment_preset_3: CharacterCashItemEquipmentPresetBody[];
};

export type CharacterCashItemEquipmentPresetBody = {
  cash_item_equipment_part: string;
  cash_item_equipment_slot: string;
  cash_item_name: string;
  cash_item_icon: string;
  cash_item_description: string | null;
  cash_item_option: CharacterCashItemEquipmentOptionBody[];
  date_expire: string | null;
  date_option_expire: string | null;
  cash_item_label: string | null;
  cash_item_coloring_prism: CharacterCashItemEquipmentColoringPrismBody | null;
  item_gender: string | null;
  skills: string[];
};

export type CharacterCashItemEquipmentOptionBody = {
  option_type: string;
  option_value: string;
};

export type CharacterCashItemEquipmentColoringPrismBody = {
  color_range: string;
  hue: number;
  saturation: number;
  value: number;
};

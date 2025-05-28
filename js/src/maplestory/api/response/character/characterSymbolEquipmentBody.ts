export type CharacterSymbolEquipmentBody = {
  date: string | null;
  character_class: string | null;
  symbol: CharacterSymbolEquipmentInfoDtoBody[];
};

export type CharacterSymbolEquipmentInfoDtoBody = {
  symbol_name: string;
  symbol_icon: string;
  symbol_description: string;
  symbol_force: string;
  symbol_level: number;
  symbol_str: string;
  symbol_dex: string;
  symbol_int: string;
  symbol_luk: string;
  symbol_hp: string;
  symbol_drop_rate: string | null;
  symbol_meso_rate: string | null;
  symbol_exp_rate: string | null;
  symbol_growth_count: number;
  symbol_require_growth_count: number;
};

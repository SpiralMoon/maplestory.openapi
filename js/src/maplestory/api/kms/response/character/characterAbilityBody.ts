export type CharacterAbilityBody = {
  date: string | null;
  ability_grade: string | null;
  ability_info: CharacterAbilityInfoBody[];
  remain_fame: number | null;
  preset_no: number | null;
  ability_preset_1: CharacterAbilityPresetBody | null;
  ability_preset_2: CharacterAbilityPresetBody | null;
  ability_preset_3: CharacterAbilityPresetBody | null;
};

export type CharacterAbilityInfoBody = {
  ability_no: string;
  ability_grade: string;
  ability_value: string;
};

export type CharacterAbilityPresetBody = {
  ability_preset_grade: string;
  ability_info: CharacterAbilityInfoBody[];
};

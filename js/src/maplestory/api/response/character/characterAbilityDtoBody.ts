export type CharacterAbilityDtoBody = {
  date: string | null;
  ability_grade: string | null;
  ability_info: CharacterAbilityInfoDtoBody[];
  remain_fame: number | null;
  preset_no: number | null;
  ability_preset_1: CharacterAbilityPresetDtoBody | null;
  ability_preset_2: CharacterAbilityPresetDtoBody | null;
  ability_preset_3: CharacterAbilityPresetDtoBody | null;
};

export type CharacterAbilityInfoDtoBody = {
  ability_no: string;
  ability_grade: string;
  ability_value: string;
};

export type CharacterAbilityPresetDtoBody = {
  ability_preset_grade: string;
  ability_info: CharacterAbilityInfoDtoBody[];
};

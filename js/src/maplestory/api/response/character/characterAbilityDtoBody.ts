type CharacterAbilityDtoBody = {
  date: string;
  ability_grade: string;
  ability_info: CharacterAbilityInfoDtoBody[];
  remain_fame: number;
  preset_no: number;
  ability_preset_1: CharacterAbilityPresetDtoBody;
  ability_preset_2: CharacterAbilityPresetDtoBody;
  ability_preset_3: CharacterAbilityPresetDtoBody;
};

type CharacterAbilityInfoDtoBody = {
  ability_no: string;
  ability_grade: string;
  ability_value: string;
};

type CharacterAbilityPresetDtoBody = {
  ability_preset_grade: string;
  ability_info: CharacterAbilityInfoDtoBody[];
};

export { CharacterAbilityDtoBody, CharacterAbilityInfoDtoBody, CharacterAbilityPresetDtoBody };

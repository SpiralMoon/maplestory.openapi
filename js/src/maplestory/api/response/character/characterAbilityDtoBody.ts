type CharacterAbilityDtoBody = {
  date: string;
  ability_grade: string;
  ability_info: CharacterAbilityInfoDtoBody[];
  remain_fame: number;
};

type CharacterAbilityInfoDtoBody = {
  ability_no: string;
  ability_grade: string;
  ability_value: string;
};

export { CharacterAbilityDtoBody, CharacterAbilityInfoDtoBody };

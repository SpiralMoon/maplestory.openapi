export type CharacterListDtoBody = {
  account_list:CharacterListAccountDtoBody [];
}

export type CharacterListAccountDtoBody = {
  account_id: string;
  character_list: CharacterListAccountCharacterDtoBody[];
}

export type CharacterListAccountCharacterDtoBody = {
  ocid: string;
  character_name: string;
  world_name: string;
  character_class: string;
  character_level: number;
}

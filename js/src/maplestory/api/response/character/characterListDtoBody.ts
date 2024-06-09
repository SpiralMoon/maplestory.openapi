type CharacterListDtoBody = {
  account_list:CharacterListAccountDtoBody [];
}

type CharacterListAccountDtoBody = {
  account_id: string;
  character_list: CharacterListAccountCharacterDtoBody[];
}

type CharacterListAccountCharacterDtoBody = {
  ocid: string;
  character_name: string;
  world_name: string;
  character_class: string;
  character_level: number;
}

export type { CharacterListDtoBody, CharacterListAccountDtoBody, CharacterListAccountCharacterDtoBody };

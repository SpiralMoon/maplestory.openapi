export type CharacterListBody = {
  account_list:CharacterListAccountBody [];
}

export type CharacterListAccountBody = {
  account_id: string;
  character_list: CharacterListAccountCharacterBody[];
}

export type CharacterListAccountCharacterBody = {
  ocid: string;
  character_name: string;
  world_name: string;
  character_class: string;
  character_level: number;
}

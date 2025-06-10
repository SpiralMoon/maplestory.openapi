export abstract class CharacterListDto {
  public abstract accountList: CharacterListAccountDto[];
}

export abstract class CharacterListAccountCharacterDto {
  public abstract ocid: string;
  public abstract characterName: string;
  public abstract worldName: string;
  public abstract characterClass: string;
  public abstract characterLevel: number;
}

export abstract class CharacterListAccountDto {
  public abstract accountId: string;
  public abstract characterList: CharacterListAccountCharacterDto[];
}

export abstract class CharacterBasicDto {
  public abstract date: Date | null;
  public abstract characterName: string;
  public abstract worldName: string;
  public abstract characterGender: string;
  public abstract characterClass: string;
  public abstract characterClassLevel: string;
  public abstract characterLevel: number;
  public abstract characterExp: number;
  public abstract characterExpRate: string;
  public abstract characterGuildName: string | null;
  public abstract characterImage: string;
  public abstract characterDateCreate: Date | null;
  public abstract accessFlag: 'true' | 'false';
  public abstract liberationQuestClear: string;

  public get isAccessFlag() {
    return this.accessFlag === 'true';
  }
}

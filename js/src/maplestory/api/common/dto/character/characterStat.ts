export abstract class CharacterStatDto {
  public abstract date: Date | null;
  public abstract characterClass: string;
  public abstract finalStat: CharacterFinalStatDto[];
  public abstract remainAP: number;
}

export abstract class CharacterFinalStatDto {
  public abstract statName: string;
  public abstract statValue: string;
}

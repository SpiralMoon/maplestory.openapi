export abstract class CharacterDojangDto {
  public abstract date: Date | null;
  public abstract characterClass: string;
  public abstract worldName: string;
  public abstract dojangBestFloor: number;
  public abstract dateDojangRecord: Date | null;
  public abstract dojangBestTime: number;
}

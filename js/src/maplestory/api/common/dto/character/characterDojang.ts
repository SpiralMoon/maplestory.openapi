export abstract class CharacterDojangDto {
  public abstract date: Date | null;
  public abstract characterClass: string | null;
  public abstract worldName: string | null;
  public abstract dojangBestFloor: number | null;
  public abstract dateDojangRecord: Date | null;
  public abstract dojangBestTime: number | null;
}

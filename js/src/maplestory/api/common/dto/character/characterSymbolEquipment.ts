export abstract class CharacterSymbolEquipmentDto {
  public abstract date: Date | null;
  public abstract characterClass: string;
  public abstract symbol: CharacterSymbolEquipmentInfoDto[];
}

export abstract class CharacterSymbolEquipmentInfoDto {
  public abstract symbolName: string;
  public abstract symbolIcon: string;
  public abstract symbolDescription: string;
  public abstract symbolForce: string;
  public abstract symbolLevel: number;
  public abstract symbolStr: string;
  public abstract symbolDex: string;
  public abstract symbolInt: string;
  public abstract symbolLuk: string;
  public abstract symbolHp: string;
  public abstract symbolDropRate: string;
  public abstract symbolMesoRate: string;
  public abstract symbolExpRate: string;
  public abstract symbolGrowthCount: number;
  public abstract symbolRequireGrowthCount: number;
}

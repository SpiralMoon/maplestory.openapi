export abstract class CharacterVMatrixDto {
  public abstract date: Date | null;
  public abstract characterClass: string | null;
  public abstract characterVCoreEquipment: CharacterVMatrixCodeEquipmentDto[];
  public abstract characterVMatrixRemainSlotUpgradePoint: number | null;
}

export abstract class CharacterVMatrixCodeEquipmentDto {
  public abstract slotId: string;
  public abstract slotLevel: number;
  public abstract vCoreName: string | null;
  public abstract vCoreType: string | null;
  public abstract vCoreLevel: number;
  public abstract vCoreSkill1: string;
  public abstract vCoreSkill2: string | null;
  public abstract vCoreSkill3: string | null;
}

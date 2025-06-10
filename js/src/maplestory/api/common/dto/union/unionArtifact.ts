export abstract class UnionArtifactDto {
  public abstract date: Date | null;
  public abstract unionArtifactEffect: UnionArtifactEffectDto[];
  public abstract unionArtifactCrystal: UnionArtifactCrystalDto[];
  public abstract unionArtifactRemainAp: number | null;
}

export abstract class UnionArtifactEffectDto {
  public abstract name: string;
  public abstract level: number;
}

export abstract class UnionArtifactCrystalDto {
  public abstract name: string;
  public abstract validityFlag: string;
  public abstract dateExpire: Date | null;
  public abstract isExpired: boolean | null;
  public abstract level: number;
  public abstract crystalOptionName1: string;
  public abstract crystalOptionName2: string;
  public abstract crystalOptionName3: string;
}

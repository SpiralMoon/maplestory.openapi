export abstract class CharacterHyperStatDto {
  public abstract date: Date | null;
  public abstract characterClass: string | null;
  public abstract usePresetNo: string | null;
  public abstract useAvailableHyperStat: number | null;
  public abstract hyperStatPreset1: CharacterHyperStatPresetDto[];
  public abstract hyperStatPreset1RemainPoint: number | null;
  public abstract hyperStatPreset2: CharacterHyperStatPresetDto[];
  public abstract hyperStatPreset2RemainPoint: number | null;
  public abstract hyperStatPreset3: CharacterHyperStatPresetDto[];
  public abstract hyperStatPreset3RemainPoint: number | null;
}

export abstract class CharacterHyperStatPresetDto {
  public abstract statType: string;
  public abstract statPoint: number | null;
  public abstract statLevel: number;
  public abstract statIncrease: string | null;
}

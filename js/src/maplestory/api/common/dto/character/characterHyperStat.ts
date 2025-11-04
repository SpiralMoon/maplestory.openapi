export abstract class CharacterHyperStatDto {
  public abstract date: Date | null;
  public abstract characterClass: string;
  public abstract usePresetNo: string;
  public abstract useAvailableHyperStat: number;
  public abstract hyperStatPreset1: CharacterHyperStatPresetDto[];
  public abstract hyperStatPreset1RemainPoint: number;
  public abstract hyperStatPreset2: CharacterHyperStatPresetDto[];
  public abstract hyperStatPreset2RemainPoint: number;
  public abstract hyperStatPreset3: CharacterHyperStatPresetDto[];
  public abstract hyperStatPreset3RemainPoint: number;
}

export abstract class CharacterHyperStatPresetDto {
  public abstract statType: string;
  public abstract statPoint: number | null;
  public abstract statLevel: number;
  public abstract statIncrease: string | null;
}

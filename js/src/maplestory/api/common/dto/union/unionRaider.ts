export abstract class UnionRaiderDto {
  public abstract date: Date | null;
  public abstract unionRaiderStat: string[];
  public abstract unionOccupiedStat: string[];
  public abstract unionInnerStat: UnionRaiderInnerStatDto[];
  public abstract unionBlock: UnionRaiderBlockDto[];
  public abstract usePresetNo: number;
  public abstract unionRaiderPreset1: UnionRaiderPresetDto | null;
  public abstract unionRaiderPreset2: UnionRaiderPresetDto | null;
  public abstract unionRaiderPreset3: UnionRaiderPresetDto | null;
  public abstract unionRaiderPreset4: UnionRaiderPresetDto | null;
  public abstract unionRaiderPreset5: UnionRaiderPresetDto | null;
}

export abstract class UnionRaiderInnerStatDto {
  public abstract statFieldId: string;
  public abstract statFieldEffect: string;
}

export abstract class UnionRaiderBlockPositionDto {
  public abstract x: number;
  public abstract y: number;
}

export abstract class UnionRaiderBlockControlPointDto {
  public abstract x: number;
  public abstract y: number;
}

export abstract class UnionRaiderBlockDto {
  public abstract blockType: string;
  public abstract blockClass: string | null;
  public abstract blockLevel: string;
  public abstract blockControlPoint: UnionRaiderBlockControlPointDto;
  public abstract blockPosition: UnionRaiderBlockPositionDto[] | null;
}

export abstract class UnionRaiderPresetDto {
  public abstract unionRaiderStat: string[];
  public abstract unionOccupiedStat: string[];
  public abstract unionInnerStat: UnionRaiderInnerStatDto[];
  public abstract unionBlock: UnionRaiderBlockDto[];
}

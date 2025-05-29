export abstract class CharacterCashItemEquipmentDto {
  public abstract date: Date | null;
  public abstract characterGender: string | null;
  public abstract characterClass: string | null;
  public abstract characterLookMode: string | null;
  public abstract presetNo: number | null;
  public abstract cashItemEquipmentBase: CharacterCashItemEquipmentPresetDto[];
  public abstract cashItemEquipmentPreset1: CharacterCashItemEquipmentPresetDto[];
  public abstract cashItemEquipmentPreset2: CharacterCashItemEquipmentPresetDto[];
  public abstract cashItemEquipmentPreset3: CharacterCashItemEquipmentPresetDto[];
  public abstract additionalCashItemEquipmentBase: CharacterCashItemEquipmentPresetDto[];
  public abstract additionalCashItemEquipmentPreset1: CharacterCashItemEquipmentPresetDto[];
  public abstract additionalCashItemEquipmentPreset2: CharacterCashItemEquipmentPresetDto[];
  public abstract additionalCashItemEquipmentPreset3: CharacterCashItemEquipmentPresetDto[];
}

export abstract class CharacterCashItemEquipmentColoringPrismDto {
  public abstract colorRange: string;
  public abstract hue: number;
  public abstract saturation: number;
  public abstract value: number;
}

export abstract class CharacterCashItemEquipmentOptionDto {
  public abstract optionType: string;
  public abstract optionValue: string;
}

export abstract class CharacterCashItemEquipmentPresetDto {
  public abstract cashItemEquipmentPart: string;
  public abstract cashItemEquipmentSlot: string;
  public abstract cashItemName: string;
  public abstract cashItemIcon: string;
  public abstract cashItemDescription: string | null;
  public abstract cashItemOption: CharacterCashItemEquipmentOptionDto[];
  public abstract dateExpire: Date | null;
  public abstract isExpired: boolean | null;
  public abstract dateOptionExpire: Date | null;
  public abstract isOptionExpired: boolean | null;
  public abstract cashItemLabel: string | null;
  public abstract cashItemColoringPrism: CharacterCashItemEquipmentColoringPrismDto | null;
  public abstract itemGender: string | null;
}

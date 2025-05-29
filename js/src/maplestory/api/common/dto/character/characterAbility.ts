export abstract class CharacterAbilityDto {
  public abstract date: Date | null;
  public abstract abilityGrade: string | null;
  public abstract abilityInfo: CharacterAbilityInfoDto[];
  public abstract remainFame: number | null;
  public abstract presetNo: number | null;
  public abstract abilityPreset1: CharacterAbilityPresetDto | null;
  public abstract abilityPreset2: CharacterAbilityPresetDto | null;
  public abstract abilityPreset3: CharacterAbilityPresetDto | null;
}

export abstract class CharacterAbilityInfoDto {
  public abstract abilityNo: string;
  public abstract abilityGrade: string;
  public abstract abilityValue: string;
}

export abstract class CharacterAbilityPresetDto {
  public abstract abilityPresetGrade: string;
  public abstract abilityInfo: CharacterAbilityInfoDto[];
}

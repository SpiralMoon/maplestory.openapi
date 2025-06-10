export abstract class CharacterSkillDto {
  public abstract date: Date | null;
  public abstract characterClass: string | null;
  public abstract characterSkillGrade: string | null;
  public abstract characterSkill: CharacterSkillInfoDto[];
}

export abstract class CharacterSkillInfoDto {
  public abstract skillName: string;
  public abstract skillDescription: string;
  public abstract skillLevel: number;
  public abstract skillEffect: string;
  public abstract skillEffectNext: string | null;
  public abstract skillIcon: string;
}

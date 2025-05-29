export abstract class CharacterLinkSkillDto {
  public abstract date: Date | null;
  public abstract characterClass: string | null;
  public abstract characterLinkSkill: CharacterLinkSkillInfoDto[];
  public abstract characterLinkSkillPreset1: CharacterLinkSkillInfoDto[];
  public abstract characterLinkSkillPreset2: CharacterLinkSkillInfoDto[];
  public abstract characterLinkSkillPreset3: CharacterLinkSkillInfoDto[];
  public abstract characterOwnedLinkSkill: CharacterLinkSkillInfoDto | null;
  public abstract characterOwnedLinkSkillPreset1: CharacterLinkSkillInfoDto | null;
  public abstract characterOwnedLinkSkillPreset2: CharacterLinkSkillInfoDto | null;
  public abstract characterOwnedLinkSkillPreset3: CharacterLinkSkillInfoDto | null;
}

export abstract class CharacterLinkSkillInfoDto {
  public abstract skillName: string;
  public abstract skillDescription: string;
  public abstract skillLevel: number;
  public abstract skillEffect: string;
  public abstract skillEffectNext: string | null;
  public abstract skillIcon: string;
}

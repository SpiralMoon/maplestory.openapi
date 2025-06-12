export abstract class GuildBasicDto {
  public abstract date: Date | null;
  public abstract worldName: string;
  public abstract guildName: string;
  public abstract guildLevel: number;
  public abstract guildFame: number;
  public abstract guildPoint: number;
  public abstract guildMasterName: string;
  public abstract guildMemberCount: number;
  public abstract guildMember: string[];
  public abstract guildSkill: GuildSkillDto[];
  public abstract guildNoblesseSkill: GuildSkillDto[];
}

export abstract class GuildSkillDto {
  public abstract skillName: string;
  public abstract skillDescription: string;
  public abstract skillLevel: number;
  public abstract skillEffect: string;
  public abstract skillIcon: string;
}

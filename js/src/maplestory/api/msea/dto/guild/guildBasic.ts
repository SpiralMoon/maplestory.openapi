import * as base from '../../../common/dto/guild/guildBasic';
import {
  GuildBasicBody,
  GuildSkillBody,
} from '../../response/guild/guildBasicBody';

/**
 * Guild basic information
 */
export class GuildBasicDto extends base.GuildBasicDto {
  /**
   * Reference date for query (SGT, daily data with hours and minutes set to 0)
   */
  public override date: Date | null;

  /**
   * World name
   */
  public override worldName: string;

  /**
   * Guild name
   */
  public override guildName: string;

  /**
   * Guild level
   */
  public override guildLevel: number;

  /**
   * Honor EXP
   */
  public override guildFame: number;

  /**
   * Guild Points (GP)
   */
  public override guildPoint: number;

  /**
   * Character name of the Guild Master
   */
  public override guildMasterName: string;

  /**
   * Number of guild members
   */
  public override guildMemberCount: number;

  /**
   * List of guild members
   */
  public override guildMember: string[];

  /**
   * List of guild skills
   */
  public override guildSkill: GuildSkillDto[];

  /**
   * List of Noblesse Guild Skills
   */
  public override guildNoblesseSkill: GuildSkillDto[];

  constructor(obj: GuildBasicBody) {
    super();

    const {
      date,
      world_name,
      guild_name,
      guild_level,
      guild_fame,
      guild_point,
      guild_master_name,
      guild_member_count,
      guild_member,
      guild_skill,
      guild_noblesse_skill,
    } = obj;

    this.date = date ? new Date(date) : null;
    this.worldName = world_name;
    this.guildName = guild_name;
    this.guildLevel = guild_level;
    this.guildFame = guild_fame;
    this.guildPoint = guild_point;
    this.guildMasterName = guild_master_name;
    this.guildMemberCount = guild_member_count;
    this.guildMember = guild_member;
    this.guildSkill = guild_skill.map((skill) => new GuildSkillDto(skill));
    this.guildNoblesseSkill = guild_noblesse_skill.map(
      (skill) => new GuildSkillDto(skill),
    );
  }
}

/**
 * Guild skill information
 */
export class GuildSkillDto extends base.GuildSkillDto {
  /**
   * Skill name
   */
  public override skillName: string;

  /**
   * Skill description
   */
  public override skillDescription: string;

  /**
   * Skill level
   */
  public override skillLevel: number;

  /**
   * Effects by skill level
   */
  public override skillEffect: string;

  /**
   * Skill icon
   */
  public override skillIcon: string;

  constructor(obj: GuildSkillBody) {
    super();

    const {
      skill_name,
      skill_description,
      skill_level,
      skill_effect,
      skill_icon,
    } = obj;

    this.skillName = skill_name;
    this.skillDescription = skill_description;
    this.skillLevel = skill_level;
    this.skillEffect = skill_effect;
    this.skillIcon = skill_icon;
  }
}

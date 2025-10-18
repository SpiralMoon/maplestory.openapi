import * as base from '../../../common/dto/guild/guildBasic';
import {
  GuildBasicBody,
  GuildSkillBody,
} from '../../response/guild/guildBasicBody';

/**
 * 公會基本資訊
 */
export class GuildBasicDto extends base.GuildBasicDto {
  /**
   * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
   */
  public override date: Date | null;

  /**
   * 世界名稱
   */
  public override worldName: string;

  /**
   * 公會名稱
   */
  public override guildName: string;

  /**
   * 公會等級
   */
  public override guildLevel: number;

  /**
   * 公會名聲值
   */
  public override guildFame: number;

  /**
   * 公會點數 (GP)
   */
  public override guildPoint: number;

  /**
   * 公會會長角色名稱
   */
  public override guildMasterName: string;

  /**
   * 公會成員人數
   */
  public override guildMemberCount: number;

  /**
   * 公會成員清單
   */
  public override guildMember: string[];

  /**
   * 公會技能清單
   */
  public override guildSkill: GuildSkillDto[];

  /**
   * 貴族技能清單
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
 * 公會技能
 */
export class GuildSkillDto extends base.GuildSkillDto {
  /**
   * 技能名稱
   */
  public override skillName: string;

  /**
   * 技能描述
   */
  public override skillDescription: string;

  /**
   * 技能等級
   */
  public override skillLevel: number;

  /**
   * 技能等級的效果
   */
  public override skillEffect: string;

  /**
   * 技能圖示
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

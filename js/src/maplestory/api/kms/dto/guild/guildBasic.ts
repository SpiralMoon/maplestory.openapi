import { GuildBasicBody, GuildSkillBody } from '../../response/guild/guildBasicBody';

/**
 * 길드 기본 정보
 */
export class GuildBasicDto {
  /**
   * 조회 기준일
   */
  date: Date | null;

  /**
   * 월드 명
   */
  worldName: string;

  /**
   * 길드 명
   */
  guildName: string;

  /**
   * 길드 레벨
   */
  guildLevel: number;

  /**
   * 길드 명성치
   */
  guildFame: number;

  /**
   * 길드 포인트(GP)
   */
  guildPoint: number;

  /**
   * 길드 마스터 캐릭터 명
   */
  guildMasterName: string;

  /**
   * 길드원 수
   */
  guildMemberCount: number;

  /**
   * 길드원 목록
   */
  guildMember: string[];

  /**
   * 길드 스킬 목록
   */
  guildSkill: GuildSkillDto[];

  /**
   * 노블레스 스킬 목록
   */
  guildNoblesseSkill: GuildSkillDto[];

  constructor(obj: GuildBasicBody) {
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
 * 길드 스킬 정보
 */
export class GuildSkillDto {
  /**
   * 스킬 명
   */
  skillName: string;

  /**
   * 스킬 설명
   */
  skillDescription: string;

  /**
   * 스킬 레벨
   */
  skillLevel: number;

  /**
   * 스킬 레벨 별 효과
   */
  skillEffect: string;

  /**
   * 스킬 아이콘
   */
  skillIcon: string;

  constructor(obj: GuildSkillBody) {
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

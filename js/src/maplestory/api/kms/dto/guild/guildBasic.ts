import * as base from '../../../common/dto/guild/guildBasic';
import {
  GuildBasicBody,
  GuildSkillBody,
} from '../../response/guild/guildBasicBody';

/**
 * 길드 기본 정보
 */
export class GuildBasicDto extends base.GuildBasicDto {
  /**
   * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
   */
  public override date: Date | null;

  /**
   * 월드 명
   */
  public override worldName: string;

  /**
   * 길드 명
   */
  public override guildName: string;

  /**
   * 길드 레벨
   */
  public override guildLevel: number;

  /**
   * 길드 명성치
   */
  public override guildFame: number;

  /**
   * 길드 포인트(GP)
   */
  public override guildPoint: number;

  /**
   * 길드 마스터 캐릭터 명
   */
  public override guildMasterName: string;

  /**
   * 길드원 수
   */
  public override guildMemberCount: number;

  /**
   * 길드원 목록
   */
  public override guildMember: string[];

  /**
   * 길드 스킬 목록
   */
  public override guildSkill: GuildSkillDto[];

  /**
   * 노블레스 스킬 목록
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
 * 길드 스킬 정보
 */
export class GuildSkillDto extends base.GuildSkillDto {
  /**
   * 스킬 명
   */
  public override skillName: string;

  /**
   * 스킬 설명
   */
  public override skillDescription: string;

  /**
   * 스킬 레벨
   */
  public override skillLevel: number;

  /**
   * 스킬 레벨 별 효과
   */
  public override skillEffect: string;

  /**
   * 스킬 아이콘
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

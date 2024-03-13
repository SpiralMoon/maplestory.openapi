import { GuildSkillDto } from '@src/maplestory/api/dto/guild/guildSkillDto';
import { GuildBasicDtoBody } from '@src/maplestory/api/response/guild/guildBasicDtoBody';

/**
 * 길드 기본 정보
 */
class GuildBasicDto {
  /**
   * 조회 기준일
   */
  date: Date;

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

  /**
   * 조합형 길드 마크
   */
  guildMark: string | null;

  /**
   * 커스텀 길드 마크 (base64 인코딩 형식)
   */
  guildMarkCustom: string | null;

  constructor(obj: GuildBasicDtoBody) {
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
      guild_mark,
      guild_mark_custom,
    } = obj;

    this.date = new Date(date);
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
    this.guildMark = guild_mark;
    this.guildMarkCustom = guild_mark_custom;
  }
}

export { GuildBasicDto };

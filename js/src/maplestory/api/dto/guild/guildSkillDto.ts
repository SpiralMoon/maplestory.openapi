import { GuildSkillBody } from '../../response/guild/guildBasicBody';

/**
 * 길드 스킬 정보
 */
class GuildSkillDto {
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

export { GuildSkillDto };

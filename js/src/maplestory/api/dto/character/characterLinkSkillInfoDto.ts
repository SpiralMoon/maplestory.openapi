import { CharacterLinkSkillInfoDtoBody } from '../../response/character/characterLinkSkillDtoBody';

/**
 * 캐릭터 링크 스킬 정보
 */
class CharacterLinkSkillInfoDto {
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
   * 스킬 효과
   */
  skillEffect: string;

  /**
   * 다음 레벨의 스킬 효과
   */
  skillEffectNext: string | null;

  /**
   * 스킬 아이콘
   */
  skillIcon: string;

  constructor(obj: CharacterLinkSkillInfoDtoBody) {
    const {
      skill_name,
      skill_description,
      skill_level,
      skill_effect,
      skill_effect_next,
      skill_icon,
    } = obj;

    this.skillName = skill_name;
    this.skillDescription = skill_description;
    this.skillLevel = skill_level;
    this.skillEffect = skill_effect;
    this.skillEffectNext = skill_effect_next;
    this.skillIcon = skill_icon;
  }
}

export { CharacterLinkSkillInfoDto };

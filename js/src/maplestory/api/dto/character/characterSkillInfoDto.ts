import { CharacterSkillInfoDtoBody } from '../../response/character/characterSkillDtoBody';

/**
 * 캐릭터 스킬 상세 정보
 */
class CharacterSkillInfoDto {
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
   * 스킬 레벨 별 효과 설명
   */
  skillEffect: string;

  /**
   * 다음 스킬 레벨 효과 설명
   */
  skillEffectNext: string | null;

  /**
   * 스킬 아이콘
   */
  skillIcon: string;

  constructor(obj: CharacterSkillInfoDtoBody) {
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

export { CharacterSkillInfoDto };

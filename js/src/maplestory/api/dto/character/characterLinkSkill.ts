import { CharacterLinkSkillBody, CharacterLinkSkillInfoBody } from '../../response/character/characterLinkSkillBody';

/**
 * 캐릭터 링크 스킬 정보
 */
export class CharacterLinkSkillDto {
  /**
   * 조회 기준일
   */
  date: Date | null;

  /**
   * 캐릭터 직업
   */
  characterClass: string | null;

  /**
   * 링크 스킬 정보
   */
  characterLinkSkill: CharacterLinkSkillInfoDto[];

  /**
   * 링크 스킬 1번 프리셋 정보
   */
  characterLinkSkillPreset1: CharacterLinkSkillInfoDto[];

  /**
   * 링크 스킬 2번 프리셋 정보
   */
  characterLinkSkillPreset2: CharacterLinkSkillInfoDto[];

  /**
   * 링크 스킬 3번 프리셋 정보
   */
  characterLinkSkillPreset3: CharacterLinkSkillInfoDto[];

  /**
   * 내 링크 스킬 정보
   */
  characterOwnedLinkSkill: CharacterLinkSkillInfoDto | null;

  /**
   * 내 링크 스킬 1번 프리셋 정보
   */
  characterOwnedLinkSkillPreset1: CharacterLinkSkillInfoDto | null;

  /**
   * 내 링크 스킬 2번 프리셋 정보
   */
  characterOwnedLinkSkillPreset2: CharacterLinkSkillInfoDto | null;

  /**
   * 내 링크 스킬 3번 프리셋 정보
   */
  characterOwnedLinkSkillPreset3: CharacterLinkSkillInfoDto | null;

  constructor(obj: CharacterLinkSkillBody) {
    const {
      date,
      character_class,
      character_link_skill,
      character_link_skill_preset_1,
      character_link_skill_preset_2,
      character_link_skill_preset_3,
      character_owned_link_skill,
      character_owned_link_skill_preset_1,
      character_owned_link_skill_preset_2,
      character_owned_link_skill_preset_3,
    } = obj;

    this.date = date ? new Date(date) : null;
    this.characterClass = character_class;
    this.characterLinkSkill = character_link_skill.map(
      (skill) => new CharacterLinkSkillInfoDto(skill),
    );
    this.characterLinkSkillPreset1 = character_link_skill_preset_1.map(
      (skill) => new CharacterLinkSkillInfoDto(skill),
    );
    this.characterLinkSkillPreset2 = character_link_skill_preset_2.map(
      (skill) => new CharacterLinkSkillInfoDto(skill),
    );
    this.characterLinkSkillPreset3 = character_link_skill_preset_3.map(
      (skill) => new CharacterLinkSkillInfoDto(skill),
    );
    this.characterOwnedLinkSkill = character_owned_link_skill ? new CharacterLinkSkillInfoDto(
      character_owned_link_skill,
    ) : null;
    this.characterOwnedLinkSkillPreset1 = character_owned_link_skill_preset_1 ? new CharacterLinkSkillInfoDto(
      character_owned_link_skill_preset_1,
    ) : null;
    this.characterOwnedLinkSkillPreset2 = character_owned_link_skill_preset_2 ?  new CharacterLinkSkillInfoDto(
      character_owned_link_skill_preset_2,
    ) : null;
    this.characterOwnedLinkSkillPreset3 =  character_owned_link_skill_preset_3 ? new CharacterLinkSkillInfoDto(
      character_owned_link_skill_preset_3,
    ) : null;
  }
}

/**
 * 캐릭터 링크 스킬 정보
 */
export class CharacterLinkSkillInfoDto {
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

  constructor(obj: CharacterLinkSkillInfoBody) {
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

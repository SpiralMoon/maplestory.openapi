import * as base from '../../../common/dto/character/characterLinkSkill';
import {
  CharacterLinkSkillBody,
  CharacterLinkSkillInfoBody,
} from '../../response/character/characterLinkSkillBody';

/**
 * Character equipped link skill information
 */
export class CharacterLinkSkillDto extends base.CharacterLinkSkillDto {
  /**
   * Reference date for query (SGT, daily data with hours and minutes set to 0)
   */
  public override date: Date | null;

  /**
   * Character job
   */
  public override characterClass: string;

  /**
   * Link Skill information
   */
  public override characterLinkSkill: CharacterLinkSkillInfoDto[];

  /**
   * Link Skill information for preset 1
   */
  public override characterLinkSkillPreset1: CharacterLinkSkillInfoDto[];

  /**
   * Link Skill information for preset 2
   */
  public override characterLinkSkillPreset2: CharacterLinkSkillInfoDto[];

  /**
   * Link Skill information for preset 3
   */
  public override characterLinkSkillPreset3: CharacterLinkSkillInfoDto[];

  /**
   * My Link Skill information
   */
  public override characterOwnedLinkSkill: CharacterLinkSkillInfoDto | null;

  /**
   * My Link Skill information for preset 1
   */
  public override characterOwnedLinkSkillPreset1: CharacterLinkSkillInfoDto | null;

  /**
   * My Link Skill information for preset 2
   */
  public override characterOwnedLinkSkillPreset2: CharacterLinkSkillInfoDto | null;

  /**
   * My Link Skill information for preset 3
   */
  public override characterOwnedLinkSkillPreset3: CharacterLinkSkillInfoDto | null;

  constructor(obj: CharacterLinkSkillBody) {
    super();

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
    this.characterClass = character_class!;
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
    this.characterOwnedLinkSkill = character_owned_link_skill
      ? new CharacterLinkSkillInfoDto(character_owned_link_skill)
      : null;
    this.characterOwnedLinkSkillPreset1 = character_owned_link_skill_preset_1
      ? new CharacterLinkSkillInfoDto(character_owned_link_skill_preset_1)
      : null;
    this.characterOwnedLinkSkillPreset2 = character_owned_link_skill_preset_2
      ? new CharacterLinkSkillInfoDto(character_owned_link_skill_preset_2)
      : null;
    this.characterOwnedLinkSkillPreset3 = character_owned_link_skill_preset_3
      ? new CharacterLinkSkillInfoDto(character_owned_link_skill_preset_3)
      : null;
  }
}

/**
 * Character link skill information
 */
export class CharacterLinkSkillInfoDto extends base.CharacterLinkSkillInfoDto {
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
   * Skill effect
   */
  public override skillEffect: string;

  /**
   * Effect for the next skill level
   */
  public override skillEffectNext: string | null;

  /**
   * Skill icon
   */
  public override skillIcon: string;

  constructor(obj: CharacterLinkSkillInfoBody) {
    super();

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

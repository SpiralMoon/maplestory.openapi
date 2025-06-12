import * as base from '../../../common/dto/character/characterSkill';
import {
  CharacterSkillBody,
  CharacterSkillInfoBody,
} from '../../response/character/characterSkillBody';

/**
 * Character skill information
 */
export class CharacterSkillDto extends base.CharacterSkillDto {
  /**
   * Reference date for query (SGT, daily data with hours and minutes set to 0)
   */
  public override date: Date | null;

  /**
   * Character job
   */
  public override characterClass: string | null;

  /**
   * Job advancement tier required to acquire the skill
   */
  public override characterSkillGrade: string | null;

  /**
   * Skill information
   */
  public override characterSkill: CharacterSkillInfoDto[];

  constructor(obj: CharacterSkillBody) {
    super();

    const { date, character_class, character_skill_grade, character_skill } =
      obj;

    this.date = date ? new Date(date) : null;
    this.characterClass = character_class;
    this.characterSkillGrade = character_skill_grade;
    this.characterSkill = character_skill.map(
      (skill) => new CharacterSkillInfoDto(skill),
    );
  }
}

/**
 * Skill information
 */
export class CharacterSkillInfoDto extends base.CharacterSkillInfoDto {
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
   * Effect description by skill level
   */
  public override skillEffect: string;

  /**
   * Effect description for the next skill level
   */
  public override skillEffectNext: string | null;

  /**
   * Skill icon
   */
  public override skillIcon: string;

  constructor(obj: CharacterSkillInfoBody) {
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

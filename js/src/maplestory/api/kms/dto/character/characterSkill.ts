import * as base from '../../../common/dto/character/characterSkill';
import {
  CharacterSkillBody,
  CharacterSkillInfoBody,
} from '../../response/character/characterSkillBody';

/**
 * 캐릭터 스킬 정보
 */
export class CharacterSkillDto extends base.CharacterSkillDto {
  /**
   * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
   */
  public override date: Date | null;

  /**
   * 캐릭터 직업
   */
  public override characterClass: string | null;

  /**
   * 스킬 전직 차수
   */
  public override characterSkillGrade: string | null;

  /**
   * 스킬 정보
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
 * 캐릭터 스킬 상세 정보
 */
export class CharacterSkillInfoDto extends base.CharacterSkillInfoDto {
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
   * 스킬 레벨 별 효과 설명
   */
  public override skillEffect: string | null;

  /**
   * 다음 스킬 레벨 효과 설명
   */
  public override skillEffectNext: string | null;

  /**
   * 스킬 아이콘
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

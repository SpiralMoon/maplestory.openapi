import * as base from '../../../common/dto/character/characterSkill';
import {
  CharacterSkillBody,
  CharacterSkillInfoBody,
} from '../../response/character/characterSkillBody';

/**
 * 角色技能與超技能資訊
 */
export class CharacterSkillDto extends base.CharacterSkillDto {
  /**
   * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
   */
  public override date: Date | null;

  /**
   * 角色職業
   */
  public override characterClass: string;

  /**
   * 技能轉職次數
   */
  public override characterSkillGrade: string | null;

  /**
   * 技能資訊
   */
  public override characterSkill: CharacterSkillInfoDto[];

  constructor(obj: CharacterSkillBody) {
    super();

    const { date, character_class, character_skill_grade, character_skill } =
      obj;

    this.date = date ? new Date(date) : null;
    this.characterClass = character_class!;
    this.characterSkillGrade = character_skill_grade;
    this.characterSkill = character_skill.map(
      (skill) => new CharacterSkillInfoDto(skill),
    );
  }
}

/**
 * 技能資訊
 */
export class CharacterSkillInfoDto extends base.CharacterSkillInfoDto {
  /**
   * 技能名稱
   */
  public override skillName: string;

  /**
   * 技能描述
   */
  public override skillDescription: string;

  /**
   * 技能等級
   */
  public override skillLevel: number;

  /**
   * 技能等級的效果描述
   */
  public override skillEffect: string | null;

  /**
   * 下一等級的技能效果
   */
  public override skillEffectNext: string | null;

  /**
   * 技能圖示
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

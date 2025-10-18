import * as base from '../../../common/dto/character/characterLinkSkill';
import {
  CharacterLinkSkillBody,
  CharacterLinkSkillInfoBody,
} from '../../response/character/characterLinkSkillBody';

/**
 * 角色已裝備連結技能資訊
 */
export class CharacterLinkSkillDto extends base.CharacterLinkSkillDto {
  /**
   * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
   */
  public override date: Date | null;

  /**
   * 角色職業
   */
  public override characterClass: string | null;

  /**
   * 連結技能資訊
   */
  public override characterLinkSkill: CharacterLinkSkillInfoDto[];

  /**
   * 連結技能 1 預設資訊
   */
  public override characterLinkSkillPreset1: CharacterLinkSkillInfoDto[];

  /**
   * 連結技能 2 預設資訊
   */
  public override characterLinkSkillPreset2: CharacterLinkSkillInfoDto[];

  /**
   * 連結技能 3 預設資訊
   */
  public override characterLinkSkillPreset3: CharacterLinkSkillInfoDto[];

  /**
   * 我的連結技能資訊
   */
  public override characterOwnedLinkSkill: CharacterLinkSkillInfoDto | null;

  /**
   * 我的連結技能 1 預設資訊
   */
  public override characterOwnedLinkSkillPreset1: CharacterLinkSkillInfoDto | null;

  /**
   * 我的連結技能 2 預設資訊
   */
  public override characterOwnedLinkSkillPreset2: CharacterLinkSkillInfoDto | null;

  /**
   * 我的連結技能 3 預設資訊
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
 * 角色連結技能資訊
 */
export class CharacterLinkSkillInfoDto extends base.CharacterLinkSkillInfoDto {
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
   * 技能效果
   */
  public override skillEffect: string;

  /**
   * 下一等級的技能效果
   */
  public override skillEffectNext: string | null;

  /**
   * 技能圖示
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

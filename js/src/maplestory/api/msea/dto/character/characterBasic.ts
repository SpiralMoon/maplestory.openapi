import * as base from '../../../common/dto/character/characterBasic';
import { CharacterBasicBody } from '../../response/character/characterBasicBody';

/**
 * Character basic information
 */
export class CharacterBasicDto extends base.CharacterBasicDto {
  /**
   * Reference date for query (SGT, daily data with hours and minutes set to 0)
   */
  public override date: Date | null;

  /**
   * Character name
   */
  public override characterName: string;

  /**
   * Character gender
   */
  public override worldName: string;

  /**
   * Character gender
   */
  public override characterGender: string;

  /**
   * Character job
   */
  public override characterClass: string;

  /**
   * Character job advancement tier
   */
  public override characterClassLevel: string;

  /**
   * Character level
   */
  public override characterLevel: number;

  /**
   * Experience points gained at the current level
   */
  public override characterExp: number;

  /**
   * Percentage of experience points at the current level
   */
  public override characterExpRate: string;

  /**
   * Guild name the character belongs to
   */
  public override characterGuildName: string | null;

  /**
   * Character appearance image
   */
  public override characterImage: string;

  /**
   * Character creation date (SGT, daily data with hours and minutes set to 0)
   */
  public override characterDateCreate: Date;

  /**
   * Login status in the past 7 days (true:logged in, false:not logged in)
   */
  public override accessFlag: 'true' | 'false';

  /**
   * Liberation quest completion status (true:completed, false:not completed)
   */
  public override liberationQuestClearFlag: 'true' | 'false';

  constructor(obj: CharacterBasicBody) {
    super();

    const {
      date,
      character_name,
      world_name,
      character_gender,
      character_class,
      character_class_level,
      character_level,
      character_exp,
      character_exp_rate,
      character_guild_name,
      character_image,
      character_date_create,
      access_flag,
      liberation_quest_clear_flag,
    } = obj;

    this.date = date ? new Date(date) : null;
    this.characterName = character_name;
    this.worldName = world_name;
    this.characterGender = character_gender;
    this.characterClass = character_class;
    this.characterClassLevel = character_class_level;
    this.characterLevel = character_level;
    this.characterExp = character_exp;
    this.characterExpRate = character_exp_rate;
    this.characterGuildName = character_guild_name;
    this.characterImage = character_image;
    this.characterDateCreate = new Date(character_date_create);
    this.accessFlag = access_flag;
    this.liberationQuestClearFlag = liberation_quest_clear_flag;
  }

  /**
   * Login status in the past 7 days
   */
  public override get isAccessFlag() {
    return super.isAccessFlag;
  }

  /**
   * Liberation quest completion status
   */
  public override get isLiberationQuestClearFlag() {
    return super.isLiberationQuestClearFlag;
  }
}

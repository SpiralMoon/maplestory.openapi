import * as base from '../../../common/dto/character/characterBasic';
import { CharacterBasicBody } from '../../response/character/characterBasicBody';
import { removeQuery } from '../../../common/lib'

/**
 * 角色基本資訊
 */
export class CharacterBasicDto extends base.CharacterBasicDto {
  /**
   * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
   */
  public override date: Date | null;

  /**
   * 角色名稱
   */
  public override characterName: string;

  /**
   * 世界名稱
   */
  public override worldName: string;

  /**
   * 角色性別
   */
  public override characterGender: string;

  /**
   * 角色職業
   */
  public override characterClass: string;

  /**
   * 角色轉職次數
   */
  public override characterClassLevel: string;

  /**
   * 角色等級
   */
  public override characterLevel: number;

  /**
   * 當前等級的經驗值
   */
  public override characterExp: number;

  /**
   * 當前等級的經驗值百分比
   */
  public override characterExpRate: string;

  /**
   * 角色所屬公會的名稱
   */
  public override characterGuildName: string | null;

  /**
   * 角色外型圖片
   */
  public override characterImage: string;

  /**
   * 角色建立日期 (TST，每日資料中的小時與分鐘將顯示為 0)
   */
  public override characterDateCreate: Date | null;

  /**
   * 過去 7 天的登入狀態 (true：已登入，false：未登入)
   */
  public override accessFlag: 'true' | 'false';

  /**
   * 解放任務完成狀態 (0：未完成，1：創世武器已解放)
   */
  public liberationQuestClear: string;

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
      liberation_quest_clear,
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
    this.characterImage = removeQuery(character_image);
    this.characterDateCreate = character_date_create ? new Date(character_date_create) : null;
    this.accessFlag = access_flag;
    this.liberationQuestClear = liberation_quest_clear;
  }

  /**
   * Login status in the past 7 days
   */
  public override get isAccessFlag() {
    return super.isAccessFlag;
  }
}

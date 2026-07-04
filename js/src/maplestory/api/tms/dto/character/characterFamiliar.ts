import {
  CharacterFamiliarBody,
  CharacterFamiliarInfoBody,
  CharacterFamiliarInfoOptionBody,
  CharacterFamiliarLinkSlotBody,
} from '../../response/character/characterFamiliarBody';

/**
 * 萌獸 資訊
 */
export class CharacterFamiliarDto {
  /**
   * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
   */
  public date: Date | null;

  /**
   * 萌獸 鏈路插槽資訊
   */
  public familiarLinkSlot: CharacterFamiliarLinkSlotDto[];

  /**
   * 萌獸 細節
   */
  public familiarInfo: CharacterFamiliarInfoDto[];

  constructor(obj: CharacterFamiliarBody) {
    const { date, familiar_link_slot, familiar_info } = obj;

    this.date = date ? new Date(date) : null;
    this.familiarLinkSlot = familiar_link_slot.map(
      (x) => new CharacterFamiliarLinkSlotDto(x),
    );
    this.familiarInfo = familiar_info.map(
      (x) => new CharacterFamiliarInfoDto(x),
    );
  }
}

/**
 * 萌獸 鏈路插槽資訊
 */
export class CharacterFamiliarLinkSlotDto {
  /**
   * 插槽標識符 (1~3, vip)
   */
  public slotId: string;

  /**
   * 連結的 萌獸 名稱 (如果插槽中沒有任何關聯，則為 null)
   */
  public familiarName: string | null;

  /**
   * 已啟用還是未啟用 (true, false)
   */
  public activeFlag: string;

  /**
   * 截止日期
   */
  public expireDate: Date | null;

  constructor(obj: CharacterFamiliarLinkSlotBody) {
    const { slot_id, familiar_name, active_flag, expire_date } = obj;

    this.slotId = slot_id!;
    this.familiarName = familiar_name;
    this.activeFlag = active_flag!;
    this.expireDate = expire_date ? new Date(expire_date) : null;
  }
}

/**
 * 萌獸 細節
 */
export class CharacterFamiliarInfoDto {
  /**
   * 萌獸 名稱
   */
  public familiarName: string;

  /**
   * 萌獸 暱稱
   */
  public familiarNickname: string;

  /**
   * 特別與否
   */
  public familiarSpecialFlag: string;

  /**
   * 萌獸 情況
   */
  public familiarState: string;

  /**
   * 等級
   */
  public familiarLevel: number;

  /**
   * 經驗
   */
  public familiarExp: number;

  /**
   * 具備的技能
   */
  public skillName: string | null;

  /**
   * 選項等級
   */
  public optionLevel: number;

  /**
   * 選項訊息
   */
  public option: CharacterFamiliarInfoOptionDto[];

  /**
   * 等級
   */
  public familiarGrade: string;

  /**
   * 外觀名稱
   */
  public lookName: string | null;

  /**
   * 當前是否已被召喚
   */
  public summonedFlag: string;

  /**
   * 連結槽索引 (1~3, vip, not link)
   */
  public slotId: string;

  constructor(obj: CharacterFamiliarInfoBody) {
    const {
      familiar_name,
      familiar_nickname,
      familiar_special_flag,
      familiar_state,
      familiar_level,
      familiar_exp,
      skill_name,
      option_level,
      option,
      familiar_grade,
      look_name,
      summoned_flag,
      slot_id,
    } = obj;

    this.familiarName = familiar_name!;
    this.familiarNickname = familiar_nickname!;
    this.familiarSpecialFlag = familiar_special_flag!;
    this.familiarState = familiar_state!;
    this.familiarLevel = familiar_level!;
    this.familiarExp = familiar_exp!;
    this.skillName = skill_name;
    this.optionLevel = option_level!;
    this.option = option.map((x) => new CharacterFamiliarInfoOptionDto(x));
    this.familiarGrade = familiar_grade!;
    this.lookName = look_name;
    this.summonedFlag = summoned_flag!;
    this.slotId = slot_id!;
  }
}

/**
 * 選項訊息
 */
export class CharacterFamiliarInfoOptionDto {
  /**
   * 選項號
   */
  public optionNo: number;

  /**
   * 選項名稱
   */
  public optionName: string;

  /**
   * 選擇權價值
   */
  public optionValue: string;

  constructor(obj: CharacterFamiliarInfoOptionBody) {
    const { option_no, option_name, option_value } = obj;

    this.optionNo = option_no!;
    this.optionName = option_name!;
    this.optionValue = option_value!;
  }
}

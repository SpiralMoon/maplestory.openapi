import * as base from '../../../common/dto/character/characterCashItemEquipment';
import {
  CharacterCashItemEquipmentBody,
  CharacterCashItemEquipmentColoringPrismBody,
  CharacterCashItemEquipmentOptionBody,
  CharacterCashItemEquipmentPresetBody,
} from '../../response/character/characterCashItemEquipmentBody';

/**
 * 角色已裝備現金道具資訊
 */
export class CharacterCashItemEquipmentDto extends base.CharacterCashItemEquipmentDto {
  /**
   * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
   */
  public override date: Date | null;

  /**
   * 角色性別
   */
  public override characterGender: string | null;

  /**
   * 角色職業
   */
  public override characterClass: string | null;

  /**
   * 角色外型模式 (0：一般模式，1：神之子為 Beta、天使破壞者為變裝模式時)
   */
  public override characterLookMode: string | null;

  /**
   * 目前套用的現金道具預設編號
   */
  public override presetNo: number | null;

  /**
   * 目前已裝備的現金道具
   */
  public override cashItemEquipmentBase: CharacterCashItemEquipmentPresetDto[];

  /**
   * 外型預設 1
   */
  public override cashItemEquipmentPreset1: CharacterCashItemEquipmentPresetDto[];

  /**
   * 外型預設 2
   */
  public override cashItemEquipmentPreset2: CharacterCashItemEquipmentPresetDto[];

  /**
   * 外型預設 3
   */
  public override cashItemEquipmentPreset3: CharacterCashItemEquipmentPresetDto[];

  /**
   * 神之子為 Beta 及天使破壞者為變裝模式時的目前已裝備現金道具
   */
  public override additionalCashItemEquipmentBase: CharacterCashItemEquipmentPresetDto[];

  /**
   * 神之子為 Beta 及天使破壞者為變裝模式時的外型預設 1
   */
  public override additionalCashItemEquipmentPreset1: CharacterCashItemEquipmentPresetDto[];

  /**
   * 神之子為 Beta 及天使破壞者為變裝模式時的外型預設 2
   */
  public override additionalCashItemEquipmentPreset2: CharacterCashItemEquipmentPresetDto[];

  /**
   * 神之子為 Beta 及天使破壞者為變裝模式時的外型預設 3
   */
  public override additionalCashItemEquipmentPreset3: CharacterCashItemEquipmentPresetDto[];

  constructor(obj: CharacterCashItemEquipmentBody) {
    super();

    const {
      date,
      character_gender,
      character_class,
      character_look_mode,
      preset_no,
      cash_item_equipment_base,
      cash_item_equipment_preset_1,
      cash_item_equipment_preset_2,
      cash_item_equipment_preset_3,
      additional_cash_item_equipment_base,
      additional_cash_item_equipment_preset_1,
      additional_cash_item_equipment_preset_2,
      additional_cash_item_equipment_preset_3,
    } = obj;

    this.date = date ? new Date(date) : null;
    this.characterGender = character_gender;
    this.characterClass = character_class;
    this.characterLookMode = character_look_mode;
    this.presetNo = preset_no;
    this.cashItemEquipmentBase = cash_item_equipment_base.map(
      (preset) => new CharacterCashItemEquipmentPresetDto(preset),
    );
    this.cashItemEquipmentPreset1 = cash_item_equipment_preset_1.map(
      (preset) => new CharacterCashItemEquipmentPresetDto(preset),
    );
    this.cashItemEquipmentPreset2 = cash_item_equipment_preset_2.map(
      (preset) => new CharacterCashItemEquipmentPresetDto(preset),
    );
    this.cashItemEquipmentPreset3 = cash_item_equipment_preset_3.map(
      (preset) => new CharacterCashItemEquipmentPresetDto(preset),
    );
    this.additionalCashItemEquipmentBase =
      additional_cash_item_equipment_base.map(
        (preset) => new CharacterCashItemEquipmentPresetDto(preset),
      );
    this.additionalCashItemEquipmentPreset1 =
      additional_cash_item_equipment_preset_1.map(
        (preset) => new CharacterCashItemEquipmentPresetDto(preset),
      );
    this.additionalCashItemEquipmentPreset2 =
      additional_cash_item_equipment_preset_2.map(
        (preset) => new CharacterCashItemEquipmentPresetDto(preset),
      );
    this.additionalCashItemEquipmentPreset3 =
      additional_cash_item_equipment_preset_3.map(
        (preset) => new CharacterCashItemEquipmentPresetDto(preset),
      );
  }
}

/**
 * 現金道具彩色稜鏡資訊
 */
export class CharacterCashItemEquipmentColoringPrismDto extends base.CharacterCashItemEquipmentColoringPrismDto {
  /**
   * 彩色稜鏡顏色範圍
   */
  public override colorRange: string;

  /**
   * 彩色稜鏡色調
   */
  public override hue: number;

  /**
   * 彩色稜鏡彩度
   */
  public override saturation: number;

  /**
   * 彩色稜鏡明度
   */
  public override value: number;

  constructor(obj: CharacterCashItemEquipmentColoringPrismBody) {
    super();

    const { color_range, hue, saturation, value } = obj;

    this.colorRange = color_range;
    this.hue = hue;
    this.saturation = saturation;
    this.value = value;
  }
}

/**
 * 現金道具選項
 */
export class CharacterCashItemEquipmentOptionDto extends base.CharacterCashItemEquipmentOptionDto {
  /**
   * 選項類型
   */
  public override optionType: string;

  /**
   * 選項數值
   */
  public override optionValue: string;

  constructor(obj: CharacterCashItemEquipmentOptionBody) {
    super();

    const { option_type, option_value } = obj;

    this.optionType = option_type;
    this.optionValue = option_value;
  }
}

/**
 * 外型預設
 */
export class CharacterCashItemEquipmentPresetDto extends base.CharacterCashItemEquipmentPresetDto {
  /**
   * 現金道具部位名稱
   */
  public override cashItemEquipmentPart: string;

  /**
   * 現金道具欄位位置
   */
  public override cashItemEquipmentSlot: string;

  /**
   * 現金道具名稱
   */
  public override cashItemName: string;

  /**
   * 現金道具圖示
   */
  public override cashItemIcon: string;

  /**
   * 現金道具描述
   */
  public override cashItemDescription: string | null;

  /**
   * 現金道具選項
   */
  public override cashItemOption: CharacterCashItemEquipmentOptionDto[];

  /**
   * 現金道具有效期間 (TST)
   */
  public override dateExpire: Date | null = null;

  /**
   * Whether the cash equipment is expired
   */
  public override isExpired: boolean | null = null;

  /**
   * 現金道具選項有效期間 (TST，時間單位資料中的分鐘顯示為 0)
   */
  public override dateOptionExpire: Date | null = null;

  /**
   * Whether the cash equipment option is expired
   */
  public override isOptionExpired: boolean | null = null;

  /**
   * 現金道具等級資訊
   */
  public override cashItemLabel: string | null;

  /**
   * 現金道具彩色稜鏡資訊
   */
  public override cashItemColoringPrism: CharacterCashItemEquipmentColoringPrismDto | null;

  /**
   * 道具可裝備性別
   */
  public override itemGender: string | null;

  /**
   * 技能名稱
   */
  public skills: string[];

  constructor(obj: CharacterCashItemEquipmentPresetBody) {
    super();

    const {
      cash_item_equipment_part,
      cash_item_equipment_slot,
      cash_item_name,
      cash_item_icon,
      cash_item_description,
      cash_item_option,
      date_expire,
      date_option_expire,
      cash_item_label,
      cash_item_coloring_prism,
      item_gender,
      skills,
    } = obj;

    this.cashItemEquipmentPart = cash_item_equipment_part;
    this.cashItemEquipmentSlot = cash_item_equipment_slot;
    this.cashItemName = cash_item_name;
    this.cashItemIcon = cash_item_icon;
    this.cashItemDescription = cash_item_description;
    this.cashItemOption = cash_item_option.map(
      (option) => new CharacterCashItemEquipmentOptionDto(option),
    );
    this.cashItemLabel = cash_item_label;
    this.cashItemColoringPrism = cash_item_coloring_prism
      ? new CharacterCashItemEquipmentColoringPrismDto(cash_item_coloring_prism)
      : null;
    this.itemGender = item_gender;
    this.skills = skills;

    if (date_expire === 'expired') {
      this.isExpired = true;
    } else if (typeof date_expire === 'string') {
      this.dateExpire = date_expire ? new Date(date_expire) : null;
    }

    if (date_option_expire === 'expired') {
      this.isOptionExpired = true;
    } else if (typeof date_option_expire === 'string') {
      this.dateOptionExpire = date_option_expire
        ? new Date(date_option_expire)
        : null;
    }
  }
}

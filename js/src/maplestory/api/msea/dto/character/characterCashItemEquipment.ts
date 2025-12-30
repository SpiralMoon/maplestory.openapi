import * as base from '../../../common/dto/character/characterCashItemEquipment';
import {
  CharacterCashItemEquipmentBody,
  CharacterCashItemEquipmentColoringPrismBody,
  CharacterCashItemEquipmentOptionBody,
  CharacterCashItemEquipmentPresetBody,
} from '../../response/character/characterCashItemEquipmentBody';

/**
 * Character cash item equipment information
 */
export class CharacterCashItemEquipmentDto extends base.CharacterCashItemEquipmentDto {
  /**
   * Reference date for query (SGT, daily data with hours and minutes set to 0)
   */
  public override date: Date | null;

  /**
   * Character gender
   */
  public override characterGender: string;

  /**
   * Character job
   */
  public override characterClass: string;

  /**
   * Character appearance mode (0:Normal mode, 1:Beta for Zero, Dress-up mode for Angelic Buster)
   */
  public override characterLookMode: string | null;

  /**
   * Preset number for equipped cash item
   */
  public override presetNo: number;

  /**
   * Equipped cash item
   */
  public override cashItemEquipmentBase: CharacterCashItemEquipmentPresetDto[];

  /**
   * Cosmetic item preset 1
   */
  public override cashItemEquipmentPreset1: CharacterCashItemEquipmentPresetDto[];

  /**
   * Cosmetic item preset 2
   */
  public override cashItemEquipmentPreset2: CharacterCashItemEquipmentPresetDto[];

  /**
   * Cosmetic item preset 3
   */
  public override cashItemEquipmentPreset3: CharacterCashItemEquipmentPresetDto[];

  /**
   * Equipped cash items for Beta mode (if Zero) or Dress-up mode (if Angelic Buster)
   */
  public override additionalCashItemEquipmentBase: CharacterCashItemEquipmentPresetDto[];

  /**
   * Cosmetic item preset 1 for Beta mode (if Zero) or Dress-up mode (if Angelic Buster)
   */
  public override additionalCashItemEquipmentPreset1: CharacterCashItemEquipmentPresetDto[];

  /**
   * Cosmetic item preset 2 for Beta mode (if Zero) or Dress-up mode (if Angelic Buster)
   */
  public override additionalCashItemEquipmentPreset2: CharacterCashItemEquipmentPresetDto[];

  /**
   * Cosmetic item preset 3 for Beta mode (if Zero) or Dress-up mode (if Angelic Buster)
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
    this.characterGender = character_gender!;
    this.characterClass = character_class!;
    this.characterLookMode = character_look_mode;
    this.presetNo = preset_no!;
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
 * Cash equipment coloring prism information
 */
export class CharacterCashItemEquipmentColoringPrismDto extends base.CharacterCashItemEquipmentColoringPrismDto {
  /**
   * Coloring prism color range
   */
  public override colorRange: string;

  /**
   * Coloring prism hue
   */
  public override hue: number;

  /**
   * Coloring prism saturation
   */
  public override saturation: number;

  /**
   * Coloring prism brightness
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
 * Cash equipment option
 */
export class CharacterCashItemEquipmentOptionDto extends base.CharacterCashItemEquipmentOptionDto {
  /**
   * Option type
   */
  public override optionType: string;

  /**
   * Option value
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
 * Equipped cash item preset information
 */
export class CharacterCashItemEquipmentPresetDto extends base.CharacterCashItemEquipmentPresetDto {
  /**
   * Cash equipment part name
   */
  public override cashItemEquipmentPart: string;

  /**
   * Cash equipment slot position
   */
  public override cashItemEquipmentSlot: string;

  /**
   * Cash equipment name
   */
  public override cashItemName: string;

  /**
   * Cash equipment icon
   */
  public override cashItemIcon: string;

  /**
   * Cash equipment description
   */
  public override cashItemDescription: string | null;

  /**
   * Cash equipment option
   */
  public override cashItemOption: CharacterCashItemEquipmentOptionDto[];

  /**
   * Cash equipment validity period (SGT)
   */
  public override dateExpire: Date | null = null;

  /**
   * Whether the cash equipment is expired
   */
  public override isExpired: boolean | null = null;

  /**
   * Cash equipment option validity period (SGT, data with minutes set to 0)
   */
  public override dateOptionExpire: Date | null = null;

  /**
   * Whether the cash equipment option is expired
   */
  public override isOptionExpired: boolean | null = null;

  /**
   * Cash equipment label information
   */
  public override cashItemLabel: string | null;

  /**
   * Cash equipment coloring prism information
   */
  public override cashItemColoringPrism: CharacterCashItemEquipmentColoringPrismDto | null;

  /**
   * Gender compatibility for item equipment
   */
  public override itemGender: string | null;

  /**
   * Skill name
   */
  public override skills: string[];

  /**
   * Freestyle Coupon application status (0:not applied, 1:applied)
   */
  public override freestyleFlag: string | null;

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
      freestyle_flag,
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
    this.freestyleFlag = freestyle_flag;

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

  /**
   * Freestyle Coupon application status
   */
  public get isFreestyleFlag() {
    return this.freestyleFlag === '1';
  }
}

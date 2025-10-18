import * as base from '../../../common/dto/character/characterAbility';
import {
  CharacterAbilityBody,
  CharacterAbilityInfoBody,
  CharacterAbilityPresetBody,
} from '../../response/character/characterAbilityBody';

/**
 * 角色能力資訊
 */
export class CharacterAbilityDto extends base.CharacterAbilityDto {
  /**
   * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
   */
  public override date: Date | null;

  /**
   * 能力階級
   */
  public override abilityGrade: string | null;

  /**
   * 能力資訊
   */
  public override abilityInfo: CharacterAbilityInfoDto[];

  /**
   * 名聲值
   */
  public override remainFame: number | null;

  /**
   * 目前套用的能力預設編號
   */
  public override presetNo: number | null;

  /**
   * 能力 1 預設完整資訊
   */
  public override abilityPreset1: CharacterAbilityPresetDto | null;

  /**
   * 能力 2 預設完整資訊
   */
  public override abilityPreset2: CharacterAbilityPresetDto | null;

  /**
   * 能力 3 預設完整資訊
   */
  public override abilityPreset3: CharacterAbilityPresetDto | null;

  constructor(obj: CharacterAbilityBody) {
    super();

    const {
      date,
      ability_grade,
      ability_info,
      remain_fame,
      preset_no,
      ability_preset_1,
      ability_preset_2,
      ability_preset_3,
    } = obj;

    this.date = date ? new Date(date) : null;
    this.abilityGrade = ability_grade;
    this.abilityInfo = ability_info.map(
      (info) => new CharacterAbilityInfoDto(info),
    );
    this.remainFame = remain_fame;
    this.presetNo = preset_no;
    this.abilityPreset1 = ability_preset_1
      ? new CharacterAbilityPresetDto(ability_preset_1)
      : null;
    this.abilityPreset2 = ability_preset_2
      ? new CharacterAbilityPresetDto(ability_preset_2)
      : null;
    this.abilityPreset3 = ability_preset_3
      ? new CharacterAbilityPresetDto(ability_preset_3)
      : null;
  }
}

/**
 * 能力資訊
 */
export class CharacterAbilityInfoDto extends base.CharacterAbilityInfoDto {
  /**
   * 能力編號
   */
  public override abilityNo: string;

  /**
   * 能力階級
   */
  public override abilityGrade: string;

  /**
   * 能力選項與數值
   */
  public override abilityValue: string;

  constructor(obj: CharacterAbilityInfoBody) {
    super();

    const { ability_no, ability_grade, ability_value } = obj;

    this.abilityNo = ability_no;
    this.abilityGrade = ability_grade;
    this.abilityValue = ability_value;
  }
}

/**
 * 能力預設完整資訊
 */
export class CharacterAbilityPresetDto extends base.CharacterAbilityPresetDto {
  /**
   * 能力預設能力階級
   */
  public override abilityPresetGrade: string;

  /**
   * 能力預設資訊
   */
  public override abilityInfo: CharacterAbilityInfoDto[];

  constructor(obj: CharacterAbilityPresetBody) {
    super();

    const { ability_preset_grade, ability_info } = obj;

    this.abilityPresetGrade = ability_preset_grade;
    this.abilityInfo = ability_info.map(
      (info) => new CharacterAbilityInfoDto(info),
    );
  }
}

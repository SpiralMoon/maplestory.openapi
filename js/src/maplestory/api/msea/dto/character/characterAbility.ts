import * as base from '../../../common/dto/character/characterAbility';
import {
  CharacterAbilityBody,
  CharacterAbilityInfoBody,
  CharacterAbilityPresetBody,
} from '../../response/character/characterAbilityBody';

/**
 * Character ability information
 */
export class CharacterAbilityDto extends base.CharacterAbilityDto {
  /**
   * Reference date for query (SGT, daily data with hours and minutes set to 0)
   */
  public override date: Date | null;

  /**
   * Ability grade
   */
  public override abilityGrade: string | null;

  /**
   * Ability information
   */
  public override abilityInfo: CharacterAbilityInfoDto[];

  /**
   * Owned Honor EXP
   */
  public override remainFame: number | null;

  /**
   * Active ability preset number
   */
  public override presetNo: number | null;

  /**
   * Complete information for Ability Preset 1
   */
  public override abilityPreset1: CharacterAbilityPresetDto | null;

  /**
   * Complete information for Ability Preset 2
   */
  public override abilityPreset2: CharacterAbilityPresetDto | null;

  /**
   * Complete information for Ability Preset 3
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
 * Information for Ability Preset
 */
export class CharacterAbilityInfoDto extends base.CharacterAbilityInfoDto {
  /**
   * Ability number
   */
  public override abilityNo: string;

  /**
   * Ability grade
   */
  public override abilityGrade: string;

  /**
   * Ability option and value
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
 * Character ability preset information
 */
export class CharacterAbilityPresetDto extends base.CharacterAbilityPresetDto {
  /**
   * Ability grade for Preset
   */
  public override abilityPresetGrade: string;

  /**
   * Information for Ability Preset
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

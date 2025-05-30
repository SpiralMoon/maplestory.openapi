import * as base from '../../../common/dto/character/characterHyperStat';
import {
  CharacterHyperStatBody,
  CharacterHyperStatPresetBody,
} from '../../response/character/characterHyperStatBody';

/**
 * Character Hyper Stat information
 */
export class CharacterHyperStatDto extends base.CharacterHyperStatDto {
  /**
   * Reference date for query (SGT, daily data with hours and minutes set to 0)
   */
  public override date: Date | null;

  /**
   * Character job
   */
  public override characterClass: string | null;

  /**
   * Active preset number
   */
  public override usePresetNo: string | null;

  /**
   * Maximum available Hyper Stat points
   */
  public override useAvailableHyperStat: number | null;

  /**
   * Hyper Stat information for preset 1
   */
  public override hyperStatPreset1: CharacterHyperStatPresetDto[];

  /**
   * Remaining Hyper Stat points for preset 1
   */
  public override hyperStatPreset1RemainPoint: number | null;

  /**
   * Hyper Stat information for preset 2
   */
  public override hyperStatPreset2: CharacterHyperStatPresetDto[];

  /**
   * Remaining Hyper Stat points for preset 2
   */
  public override hyperStatPreset2RemainPoint: number | null;

  /**
   * Hyper Stat information for preset 3
   */
  public override hyperStatPreset3: CharacterHyperStatPresetDto[];

  /**
   * Remaining Hyper Stat points for preset 3
   */
  public override hyperStatPreset3RemainPoint: number | null;

  constructor(obj: CharacterHyperStatBody) {
    super();

    const {
      date,
      character_class,
      use_preset_no,
      use_available_hyper_stat,
      hyper_stat_preset_1,
      hyper_stat_preset_1_remain_point,
      hyper_stat_preset_2,
      hyper_stat_preset_2_remain_point,
      hyper_stat_preset_3,
      hyper_stat_preset_3_remain_point,
    } = obj;

    this.date = date ? new Date(date) : null;
    this.characterClass = character_class;
    this.usePresetNo = use_preset_no;
    this.useAvailableHyperStat = use_available_hyper_stat;
    this.hyperStatPreset1 = hyper_stat_preset_1.map(
      (preset) => new CharacterHyperStatPresetDto(preset),
    );
    this.hyperStatPreset1RemainPoint = hyper_stat_preset_1_remain_point;
    this.hyperStatPreset2 = hyper_stat_preset_2.map(
      (preset) => new CharacterHyperStatPresetDto(preset),
    );
    this.hyperStatPreset2RemainPoint = hyper_stat_preset_2_remain_point;
    this.hyperStatPreset3 = hyper_stat_preset_3.map(
      (preset) => new CharacterHyperStatPresetDto(preset),
    );
    this.hyperStatPreset3RemainPoint = hyper_stat_preset_3_remain_point;
  }
}

/**
 * Hyper Stat information for preset
 */
export class CharacterHyperStatPresetDto extends base.CharacterHyperStatPresetDto {
  /**
   * Stat type
   */
  public override statType: string;

  /**
   * Stat points to invest
   */
  public override statPoint: number | null;

  /**
   * Stat level
   */
  public override statLevel: number;

  /**
   * Stat increases
   */
  public override statIncrease: string | null;

  constructor(obj: CharacterHyperStatPresetBody) {
    super();

    const { stat_type, stat_point, stat_level, stat_increase } = obj;

    this.statType = stat_type;
    this.statPoint = stat_point;
    this.statLevel = stat_level;
    this.statIncrease = stat_increase;
  }
}

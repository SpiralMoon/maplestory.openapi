import * as base from '../../../common/dto/character/characterHyperStat';
import {
  CharacterHyperStatBody,
  CharacterHyperStatPresetBody,
} from '../../response/character/characterHyperStatBody';

/**
 * 角色極限屬性資訊
 */
export class CharacterHyperStatDto extends base.CharacterHyperStatDto {
  /**
   * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
   */
  public override date: Date | null;

  /**
   * 角色職業
   */
  public override characterClass: string;

  /**
   * 目前套用的預設編號
   */
  public override usePresetNo: string;

  /**
   * 可用的極限屬性點數上限
   */
  public override useAvailableHyperStat: number;

  /**
   * 預設 1 的極限屬性資訊
   */
  public override hyperStatPreset1: CharacterHyperStatPresetDto[];

  /**
   * 預設 1 剩餘的極限屬性點數
   */
  public override hyperStatPreset1RemainPoint: number;

  /**
   * 預設 2 的極限屬性資訊
   */
  public override hyperStatPreset2: CharacterHyperStatPresetDto[];

  /**
   * 預設 2 剩餘的極限屬性點數
   */
  public override hyperStatPreset2RemainPoint: number;

  /**
   * 預設 3 的極限屬性資訊
   */
  public override hyperStatPreset3: CharacterHyperStatPresetDto[];

  /**
   * 預設 3 剩餘的極限屬性點數
   */
  public override hyperStatPreset3RemainPoint: number;

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
    this.characterClass = character_class!;
    this.usePresetNo = use_preset_no!;
    this.useAvailableHyperStat = use_available_hyper_stat!;
    this.hyperStatPreset1 = hyper_stat_preset_1.map(
      (preset) => new CharacterHyperStatPresetDto(preset),
    );
    this.hyperStatPreset1RemainPoint = hyper_stat_preset_1_remain_point!;
    this.hyperStatPreset2 = hyper_stat_preset_2.map(
      (preset) => new CharacterHyperStatPresetDto(preset),
    );
    this.hyperStatPreset2RemainPoint = hyper_stat_preset_2_remain_point!;
    this.hyperStatPreset3 = hyper_stat_preset_3.map(
      (preset) => new CharacterHyperStatPresetDto(preset),
    );
    this.hyperStatPreset3RemainPoint = hyper_stat_preset_3_remain_point!;
  }
}

/**
 * 預設的極限屬性資訊
 */
export class CharacterHyperStatPresetDto extends base.CharacterHyperStatPresetDto {
  /**
   * 能力值類型
   */
  public override statType: string;

  /**
   * 投入於能力值的點數
   */
  public override statPoint: number | null;

  /**
   * 能力值等級
   */
  public override statLevel: number;

  /**
   * 能力值提升量
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

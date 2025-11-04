import * as base from '../../../common/dto/character/characterHyperStat';
import {
  CharacterHyperStatBody,
  CharacterHyperStatPresetBody,
} from '../../response/character/characterHyperStatBody';

/**
 * 캐릭터 하이퍼 스탯 정보
 */
export class CharacterHyperStatDto extends base.CharacterHyperStatDto {
  /**
   * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
   */
  public override date: Date | null;

  /**
   * 캐릭터 직업
   */
  public override characterClass: string;

  /**
   * 적용 중인 프리셋 번호
   */
  public override usePresetNo: string;

  /**
   * 사용 가능한 최대 하이퍼스탯 포인트
   */
  public override useAvailableHyperStat: number;

  /**
   * 프리셋 1번 하이퍼 스탯 정보
   */
  public override hyperStatPreset1: CharacterHyperStatPresetDto[];

  /**
   * 프리셋 1번 하이퍼 스탯 잔여 포인트
   */
  public override hyperStatPreset1RemainPoint: number;

  /**
   * 프리셋 2번 하이퍼 스탯 정보
   */
  public override hyperStatPreset2: CharacterHyperStatPresetDto[];

  /**
   * 프리셋 2번 하이퍼 스탯 잔여 포인트
   */
  public override hyperStatPreset2RemainPoint: number;

  /**
   * 프리셋 3번 하이퍼 스탯 정보
   */
  public override hyperStatPreset3: CharacterHyperStatPresetDto[];

  /**
   * 프리셋 3번 하이퍼 스탯 잔여 포인트
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
 * 캐릭터 하이퍼 스탯 프리셋 정보
 */
export class CharacterHyperStatPresetDto extends base.CharacterHyperStatPresetDto {
  /**
   * 스탯 종류
   */
  public override statType: string;

  /**
   * 스탯 투자 포인트
   */
  public override statPoint: number | null;

  /**
   * 스탯 레벨
   */
  public override statLevel: number;

  /**
   * 스탯 상승량
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

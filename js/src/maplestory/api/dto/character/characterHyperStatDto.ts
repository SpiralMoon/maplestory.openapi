import { CharacterHyperStatPresetDto } from './characterHyperStatPresetDto';
import { CharacterHyperStatDtoBody } from '../../response/character/characterHyperStatDtoBody';

/**
 * 캐릭터 하이퍼 스탯 정보
 */
class CharacterHyperStatDto {
  /**
   * 조회 기준일
   */
  date: Date | null;

  /**
   * 캐릭터 직업
   */
  characterClass: string | null;

  /**
   * 적용 중인 프리셋 번호
   */
  usePresetNo: string | null;

  /**
   * 사용 가능한 최대 하이퍼스탯 포인트
   */
  useAvailableHyperStat: number | null;

  /**
   * 프리셋 1번 하이퍼 스탯 정보
   */
  hyperStatPreset1: CharacterHyperStatPresetDto[];

  /**
   * 프리셋 1번 하이퍼 스탯 잔여 포인트
   */
  hyperStatPreset1RemainPoint: number | null;

  /**
   * 프리셋 2번 하이퍼 스탯 정보
   */
  hyperStatPreset2: CharacterHyperStatPresetDto[];

  /**
   * 프리셋 2번 하이퍼 스탯 잔여 포인트
   */
  hyperStatPreset2RemainPoint: number | null;

  /**
   * 프리셋 3번 하이퍼 스탯 정보
   */
  hyperStatPreset3: CharacterHyperStatPresetDto[];

  /**
   * 프리셋 3번 하이퍼 스탯 잔여 포인트
   */
  hyperStatPreset3RemainPoint: number | null;

  constructor(obj: CharacterHyperStatDtoBody) {
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

export { CharacterHyperStatDto };

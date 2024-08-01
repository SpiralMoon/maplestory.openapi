import { UnionRaiderBlockDto } from './unionRaiderBlockDto';
import { UnionRaiderInnerStatDto } from './unionRaiderInnerStatDto';
import { UnionRaiderPresetDto } from './unionRaiderPresetDto';
import { UnionRaiderDtoBody } from '../../response/union/unionRaiderDtoBody';

/**
 * 유니온 공격대 정보
 */
class UnionRaiderDto {
  date: Date | null;

  /**
   * 유니온 공격대원 효과
   */
  unionRaiderStat: string[];

  /**
   * 유니온 공격대 점령 효과
   */
  unionOccupiedStat: string[];

  /**
   * 유니온 공격대 배치
   */
  unionInnerStat: UnionRaiderInnerStatDto[];

  /**
   * 유니온 블록 정보
   */
  unionBlock: UnionRaiderBlockDto[];

  /**
   * 적용 중인 프리셋 번호
   */
  usePresetNo: number;

  /**
   * 유니온 프리셋 1번 정보
   */
  unionRaiderPreset1: UnionRaiderPresetDto | null;

  /**
   * 유니온 프리셋 2번 정보
   */
  unionRaiderPreset2: UnionRaiderPresetDto | null;

  /**
   * 유니온 프리셋 3번 정보
   */
  unionRaiderPreset3: UnionRaiderPresetDto | null;

  /**
   * 유니온 프리셋 4번 정보
   */
  unionRaiderPreset4: UnionRaiderPresetDto | null;

  /**
   * 유니온 프리셋 5번 정보
   */
  unionRaiderPreset5: UnionRaiderPresetDto | null;

  constructor(obj: UnionRaiderDtoBody) {
    const {
      date,
      union_raider_stat,
      union_occupied_stat,
      union_inner_stat,
      union_block,
      use_preset_no,
      union_raider_preset_1,
      union_raider_preset_2,
      union_raider_preset_3,
      union_raider_preset_4,
      union_raider_preset_5,
    } = obj;

    this.date = date ? new Date(date) : null;
    this.unionRaiderStat = union_raider_stat;
    this.unionOccupiedStat = union_occupied_stat;
    this.unionInnerStat = union_inner_stat.map(
      (stat) => new UnionRaiderInnerStatDto(stat),
    );
    this.unionBlock = union_block.map(
      (block) => new UnionRaiderBlockDto(block),
    );
    this.usePresetNo = use_preset_no;
    this.unionRaiderPreset1 = union_raider_preset_1
      ? new UnionRaiderPresetDto(union_raider_preset_1)
      : null;
    this.unionRaiderPreset2 = union_raider_preset_2
      ? new UnionRaiderPresetDto(union_raider_preset_2)
      : null;
    this.unionRaiderPreset3 = union_raider_preset_3
      ? new UnionRaiderPresetDto(union_raider_preset_3)
      : null;
    this.unionRaiderPreset4 = union_raider_preset_4
      ? new UnionRaiderPresetDto(union_raider_preset_4)
      : null;
    this.unionRaiderPreset5 = union_raider_preset_5
      ? new UnionRaiderPresetDto(union_raider_preset_5)
      : null;
  }
}

export { UnionRaiderDto };

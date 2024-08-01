import { UnionRaiderBlockDto } from './unionRaiderBlockDto';
import { UnionRaiderInnerStatDto } from './unionRaiderInnerStatDto';
import { UnionRaiderPresetDtoBody } from '../../response/union/unionRaiderDtoBody';

/**
 * 유니온 프리셋 정보
 */
class UnionRaiderPresetDto {

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

  constructor(obj: UnionRaiderPresetDtoBody) {
    const {
      union_raider_stat,
      union_occupied_stat,
      union_inner_stat,
      union_block,
    } = obj;

    this.unionRaiderStat = union_raider_stat;
    this.unionOccupiedStat = union_occupied_stat;
    this.unionInnerStat = union_inner_stat.map(
      (stat) => new UnionRaiderInnerStatDto(stat),
    );
    this.unionBlock = union_block.map(
      (block) => new UnionRaiderBlockDto(block),
    );
  }
}

export { UnionRaiderPresetDto };

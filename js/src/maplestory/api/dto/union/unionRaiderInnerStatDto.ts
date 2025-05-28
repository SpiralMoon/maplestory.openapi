import { UnionRaiderInnerStatBody } from '../../response/union/unionRaiderBody';

/**
 * 유니온 공격대 배치 정보
 */
class UnionRaiderInnerStatDto {
  /**
   * 공격대 배치 위치 (11시 방향부터 시계 방향 순서대로 0~7)
   */
  statFieldId: string;

  /**
   * 해당 지역 점령 효과
   */
  statFieldEffect: string;

  constructor(obj: UnionRaiderInnerStatBody) {
    const { stat_field_id, stat_field_effect } = obj;

    this.statFieldId = stat_field_id;
    this.statFieldEffect = stat_field_effect;
  }
}

export { UnionRaiderInnerStatDto };

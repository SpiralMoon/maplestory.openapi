import { StarforceEventDtoBody } from '@src/maplestory/api/response/history/starforceEventDtoBody';

/**
 * 스타포스 강화 이벤트 정보
 */
class StarforceEventDto {
  /**
   * 이벤트 성공 확률
   */
  successRate: string;

  /**
   * 이벤트 비용 할인율
   */
  costDiscountRate: string;

  /**
   * 이벤트 강화 수치 가중값
   */
  plusValue: string;

  /**
   * 이벤트 적용 강화 시도 가능한 n성 범위
   */
  starforceEventRange: string;

  constructor(obj: StarforceEventDtoBody) {
    const {
      success_rate,
      cost_discount_rate,
      plus_value,
      starforce_event_range,
    } = obj;

    this.successRate = success_rate;
    this.costDiscountRate = cost_discount_rate;
    this.plusValue = plus_value;
    this.starforceEventRange = starforce_event_range;
  }
}

export { StarforceEventDto };

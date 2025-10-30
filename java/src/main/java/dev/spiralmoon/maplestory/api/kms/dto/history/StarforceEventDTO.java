package dev.spiralmoon.maplestory.api.kms.dto.history;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 스타포스 강화 이벤트 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class StarforceEventDTO {

    /**
     * 이벤트 성공 확률
     */
    @JsonProperty("success_rate")
    private String successRate;

    /**
     * 이벤트 파괴 확률 감소율
     */
    @JsonProperty("destroy_decrease_rate")
    private String destroyDecreaseRate;

    /**
     * 이벤트 비용 할인율
     */
    @JsonProperty("cost_discount_rate")
    private String costDiscountRate;

    /**
     * 이벤트 강화 수치 가중값
     */
    @JsonProperty("plus_value")
    private String plusValue;

    /**
     * 이벤트 적용 강화 시도 가능한 n성 범위
     */
    @JsonProperty("starforce_event_range")
    private String starforceEventRange;
}

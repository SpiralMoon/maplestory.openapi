package dev.spiralmoon.maplestory.api.dto.history;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 스타포스 강화 이벤트 정보
 */
@AllArgsConstructor
@Data
@ToString
public class StarforceEventDTO {

    /**
     * 이벤트 성공 확률
     */
    @SerializedName("success_rate")
    private String successRate;

    /**
     * 이벤트 비용 할인율
     */
    @SerializedName("cost_discount_rate")
    private String costDiscountRate;

    /**
     * 이벤트 강화 수치 가중값
     */
    @SerializedName("plus_value")
    private String plusValue;

    /**
     * 이벤트 적용 강화 시도 가능한 n성 범위
     */
    @SerializedName("starforce_event_range")
    private String starforceEventRange;
}

package dev.spiralmoon.maplestory.api.kms.dto.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 유니온 공격대 배치 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionRaiderInnerStatDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionRaiderInnerStatDTO {

    /**
     * 공격대 배치 위치 (11시 방향부터 시계 방향 순서대로 0~7)
     */
    @JsonProperty("stat_field_id")
    private String statFieldId;

    /**
     * 해당 지역 점령 효과
     */
    @JsonProperty("stat_field_effect")
    private String statFieldEffect;
}

package dev.spiralmoon.maplestory.api.tms.dto.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 方塊基準點座標
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionRaiderBlockControlPointDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionRaiderBlockControlPointDTO {

    /**
     * 方塊基準點 x 座標
     */
    @JsonProperty("x")
    private long x;

    /**
     * 方塊基準點 y 座標
     */
    @JsonProperty("y")
    private long y;
}

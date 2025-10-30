package dev.spiralmoon.maplestory.api.tms.dto.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 方塊佔領區域的座標
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionRaiderBlockPositionDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionRaiderBlockPositionDTO {

    /**
     * 方塊 x 座標
     */
    @JsonProperty("x")
    private long x;

    /**
     * 方塊 y 座標
     */
    @JsonProperty("y")
    private long y;
}

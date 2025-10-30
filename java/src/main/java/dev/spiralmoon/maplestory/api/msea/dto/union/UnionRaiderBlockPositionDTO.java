package dev.spiralmoon.maplestory.api.msea.dto.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Coordinates of the area occupied by the block
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionRaiderBlockPositionDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionRaiderBlockPositionDTO {

    /**
     * Block X-coordinate
     */
    @JsonProperty("x")
    private long x;

    /**
     * Block Y-coordinate
     */
    @JsonProperty("y")
    private long y;
}

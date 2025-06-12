package dev.spiralmoon.maplestory.api.msea.dto.union;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Coordinates of the area occupied by the block
 */
@AllArgsConstructor
@Data
@ToString
public class UnionRaiderBlockPositionDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionRaiderBlockPositionDTO {

    /**
     * Block X-coordinate
     */
    @SerializedName("x")
    private long x;

    /**
     * Block Y-coordinate
     */
    @SerializedName("y")
    private long y;
}

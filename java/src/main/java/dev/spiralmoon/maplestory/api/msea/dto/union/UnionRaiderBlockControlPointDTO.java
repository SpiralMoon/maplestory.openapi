package dev.spiralmoon.maplestory.api.msea.dto.union;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Coordinates of the block's reference point:<br>
 * - The bottom-right square among the four central squares is positioned at x: 0, y: 0.<br>
 * - Moving one square to the left decreases x by 1.<br>
 * - Moving one square to the right increases x by 1.<br>
 * - Moving one square downward decreases y by 1.<br>
 * - Moving one square upward increases y by 1.
 */
@AllArgsConstructor
@Data
@ToString
public class UnionRaiderBlockControlPointDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionRaiderBlockControlPointDTO {

    /**
     * Block reference point X-coordinate
     */
    @SerializedName("x")
    private long x;

    /**
     * Block reference point Y-coordinate
     */
    @SerializedName("y")
    private long y;
}

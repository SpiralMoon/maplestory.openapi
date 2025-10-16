package dev.spiralmoon.maplestory.api.tms.dto.union;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 方塊基準點座標
 */
@AllArgsConstructor
@Data
@ToString
public class UnionRaiderBlockControlPointDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionRaiderBlockControlPointDTO {

    /**
     * 方塊基準點 x 座標
     */
    @SerializedName("x")
    private long x;

    /**
     * 方塊基準點 y 座標
     */
    @SerializedName("y")
    private long y;
}

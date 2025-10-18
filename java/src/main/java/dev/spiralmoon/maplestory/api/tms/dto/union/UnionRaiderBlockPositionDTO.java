package dev.spiralmoon.maplestory.api.tms.dto.union;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 方塊佔領區域的座標
 */
@AllArgsConstructor
@Data
@ToString
public class UnionRaiderBlockPositionDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionRaiderBlockPositionDTO {

    /**
     * 方塊 x 座標
     */
    @SerializedName("x")
    private long x;

    /**
     * 方塊 y 座標
     */
    @SerializedName("y")
    private long y;
}

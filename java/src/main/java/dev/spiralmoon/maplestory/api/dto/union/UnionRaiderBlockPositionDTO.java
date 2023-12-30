package dev.spiralmoon.maplestory.api.dto.union;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 유니온 블록이 차지하고 있는 영역 좌표들
 */
@AllArgsConstructor
@Data
@ToString
public class UnionRaiderBlockPositionDTO {

    /**
     * 블록 X좌표
     */
    @SerializedName("x")
    private long x;

    /**
     * 블록 Y좌표
     */
    @SerializedName("y")
    private long y;
}

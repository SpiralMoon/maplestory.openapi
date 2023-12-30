package dev.spiralmoon.maplestory.api.dto.union;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 유니온 블록 기준점 좌표 정보
 */
@AllArgsConstructor
@Data
@ToString
public class UnionRaiderBlockControlPointDTO {

    /**
     * 블록 기준점 X좌표
     */
    @SerializedName("x")
    private long x;

    /**
     * 블록 기준점 Y좌표
     */
    @SerializedName("y")
    private long y;
}

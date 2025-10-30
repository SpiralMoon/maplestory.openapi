package dev.spiralmoon.maplestory.api.kms.dto.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 유니온 블록이 차지하고 있는 영역 좌표들
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionRaiderBlockPositionDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionRaiderBlockPositionDTO {

    /**
     * 블록 X좌표
     */
    @JsonProperty("x")
    private long x;

    /**
     * 블록 Y좌표
     */
    @JsonProperty("y")
    private long y;
}

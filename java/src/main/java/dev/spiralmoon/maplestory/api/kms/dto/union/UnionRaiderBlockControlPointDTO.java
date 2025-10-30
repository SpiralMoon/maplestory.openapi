package dev.spiralmoon.maplestory.api.kms.dto.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 유니온 블록 기준점 좌표 정보<br>
 * - 중앙 4칸 중 오른쪽 아래 칸이 x : 0, y : 0 포지션<br>
 * - 좌측으로 1칸씩 이동하면 x가 1씩 감소<br>
 * - 우측으로 1칸씩 이동하면 x가 1씩 증가<br>
 * - 아래로 1칸씩 이동하면 y가 1씩 감소<br>
 * - 위로 1칸씩 이동하면 y가 1씩 증가
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionRaiderBlockControlPointDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionRaiderBlockControlPointDTO {

    /**
     * 블록 기준점 X좌표
     */
    @JsonProperty("x")
    private long x;

    /**
     * 블록 기준점 Y좌표
     */
    @JsonProperty("y")
    private long y;
}

package dev.spiralmoon.maplestory.api.dto.union;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 유니온 공격대 정보
 */
@AllArgsConstructor
@Data
@ToString
public class UnionRaiderDTO {

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @SerializedName("date")
    private String date;

    /**
     * 유니온 공격대원 효과
     */
    @SerializedName("union_raider_stat")
    private List<String> unionRaiderStat;

    /**
     * 유니온 공격대 점령 효과
     */
    @SerializedName("union_occupied_stat")
    private List<String> unionOccupiedStat;

    /**
     * 유니온 공격대 배치
     */
    @SerializedName("union_inner_stat")
    private List<UnionRaiderInnerStatDTO> unionInnerStat;

    /**
     * 유니온 블록 정보
     */
    @SerializedName("union_block")
    private List<UnionRaiderBlockDTO> unionBlock;

    public LocalDateTime getDate() {
        return Utils.toLocalDateTime(this.date);
    }
}

package dev.spiralmoon.maplestory.api.kms.dto.union;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 유니온 프리셋 정보
 */
@AllArgsConstructor
@Data
@ToString
public class UnionRaiderPresetDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionRaiderPresetDTO<UnionRaiderInnerStatDTO, UnionRaiderBlockDTO> {

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
}

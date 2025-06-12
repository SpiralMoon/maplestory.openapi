package dev.spiralmoon.maplestory.api.msea.dto.union;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Union preset information
 */
@AllArgsConstructor
@Data
@ToString
public class UnionRaiderPresetDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionRaiderPresetDTO<UnionRaiderInnerStatDTO, UnionRaiderBlockDTO> {

    /**
     * Union raid member effects
     */
    @SerializedName("union_raider_stat")
    private List<String> unionRaiderStat;

    /**
     * Union raid capture effects
     */
    @SerializedName("union_occupied_stat")
    private List<String> unionOccupiedStat;

    /**
     * Union raider deployment
     */
    @SerializedName("union_inner_stat")
    private List<UnionRaiderInnerStatDTO> unionInnerStat;

    /**
     * Information about Legion Blocks
     */
    @SerializedName("union_block")
    private List<UnionRaiderBlockDTO> unionBlock;
}

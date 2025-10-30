package dev.spiralmoon.maplestory.api.msea.dto.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Union preset information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionRaiderPresetDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionRaiderPresetDTO<UnionRaiderInnerStatDTO, UnionRaiderBlockDTO> {

    /**
     * Union raid member effects
     */
    @JsonProperty("union_raider_stat")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<String> unionRaiderStat;

    /**
     * Union raid capture effects
     */
    @JsonProperty("union_occupied_stat")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<String> unionOccupiedStat;

    /**
     * Union raider deployment
     */
    @JsonProperty("union_inner_stat")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<UnionRaiderInnerStatDTO> unionInnerStat;

    /**
     * Information about Legion Blocks
     */
    @JsonProperty("union_block")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<UnionRaiderBlockDTO> unionBlock;
}

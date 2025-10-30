package dev.spiralmoon.maplestory.api.msea.dto.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Union raider information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionRaiderDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionRaiderDTO<UnionRaiderInnerStatDTO, UnionRaiderBlockDTO, UnionRaiderPresetDTO> {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @JsonProperty("date")
    private String date;

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
     * Union Legion Block
     */
    @JsonProperty("union_block")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<UnionRaiderBlockDTO> unionBlock;

    /**
     * Number of the preset currently in use
     */
    @JsonProperty("use_preset_no")
    private int usePresetNo;

    /**
     * Information for Union Preset 1
     */
    @JsonProperty("union_raider_preset_1")
    private UnionRaiderPresetDTO unionRaiderPreset1;

    /**
     * Information for Union Preset 2
     */
    @JsonProperty("union_raider_preset_2")
    private UnionRaiderPresetDTO unionRaiderPreset2;

    /**
     * Information for Union Preset 3
     */
    @JsonProperty("union_raider_preset_3")
    private UnionRaiderPresetDTO unionRaiderPreset3;

    /**
     * Information for Union Preset 4
     */
    @JsonProperty("union_raider_preset_4")
    private UnionRaiderPresetDTO unionRaiderPreset4;

    /**
     * Information for Union Preset 5
     */
    @JsonProperty("union_raider_preset_5")
    private UnionRaiderPresetDTO unionRaiderPreset5;

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}

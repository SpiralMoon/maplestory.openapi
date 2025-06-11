package dev.spiralmoon.maplestory.api.msea.dto.union;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Union raider information
 */
@AllArgsConstructor
@Data
@ToString
public class UnionRaiderDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionRaiderDTO<UnionRaiderInnerStatDTO, UnionRaiderBlockDTO, UnionRaiderPresetDTO> {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @SerializedName("date")
    private String date;

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
     * Union Legion Block
     */
    @SerializedName("union_block")
    private List<UnionRaiderBlockDTO> unionBlock;

    /**
     * Number of the preset currently in use
     */
    @SerializedName("use_preset_no")
    private int usePresetNo;

    /**
     * Information for Union Preset 1
     */
    @SerializedName("union_raider_preset_1")
    private UnionRaiderPresetDTO unionRaiderPreset1;

    /**
     * Information for Union Preset 2
     */
    @SerializedName("union_raider_preset_2")
    private UnionRaiderPresetDTO unionRaiderPreset2;

    /**
     * Information for Union Preset 3
     */
    @SerializedName("union_raider_preset_3")
    private UnionRaiderPresetDTO unionRaiderPreset3;

    /**
     * Information for Union Preset 4
     */
    @SerializedName("union_raider_preset_4")
    private UnionRaiderPresetDTO unionRaiderPreset4;

    /**
     * Information for Union Preset 5
     */
    @SerializedName("union_raider_preset_5")
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

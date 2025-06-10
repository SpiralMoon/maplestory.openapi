package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Character Hyper Stat information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterHyperStatDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHyperStatDTO<
        CharacterHyperStatPresetDTO> {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @SerializedName("date")
    private String date;

    /**
     * Character job
     */
    @SerializedName("character_class")
    private String characterClass;

    /**
     * Active preset number
     */
    @SerializedName("use_preset_no")
    private String usePresetNo;

    /**
     * Maximum available Hyper Stat points
     */
    @SerializedName("use_available_hyper_stat")
    private Integer useAvailableHyperStat;

    /**
     * Hyper Stat information for preset 1
     */
    @SerializedName("hyper_stat_preset_1")
    private List<CharacterHyperStatPresetDTO> hyperStatPreset1;

    /**
     * Remaining Hyper Stat points for preset 1
     */
    @SerializedName("hyper_stat_preset_1_remain_point")
    private Integer hyperStatPreset1RemainPoint;

    /**
     * Hyper Stat information for preset 2
     */
    @SerializedName("hyper_stat_preset_2")
    private List<CharacterHyperStatPresetDTO> hyperStatPreset2;

    /**
     * Remaining Hyper Stat points for preset 2
     */
    @SerializedName("hyper_stat_preset_2_remain_point")
    private Integer hyperStatPreset2RemainPoint;

    /**
     * Hyper Stat information for preset 3
     */
    @SerializedName("hyper_stat_preset_3")
    private List<CharacterHyperStatPresetDTO> hyperStatPreset3;

    /**
     * Remaining Hyper Stat points for preset 3
     */
    @SerializedName("hyper_stat_preset_3_remain_point")
    private Integer hyperStatPreset3RemainPoint;

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}

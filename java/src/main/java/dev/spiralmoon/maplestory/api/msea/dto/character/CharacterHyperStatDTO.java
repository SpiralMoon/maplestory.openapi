package dev.spiralmoon.maplestory.api.msea.dto.character;

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
 * Character Hyper Stat information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterHyperStatDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHyperStatDTO<
        CharacterHyperStatPresetDTO> {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @JsonProperty("date")
    private String date;

    /**
     * Character job
     */
    @JsonProperty("character_class")
    private String characterClass;

    /**
     * Active preset number
     */
    @JsonProperty("use_preset_no")
    private String usePresetNo;

    /**
     * Maximum available Hyper Stat points
     */
    @JsonProperty("use_available_hyper_stat")
    private Integer useAvailableHyperStat;

    /**
     * Hyper Stat information for preset 1
     */
    @JsonProperty("hyper_stat_preset_1")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterHyperStatPresetDTO> hyperStatPreset1;

    /**
     * Remaining Hyper Stat points for preset 1
     */
    @JsonProperty("hyper_stat_preset_1_remain_point")
    private Integer hyperStatPreset1RemainPoint;

    /**
     * Hyper Stat information for preset 2
     */
    @JsonProperty("hyper_stat_preset_2")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterHyperStatPresetDTO> hyperStatPreset2;

    /**
     * Remaining Hyper Stat points for preset 2
     */
    @JsonProperty("hyper_stat_preset_2_remain_point")
    private Integer hyperStatPreset2RemainPoint;

    /**
     * Hyper Stat information for preset 3
     */
    @JsonProperty("hyper_stat_preset_3")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterHyperStatPresetDTO> hyperStatPreset3;

    /**
     * Remaining Hyper Stat points for preset 3
     */
    @JsonProperty("hyper_stat_preset_3_remain_point")
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

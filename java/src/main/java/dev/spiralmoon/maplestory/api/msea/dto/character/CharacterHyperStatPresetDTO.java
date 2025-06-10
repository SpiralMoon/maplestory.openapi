package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Hyper Stat information for preset
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterHyperStatPresetDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHyperStatPresetDTO {

    /**
     * Stat type
     */
    @SerializedName("stat_type")
    private String statType;

    /**
     * Stat points to invest
     */
    @SerializedName("stat_point")
    private long statPoint;

    /**
     * Stat level
     */
    @SerializedName("stat_level")
    private long statLevel;

    /**
     * Stat increases
     */
    @SerializedName("stat_increase")
    private String statIncrease;
}

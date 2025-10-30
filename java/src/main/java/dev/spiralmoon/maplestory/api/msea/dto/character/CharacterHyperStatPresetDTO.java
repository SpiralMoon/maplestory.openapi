package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Hyper Stat information for preset
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterHyperStatPresetDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHyperStatPresetDTO {

    /**
     * Stat type
     */
    @JsonProperty("stat_type")
    private String statType;

    /**
     * Stat points to invest
     */
    @JsonProperty("stat_point")
    private long statPoint;

    /**
     * Stat level
     */
    @JsonProperty("stat_level")
    private long statLevel;

    /**
     * Stat increases
     */
    @JsonProperty("stat_increase")
    private String statIncrease;
}

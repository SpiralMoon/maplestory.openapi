package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Current stat information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterFinalStatDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterFinalStatDTO {

    /**
     * Stat name
     */
    @JsonProperty("stat_name")
    private String statName;

    /**
     * Stat value
     */
    @JsonProperty("stat_value")
    private String statValue;
}

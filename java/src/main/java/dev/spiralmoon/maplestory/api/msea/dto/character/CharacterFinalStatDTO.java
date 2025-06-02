package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Current stat information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterFinalStatDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterFinalStatDTO {

    /**
     * Stat name
     */
    @SerializedName("stat_name")
    private String statName;

    /**
     * Stat value
     */
    @SerializedName("stat_value")
    private String statValue;
}

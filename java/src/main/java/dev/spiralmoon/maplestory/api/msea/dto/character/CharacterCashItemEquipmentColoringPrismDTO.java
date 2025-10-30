package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Cash equipment coloring prism information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterCashItemEquipmentColoringPrismDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterCashItemEquipmentColoringPrismDTO {

    /**
     * Coloring prism color range
     */
    @JsonProperty("color_range")
    private String colorRange;

    /**
     * Coloring prism hue
     */
    @JsonProperty("hue")
    private long hue;

    /**
     * Coloring prism saturation
     */
    @JsonProperty("saturation")
    private long saturation;

    /**
     * Coloring prism brightness
     */
    @JsonProperty("value")
    private long value;
}

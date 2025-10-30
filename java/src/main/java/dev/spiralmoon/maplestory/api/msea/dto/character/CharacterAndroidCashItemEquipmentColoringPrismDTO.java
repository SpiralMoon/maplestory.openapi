package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Android cash item coloring prism information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterAndroidCashItemEquipmentColoringPrismDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidCashItemEquipmentColoringPrismDTO {

    /**
     * Coloring prism color range
     */
    @JsonProperty("color_range")
    private String colorRange;

    /**
     * Coloring prism hue
     */
    @JsonProperty("hue")
    private Long hue;

    /**
     * Coloring prism saturation
     */
    @JsonProperty("saturation")
    private Long saturation;

    /**
     * Coloring prism brightness
     */
    @JsonProperty("value")
    private Long value;
}

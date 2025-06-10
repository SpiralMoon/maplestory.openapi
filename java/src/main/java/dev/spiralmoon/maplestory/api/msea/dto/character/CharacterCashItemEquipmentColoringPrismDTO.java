package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Cash equipment coloring prism information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterCashItemEquipmentColoringPrismDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterCashItemEquipmentColoringPrismDTO {

    /**
     * Coloring prism color range
     */
    @SerializedName("color_range")
    private String colorRange;

    /**
     * Coloring prism hue
     */
    @SerializedName("hue")
    private long hue;

    /**
     * Coloring prism saturation
     */
    @SerializedName("saturation")
    private long saturation;

    /**
     * Coloring prism brightness
     */
    @SerializedName("value")
    private long value;
}

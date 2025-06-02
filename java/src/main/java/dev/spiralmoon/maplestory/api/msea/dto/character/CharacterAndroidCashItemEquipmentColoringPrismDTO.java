package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Android cash item coloring prism information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterAndroidCashItemEquipmentColoringPrismDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidCashItemEquipmentColoringPrismDTO {

    /**
     * Coloring prism color range
     */
    @SerializedName("color_range")
    private String colorRange;

    /**
     * Coloring prism hue
     */
    @SerializedName("hue")
    private Long hue;

    /**
     * Coloring prism saturation
     */
    @SerializedName("saturation")
    private Long saturation;

    /**
     * Coloring prism brightness
     */
    @SerializedName("value")
    private Long value;
}

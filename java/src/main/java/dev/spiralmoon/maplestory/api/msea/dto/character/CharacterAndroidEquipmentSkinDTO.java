package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Android skin information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterAndroidEquipmentSkinDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidEquipmentSkinDTO {

    /**
     * Skin name
     */
    @JsonProperty("skin_name")
    private String skinName;

    /**
     * Color style
     */
    @JsonProperty("color_style")
    private String colorStyle;

    /**
     * Skin hue
     */
    @JsonProperty("hue")
    private Integer hue;

    /**
     * Skin saturation
     */
    @JsonProperty("saturation")
    private Integer saturation;

    /**
     * Skin brightness
     */
    @JsonProperty("brightness")
    private Integer brightness;
}

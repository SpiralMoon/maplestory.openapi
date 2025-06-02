package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Android skin information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterAndroidEquipmentSkinDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidEquipmentSkinDTO {

    /**
     * Skin name
     */
    @SerializedName("skin_name")
    private String skinName;

    /**
     * Color style
     */
    @SerializedName("color_style")
    private String colorStyle;

    /**
     * Skin hue
     */
    @SerializedName("hue")
    private Integer hue;

    /**
     * Skin saturation
     */
    @SerializedName("saturation")
    private Integer saturation;

    /**
     * Skin brightness
     */
    @SerializedName("brightness")
    private Integer brightness;
}

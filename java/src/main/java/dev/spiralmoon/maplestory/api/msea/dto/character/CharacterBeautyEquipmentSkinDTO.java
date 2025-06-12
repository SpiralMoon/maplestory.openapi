package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Character skin information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterBeautyEquipmentSkinDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterBeautyEquipmentSkinDTO {

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

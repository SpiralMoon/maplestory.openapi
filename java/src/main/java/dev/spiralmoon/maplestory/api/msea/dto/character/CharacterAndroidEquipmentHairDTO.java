package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Android hair information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterAndroidEquipmentHairDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidEquipmentHairDTO {

    /**
     * Android hair name
     */
    @SerializedName("hair_name")
    private String hairName;

    /**
     * Android base hair color
     */
    @SerializedName("base_color")
    private String baseColor;

    /**
     * Android mixed hair color
     */
    @SerializedName("mix_color")
    private String mixColor;

    /**
     * Dye ratio for Android mixed hair color
     */
    @SerializedName("mix_rate")
    private String mixRate;
}

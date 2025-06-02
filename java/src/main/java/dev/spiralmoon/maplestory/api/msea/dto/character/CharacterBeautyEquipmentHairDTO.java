package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Character hair information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterBeautyEquipmentHairDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterBeautyEquipmentHairDTO {

    /**
     * Hair name
     */
    @SerializedName("hair_name")
    private String hairName;

    /**
     * Base hair color
     */
    @SerializedName("base_color")
    private String baseColor;

    /**
     * Mixed hair color
     */
    @SerializedName("mix_color")
    private String mixColor;

    /**
     * Dye ratio for mixed hair color
     */
    @SerializedName("mix_rate")
    private String mixRate;
}

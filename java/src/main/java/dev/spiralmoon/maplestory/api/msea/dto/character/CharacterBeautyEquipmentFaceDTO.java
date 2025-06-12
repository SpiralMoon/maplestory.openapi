package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Character face information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterBeautyEquipmentFaceDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterBeautyEquipmentFaceDTO {

    /**
     * Face name
     */
    @SerializedName("face_name")
    private String faceName;

    /**
     * Base face color
     */
    @SerializedName("base_color")
    private String baseColor;

    /**
     * Mixed face color
     */
    @SerializedName("mix_color")
    private String mixColor;

    /**
     * Dye ratio for mixed face color
     */
    @SerializedName("mix_rate")
    private String mixRate;
}

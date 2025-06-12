package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Android face information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterAndroidEquipmentFaceDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidEquipmentFaceDTO {

    /**
     * Android face name
     */
    @SerializedName("face_name")
    private String faceName;

    /**
     * Android base face color
     */
    @SerializedName("base_color")
    private String baseColor;

    /**
     * Android mixed face color
     */
    @SerializedName("mix_color")
    private String mixColor;

    /**
     * Dye ratio for Android mixed face color
     */
    @SerializedName("mix_rate")
    private String mixRate;
}

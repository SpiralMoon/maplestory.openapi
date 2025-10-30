package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Android face information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterAndroidEquipmentFaceDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidEquipmentFaceDTO {

    /**
     * Android face name
     */
    @JsonProperty("face_name")
    private String faceName;

    /**
     * Android base face color
     */
    @JsonProperty("base_color")
    private String baseColor;

    /**
     * Android mixed face color
     */
    @JsonProperty("mix_color")
    private String mixColor;

    /**
     * Dye ratio for Android mixed face color
     */
    @JsonProperty("mix_rate")
    private String mixRate;
}

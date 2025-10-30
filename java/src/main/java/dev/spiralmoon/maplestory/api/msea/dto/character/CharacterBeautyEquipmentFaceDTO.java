package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Character face information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterBeautyEquipmentFaceDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterBeautyEquipmentFaceDTO {

    /**
     * Face name
     */
    @JsonProperty("face_name")
    private String faceName;

    /**
     * Base face color
     */
    @JsonProperty("base_color")
    private String baseColor;

    /**
     * Mixed face color
     */
    @JsonProperty("mix_color")
    private String mixColor;

    /**
     * Dye ratio for mixed face color
     */
    @JsonProperty("mix_rate")
    private String mixRate;
}

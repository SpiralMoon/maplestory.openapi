package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Character hair information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterBeautyEquipmentHairDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterBeautyEquipmentHairDTO {

    /**
     * Hair name
     */
    @JsonProperty("hair_name")
    private String hairName;

    /**
     * Base hair color
     */
    @JsonProperty("base_color")
    private String baseColor;

    /**
     * Mixed hair color
     */
    @JsonProperty("mix_color")
    private String mixColor;

    /**
     * Dye ratio for mixed hair color
     */
    @JsonProperty("mix_rate")
    private String mixRate;
}

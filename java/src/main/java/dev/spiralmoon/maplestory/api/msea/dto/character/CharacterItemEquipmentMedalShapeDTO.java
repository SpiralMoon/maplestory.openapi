package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Medal appearance information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentMedalShapeDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterItemEquipmentMedalShapeDTO {

    /**
     * Medal equipment name registered in the appearance settings
     */
    @JsonProperty("medal_shape_name")
    private String medalShapeName;

    /**
     * Medal icon registered in the appearance settings
     */
    @JsonProperty("medal_shape_icon")
    private String medalShapeIcon;

    /**
     * Medal description registered in the appearance settings
     */
    @JsonProperty("medal_shape_description")
    private String medalShapeDescription;

    /**
     * Fusion Anvil-applied medal equipment name registered in the appearance settings
     */
    @JsonProperty("medal_shape_changed_name")
    private String medalShapeChangedName;

    /**
     * Fusion Anvil-applied medal icon registered in the appearance settings
     */
    @JsonProperty("medal_shape_changed_icon")
    private String medalShapeChangedIcon;

    /**
     * Fusion Anvil-applied medal description registered in the appearance settings
     */
    @JsonProperty("medal_shape_changed_description")
    private String medalShapeChangedDescription;
}

package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Cash equipment option
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterCashItemEquipmentOptionDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterCashItemEquipmentOptionDTO {

    /**
     * Option type
     */
    @JsonProperty("option_type")
    private String optionType;

    /**
     * Option value
     */
    @JsonProperty("option_value")
    private String optionValue;
}

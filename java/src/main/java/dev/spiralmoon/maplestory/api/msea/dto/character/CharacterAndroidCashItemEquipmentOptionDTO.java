package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Android cash item options
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterAndroidCashItemEquipmentOptionDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidCashItemEquipmentOptionDTO {

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

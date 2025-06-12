package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Cash equipment option
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterCashItemEquipmentOptionDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterCashItemEquipmentOptionDTO {

    /**
     * Option type
     */
    @SerializedName("option_type")
    private String optionType;

    /**
     * Option value
     */
    @SerializedName("option_value")
    private String optionValue;
}

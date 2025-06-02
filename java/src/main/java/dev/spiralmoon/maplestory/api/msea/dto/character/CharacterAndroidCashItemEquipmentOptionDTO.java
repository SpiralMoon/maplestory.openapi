package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Android cash item options
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterAndroidCashItemEquipmentOptionDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidCashItemEquipmentOptionDTO {

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

package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 道具顯示選項
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterPetEquipmentItemOptionDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterPetEquipmentItemOptionDTO {

    /**
     * 選項類型
     */
    @SerializedName("option_type")
    private String optionType;

    /**
     * 選項數值
     */
    @SerializedName("option_value")
    private String optionValue;
}

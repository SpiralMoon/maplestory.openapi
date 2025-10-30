package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 道具顯示選項
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterPetEquipmentItemOptionDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterPetEquipmentItemOptionDTO {

    /**
     * 選項類型
     */
    @JsonProperty("option_type")
    private String optionType;

    /**
     * 選項數值
     */
    @JsonProperty("option_value")
    private String optionValue;
}

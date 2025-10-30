package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 現金道具選項
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterCashItemEquipmentOptionDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterCashItemEquipmentOptionDTO {

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

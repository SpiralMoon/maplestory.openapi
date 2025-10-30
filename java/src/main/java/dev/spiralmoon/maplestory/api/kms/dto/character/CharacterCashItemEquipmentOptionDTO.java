package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 캐릭터 캐시 장비 옵션
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterCashItemEquipmentOptionDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterCashItemEquipmentOptionDTO {

    /**
     * 옵션 타입
     */
    @JsonProperty("option_type")
    private String optionType;

    /**
     * 옵션 값
     */
    @JsonProperty("option_value")
    private String optionValue;
}

package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 캐릭터 펫 장비 아이템 옵션 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterPetEquipmentItemOptionDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterPetEquipmentItemOptionDTO {

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

package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 캐릭터 안드로이드 캐시 아이템 옵션 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterAndroidCashItemEquipmentOptionDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidCashItemEquipmentOptionDTO {

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

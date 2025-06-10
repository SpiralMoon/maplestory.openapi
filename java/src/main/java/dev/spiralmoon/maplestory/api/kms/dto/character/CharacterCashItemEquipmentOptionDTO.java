package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 캐릭터 캐시 장비 옵션
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterCashItemEquipmentOptionDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterCashItemEquipmentOptionDTO {

    /**
     * 옵션 타입
     */
    @SerializedName("option_type")
    private String optionType;

    /**
     * 옵션 값
     */
    @SerializedName("option_value")
    private String optionValue;
}

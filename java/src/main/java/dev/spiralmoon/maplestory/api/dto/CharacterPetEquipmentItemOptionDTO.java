package dev.spiralmoon.maplestory.api.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 캐릭터 펫 장비 아이템 옵션 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterPetEquipmentItemOptionDTO {

    @SerializedName("option_type")
    private String optionType;

    @SerializedName("option_value")
    private String optionValue;
}

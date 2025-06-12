package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 캐릭터 캐시 장비 컬러링프리즘
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterCashItemEquipmentColoringPrismDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterCashItemEquipmentColoringPrismDTO {

    /**
     * 컬러링프리즘 색상 범위
     */
    @SerializedName("color_range")
    private String colorRange;

    /**
     * 컬러링프리즘 색조
     */
    @SerializedName("hue")
    private long hue;

    /**
     * 컬러링프리즘 채도
     */
    @SerializedName("saturation")
    private long saturation;

    /**
     * 컬러링프리즘 명도
     */
    @SerializedName("value")
    private long value;
}

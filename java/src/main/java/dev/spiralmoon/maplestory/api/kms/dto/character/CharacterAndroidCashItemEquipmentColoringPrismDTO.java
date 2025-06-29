package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 캐릭터 안드로이드 캐시 아이템 컬러링프리즘 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterAndroidCashItemEquipmentColoringPrismDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidCashItemEquipmentColoringPrismDTO {

    /**
     * 컬러링프리즘 색상 범위
     */
    @SerializedName("color_range")
    private String colorRange;

    /**
     * 컬러링프리즘 색조
     */
    @SerializedName("hue")
    private Long hue;

    /**
     * 컬러링프리즘 채도
     */
    @SerializedName("saturation")
    private Long saturation;

    /**
     * 컬러링프리즘 명도
     */
    @SerializedName("value")
    private Long value;
}

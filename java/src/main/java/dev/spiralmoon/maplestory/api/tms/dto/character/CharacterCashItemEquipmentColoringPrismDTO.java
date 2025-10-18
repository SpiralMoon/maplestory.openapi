package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 現金道具彩色稜鏡資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterCashItemEquipmentColoringPrismDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterCashItemEquipmentColoringPrismDTO {

    /**
     * 彩色稜鏡顏色範圍
     */
    @SerializedName("color_range")
    private String colorRange;

    /**
     * 彩色稜鏡色調
     */
    @SerializedName("hue")
    private long hue;

    /**
     * 彩色稜鏡彩度
     */
    @SerializedName("saturation")
    private long saturation;

    /**
     * 彩色稜鏡明度
     */
    @SerializedName("value")
    private long value;
}

package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 機器人現金道具彩色稜鏡資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterAndroidCashItemEquipmentColoringPrismDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidCashItemEquipmentColoringPrismDTO {

    /**
     * 彩色稜鏡顏色範圍
     */
    @JsonProperty("color_range")
    private String colorRange;

    /**
     * 彩色稜鏡色調
     */
    @JsonProperty("hue")
    private Long hue;

    /**
     * 彩色稜鏡彩度
     */
    @JsonProperty("saturation")
    private Long saturation;

    /**
     * 彩色稜鏡明度
     */
    @JsonProperty("value")
    private Long value;
}

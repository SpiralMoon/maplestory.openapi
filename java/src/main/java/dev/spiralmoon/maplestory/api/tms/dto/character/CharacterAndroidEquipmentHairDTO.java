package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 機器人髮型資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterAndroidEquipmentHairDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidEquipmentHairDTO {

    /**
     * 機器人髮型名稱
     */
    @JsonProperty("hair_name")
    private String hairName;

    /**
     * 機器人髮型基本顏色
     */
    @JsonProperty("base_color")
    private String baseColor;

    /**
     * 機器人髮型混染顏色
     */
    @JsonProperty("mix_color")
    private String mixColor;

    /**
     * 機器人髮型混染顏色比例
     */
    @JsonProperty("mix_rate")
    private String mixRate;
}

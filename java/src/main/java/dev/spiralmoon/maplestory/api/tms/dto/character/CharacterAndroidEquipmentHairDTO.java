package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 機器人髮型資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterAndroidEquipmentHairDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidEquipmentHairDTO {

    /**
     * 機器人髮型名稱
     */
    @SerializedName("hair_name")
    private String hairName;

    /**
     * 機器人髮型基本顏色
     */
    @SerializedName("base_color")
    private String baseColor;

    /**
     * 機器人髮型混染顏色
     */
    @SerializedName("mix_color")
    private String mixColor;

    /**
     * 機器人髮型混染顏色比例
     */
    @SerializedName("mix_rate")
    private String mixRate;
}

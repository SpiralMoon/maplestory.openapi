package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 機器人臉型資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterAndroidEquipmentFaceDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidEquipmentFaceDTO {

    /**
     * 機器人臉型名稱
     */
    @JsonProperty("face_name")
    private String faceName;

    /**
     * 機器人臉型基本顏色
     */
    @JsonProperty("base_color")
    private String baseColor;

    /**
     * 機器人臉型混染顏色
     */
    @JsonProperty("mix_color")
    private String mixColor;

    /**
     * 機器人臉型混染顏色比例
     */
    @JsonProperty("mix_rate")
    private String mixRate;

    /**
     * 自由造型券 使用狀態（0：未使用，1：已使用）
     */
    @JsonProperty("freestyle_flag")
    private String freestyleFlag;

    /**
     * 自由造型券 使用狀態
     */
    public boolean isFreestyleFlag() {
        return "1".equals(this.freestyleFlag);
    }
}

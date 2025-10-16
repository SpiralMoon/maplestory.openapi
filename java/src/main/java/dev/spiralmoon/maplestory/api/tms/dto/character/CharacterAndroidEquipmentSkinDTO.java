package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 機器人膚色資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterAndroidEquipmentSkinDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidEquipmentSkinDTO {

    /**
     * 膚色名稱
     */
    @SerializedName("skin_name")
    private String skinName;

    /**
     * 色系
     */
    @SerializedName("color_style")
    private String colorStyle;

    /**
     * 膚色色調
     */
    @SerializedName("hue")
    private Integer hue;

    /**
     * 膚色彩度
     */
    @SerializedName("saturation")
    private Integer saturation;

    /**
     * 膚色明度
     */
    @SerializedName("brightness")
    private Integer brightness;
}

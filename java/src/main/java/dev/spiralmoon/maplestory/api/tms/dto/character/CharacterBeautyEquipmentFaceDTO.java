package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 角色臉型資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterBeautyEquipmentFaceDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterBeautyEquipmentFaceDTO {

    /**
     * 臉型名稱
     */
    @SerializedName("face_name")
    private String faceName;

    /**
     * 臉型基本顏色
     */
    @SerializedName("base_color")
    private String baseColor;

    /**
     * 臉型混染顏色
     */
    @SerializedName("mix_color")
    private String mixColor;

    /**
     * 臉型混染顏色比例
     */
    @SerializedName("mix_rate")
    private String mixRate;
}

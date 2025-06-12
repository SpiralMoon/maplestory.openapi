package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 캐릭터 피부 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterBeautyEquipmentSkinDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterBeautyEquipmentSkinDTO {

    /**
     * 피부 명
     */
    @SerializedName("skin_name")
    private String skinName;

    /**
     * 색상 계열
     */
    @SerializedName("color_style")
    private String colorStyle;

    /**
     * 피부 색조
     */
    @SerializedName("hue")
    private Integer hue;

    /**
     * 피부 채도
     */
    @SerializedName("saturation")
    private Integer saturation;

    /**
     * 피부 명도
     */
    @SerializedName("brightness")
    private Integer brightness;
}

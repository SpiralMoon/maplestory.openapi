package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 캐릭터 피부 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterBeautyEquipmentSkinDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterBeautyEquipmentSkinDTO {

    /**
     * 피부 명
     */
    @JsonProperty("skin_name")
    private String skinName;

    /**
     * 색상 계열
     */
    @JsonProperty("color_style")
    private String colorStyle;

    /**
     * 피부 색조
     */
    @JsonProperty("hue")
    private Integer hue;

    /**
     * 피부 채도
     */
    @JsonProperty("saturation")
    private Integer saturation;

    /**
     * 피부 명도
     */
    @JsonProperty("brightness")
    private Integer brightness;
}

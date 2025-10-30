package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 角色膚色資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterBeautyEquipmentSkinDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterBeautyEquipmentSkinDTO {

    /**
     * 膚色名稱
     */
    @JsonProperty("skin_name")
    private String skinName;

    /**
     * 色系
     */
    @JsonProperty("color_style")
    private String colorStyle;

    /**
     * 膚色色調
     */
    @JsonProperty("hue")
    private Integer hue;

    /**
     * 膚色彩度
     */
    @JsonProperty("saturation")
    private Integer saturation;

    /**
     * 膚色明度
     */
    @JsonProperty("brightness")
    private Integer brightness;
}

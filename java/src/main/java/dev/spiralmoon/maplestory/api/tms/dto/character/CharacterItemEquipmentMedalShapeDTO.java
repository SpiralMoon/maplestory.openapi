package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 外型設定中已登錄勳章的外型資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentMedalShapeDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterItemEquipmentMedalShapeDTO {

    /**
     * 外型設定中已登錄勳章的道具名稱
     */
    @JsonProperty("medal_shape_name")
    private String medalShapeName;

    /**
     * 外型設定中已登錄勳章的圖示
     */
    @JsonProperty("medal_shape_icon")
    private String medalShapeIcon;

    /**
     * 外型設定中已登錄勳章的描述
     */
    @JsonProperty("medal_shape_description")
    private String medalShapeDescription;

    /**
     * 外型設定中已登錄勳章的鐵砧套用道具名稱
     */
    @JsonProperty("medal_shape_changed_name")
    private String medalShapeChangedName;

    /**
     * 外型設定中已登錄勳章的鐵砧套用圖示
     */
    @JsonProperty("medal_shape_changed_icon")
    private String medalShapeChangedIcon;

    /**
     * 外型設定中已登錄勳章的鐵砧套用勳章說明
     */
    @JsonProperty("medal_shape_changed_description")
    private String medalShapeChangedDescription;
}

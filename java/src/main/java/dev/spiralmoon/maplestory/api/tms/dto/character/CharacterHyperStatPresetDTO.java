package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 預設的極限屬性資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterHyperStatPresetDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHyperStatPresetDTO {

    /**
     * 能力值類型
     */
    @JsonProperty("stat_type")
    private String statType;

    /**
     * 投入於能力值的點數
     */
    @JsonProperty("stat_point")
    private Long statPoint;

    /**
     * 能力值等級
     */
    @JsonProperty("stat_level")
    private long statLevel;

    /**
     * 能力值提升量
     */
    @JsonProperty("stat_increase")
    private String statIncrease;
}

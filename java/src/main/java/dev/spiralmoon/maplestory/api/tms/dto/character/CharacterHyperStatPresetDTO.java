package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 預設的極限屬性資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterHyperStatPresetDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHyperStatPresetDTO {

    /**
     * 能力值類型
     */
    @SerializedName("stat_type")
    private String statType;

    /**
     * 投入於能力值的點數
     */
    @SerializedName("stat_point")
    private long statPoint;

    /**
     * 能力值等級
     */
    @SerializedName("stat_level")
    private long statLevel;

    /**
     * 能力值提升量
     */
    @SerializedName("stat_increase")
    private String statIncrease;
}

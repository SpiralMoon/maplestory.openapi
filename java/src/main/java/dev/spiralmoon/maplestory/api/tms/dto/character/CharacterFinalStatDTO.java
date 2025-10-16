package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 當前能力值資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterFinalStatDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterFinalStatDTO {

    /**
     * 能力值名稱
     */
    @SerializedName("stat_name")
    private String statName;

    /**
     * 能力值數值
     */
    @SerializedName("stat_value")
    private String statValue;
}
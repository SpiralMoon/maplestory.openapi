package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 當前能力值資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterFinalStatDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterFinalStatDTO {

    /**
     * 能力值名稱
     */
    @JsonProperty("stat_name")
    private String statName;

    /**
     * 能力值數值
     */
    @JsonProperty("stat_value")
    private String statValue;
}
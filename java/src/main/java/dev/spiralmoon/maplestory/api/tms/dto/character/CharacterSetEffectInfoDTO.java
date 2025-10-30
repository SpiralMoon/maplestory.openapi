package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 目前已裝備的套裝效果資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterSetEffectInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSetEffectInfoDTO {

    /**
     * 套裝效果等級 (裝備件數)
     */
    @JsonProperty("set_count")
    private int setCount;

    /**
     * 套裝效果
     */
    @JsonProperty("set_option")
    private String setOption;
}

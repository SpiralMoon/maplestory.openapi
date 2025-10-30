package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Active Set Item effect information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterSetEffectInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSetEffectInfoDTO {

    /**
     * Set Item effect level (number of equipped items)
     */
    @JsonProperty("set_count")
    private int setCount;

    /**
     * Set Item effect
     */
    @JsonProperty("set_option")
    private String setOption;
}

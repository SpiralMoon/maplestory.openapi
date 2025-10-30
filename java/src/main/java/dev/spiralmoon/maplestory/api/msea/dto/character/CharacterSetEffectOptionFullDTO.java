package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * All Set Item effect information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterSetEffectOptionFullDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSetEffectOptionFullDTO {

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

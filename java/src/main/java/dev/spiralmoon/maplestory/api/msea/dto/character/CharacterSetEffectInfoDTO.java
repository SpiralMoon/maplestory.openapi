package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Active Set Item effect information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterSetEffectInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSetEffectInfoDTO {

    /**
     * Set Item effect level (number of equipped items)
     */
    @SerializedName("set_count")
    private int setCount;

    /**
     * Set Item effect
     */
    @SerializedName("set_option")
    private String setOption;
}

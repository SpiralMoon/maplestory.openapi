package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * All Set Item effect information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterSetEffectOptionFullDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSetEffectOptionFullDTO {

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

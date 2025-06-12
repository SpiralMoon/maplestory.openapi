package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Set Item effect information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterSetEffectSetDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSetEffectSetDTO<
        CharacterSetEffectInfoDTO,
        CharacterSetEffectOptionFullDTO> {

    /**
     * Set Item effect name
     */
    @SerializedName("set_name")
    private String setName;

    /**
     * Number of Set Items (including Lucky Items)
     */
    @SerializedName("total_set_count")
    private long totalSetCount;

    /**
     * Active Set Item effect information
     */
    @SerializedName("set_effect_info")
    private List<CharacterSetEffectInfoDTO> setEffectInfo;

    /**
     * All Set Item effect information
     */
    @SerializedName("set_option_full")
    private List<CharacterSetEffectOptionFullDTO> setOptionFull;
}

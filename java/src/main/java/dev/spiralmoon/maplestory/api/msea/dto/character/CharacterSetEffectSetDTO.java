package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Set Item effect information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterSetEffectSetDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSetEffectSetDTO<
        CharacterSetEffectInfoDTO,
        CharacterSetEffectOptionFullDTO> {

    /**
     * Set Item effect name
     */
    @JsonProperty("set_name")
    private String setName;

    /**
     * Number of Set Items (including Lucky Items)
     */
    @JsonProperty("total_set_count")
    private long totalSetCount;

    /**
     * Active Set Item effect information
     */
    @JsonProperty("set_effect_info")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterSetEffectInfoDTO> setEffectInfo;

    /**
     * All Set Item effect information
     */
    @JsonProperty("set_option_full")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterSetEffectOptionFullDTO> setOptionFull;
}

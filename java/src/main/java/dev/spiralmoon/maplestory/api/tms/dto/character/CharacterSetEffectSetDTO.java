package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 套裝效果資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterSetEffectSetDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSetEffectSetDTO<CharacterSetEffectInfoDTO, CharacterSetEffectOptionFullDTO> {

    /**
     * 套裝效果名稱
     */
    @JsonProperty("set_name")
    private String setName;

    /**
     * 套裝件數 (包含幸運道具)
     */
    @JsonProperty("total_set_count")
    private long totalSetCount;

    /**
     * 目前已裝備的套裝效果資訊
     */
    @JsonProperty("set_effect_info")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterSetEffectInfoDTO> setEffectInfo;

    /**
     * 全部套裝效果資訊
     */
    @JsonProperty("set_option_full")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterSetEffectOptionFullDTO> setOptionFull;
}

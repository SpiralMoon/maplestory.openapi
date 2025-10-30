package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 캐릭터 세트 효과 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterSetEffectSetDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSetEffectSetDTO<
        CharacterSetEffectInfoDTO,
        CharacterSetEffectOptionFullDTO> {

    /**
     * 세트 효과 명
     */
    @JsonProperty("set_name")
    private String setName;

    /**
     * 세트 개수 (럭키 아이템 포함)
     */
    @JsonProperty("total_set_count")
    private long totalSetCount;

    /**
     * 적용 중인 세트 효과 정보
     */
    @JsonProperty("set_effect_info")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterSetEffectInfoDTO> setEffectInfo;

    /**
     * 모든 세트 효과 정보
     */
    @JsonProperty("set_option_full")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterSetEffectOptionFullDTO> setOptionFull;
}

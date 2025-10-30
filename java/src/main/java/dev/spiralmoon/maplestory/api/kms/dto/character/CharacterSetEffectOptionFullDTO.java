package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 모든 세트 효과 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterSetEffectOptionFullDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSetEffectOptionFullDTO {

    /**
     * 세트 효과 레벨 (장비 수)
     */
    @JsonProperty("set_count")
    private int setCount;

    /**
     * 세트 효과
     */
    @JsonProperty("set_option")
    private String setOption;
}

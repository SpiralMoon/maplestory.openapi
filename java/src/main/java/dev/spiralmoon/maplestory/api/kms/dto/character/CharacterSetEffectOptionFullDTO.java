package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 모든 세트 효과 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterSetEffectOptionFullDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSetEffectOptionFullDTO {

    /**
     * 세트 효과 레벨 (장비 수)
     */
    @SerializedName("set_count")
    private int setCount;

    /**
     * 세트 효과
     */
    @SerializedName("set_option")
    private String setOption;
}

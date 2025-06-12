package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 적용 중인 세트 효과 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterSetEffectInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSetEffectInfoDTO {

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

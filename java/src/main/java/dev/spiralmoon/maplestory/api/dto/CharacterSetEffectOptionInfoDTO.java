package dev.spiralmoon.maplestory.api.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 캐릭터 세트 효과 옵션 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterSetEffectOptionInfoDTO {

    /**
     * 세트 효과 레벨 (장비 수)
     */
    @SerializedName("set_count")
    private long setCount;

    /**
     * 적용 중인 세트 효과
     */
    @SerializedName("set_option")
    private String setOption;
}

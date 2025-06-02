package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 캐릭터 세트 효과 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterSetEffectSetDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSetEffectSetDTO<
        CharacterSetEffectInfoDTO,
        CharacterSetEffectOptionFullDTO> {

    /**
     * 세트 효과 명
     */
    @SerializedName("set_name")
    private String setName;

    /**
     * 세트 개수 (럭키 아이템 포함)
     */
    @SerializedName("total_set_count")
    private long totalSetCount;

    /**
     * 적용 중인 세트 효과 정보
     */
    @SerializedName("set_effect_info")
    private List<CharacterSetEffectInfoDTO> setEffectInfo;

    /**
     * 모든 세트 효과 정보
     */
    @SerializedName("set_option_full")
    private List<CharacterSetEffectOptionFullDTO> setOptionFull;
}

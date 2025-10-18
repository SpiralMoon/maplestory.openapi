package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 套裝效果資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterSetEffectSetDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSetEffectSetDTO<CharacterSetEffectInfoDTO, CharacterSetEffectOptionFullDTO> {

    /**
     * 套裝效果名稱
     */
    @SerializedName("set_name")
    private String setName;

    /**
     * 套裝件數 (包含幸運道具)
     */
    @SerializedName("total_set_count")
    private long totalSetCount;

    /**
     * 目前已裝備的套裝效果資訊
     */
    @SerializedName("set_effect_info")
    private List<CharacterSetEffectInfoDTO> setEffectInfo;

    /**
     * 全部套裝效果資訊
     */
    @SerializedName("set_option_full")
    private List<CharacterSetEffectOptionFullDTO> setOptionFull;
}

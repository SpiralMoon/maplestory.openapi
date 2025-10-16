package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 全部套裝效果資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterSetEffectOptionFullDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSetEffectOptionFullDTO {

    /**
     * 套裝效果等級 (裝備件數)
     */
    @SerializedName("set_count")
    private int setCount;

    /**
     * 套裝效果
     */
    @SerializedName("set_option")
    private String setOption;
}

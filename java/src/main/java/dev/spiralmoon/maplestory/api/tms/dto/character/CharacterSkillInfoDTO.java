package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 技能資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterSkillInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSkillInfoDTO {

    /**
     * 技能名稱
     */
    @SerializedName("skill_name")
    private String skillName;

    /**
     * 技能描述
     */
    @SerializedName("skill_description")
    private String skillDescription;

    /**
     * 技能等級
     */
    @SerializedName("skill_level")
    private Long skillLevel;

    /**
     * 技能等級的效果描述
     */
    @SerializedName("skill_effect")
    private String skillEffect;

    /**
     * 下一等級的技能效果
     */
    @SerializedName("skill_effect_next")
    private String skillEffectNext;

    /**
     * 技能圖示
     */
    @SerializedName("skill_icon")
    private String skillIcon;
}

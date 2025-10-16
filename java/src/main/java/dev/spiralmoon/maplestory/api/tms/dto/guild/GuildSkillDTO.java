package dev.spiralmoon.maplestory.api.tms.dto.guild;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 公會技能
 */
@AllArgsConstructor
@Data
@ToString
public class GuildSkillDTO implements dev.spiralmoon.maplestory.api.common.dto.guild.GuildSkillDTO {

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
    private long skillLevel;

    /**
     * 技能等級的效果
     */
    @SerializedName("skill_effect")
    private String skillEffect;

    /**
     * 技能圖示
     */
    @SerializedName("skill_icon")
    private String skillIcon;
}

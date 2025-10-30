package dev.spiralmoon.maplestory.api.tms.dto.guild;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 公會技能
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class GuildSkillDTO implements dev.spiralmoon.maplestory.api.common.dto.guild.GuildSkillDTO {

    /**
     * 技能名稱
     */
    @JsonProperty("skill_name")
    private String skillName;

    /**
     * 技能描述
     */
    @JsonProperty("skill_description")
    private String skillDescription;

    /**
     * 技能等級
     */
    @JsonProperty("skill_level")
    private long skillLevel;

    /**
     * 技能等級的效果
     */
    @JsonProperty("skill_effect")
    private String skillEffect;

    /**
     * 技能圖示
     */
    @JsonProperty("skill_icon")
    private String skillIcon;
}

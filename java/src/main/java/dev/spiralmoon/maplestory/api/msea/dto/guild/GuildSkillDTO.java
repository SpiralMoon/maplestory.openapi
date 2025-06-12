package dev.spiralmoon.maplestory.api.msea.dto.guild;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Guild skill information
 */
@AllArgsConstructor
@Data
@ToString
public class GuildSkillDTO implements dev.spiralmoon.maplestory.api.common.dto.guild.GuildSkillDTO {

    /**
     * Skill name
     */
    @SerializedName("skill_name")
    private String skillName;

    /**
     * Skill description
     */
    @SerializedName("skill_description")
    private String skillDescription;

    /**
     * Skill level
     */
    @SerializedName("skill_level")
    private long skillLevel;

    /**
     * Effects by skill level
     */
    @SerializedName("skill_effect")
    private String skillEffect;

    /**
     * Skill icon
     */
    @SerializedName("skill_icon")
    private String skillIcon;
}

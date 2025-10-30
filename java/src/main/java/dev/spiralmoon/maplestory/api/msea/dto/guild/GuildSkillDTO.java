package dev.spiralmoon.maplestory.api.msea.dto.guild;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Guild skill information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class GuildSkillDTO implements dev.spiralmoon.maplestory.api.common.dto.guild.GuildSkillDTO {

    /**
     * Skill name
     */
    @JsonProperty("skill_name")
    private String skillName;

    /**
     * Skill description
     */
    @JsonProperty("skill_description")
    private String skillDescription;

    /**
     * Skill level
     */
    @JsonProperty("skill_level")
    private long skillLevel;

    /**
     * Effects by skill level
     */
    @JsonProperty("skill_effect")
    private String skillEffect;

    /**
     * Skill icon
     */
    @JsonProperty("skill_icon")
    private String skillIcon;
}

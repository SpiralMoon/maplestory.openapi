package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Character link skill information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterLinkSkillInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterLinkSkillInfoDTO {

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
    private Long skillLevel;

    /**
     * Skill effect
     */
    @JsonProperty("skill_effect")
    private String skillEffect;

    /**
     * Effect for the next skill level
     */
    @JsonProperty("skill_effect_next")
    private String skillEffectNext;

    /**
     * Skill icon
     */
    @JsonProperty("skill_icon")
    private String skillIcon;
}

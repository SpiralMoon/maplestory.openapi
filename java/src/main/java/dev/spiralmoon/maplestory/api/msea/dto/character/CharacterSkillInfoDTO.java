package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Skill information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterSkillInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSkillInfoDTO {

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
    private Long skillLevel;

    /**
     * Effect description by skill level
     */
    @SerializedName("skill_effect")
    private String skillEffect;

    /**
     * Effect description for the next skill level
     */
    @SerializedName("skill_effect_next")
    private String skillEffectNext;

    /**
     * Skill icon
     */
    @SerializedName("skill_icon")
    private String skillIcon;
}

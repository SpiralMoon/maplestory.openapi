package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 技能資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterSkillInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSkillInfoDTO {

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
    private Long skillLevel;

    /**
     * 技能等級的效果描述
     */
    @JsonProperty("skill_effect")
    private String skillEffect;

    /**
     * 下一等級的技能效果
     */
    @JsonProperty("skill_effect_next")
    private String skillEffectNext;

    /**
     * 技能圖示
     */
    @JsonProperty("skill_icon")
    private String skillIcon;
}

package dev.spiralmoon.maplestory.api.kms.dto.guild;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 길드 스킬 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class GuildSkillDTO implements dev.spiralmoon.maplestory.api.common.dto.guild.GuildSkillDTO {

    /**
     * 스킬 명
     */
    @JsonProperty("skill_name")
    private String skillName;

    /**
     * 스킬 설명
     */
    @JsonProperty("skill_description")
    private String skillDescription;

    /**
     * 스킬 레벨
     */
    @JsonProperty("skill_level")
    private long skillLevel;

    /**
     * 스킬 레벨 별 효과
     */
    @JsonProperty("skill_effect")
    private String skillEffect;

    /**
     * 스킬 아이콘
     */
    @JsonProperty("skill_icon")
    private String skillIcon;
}

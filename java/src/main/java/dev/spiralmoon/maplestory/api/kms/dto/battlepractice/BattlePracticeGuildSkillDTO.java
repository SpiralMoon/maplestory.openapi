package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 연무장 입장 시 길드 스킬
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeGuildSkillDTO {

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
    private Integer skillLevel;

    /**
     * 스킬 레벨별 효과
     */
    @JsonProperty("skill_effect")
    private String skillEffect;

    /**
     * 스킬 아이콘
     */
    @JsonProperty("skill_icon")
    private String skillIcon;
}

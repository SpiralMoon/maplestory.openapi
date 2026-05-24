package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 연무장 스킬 타임라인
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeSkillTimelineEventDTO {

    /**
     * 연무 시작 후 경과 시간 (ms)
     */
    @JsonProperty("elapse_time")
    private Long elapseTime;

    /**
     * 사용한 스킬 명
     */
    @JsonProperty("skill_name")
    private String skillName;

    /**
     * 헥사 스킬 특성 여부 (0:그 외 스킬, 1:오리진 스킬, 2:어센트 스킬)
     */
    @JsonProperty("hexa_skill_specificity_flag")
    private String hexaSkillSpecificityFlag;

    /**
     * 시퀀스 명
     */
    @JsonProperty("sequence_name")
    private String sequenceName;

    /**
     * 시퀀스 키
     */
    @JsonProperty("sequence_key")
    private String sequenceKey;
}

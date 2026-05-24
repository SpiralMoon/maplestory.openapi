package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 연무장 스킬 사용 내역
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeSkillTimelineDTO {

    /**
     * 조회된 페이지 번호
     */
    @JsonProperty("page_no")
    private Long pageNo;

    /**
     * 전체 페이지 번호
     */
    @JsonProperty("total_page_no")
    private Long totalPageNo;

    /**
     * 스킬 타임라인 정보
     */
    @JsonProperty("skill_timeline")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<BattlePracticeSkillTimelineEventDTO> skillTimeline;
}

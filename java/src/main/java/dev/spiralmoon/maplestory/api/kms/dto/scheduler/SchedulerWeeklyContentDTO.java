package dev.spiralmoon.maplestory.api.kms.dto.scheduler;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 스케줄러 주간 콘텐츠 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SchedulerWeeklyContentDTO {

    /**
     * 콘텐츠 명
     */
    @JsonProperty("content_name")
    private String contentName;

    /**
     * 콘텐츠 종류 ('contents', 'quest')
     */
    @JsonProperty("type")
    private String type;

    /**
     * 인게임 스케줄러 등록 여부 (true/false)
     */
    @JsonProperty("registration_flag")
    private String registrationFlag;

    /**
     * 현재 완료 횟수/점수
     */
    @JsonProperty("now_count")
    private Long nowCount;

    /**
     * 최대 완료 가능 횟수/점수
     */
    @JsonProperty("max_count")
    private Long maxCount;

    /**
     * 퀘스트인 경우 진행 상태 ("0":기타, "1":진행 중, "2":완료)
     */
    @JsonProperty("quest_state")
    private String questState;
}

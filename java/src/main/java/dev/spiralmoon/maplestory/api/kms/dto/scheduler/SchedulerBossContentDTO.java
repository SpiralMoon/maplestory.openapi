package dev.spiralmoon.maplestory.api.kms.dto.scheduler;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 스케줄러 보스 콘텐츠 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SchedulerBossContentDTO {

    /**
     * 보스 명
     */
    @JsonProperty("content_name")
    private String contentName;

    /**
     * 보스 난이도
     */
    @JsonProperty("difficulty")
    private String difficulty;

    /**
     * 보스 초기화 주기
     */
    @JsonProperty("cycle")
    private String cycle;

    /**
     * 리스트 순서
     */
    @JsonProperty("list_order_no")
    private Long listOrderNo;

    /**
     * 인게임 스케줄러 등록 여부 (true/false)
     */
    @JsonProperty("registration_flag")
    private String registrationFlag;

    /**
     * 완료 여부 (true/false)
     */
    @JsonProperty("complete_flag")
    private String completeFlag;
}

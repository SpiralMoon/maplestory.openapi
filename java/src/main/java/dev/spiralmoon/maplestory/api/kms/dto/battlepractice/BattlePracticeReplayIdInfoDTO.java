package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 연무장 리플레이 식별자 상세 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeReplayIdInfoDTO {

    /**
     * 기간 번호 (연무장 초기화 시마다 1씩 증가됩니다.)
     */
    @JsonProperty("period_no")
    private Integer periodNo;

    /**
     * 리플레이 등록 일시 (KST)
     */
    @JsonProperty("register_date")
    private String registerDate;

    /**
     * 연무장 리플레이 고유 식별자
     */
    @JsonProperty("replay_id")
    private String replayId;

    /**
     * 리플레이 등록 일시 (KST)
     */
    public ZonedDateTime getRegisterDate() {
        return registerDate != null
                ? Utils.toZonedDateTime(this.registerDate)
                : null;
    }
}

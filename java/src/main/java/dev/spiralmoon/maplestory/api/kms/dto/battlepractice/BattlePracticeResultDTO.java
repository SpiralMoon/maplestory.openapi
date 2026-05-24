package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 연무장 측정 결과 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeResultDTO {

    /**
     * 리플레이 등록 일시 (KST)
     */
    @JsonProperty("register_date")
    private String registerDate;

    /**
     * 총 연무 시간 (ms)
     */
    @JsonProperty("total_play_time")
    private Long totalPlayTime;

    /**
     * 총합 데미지
     */
    @JsonProperty("total_damage")
    private Long totalDamage;

    /**
     * 초당 평균 데미지
     */
    @JsonProperty("total_dps")
    private Long totalDps;

    /**
     * 종료 타입 (1:자동 종료, 2:수동 종료, 3:시간 초과, 9:기타 종료)
     */
    @JsonProperty("end_type")
    private String endType;

    /**
     * 리플레이 추천 수
     */
    @JsonProperty("like_count")
    private Long likeCount;

    /**
     * 스킬 단위 전투 분석 정보
     */
    @JsonProperty("skill_statistic")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<BattlePracticeSkillStatisticDTO> skillStatistic;

    /**
     * 리플레이 등록 일시 (KST)
     */
    public ZonedDateTime getRegisterDate() {
        return registerDate != null
                ? Utils.toZonedDateTime(this.registerDate)
                : null;
    }
}

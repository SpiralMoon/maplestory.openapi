package dev.spiralmoon.maplestory.api.kms.dto.scheduler;

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
 * 캐릭터 스케줄러 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SchedulerCharacterStateDTO {

    /**
     * 조회 기준일 (YYYY-MM-DD)
     */
    @JsonProperty("date")
    private String date;

    /**
     * 캐릭터 명
     */
    @JsonProperty("character_name")
    private String characterName;

    /**
     * 월드 명
     */
    @JsonProperty("world_name")
    private String worldName;

    /**
     * 캐릭터 레벨
     */
    @JsonProperty("character_level")
    private Long characterLevel;

    /**
     * 캐릭터 직업
     */
    @JsonProperty("character_class")
    private String characterClass;

    /**
     * 일일 콘텐츠 정보
     */
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    @JsonProperty("daily_contents")
    private List<SchedulerDailyContentDTO> dailyContents;

    /**
     * 주간 콘텐츠 정보
     */
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    @JsonProperty("weekly_contents")
    private List<SchedulerWeeklyContentDTO> weeklyContents;

    /**
     * 보스 콘텐츠 정보
     */
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    @JsonProperty("boss_contents")
    private List<SchedulerBossContentDTO> bossContents;

    /**
     * 주간 보스 처치 완료 횟수
     */
    @JsonProperty("weekly_boss_clear_count")
    private Long weeklyBossClearCount;

    /**
     * 주간 보스 처치 제한 횟수
     */
    @JsonProperty("weekly_boss_clear_limit_count")
    private Long weeklyBossClearLimitCount;

    /**
     * 조회 기준일 (YYYY-MM-DD)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}

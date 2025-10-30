package dev.spiralmoon.maplestory.api.kms.dto.ranking;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 종합 랭킹 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OverallRankingDTO {

    /**
     * 랭킹 업데이트 일자 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @JsonProperty("date")
    private String date;

    /**
     * 종합 랭킹 순위
     */
    @JsonProperty("ranking")
    private int ranking;

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
     * 직업 명
     */
    @JsonProperty("class_name")
    private String className;

    /**
     * 전직 직업 명
     */
    @JsonProperty("sub_class_name")
    private String subClassName;

    /**
     * 캐릭터 레벨
     */
    @JsonProperty("character_level")
    private int characterLevel;

    /**
     * 캐릭터 경험치
     */
    @JsonProperty("character_exp")
    private long characterExp;

    /**
     * 캐릭터 인기도
     */
    @JsonProperty("character_popularity")
    private int characterPopularity;

    /**
     * 길드 명
     */
    @JsonProperty("character_guildname")
    private String characterGuildName;

    public ZonedDateTime getDate() {
        return Utils.toZonedDateTime(this.date);
    }
}

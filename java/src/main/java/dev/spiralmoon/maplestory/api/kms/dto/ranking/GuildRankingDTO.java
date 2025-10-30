package dev.spiralmoon.maplestory.api.kms.dto.ranking;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 길드 랭킹 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class GuildRankingDTO {

    /**
     * 랭킹 업데이트 일자 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @JsonProperty("date")
    private String date;

    /**
     * 길드 랭킹 순위
     */
    @JsonProperty("ranking")
    private int ranking;

    /**
     * 길드 명
     */
    @JsonProperty("guild_name")
    private String guildName;

    /**
     * 월드 명
     */
    @JsonProperty("world_name")
    private String worldName;

    /**
     * 길드 레벨
     */
    @JsonProperty("guild_level")
    private int guildLevel;

    /**
     * 길드 마스터 캐릭터 명
     */
    @JsonProperty("guild_master_name")
    private String guildMasterName;

    /**
     * 길드 마크
     */
    @JsonProperty("guild_mark")
    private String guildMark;

    /**
     * 길드 포인트
     */
    @JsonProperty("guild_point")
    private long guildPoint;

    public ZonedDateTime getDate() {
        return Utils.toZonedDateTime(this.date);
    }
}

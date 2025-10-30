package dev.spiralmoon.maplestory.api.kms.dto.ranking;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 유니온 랭킹 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionRankingDTO {
    /**
     * 랭킹 업데이트 일자 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @JsonProperty("date")
    private String date;

    /**
     * 유니온 랭킹 순위
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
     * 유니온 레벨
     */
    @JsonProperty("union_level")
    private int unionLevel;

    /**
     * 유니온 파워
     */
    @JsonProperty("union_power")
    private long unionPower;

    public ZonedDateTime getDate() {
        return Utils.toZonedDateTime(this.date);
    }
}

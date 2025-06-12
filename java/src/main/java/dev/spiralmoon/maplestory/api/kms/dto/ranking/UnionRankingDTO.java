package dev.spiralmoon.maplestory.api.kms.dto.ranking;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 유니온 랭킹 정보
 */
@AllArgsConstructor
@Data
@ToString
public class UnionRankingDTO {
    /**
     * 랭킹 업데이트 일자 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @SerializedName("date")
    private String date;

    /**
     * 유니온 랭킹 순위
     */
    @SerializedName("ranking")
    private int ranking;

    /**
     * 캐릭터 명
     */
    @SerializedName("character_name")
    private String characterName;

    /**
     * 월드 명
     */
    @SerializedName("world_name")
    private String worldName;

    /**
     * 직업 명
     */
    @SerializedName("class_name")
    private String className;

    /**
     * 전직 직업 명
     */
    @SerializedName("sub_class_name")
    private String subClassName;

    /**
     * 유니온 레벨
     */
    @SerializedName("union_level")
    private int unionLevel;

    /**
     * 유니온 파워
     */
    @SerializedName("union_power")
    private long unionPower;

    public ZonedDateTime getDate() {
        return Utils.toZonedDateTime(this.date);
    }
}

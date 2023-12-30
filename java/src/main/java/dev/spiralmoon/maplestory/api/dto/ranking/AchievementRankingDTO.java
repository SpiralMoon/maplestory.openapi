package dev.spiralmoon.maplestory.api.dto.ranking;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 업적 랭킹 정보
 */
@AllArgsConstructor
@Data
@ToString
public class AchievementRankingDTO {

    /**
     * 랭킹 업데이트 일자 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @SerializedName("date")
    private String date;

    /**
     * 업적 랭킹 순위
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
     * 업적 등급
     */
    @SerializedName("trophy_grade")
    private String trophyGrade;

    /**
     * 업적 점수
     */
    @SerializedName("trophy_score")
    private int trophyScore;

    public LocalDateTime getDate() {
        return Utils.toLocalDateTime(this.date);
    }
}

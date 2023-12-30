package dev.spiralmoon.maplestory.api.dto;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 유니온 정보
 */
@AllArgsConstructor
@Data
@ToString
public class UnionDTO {

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @SerializedName("date")
    private String date;

    /**
     * 유니온 레벨
     */
    @SerializedName("union_level")
    private long unionLevel;

    /**
     * 유니온 등급
     */
    @SerializedName("union_grade")
    private String unionGrade;

    public LocalDateTime getDate() {
        return Utils.toLocalDateTime(this.date);
    }
}

package dev.spiralmoon.maplestory.api.dto.history;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.dto.PotentialOptionGrade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 잠재능력 재설정 결과 옵션 정보
 */
@AllArgsConstructor
@Data
@ToString
public class PotentialResultOptionDTO {

    /**
     * 옵션 명
     */
    @SerializedName("value")
    private String value;

    /**
     * 옵션 등급
     */
    @SerializedName("grade")
    private String grade;

    public PotentialOptionGrade getGradeEnum() {
        return PotentialOptionGrade.fromString(this.grade);
    }
}


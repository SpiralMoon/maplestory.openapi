package dev.spiralmoon.maplestory.api.kms.dto.history;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.common.dto.PotentialOptionGrade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 큐브 결과 옵션 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CubeResultOptionDTO {

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


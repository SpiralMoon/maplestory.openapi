package dev.spiralmoon.maplestory.api.kms.dto.history;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.spiralmoon.maplestory.api.common.dto.PotentialOptionGrade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 잠재능력 재설정 결과 옵션 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PotentialResultOptionDTO {

    /**
     * 옵션 명
     */
    @JsonProperty("value")
    private String value;

    /**
     * 옵션 등급
     */
    @JsonProperty("grade")
    private String grade;

    public PotentialOptionGrade getGradeEnum() {
        return PotentialOptionGrade.fromString(this.grade);
    }
}


package dev.spiralmoon.maplestory.api.kms.dto.union;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 유니온 정보
 */
@AllArgsConstructor
@Data
@ToString
public class UnionDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionDTO {

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @SerializedName("date")
    private String date;

    /**
     * 유니온 레벨
     */
    @SerializedName("union_level")
    private Integer unionLevel;

    /**
     * 유니온 등급
     */
    @SerializedName("union_grade")
    private String unionGrade;

    /**
     * 아티팩트 레벨
     */
    @SerializedName("union_artifact_level")
    private Integer unionArtifactLevel;

    /**
     * 보유 아티팩트 경험치
     */
    @SerializedName("union_artifact_exp")
    private Integer unionArtifactExp;

    /**
     * 보유 아티팩트 포인트
     */
    @SerializedName("union_artifact_point")
    private Integer unionArtifactPoint;

    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}

package dev.spiralmoon.maplestory.api.msea.dto.union;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * Union information
 */
@AllArgsConstructor
@Data
@ToString
public class UnionDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionDTO {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @SerializedName("date")
    private String date;

    /**
     * Union level
     */
    @SerializedName("union_level")
    private Integer unionLevel;

    /**
     * Union grade
     */
    @SerializedName("union_grade")
    private String unionGrade;

    /**
     * Artifact level
     */
    @SerializedName("union_artifact_level")
    private Integer unionArtifactLevel;

    /**
     * Earned Artifact EXP
     */
    @SerializedName("union_artifact_exp")
    private Integer unionArtifactExp;

    /**
     * Earned Artifact Points
     */
    @SerializedName("union_artifact_point")
    private Integer unionArtifactPoint;

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}

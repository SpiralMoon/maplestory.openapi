package dev.spiralmoon.maplestory.api.msea.dto.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * Union information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionDTO {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @JsonProperty("date")
    private String date;

    /**
     * Union level
     */
    @JsonProperty("union_level")
    private Integer unionLevel;

    /**
     * Union grade
     */
    @JsonProperty("union_grade")
    private String unionGrade;

    /**
     * Artifact level
     */
    @JsonProperty("union_artifact_level")
    private Integer unionArtifactLevel;

    /**
     * Earned Artifact EXP
     */
    @JsonProperty("union_artifact_exp")
    private Integer unionArtifactExp;

    /**
     * Earned Artifact Points
     */
    @JsonProperty("union_artifact_point")
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

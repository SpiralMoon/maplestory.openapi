package dev.spiralmoon.maplestory.api.msea.dto.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Union artifact information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionArtifactDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionArtifactDTO<UnionArtifactEffectDTO, UnionArtifactCrystalDTO> {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @JsonProperty("date")
    private String date;

    /**
     * Artifact effect information
     */
    @JsonProperty("union_artifact_effect")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<UnionArtifactEffectDTO> unionArtifactEffect;

    /**
     * Artifact crystal information
     */
    @JsonProperty("union_artifact_crystal")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<UnionArtifactCrystalDTO> unionArtifactCrystal;

    /**
     * Remaining artifact AP
     */
    @JsonProperty("union_artifact_remain_ap")
    private Integer unionArtifactRemainAp;

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}

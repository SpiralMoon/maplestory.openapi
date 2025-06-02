package dev.spiralmoon.maplestory.api.msea.dto.union;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Union artifact information
 */
@AllArgsConstructor
@Data
@ToString
public class UnionArtifactDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionArtifactDTO<UnionArtifactEffectDTO, UnionArtifactCrystalDTO> {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @SerializedName("date")
    private String date;

    /**
     * Artifact effect information
     */
    @SerializedName("union_artifact_effect")
    private List<UnionArtifactEffectDTO> unionArtifactEffect;

    /**
     * Artifact crystal information
     */
    @SerializedName("union_artifact_crystal")
    private List<UnionArtifactCrystalDTO> unionArtifactCrystal;

    /**
     * Remaining artifact AP
     */
    @SerializedName("union_artifact_remain_ap")
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

package dev.spiralmoon.maplestory.api.dto.union;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 유니온 아티팩트 정보
 */
@AllArgsConstructor
@Data
@ToString
public class UnionArtifactDTO {

    /**
     * 조회 기준일
     */
    @SerializedName("date")
    private String date;

    /**
     * 아티팩트 효과 정보
     */
    @SerializedName("union_artifact_effect")
    private List<UnionArtifactEffectDTO> unionArtifactEffect;

    /**
     * 아티팩트 크리스탈 정보
     */
    @SerializedName("union_artifact_crystal")
    private List<UnionArtifactCrystalDTO> unionArtifactCrystal;

    /**
     * 잔여 아티팩트 AP
     */
    @SerializedName("union_artifact_remain_ap")
    private Integer unionArtifactRemainAp;

    public LocalDateTime getDate() {
        return date != null
                ? Utils.toLocalDateTime(this.date)
                : null;
    }
}

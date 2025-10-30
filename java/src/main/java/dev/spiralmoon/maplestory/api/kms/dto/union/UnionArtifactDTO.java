package dev.spiralmoon.maplestory.api.kms.dto.union;

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
 * 유니온 아티팩트 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionArtifactDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionArtifactDTO<UnionArtifactEffectDTO, UnionArtifactCrystalDTO> {

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @JsonProperty("date")
    private String date;

    /**
     * 아티팩트 효과 정보
     */
    @JsonProperty("union_artifact_effect")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<UnionArtifactEffectDTO> unionArtifactEffect;

    /**
     * 아티팩트 크리스탈 정보
     */
    @JsonProperty("union_artifact_crystal")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<UnionArtifactCrystalDTO> unionArtifactCrystal;

    /**
     * 잔여 아티팩트 AP
     */
    @JsonProperty("union_artifact_remain_ap")
    private Integer unionArtifactRemainAp;

    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}

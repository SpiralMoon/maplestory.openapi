package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 연무장 입장 시 유니온 아티팩트 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeUnionArtifactObjectDTO {

    /**
     * 아티팩트 효과 정보
     */
    @JsonProperty("union_artifact_effect")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<BattlePracticeUnionArtifactEffectDTO> unionArtifactEffect;
}

package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 연무장 입장 시 유니온 아티팩트 효과 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeUnionArtifactEffectDTO {

    /**
     * 아티팩트 효과 명
     */
    @JsonProperty("name")
    private String name;

    /**
     * 아티팩트 효과 레벨
     */
    @JsonProperty("level")
    private Integer level;
}

package dev.spiralmoon.maplestory.api.msea.dto.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Artifact effect information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionArtifactEffectDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionArtifactEffectDTO {

    /**
     * Name of the artifact effect
     */
    @JsonProperty("name")
    private String name;

    /**
     * Level of the artifact effect
     */
    @JsonProperty("level")
    private int level;
}

package dev.spiralmoon.maplestory.api.msea.dto.union;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Artifact artifact information
 */
@AllArgsConstructor
@Data
@ToString
public class UnionArtifactEffectDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionArtifactEffectDTO {

    /**
     * Name of the artifact effect
     */
    @SerializedName("name")
    private String name;

    /**
     * Level of the artifact effect
     */
    @SerializedName("level")
    private int level;
}

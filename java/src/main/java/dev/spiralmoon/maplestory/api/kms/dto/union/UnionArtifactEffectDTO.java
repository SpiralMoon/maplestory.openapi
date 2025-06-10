package dev.spiralmoon.maplestory.api.kms.dto.union;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 유니온 아티팩트 효과 정보
 */
@AllArgsConstructor
@Data
@ToString
public class UnionArtifactEffectDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionArtifactEffectDTO {

    /**
     * 아티팩트 효과 명
     */
    @SerializedName("name")
    private String name;

    /**
     * 아티팩트 효과 레벨
     */
    @SerializedName("level")
    private int level;
}

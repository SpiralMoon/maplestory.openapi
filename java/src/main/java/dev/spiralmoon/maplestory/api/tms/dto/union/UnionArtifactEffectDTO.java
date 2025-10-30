package dev.spiralmoon.maplestory.api.tms.dto.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 神器效果資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionArtifactEffectDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionArtifactEffectDTO {

    /**
     * 神器效果名稱
     */
    @JsonProperty("name")
    private String name;

    /**
     * 神器效果等級
     */
    @JsonProperty("level")
    private int level;
}

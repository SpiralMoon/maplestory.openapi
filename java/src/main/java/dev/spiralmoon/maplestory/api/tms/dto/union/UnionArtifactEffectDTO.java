package dev.spiralmoon.maplestory.api.tms.dto.union;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 神器效果資訊
 */
@AllArgsConstructor
@Data
@ToString
public class UnionArtifactEffectDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionArtifactEffectDTO {

    /**
     * 神器效果名稱
     */
    @SerializedName("name")
    private String name;

    /**
     * 神器效果等級
     */
    @SerializedName("level")
    private int level;
}

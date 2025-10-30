package dev.spiralmoon.maplestory.api.tms.dto.union;

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
 * 戰地神器資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionArtifactDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionArtifactDTO<UnionArtifactEffectDTO, UnionArtifactCrystalDTO> {

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    @JsonProperty("date")
    private String date;

    /**
     * 神器效果資訊
     */
    @JsonProperty("union_artifact_effect")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<UnionArtifactEffectDTO> unionArtifactEffect;

    /**
     * 神器水晶資訊
     */
    @JsonProperty("union_artifact_crystal")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<UnionArtifactCrystalDTO> unionArtifactCrystal;

    /**
     * 剩餘神器 AP
     */
    @JsonProperty("union_artifact_remain_ap")
    private Integer unionArtifactRemainAp;

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}

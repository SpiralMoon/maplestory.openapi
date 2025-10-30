package dev.spiralmoon.maplestory.api.tms.dto.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 戰地資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionDTO {

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    @JsonProperty("date")
    private String date;

    /**
     * 聯盟等級
     */
    @JsonProperty("union_level")
    private Integer unionLevel;

    /**
     * 聯盟階級
     */
    @JsonProperty("union_grade")
    private String unionGrade;

    /**
     * 神器等級
     */
    @JsonProperty("union_artifact_level")
    private Integer unionArtifactLevel;

    /**
     * 持有的神器經驗值
     */
    @JsonProperty("union_artifact_exp")
    private Integer unionArtifactExp;

    /**
     * 持有的神器點數
     */
    @JsonProperty("union_artifact_point")
    private Integer unionArtifactPoint;

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}

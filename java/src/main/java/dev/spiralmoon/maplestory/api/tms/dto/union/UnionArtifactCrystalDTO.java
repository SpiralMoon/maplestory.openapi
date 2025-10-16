package dev.spiralmoon.maplestory.api.tms.dto.union;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 神器水晶資訊
 */
@AllArgsConstructor
@Data
@ToString
public class UnionArtifactCrystalDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionArtifactCrystalDTO {

    /**
     * 神器水晶名稱
     */
    @SerializedName("name")
    private String name;

    /**
     * 能力有效性 (0：有效，1：無效)
     */
    @SerializedName("validity_flag")
    private String validityFlag;

    /**
     * 能力有效期間 (TST)
     */
    @SerializedName("date_expire")
    private String dateExpire;

    /**
     * 神器水晶階級
     */
    @SerializedName("level")
    private int level;

    /**
     * 神器水晶第一選項名稱
     */
    @SerializedName("crystal_option_name_1")
    private String crystalOptionName1;

    /**
     * 神器水晶第二選項名稱
     */
    @SerializedName("crystal_option_name_2")
    private String crystalOptionName2;

    /**
     * 神器水晶第三選項名稱
     */
    @SerializedName("crystal_option_name_3")
    private String crystalOptionName3;

    /**
     * 能力有效期間 (TST)
     */
    public ZonedDateTime getDateExpire() {
        if (this.dateExpire != null && !"expired".equals(this.dateExpire)) {
            return Utils.toZonedDateTime(this.dateExpire);
        } else {
            return null;
        }
    }

    /**
     * Whether the artifact crystal is expired
     */
    public Boolean isExpired() {

        if (this.dateExpire == null) {
            return null;
        }

        return "expired".equals(this.dateExpire);
    }
}

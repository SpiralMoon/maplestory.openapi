package dev.spiralmoon.maplestory.api.msea.dto.union;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * Artifact crystal information
 */
@AllArgsConstructor
@Data
@ToString
public class UnionArtifactCrystalDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionArtifactCrystalDTO {

    /**
     * Name of the artifact crystal
     */
    @SerializedName("name")
    private String name;

    /**
     * Validity of the stat (0:Valid, 1:Invalid)
     */
    @SerializedName("validity_flag")
    private String validityFlag;

    /**
     * Expiration date of the stat (SGT)
     */
    @SerializedName("date_expire")
    private String dateExpire;

    /**
     * Grade of the artifact crystal
     */
    @SerializedName("level")
    private int level;

    /**
     * First option of the artifact crystal
     */
    @SerializedName("crystal_option_name_1")
    private String crystalOptionName1;

    /**
     * Second option of the artifact crystal
     */
    @SerializedName("crystal_option_name_2")
    private String crystalOptionName2;

    /**
     * Third option of the artifact crystal
     */
    @SerializedName("crystal_option_name_3")
    private String crystalOptionName3;

    /**
     * Expiration date of the stat (SGT)
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

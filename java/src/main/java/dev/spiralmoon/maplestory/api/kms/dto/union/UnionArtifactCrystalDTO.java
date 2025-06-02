package dev.spiralmoon.maplestory.api.kms.dto.union;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * 유니온 아티팩트 크리스탈 정보
 */
@AllArgsConstructor
@Data
@ToString
public class UnionArtifactCrystalDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionArtifactCrystalDTO {

    /**
     * 아티팩트 효과 명
     */
    @SerializedName("name")
    private String name;

    /**
     * 능력치 유효 여부 (0:유효, 1:유효하지 않음)
     */
    @SerializedName("validity_flag")
    private String validityFlag;

    /**
     * 능력치 유효 기간 (KST)
     */
    @SerializedName("date_expire")
    private String dateExpire;

    /**
     * 아티팩트 크리스탈 등급
     */
    @SerializedName("level")
    private int level;

    /**
     * 아티팩트 크리스탈 첫 번째 옵션 명
     */
    @SerializedName("crystal_option_name_1")
    private String crystalOptionName1;

    /**
     * 아티팩트 크리스탈 두 번째 옵션 명
     */
    @SerializedName("crystal_option_name_2")
    private String crystalOptionName2;

    /**
     * 아티팩트 크리스탈 세 번째 옵션 명
     */
    @SerializedName("crystal_option_name_3")
    private String crystalOptionName3;

    public ZonedDateTime getDateExpire() {
        if (this.dateExpire != null && !"expired".equals(this.dateExpire)) {
            return Utils.toZonedDateTime(this.dateExpire);
        } else {
            return null;
        }
    }

    /**
     * 능력치 유효 기간 만료 여부
     */
    public Boolean isExpired() {

        if (this.dateExpire == null) {
            return null;
        }

        return "expired".equals(this.dateExpire);
    }
}

package dev.spiralmoon.maplestory.api.tms.dto.union;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 戰地攻擊隊部署
 */
@AllArgsConstructor
@Data
@ToString
public class UnionRaiderInnerStatDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionRaiderInnerStatDTO {

    /**
     * 攻擊單位部署位置 (以 11 點鐘方向為起點，順時針 0-7)
     */
    @SerializedName("stat_field_id")
    private String statFieldId;

    /**
     * 相關區域佔領效果
     */
    @SerializedName("stat_field_effect")
    private String statFieldEffect;
}

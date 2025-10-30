package dev.spiralmoon.maplestory.api.tms.dto.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 戰地攻擊隊部署
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionRaiderInnerStatDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionRaiderInnerStatDTO {

    /**
     * 攻擊單位部署位置 (以 11 點鐘方向為起點，順時針 0-7)
     */
    @JsonProperty("stat_field_id")
    private String statFieldId;

    /**
     * 相關區域佔領效果
     */
    @JsonProperty("stat_field_effect")
    private String statFieldEffect;
}

package dev.spiralmoon.maplestory.api.tms.dto.union;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 聯盟預設 資訊
 */
@AllArgsConstructor
@Data
@ToString
public class UnionRaiderPresetDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionRaiderPresetDTO<UnionRaiderInnerStatDTO, UnionRaiderBlockDTO> {

    /**
     * 戰地攻擊隊員效果
     */
    @SerializedName("union_raider_stat")
    private List<String> unionRaiderStat;

    /**
     * 戰地攻擊隊佔領效果
     */
    @SerializedName("union_occupied_stat")
    private List<String> unionOccupiedStat;

    /**
     * 戰地攻擊隊部署
     */
    @SerializedName("union_inner_stat")
    private List<UnionRaiderInnerStatDTO> unionInnerStat;

    /**
     * 聯盟方塊資訊
     */
    @SerializedName("union_block")
    private List<UnionRaiderBlockDTO> unionBlock;
}

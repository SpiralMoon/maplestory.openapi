package dev.spiralmoon.maplestory.api.tms.dto.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 聯盟預設 資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionRaiderPresetDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionRaiderPresetDTO<UnionRaiderInnerStatDTO, UnionRaiderBlockDTO> {

    /**
     * 戰地攻擊隊員效果
     */
    @JsonProperty("union_raider_stat")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<String> unionRaiderStat;

    /**
     * 戰地攻擊隊佔領效果
     */
    @JsonProperty("union_occupied_stat")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<String> unionOccupiedStat;

    /**
     * 戰地攻擊隊部署
     */
    @JsonProperty("union_inner_stat")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<UnionRaiderInnerStatDTO> unionInnerStat;

    /**
     * 聯盟方塊資訊
     */
    @JsonProperty("union_block")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<UnionRaiderBlockDTO> unionBlock;
}

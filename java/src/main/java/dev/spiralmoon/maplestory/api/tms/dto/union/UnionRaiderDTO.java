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
 * 戰地攻擊隊資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionRaiderDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionRaiderDTO<UnionRaiderInnerStatDTO, UnionRaiderBlockDTO, UnionRaiderPresetDTO> {

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    @JsonProperty("date")
    private String date;

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

    /**
     * 目前套用的預設編號
     */
    @JsonProperty("use_preset_no")
    private int usePresetNo;

    /**
     * 聯盟預設 1 資訊
     */
    @JsonProperty("union_raider_preset_1")
    private UnionRaiderPresetDTO unionRaiderPreset1;

    /**
     * 聯盟預設 2 資訊
     */
    @JsonProperty("union_raider_preset_2")
    private UnionRaiderPresetDTO unionRaiderPreset2;

    /**
     * 聯盟預設 3 資訊
     */
    @JsonProperty("union_raider_preset_3")
    private UnionRaiderPresetDTO unionRaiderPreset3;

    /**
     * 聯盟預設 4 資訊
     */
    @JsonProperty("union_raider_preset_4")
    private UnionRaiderPresetDTO unionRaiderPreset4;

    /**
     * 聯盟預設 5 資訊
     */
    @JsonProperty("union_raider_preset_5")
    private UnionRaiderPresetDTO unionRaiderPreset5;

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}

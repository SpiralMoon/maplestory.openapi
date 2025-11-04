package dev.spiralmoon.maplestory.api.tms.dto.character;

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
 * 角色極限屬性資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterHyperStatDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHyperStatDTO<CharacterHyperStatPresetDTO> {

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    @JsonProperty("date")
    private String date;

    /**
     * 角色職業
     */
    @JsonProperty("character_class")
    private String characterClass;

    /**
     * 目前套用的預設編號
     */
    @JsonProperty("use_preset_no")
    private String usePresetNo;

    /**
     * 可用的極限屬性點數上限
     */
    @JsonProperty("use_available_hyper_stat")
    private int useAvailableHyperStat;

    /**
     * 預設 1 的極限屬性資訊
     */
    @JsonProperty("hyper_stat_preset_1")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterHyperStatPresetDTO> hyperStatPreset1;

    /**
     * 預設 1 剩餘的極限屬性點數
     */
    @JsonProperty("hyper_stat_preset_1_remain_point")
    private int hyperStatPreset1RemainPoint;

    /**
     * 預設 2 的極限屬性資訊
     */
    @JsonProperty("hyper_stat_preset_2")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterHyperStatPresetDTO> hyperStatPreset2;

    /**
     * 預設 2 剩餘的極限屬性點數
     */
    @JsonProperty("hyper_stat_preset_2_remain_point")
    private int hyperStatPreset2RemainPoint;

    /**
     * 預設 3 的極限屬性資訊
     */
    @JsonProperty("hyper_stat_preset_3")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterHyperStatPresetDTO> hyperStatPreset3;

    /**
     * 預設 3 剩餘的極限屬性點數
     */
    @JsonProperty("hyper_stat_preset_3_remain_point")
    private int hyperStatPreset3RemainPoint;

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}

package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 角色極限屬性資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterHyperStatDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHyperStatDTO<CharacterHyperStatPresetDTO> {

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    @SerializedName("date")
    private String date;

    /**
     * 角色職業
     */
    @SerializedName("character_class")
    private String characterClass;

    /**
     * 目前套用的預設編號
     */
    @SerializedName("use_preset_no")
    private String usePresetNo;

    /**
     * 可用的極限屬性點數上限
     */
    @SerializedName("use_available_hyper_stat")
    private Integer useAvailableHyperStat;

    /**
     * 預設 1 的極限屬性資訊
     */
    @SerializedName("hyper_stat_preset_1")
    private List<CharacterHyperStatPresetDTO> hyperStatPreset1;

    /**
     * 預設 1 剩餘的極限屬性點數
     */
    @SerializedName("hyper_stat_preset_1_remain_point")
    private Integer hyperStatPreset1RemainPoint;

    /**
     * 預設 2 的極限屬性資訊
     */
    @SerializedName("hyper_stat_preset_2")
    private List<CharacterHyperStatPresetDTO> hyperStatPreset2;

    /**
     * 預設 2 剩餘的極限屬性點數
     */
    @SerializedName("hyper_stat_preset_2_remain_point")
    private Integer hyperStatPreset2RemainPoint;

    /**
     * 預設 3 的極限屬性資訊
     */
    @SerializedName("hyper_stat_preset_3")
    private List<CharacterHyperStatPresetDTO> hyperStatPreset3;

    /**
     * 預設 3 剩餘的極限屬性點數
     */
    @SerializedName("hyper_stat_preset_3_remain_point")
    private Integer hyperStatPreset3RemainPoint;

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}

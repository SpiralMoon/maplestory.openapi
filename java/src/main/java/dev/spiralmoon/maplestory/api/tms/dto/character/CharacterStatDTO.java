package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 角色綜合能力值資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterStatDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterStatDTO<CharacterFinalStatDTO> {

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
     * 當前能力值資訊
     */
    @SerializedName("final_stat")
    private List<CharacterFinalStatDTO> finalStat;

    /**
     * 剩餘 AP
     */
    @SerializedName("remain_ap")
    private Integer remainAp;

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}

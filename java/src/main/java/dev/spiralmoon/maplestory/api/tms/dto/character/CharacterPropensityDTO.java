package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 角色性向資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterPropensityDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterPropensityDTO {

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    @SerializedName("date")
    private String date;

    /**
     * 領導力等級
     */
    @SerializedName("charisma_level")
    private Integer charismaLevel;

    /**
     * 感性等級
     */
    @SerializedName("sensibility_level")
    private Integer sensibilityLevel;

    /**
     * 洞察力等級
     */
    @SerializedName("insight_level")
    private Integer insightLevel;

    /**
     * 意志等級
     */
    @SerializedName("willingness_level")
    private Integer willingnessLevel;

    /**
     * 手藝等級
     */
    @SerializedName("handicraft_level")
    private Integer handicraftLevel;

    /**
     * 魅力等級
     */
    @SerializedName("charm_level")
    private Integer charmLevel;

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}

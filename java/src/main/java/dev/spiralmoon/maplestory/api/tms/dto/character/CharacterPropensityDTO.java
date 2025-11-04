package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 角色性向資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterPropensityDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterPropensityDTO {

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    @JsonProperty("date")
    private String date;

    /**
     * 領導力等級
     */
    @JsonProperty("charisma_level")
    private int charismaLevel;

    /**
     * 感性等級
     */
    @JsonProperty("sensibility_level")
    private int sensibilityLevel;

    /**
     * 洞察力等級
     */
    @JsonProperty("insight_level")
    private int insightLevel;

    /**
     * 意志等級
     */
    @JsonProperty("willingness_level")
    private int willingnessLevel;

    /**
     * 手藝等級
     */
    @JsonProperty("handicraft_level")
    private int handicraftLevel;

    /**
     * 魅力等級
     */
    @JsonProperty("charm_level")
    private int charmLevel;

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}

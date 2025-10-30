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
 * 角色目前套用的套裝效果資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterSetEffectDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSetEffectDTO<CharacterSetEffectSetDTO> {

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    @JsonProperty("date")
    private String date;

    /**
     * 套裝效果資訊
     */
    @JsonProperty("set_effect")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterSetEffectSetDTO> setEffect;

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}

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
 * 萌獸 資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterFamiliarDTO {

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    @JsonProperty("date")
    private String date;

    /**
     * 萌獸 鏈路插槽資訊
     */
    @JsonProperty("familiar_link_slot")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterFamiliarLinkSlotDTO> familiarLinkSlot;

    /**
     * 萌獸 細節
     */
    @JsonProperty("familiar_info")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterFamiliarInfoDTO> familiarInfo;

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}

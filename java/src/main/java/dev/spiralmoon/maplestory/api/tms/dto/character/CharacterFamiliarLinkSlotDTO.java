package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 萌獸 鏈路插槽資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterFamiliarLinkSlotDTO {

    /**
     * 插槽標識符 (1~3, vip)
     */
    @JsonProperty("slot_id")
    private String slotId;

    /**
     * 連結的 萌獸 名稱 (如果插槽中沒有任何關聯，則為 null)
     */
    @JsonProperty("familiar_name")
    private String familiarName;

    /**
     * 已啟用還是未啟用 (true, false)
     */
    @JsonProperty("active_flag")
    private String activeFlag;

    /**
     * 截止日期
     */
    @JsonProperty("expire_date")
    private String expireDate;

    /**
     * 截止日期
     */
    public ZonedDateTime getExpireDate() {
        return expireDate != null
                ? Utils.toZonedDateTime(this.expireDate)
                : null;
    }
}

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
 * 外型預設
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterCashItemEquipmentPresetDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterCashItemEquipmentPresetDTO<CharacterCashItemEquipmentOptionDTO, CharacterCashItemEquipmentColoringPrismDTO> {

    /**
     * 現金道具部位名稱
     */
    @JsonProperty("cash_item_equipment_part")
    private String cashItemEquipmentPart;

    /**
     * 現金道具欄位位置
     */
    @JsonProperty("cash_item_equipment_slot")
    private String cashItemEquipmentSlot;

    /**
     * 現金道具名稱
     */
    @JsonProperty("cash_item_name")
    private String cashItemName;

    /**
     * 現金道具圖示
     */
    @JsonProperty("cash_item_icon")
    private String cashItemIcon;

    /**
     * 現金道具描述
     */
    @JsonProperty("cash_item_description")
    private String cashItemDescription;

    /**
     * 現金道具選項
     */
    @JsonProperty("cash_item_option")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterCashItemEquipmentOptionDTO> cashItemOption;

    /**
     * 現金道具有效期間 (TST)
     */
    @JsonProperty("date_expire")
    private String dateExpire;

    /**
     * 現金道具有效期間 (TST)
     */
    public ZonedDateTime getDateExpire() {
        return dateExpire != null
                ? Utils.toZonedDateTime(this.dateExpire)
                : null;
    }

    /**
     * 現金道具選項有效期間 (TST，時間單位資料中的分鐘顯示為 0)
     */
    @JsonProperty("date_option_expire")
    private String dateOptionExpire;

    /**
     * 現金道具選項有效期間 (TST，時間單位資料中的分鐘顯示為 0)
     */
    public ZonedDateTime getDateOptionExpire() {
        return dateOptionExpire != null
                ? Utils.toZonedDateTime(this.dateOptionExpire)
                : null;
    }

    /**
     * 現金道具等級資訊
     */
    @JsonProperty("cash_item_label")
    private String cashItemLabel;

    /**
     * 現金道具彩色稜鏡資訊
     */
    @JsonProperty("cash_item_coloring_prism")
    private CharacterCashItemEquipmentColoringPrismDTO cashItemColoringPrism;

    /**
     * 道具可裝備性別
     */
    @JsonProperty("item_gender")
    private String itemGender;

    /**
     * 技能名稱
     */
    @JsonProperty("skills")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<String> skills;

    /**
     * Whether the cash equipment is expired
     */
    public Boolean isExpired() {
        if (this.dateExpire == null) {
            return null;
        }
        return "expired".equals(this.dateExpire);
    }

    /**
     * Whether the cash equipment option is expired
     */
    public Boolean isOptionExpired() {
        if (this.dateOptionExpire == null) {
            return null;
        }
        return "expired".equals(this.dateOptionExpire);
    }
}

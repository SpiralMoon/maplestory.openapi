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
 * 機器人的已裝備現金道具資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterAndroidCashItemEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidCashItemEquipmentDTO<CharacterAndroidCashItemEquipmentOptionDTO, CharacterAndroidCashItemEquipmentColoringPrismDTO> {

    /**
     * 機器人現金道具部位名稱
     */
    @JsonProperty("cash_item_equipment_part")
    private String cashItemEquipmentPart;

    /**
     * 機器人現金道具欄位位置
     */
    @JsonProperty("cash_item_equipment_slot")
    private String cashItemEquipmentSlot;

    /**
     * 機器人現金道具名稱
     */
    @JsonProperty("cash_item_name")
    private String cashItemName;

    /**
     * 機器人現金道具圖示
     */
    @JsonProperty("cash_item_icon")
    private String cashItemIcon;

    /**
     * 機器人現金道具描述
     */
    @JsonProperty("cash_item_description")
    private String cashItemDescription;

    /**
     * 機器人現金道具選項
     */
    @JsonProperty("cash_item_option")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterAndroidCashItemEquipmentOptionDTO> cashItemOption;

    /**
     * 機器人現金道具有效期間 (TST)
     */
    @JsonProperty("date_expire")
    private String dateExpire;

    /**
     * 機器人現金道具選項有效期間 (TST)
     */
    @JsonProperty("date_option_expire")
    private String dateOptionExpire;

    /**
     * 機器人現金道具標籤資訊 (特殊標籤、紅標籤、黑標籤、大師標籤)
     */
    @JsonProperty("cash_item_label")
    private String cashItemLabel;

    /**
     * 機器人現金道具彩色稜鏡資訊
     */
    @JsonProperty("cash_item_coloring_prism")
    private CharacterAndroidCashItemEquipmentColoringPrismDTO cashItemColoringPrism;

    /**
     * 道具可裝備性別
     */
    @JsonProperty("android_item_gender")
    private String androidItemGender;

    /**
     * 機器人現金道具有效期間 (TST)
     */
    public ZonedDateTime getDateExpire() {
        if (this.dateExpire != null && !"expired".equals(this.dateExpire)) {
            return Utils.toZonedDateTime(this.dateExpire);
        } else {
            return null;
        }
    }

    /**
     * Whether the Android cash item is expired
     */
    public Boolean isExpired() {

        if (this.dateExpire == null) {
            return null;
        }

        return "expired".equals(this.dateExpire);
    }

    /**
     * 機器人現金道具選項有效期間 (TST)
     */
    public ZonedDateTime getDateOptionExpire() {
        if (this.dateOptionExpire != null && !"expired".equals(this.dateOptionExpire)) {
            return Utils.toZonedDateTime(this.dateOptionExpire);
        } else {
            return null;
        }
    }

    /**
     * Whether the Android cash item option is expired
     */
    public Boolean isOptionExpired() {

        if (this.dateOptionExpire == null) {
            return null;
        }

        return "expired".equals(this.dateOptionExpire);
    }
}

package dev.spiralmoon.maplestory.api.msea.dto.character;

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
 * Android cash item equipment information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterAndroidCashItemEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidCashItemEquipmentDTO<CharacterAndroidCashItemEquipmentOptionDTO, CharacterAndroidCashItemEquipmentColoringPrismDTO> {

    /**
     * Android cash item part name
     */
    @JsonProperty("cash_item_equipment_part")
    private String cashItemEquipmentPart;

    /**
     * Android cash item slot position
     */
    @JsonProperty("cash_item_equipment_slot")
    private String cashItemEquipmentSlot;

    /**
     * Android cash item name
     */
    @JsonProperty("cash_item_name")
    private String cashItemName;

    /**
     * Android cash item icon
     */
    @JsonProperty("cash_item_icon")
    private String cashItemIcon;

    /**
     * Android cash item description
     */
    @JsonProperty("cash_item_description")
    private String cashItemDescription;

    /**
     * Android cash item options
     */
    @JsonProperty("cash_item_option")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterAndroidCashItemEquipmentOptionDTO> cashItemOption;

    /**
     * Android cash item validity period (SGT)
     */
    @JsonProperty("date_expire")
    private String dateExpire;

    /**
     * Android cash item option validity period (SGT, data with minutes set to 0)
     */
    @JsonProperty("date_option_expire")
    private String dateOptionExpire;

    /**
     * Android cash item label information (e.g., Special Label, Red Label, Black Label, Master Label)
     */
    @JsonProperty("cash_item_label")
    private String cashItemLabel;

    /**
     * Android cash item coloring prism information
     */
    @JsonProperty("cash_item_coloring_prism")
    private CharacterAndroidCashItemEquipmentColoringPrismDTO cashItemColoringPrism;

    /**
     * Gender compatibility for item equipment
     */
    @JsonProperty("android_item_gender")
    private String androidItemGender;

    /**
     * Freestyle Coupon application status (0:not applied, 1:applied)
     */
    @JsonProperty("freestyle_flag")
    private String freestyleFlag;

    /**
     * Android cash item validity period (SGT)
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
     * Android cash item option validity period (SGT, data with minutes set to 0)
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

    /**
     * Freestyle Coupon application status
     */
    public boolean isFreestyleFlag() {
        return "1".equals(this.freestyleFlag);
    }
}

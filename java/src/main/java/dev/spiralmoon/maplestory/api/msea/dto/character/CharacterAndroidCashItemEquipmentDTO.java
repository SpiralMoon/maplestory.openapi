package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Android cash item equipment information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterAndroidCashItemEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidCashItemEquipmentDTO<CharacterAndroidCashItemEquipmentOptionDTO, CharacterAndroidCashItemEquipmentColoringPrismDTO> {

    /**
     * Android cash item part name
     */
    @SerializedName("cash_item_equipment_part")
    private String cashItemEquipmentPart;

    /**
     * Android cash item slot position
     */
    @SerializedName("cash_item_equipment_slot")
    private String cashItemEquipmentSlot;

    /**
     * Android cash item name
     */
    @SerializedName("cash_item_name")
    private String cashItemName;

    /**
     * Android cash item icon
     */
    @SerializedName("cash_item_icon")
    private String cashItemIcon;

    /**
     * Android cash item description
     */
    @SerializedName("cash_item_description")
    private String cashItemDescription;

    /**
     * Android cash item options
     */
    @SerializedName("cash_item_option")
    private List<CharacterAndroidCashItemEquipmentOptionDTO> cashItemOption;

    /**
     * Android cash item validity period (SGT)
     */
    @SerializedName("date_expire")
    private String dateExpire;

    /**
     * Android cash item option validity period (SGT, data with minutes set to 0)
     */
    @SerializedName("date_option_expire")
    private String dateOptionExpire;

    /**
     * Android cash item label information (e.g., Special Label, Red Label, Black Label, Master Label)
     */
    @SerializedName("cash_item_label")
    private String cashItemLabel;

    /**
     * Android cash item coloring prism information
     */
    @SerializedName("cash_item_coloring_prism")
    private CharacterAndroidCashItemEquipmentColoringPrismDTO cashItemColoringPrism;

    /**
     * Gender compatibility for item equipment
     */
    @SerializedName("android_item_gender")
    private String androidItemGender;

    /**
     * Android cash item validity period (SGT)
     */
    public ZonedDateTime getDateExpire() {
        return dateExpire != null && !"expired".equals(dateExpire) ? Utils.toZonedDateTime(dateExpire) : null;
    }

    /**
     * Whether the Android cash item is expired
     */
    public Boolean isExpired() {
        return "expired".equals(dateExpire);
    }

    /**
     * Android cash item option validity period (SGT, data with minutes set to 0)
     */
    public ZonedDateTime getDateOptionExpire() {
        return dateOptionExpire != null && !"expired".equals(dateOptionExpire) ? Utils.toZonedDateTime(dateOptionExpire) : null;
    }

    /**
     * Whether the Android cash item option is expired
     */
    public Boolean isOptionExpired() {
        return "expired".equals(dateOptionExpire);
    }
}

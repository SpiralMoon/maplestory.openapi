package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Equipped cash item preset information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterCashItemEquipmentPresetDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterCashItemEquipmentPresetDTO<
        CharacterCashItemEquipmentOptionDTO,
        CharacterCashItemEquipmentColoringPrismDTO> {

    /**
     * Cash equipment part name
     */
    @SerializedName("cash_item_equipment_part")
    private String cashItemEquipmentPart;

    /**
     * Cash equipment slot position
     */
    @SerializedName("cash_item_equipment_slot")
    private String cashItemEquipmentSlot;

    /**
     * Cash equipment name
     */
    @SerializedName("cash_item_name")
    private String cashItemName;

    /**
     * Cash equipment icon
     */
    @SerializedName("cash_item_icon")
    private String cashItemIcon;

    /**
     * Cash equipment description
     */
    @SerializedName("cash_item_description")
    private String cashItemDescription;

    /**
     * Cash equipment option
     */
    @SerializedName("cash_item_option")
    private List<CharacterCashItemEquipmentOptionDTO> cashItemOption;

    /**
     * Cash equipment validity period (SGT)
     */
    @SerializedName("date_expire")
    private String dateExpire;

    /**
     * Cash equipment validity period (SGT)
     */
    public ZonedDateTime getDateExpire() {
        return dateExpire != null
                ? Utils.toZonedDateTime(this.dateExpire)
                : null;
    }

    /**
     * Cash equipment option validity period (SGT, data with minutes set to 0)
     */
    @SerializedName("date_option_expire")
    private String dateOptionExpire;

    /**
     * Cash equipment option validity period (SGT, data with minutes set to 0)
     */
    public ZonedDateTime getDateOptionExpire() {
        return dateOptionExpire != null
                ? Utils.toZonedDateTime(this.dateOptionExpire)
                : null;
    }

    /**
     * Cash equipment label information
     */
    @SerializedName("cash_item_label")
    private String cashItemLabel;

    /**
     * Cash equipment coloring prism information
     */
    @SerializedName("cash_item_coloring_prism")
    private CharacterCashItemEquipmentColoringPrismDTO cashItemColoringPrism;

    /**
     * Gender compatibility for item equipment
     */
    @SerializedName("item_gender")
    private String itemGender;

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

package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * Mechanic equipment information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentMechanicInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterItemEquipmentMechanicInfoDTO<
        CharacterItemEquipmentTotalOptionDTO,
        CharacterItemEquipmentBaseOptionDTO,
        CharacterItemEquipmentExceptionalOptionDTO,
        CharacterItemEquipmentAddOptionDTO,
        CharacterItemEquipmentEtcOptionDTO,
        CharacterItemEquipmentStarforceOptionDTO> {

    /**
     * Equipment part name
     */
    @SerializedName("item_equipment_part")
    private String itemEquipmentPart;

    /**
     * Equipment slot position
     */
    @SerializedName("item_equipment_slot")
    private String itemEquipmentSlot;

    /**
     * Equipment name
     */
    @SerializedName("item_name")
    private String itemName;

    /**
     * Equipment icon
     */
    @SerializedName("item_icon")
    private String itemIcon;

    /**
     * Equipment description
     */
    @SerializedName("item_description")
    private String itemDescription;

    /**
     * Equipment type
     */
    @SerializedName("item_shape_name")
    private String itemShapeName;

    /**
     * Equipment type icon
     */
    @SerializedName("item_shape_icon")
    private String itemShapeIcon;

    /**
     * Gender-specific equipment
     */
    @SerializedName("item_gender")
    private String itemGender;

    /**
     * Final equipment option information
     */
    @SerializedName("item_total_option")
    private CharacterItemEquipmentTotalOptionDTO itemTotalOption;

    /**
     * Basic equipment option information
     */
    @SerializedName("item_base_option")
    private CharacterItemEquipmentBaseOptionDTO itemBaseOption;

    /**
     * Equipment level increases
     */
    @SerializedName("equipment_level_increase")
    private long equipmentLevelIncrease;

    /**
     * Exceptional equipment option information
     */
    @SerializedName("item_exceptional_option")
    private CharacterItemEquipmentExceptionalOptionDTO itemExceptionalOption;

    /**
     * Additional equipment options
     */
    @SerializedName("item_add_option")
    private CharacterItemEquipmentAddOptionDTO itemAddOption;

    /**
     * Growth EXP
     */
    @SerializedName("growth_exp")
    private long growthExp;

    /**
     * Growth level
     */
    @SerializedName("growth_level")
    private long growthLevel;

    /**
     * Number of upgrades
     */
    @SerializedName("scroll_upgrade")
    private String scrollUpgrade;

    /**
     * Number of scissors usage available (Untradable, 255 for equipment without scissors usage count)
     */
    @SerializedName("cuttable_count")
    private String cuttableCount;

    /**
     * Golden Hammer refinement applied (true:applied, false:not applied)
     */
    @SerializedName("golden_hammer_flag")
    private String goldenHammerFlag;

    /**
     * Number of restoration attempts available
     */
    @SerializedName("scroll_resilience_count")
    private String scrollResilienceCount;

    /**
     * Number of upgrades available
     */
    @SerializedName("scroll_upgradeable_count")
    private String scrollUpgradeableCount;

    /**
     * Soul name
     */
    @SerializedName("soul_name")
    private String soulName;

    /**
     * Soul option
     */
    @SerializedName("soul_option")
    private String soulOption;

    /**
     * Miscellaneous equipment option information
     */
    @SerializedName("item_etc_option")
    private CharacterItemEquipmentEtcOptionDTO itemEtcOption;

    /**
     * Enhancement level
     */
    @SerializedName("starforce")
    private String starforce;

    /**
     * Usage status of Miraculous Equip Enhancement Scroll (true:used, false:not used)
     */
    @SerializedName("starforce_scroll_flag")
    private String starforceScrollFlag;

    /**
     * Equipment Star Force option information
     */
    @SerializedName("item_starforce_option")
    private CharacterItemEquipmentStarforceOptionDTO itemStarforceOption;

    /**
     * Special Skill Ring
     */
    @SerializedName("special_ring_level")
    private long specialRingLevel;

    /**
     * Equipment expiration date (SGT)
     */
    @SerializedName("date_expire")
    private String dateExpire;

    /**
     * Equipment expiration date (SGT)
     */
    public ZonedDateTime getDateExpire() {
        if (this.dateExpire != null && !"expired".equals(this.dateExpire)) {
            return Utils.toZonedDateTime(this.dateExpire);
        } else {
            return null;
        }
    }

    /**
     * Whether the equipment is expired
     */
    public Boolean isExpired() {

        if (this.dateExpire == null) {
            return null;
        }

        return "expired".equals(this.dateExpire);
    }
}

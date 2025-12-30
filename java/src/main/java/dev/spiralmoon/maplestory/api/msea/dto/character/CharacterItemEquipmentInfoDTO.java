package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * Equipment information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterItemEquipmentInfoDTO<
        CharacterItemEquipmentTotalOptionDTO,
        CharacterItemEquipmentBaseOptionDTO,
        CharacterItemEquipmentExceptionalOptionDTO,
        CharacterItemEquipmentAddOptionDTO,
        CharacterItemEquipmentEtcOptionDTO,
        CharacterItemEquipmentStarforceOptionDTO> {

    /**
     * Equipment part name
     */
    @JsonProperty("item_equipment_part")
    private String itemEquipmentPart;

    /**
     * Equipment slot position
     */
    @JsonProperty("item_equipment_slot")
    private String itemEquipmentSlot;

    /**
     * Equipment name
     */
    @JsonProperty("item_name")
    private String itemName;

    /**
     * Equipment icon
     */
    @JsonProperty("item_icon")
    private String itemIcon;

    /**
     * Equipment description
     */
    @JsonProperty("item_description")
    private String itemDescription;

    /**
     * Equipment type
     */
    @JsonProperty("item_shape_name")
    private String itemShapeName;

    /**
     * Equipment type icon
     */
    @JsonProperty("item_shape_icon")
    private String itemShapeIcon;

    /**
     * Gender-specific equipment
     */
    @JsonProperty("item_gender")
    private String itemGender;

    /**
     * Final equipment option information
     */
    @JsonProperty("item_total_option")
    private CharacterItemEquipmentTotalOptionDTO itemTotalOption;

    /**
     * Basic equipment option information
     */
    @JsonProperty("item_base_option")
    private CharacterItemEquipmentBaseOptionDTO itemBaseOption;

    /**
     * Potential seal status (true:sealed, false:not sealed)
     */
    @JsonProperty("potential_option_flag")
    private String potentialOptionFlag;

    /**
     * Additional potential seal status (true:sealed, false:not sealed)
     */
    @JsonProperty("additional_potential_option_flag")
    private String additionalPotentialOptionFlag;

    /**
     * Potential grade
     */
    @JsonProperty("potential_option_grade")
    private String potentialOptionGrade;

    /**
     * Additional potential grade
     */
    @JsonProperty("additional_potential_option_grade")
    private String additionalPotentialOptionGrade;

    /**
     * First Potential option
     */
    @JsonProperty("potential_option_1")
    private String potentialOption1;

    /**
     * Second Potential option
     */
    @JsonProperty("potential_option_2")
    private String potentialOption2;

    /**
     * Third Potential option
     */
    @JsonProperty("potential_option_3")
    private String potentialOption3;

    /**
     * First additional Potential option
     */
    @JsonProperty("additional_potential_option_1")
    private String additionalPotentialOption1;

    /**
     * Second additional Potential option
     */
    @JsonProperty("additional_potential_option_2")
    private String additionalPotentialOption2;

    /**
     * Third additional Potential option
     */
    @JsonProperty("additional_potential_option_3")
    private String additionalPotentialOption3;

    /**
     * Equipment level increase
     */
    @JsonProperty("equipment_level_increase")
    private long equipmentLevelIncrease;

    /**
     * Exceptional equipment option information
     */
    @JsonProperty("item_exceptional_option")
    private CharacterItemEquipmentExceptionalOptionDTO itemExceptionalOption;

    /**
     * Additional equipment options
     */
    @JsonProperty("item_add_option")
    private CharacterItemEquipmentAddOptionDTO itemAddOption;

    /**
     * Growth EXP
     */
    @JsonProperty("growth_exp")
    private long growthExp;

    /**
     * Growth level
     */
    @JsonProperty("growth_level")
    private long growthLevel;

    /**
     * Number of upgrade attempts
     */
    @JsonProperty("scroll_upgrade")
    private String scrollUpgrade;

    /**
     * Number of scissors usage available (Untradable, 255 for equipment without scissors usage count)
     */
    @JsonProperty("cuttable_count")
    private String cuttableCount;

    /**
     * Golden Hammer refinement applied (true:applied, false:not applied)
     */
    @JsonProperty("golden_hammer_flag")
    private String goldenHammerFlag;

    /**
     * Number of restoration attempts available
     */
    @JsonProperty("scroll_resilience_count")
    private String scrollResilienceCount;

    /**
     * Number of upgrades available
     */
    @JsonProperty("scroll_upgradeable_count")
    private String scrollUpgradeableCount;

    /**
     * Soul name
     */
    @JsonProperty("soul_name")
    private String soulName;

    /**
     * Soul option
     */
    @JsonProperty("soul_option")
    private String soulOption;

    /**
     * Miscellaneous equipment option information
     */
    @JsonProperty("item_etc_option")
    private CharacterItemEquipmentEtcOptionDTO itemEtcOption;

    /**
     * Enhancement level
     */
    @JsonProperty("starforce")
    private String starforce;

    /**
     * Usage status of Miraculous Equip Enhancement Scroll (true:used, false:not used)
     */
    @JsonProperty("starforce_scroll_flag")
    private String starforceScrollFlag;

    /**
     * Equipment Star Force option information
     */
    @JsonProperty("item_starforce_option")
    private CharacterItemEquipmentStarforceOptionDTO itemStarforceOption;

    /**
     * Special Skill Ring
     */
    @JsonProperty("special_ring_level")
    private long specialRingLevel;

    /**
     * Equipment expiration date (SGT)
     */
    @JsonProperty("date_expire")
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

    /**
     * Freestyle Coupon application status (0:not applied, 1:applied)
     */
    @JsonProperty("freestyle_flag")
    private String freestyleFlag;

    /**
     * Freestyle Coupon application status
     */
    public boolean isFreestyleFlag() {
        return "1".equals(this.freestyleFlag);
    }
}

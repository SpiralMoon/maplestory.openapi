package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 道具資訊
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
     * 道具部位名稱
     */
    @JsonProperty("item_equipment_part")
    private String itemEquipmentPart;

    /**
     * 道具欄位位置
     */
    @JsonProperty("item_equipment_slot")
    private String itemEquipmentSlot;

    /**
     * 道具名稱
     */
    @JsonProperty("item_name")
    private String itemName;

    /**
     * 道具圖示
     */
    @JsonProperty("item_icon")
    private String itemIcon;

    /**
     * 道具描述
     */
    @JsonProperty("item_description")
    private String itemDescription;

    /**
     * 道具外型
     */
    @JsonProperty("item_shape_name")
    private String itemShapeName;

    /**
     * 道具外型圖示
     */
    @JsonProperty("item_shape_icon")
    private String itemShapeIcon;

    /**
     * 性別限定
     */
    @JsonProperty("item_gender")
    private String itemGender;

    /**
     * 道具最終選項資訊
     */
    @JsonProperty("item_total_option")
    private CharacterItemEquipmentTotalOptionDTO itemTotalOption;

    /**
     * 道具基本選項資訊
     */
    @JsonProperty("item_base_option")
    private CharacterItemEquipmentBaseOptionDTO itemBaseOption;

    /**
     * 潛在能力封印狀態 (true：已封印，false：未封印)
     */
    @JsonProperty("potential_option_flag")
    private String potentialOptionFlag;

    /**
     * 附加潛在能力封印狀態 (true：已封印，false：未封印)
     */
    @JsonProperty("additional_potential_option_flag")
    private String additionalPotentialOptionFlag;

    /**
     * 潛在能力階級
     */
    @JsonProperty("potential_option_grade")
    private String potentialOptionGrade;

    /**
     * 附加潛在能力階級
     */
    @JsonProperty("additional_potential_option_grade")
    private String additionalPotentialOptionGrade;

    /**
     * 第一潛在能力選項
     */
    @JsonProperty("potential_option_1")
    private String potentialOption1;

    /**
     * 第二潛在能力選項
     */
    @JsonProperty("potential_option_2")
    private String potentialOption2;

    /**
     * 第三潛在能力選項
     */
    @JsonProperty("potential_option_3")
    private String potentialOption3;

    /**
     * 第一附加潛在能力選項
     */
    @JsonProperty("additional_potential_option_1")
    private String additionalPotentialOption1;

    /**
     * 第二附加潛在能力選項
     */
    @JsonProperty("additional_potential_option_2")
    private String additionalPotentialOption2;

    /**
     * 第三附加潛在能力選項
     */
    @JsonProperty("additional_potential_option_3")
    private String additionalPotentialOption3;

    /**
     * 裝備等級增加
     */
    @JsonProperty("equipment_level_increase")
    private long equipmentLevelIncrease;

    /**
     * 道具特殊選項資訊
     */
    @JsonProperty("item_exceptional_option")
    private CharacterItemEquipmentExceptionalOptionDTO itemExceptionalOption;

    /**
     * 附加道具選項
     */
    @JsonProperty("item_add_option")
    private CharacterItemEquipmentAddOptionDTO itemAddOption;

    /**
     * 成長經驗值
     */
    @JsonProperty("growth_exp")
    private long growthExp;

    /**
     * 成長等級
     */
    @JsonProperty("growth_level")
    private long growthLevel;

    /**
     * 強化次數
     */
    @JsonProperty("scroll_upgrade")
    private String scrollUpgrade;

    /**
     * 可使用剪刀的次數 (不可交易道具、可交易但從未使用剪刀的道具：255)
     */
    @JsonProperty("cuttable_count")
    private String cuttableCount;

    /**
     * 黃金鐵鎚精煉 (true：已套用，false：未套用)
     */
    @JsonProperty("golden_hammer_flag")
    private String goldenHammerFlag;

    /**
     * 道具可復原次數
     */
    @JsonProperty("scroll_resilience_count")
    private String scrollResilienceCount;

    /**
     * 道具可升級次數
     */
    @JsonProperty("scroll_upgradeable_count")
    private String scrollUpgradeableCount;

    /**
     * 靈魂名稱
     */
    @JsonProperty("soul_name")
    private String soulName;

    /**
     * 靈魂選項
     */
    @JsonProperty("soul_option")
    private String soulOption;

    /**
     * 道具其他選項資訊
     */
    @JsonProperty("item_etc_option")
    private CharacterItemEquipmentEtcOptionDTO itemEtcOption;

    /**
     * 強化階級
     */
    @JsonProperty("starforce")
    private String starforce;

    /**
     * 驚異道具強化卷軸 (true：已使用，false：未使用)
     */
    @JsonProperty("starforce_scroll_flag")
    private String starforceScrollFlag;

    /**
     * 道具星星力量資訊
     */
    @JsonProperty("item_starforce_option")
    private CharacterItemEquipmentStarforceOptionDTO itemStarforceOption;

    /**
     * 特殊戒指等級
     */
    @JsonProperty("special_ring_level")
    private long specialRingLevel;

    /**
     * 道具有效期間 (TST)
     */
    @JsonProperty("date_expire")
    private String dateExpire;

    /**
     * 道具有效期間 (TST)
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

package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 龍魔導士的龍道具資訊 (僅在龍魔導士時回應)
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentDragonInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterItemEquipmentDragonInfoDTO<
        CharacterItemEquipmentTotalOptionDTO,
        CharacterItemEquipmentBaseOptionDTO,
        CharacterItemEquipmentExceptionalOptionDTO,
        CharacterItemEquipmentAddOptionDTO,
        CharacterItemEquipmentEtcOptionDTO,
        CharacterItemEquipmentStarforceOptionDTO> {

    /**
     * 道具部位名稱
     */
    @SerializedName("item_equipment_part")
    private String itemEquipmentPart;

    /**
     * 道具欄位位置
     */
    @SerializedName("item_equipment_slot")
    private String itemEquipmentSlot;

    /**
     * 道具名稱
     */
    @SerializedName("item_name")
    private String itemName;

    /**
     * 道具圖示
     */
    @SerializedName("item_icon")
    private String itemIcon;

    /**
     * 道具描述
     */
    @SerializedName("item_description")
    private String itemDescription;

    /**
     * 道具外型
     */
    @SerializedName("item_shape_name")
    private String itemShapeName;

    /**
     * 道具外型圖示
     */
    @SerializedName("item_shape_icon")
    private String itemShapeIcon;

    /**
     * 性別限定
     */
    @SerializedName("item_gender")
    private String itemGender;

    /**
     * 道具最終選項資訊
     */
    @SerializedName("item_total_option")
    private CharacterItemEquipmentTotalOptionDTO itemTotalOption;

    /**
     * 道具基本選項資訊
     */
    @SerializedName("item_base_option")
    private CharacterItemEquipmentBaseOptionDTO itemBaseOption;

    /**
     * 裝備等級增加
     */
    @SerializedName("equipment_level_increase")
    private long equipmentLevelIncrease;

    /**
     * 道具特殊選項資訊
     */
    @SerializedName("item_exceptional_option")
    private CharacterItemEquipmentExceptionalOptionDTO itemExceptionalOption;

    /**
     * 附加道具選項
     */
    @SerializedName("item_add_option")
    private CharacterItemEquipmentAddOptionDTO itemAddOption;

    /**
     * 成長經驗值
     */
    @SerializedName("growth_exp")
    private long growthExp;

    /**
     * 成長等級
     */
    @SerializedName("growth_level")
    private long growthLevel;

    /**
     * 強化次數
     */
    @SerializedName("scroll_upgrade")
    private String scrollUpgrade;

    /**
     * 可使用剪刀的次數 (不可交易道具、可交易但從未使用剪刀的道具：255)
     */
    @SerializedName("cuttable_count")
    private String cuttableCount;

    /**
     * 黃金鐵鎚精煉 (true：已套用，false：未套用)
     */
    @SerializedName("golden_hammer_flag")
    private String goldenHammerFlag;

    /**
     * 道具可復原次數
     */
    @SerializedName("scroll_resilience_count")
    private String scrollResilienceCount;

    /**
     * 道具可升級次數
     */
    @SerializedName("scroll_upgradeable_count")
    private String scrollUpgradeableCount;

    /**
     * 靈魂名稱
     */
    @SerializedName("soul_name")
    private String soulName;

    /**
     * 靈魂選項
     */
    @SerializedName("soul_option")
    private String soulOption;

    /**
     * 道具其他選項資訊
     */
    @SerializedName("item_etc_option")
    private CharacterItemEquipmentEtcOptionDTO itemEtcOption;

    /**
     * 強化階級
     */
    @SerializedName("starforce")
    private String starforce;

    /**
     * 驚異道具強化卷軸 (true：已使用，false：未使用)
     */
    @SerializedName("starforce_scroll_flag")
    private String starforceScrollFlag;

    /**
     * 道具星星力量資訊
     */
    @SerializedName("item_starforce_option")
    private CharacterItemEquipmentStarforceOptionDTO itemStarforceOption;

    /**
     * 特殊戒指等級
     */
    @SerializedName("special_ring_level")
    private Long specialRingLevel;

    /**
     * 道具有效期間 (TST)
     */
    @SerializedName("date_expire")
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
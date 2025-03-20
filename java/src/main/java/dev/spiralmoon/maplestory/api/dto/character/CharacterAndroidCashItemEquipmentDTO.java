package dev.spiralmoon.maplestory.api.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 캐릭터 안드로이드 캐시 아이템 장착 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterAndroidCashItemEquipmentDTO {

    /**
     * 안드로이드 캐시 아이템 부위 명
     */
    @SerializedName("cash_item_equipment_part")
    private String cashItemEquipmentPart;

    /**
     * 안드로이드 캐시 아이템 슬롯 위치
     */
    @SerializedName("cash_item_equipment_slot")
    private String cashItemEquipmentSlot;

    /**
     * 안드로이드 캐시 아이템 명
     */
    @SerializedName("cash_item_name")
    private String cashItemName;

    /**
     * 안드로이드 캐시 아이템 아이콘
     */
    @SerializedName("cash_item_icon")
    private String cashItemIcon;

    /**
     * 안드로이드 캐시 아이템 설명
     */
    @SerializedName("cash_item_description")
    private String cashItemDescription;

    /**
     * 안드로이드 캐시 아이템 옵션
     */
    @SerializedName("cash_item_option")
    private List<CharacterAndroidCashItemEquipmentOptionDTO> cashItemOption;

    /**
     * 안드로이드 캐시 아이템 유효 기간 (KST)
     */
    @SerializedName("date_expire")
    private String dateExpire;

    /**
     * 안드로이드 캐시 아이템 옵션 유효 기간 (KST)
     */
    @SerializedName("date_option_expire")
    private String dateOptionExpire;

    /**
     * 안드로이드 캐시 아이템 라벨 정보 (스페셜라벨, 레드라벨, 블랙라벨, 마스터라벨)
     */
    @SerializedName("cash_item_label")
    private String cashItemLabel;

    /**
     * 안드로이드 캐시 아이템 컬러링프리즘 정보
     */
    @SerializedName("cash_item_coloring_prism")
    private CharacterAndroidCashItemEquipmentColoringPrismDTO cashItemColoringPrism;

    private LocalDateTime getDateExpire() {
        if (this.dateExpire != null && !"expired".equals(this.dateExpire)) {
            return Utils.toLocalDateTime(this.dateExpire);
        } else {
            return null;
        }
    }

    private LocalDateTime getDateOptionExpire() {
        if (this.dateOptionExpire != null && !"expired".equals(this.dateOptionExpire)) {
            return Utils.toLocalDateTime(this.dateOptionExpire);
        } else {
            return null;
        }
    }

    /**
     * 안드로이드 캐시 아이템 유효 기간 만료 여부
     */
    private Boolean isExpired() {

        if (this.dateExpire == null) {
            return null;
        }

        return "expired".equals(this.dateExpire);
    }

    /**
     * 안드로이드 캐시 아이템 옵션 유효 기간 만료 여부
     */
    private Boolean isOptionExpired() {

        if (this.dateOptionExpire == null) {
            return null;
        }

        return "expired".equals(this.dateOptionExpire);
    }
}

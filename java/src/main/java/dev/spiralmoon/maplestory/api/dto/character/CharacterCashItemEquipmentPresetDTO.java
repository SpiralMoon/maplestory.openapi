package dev.spiralmoon.maplestory.api.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 캐릭터 프리셋 장착 캐시 장비 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterCashItemEquipmentPresetDTO {

    /**
     * 캐시 장비 부위 명
     */
    @SerializedName("cash_item_equipment_part")
    private String cashItemEquipmentPart;

    /**
     * 캐시 장비 슬롯 위치
     */
    @SerializedName("cash_item_equipment_slot")
    private String cashItemEquipmentSlot;

    /**
     * 캐시 장비 명
     */
    @SerializedName("cash_item_name")
    private String cashItemName;

    /**
     * 캐시 장비 아이콘
     */
    @SerializedName("cash_item_icon")
    private String cashItemIcon;

    /**
     * 캐시 장비 설명
     */
    @SerializedName("cash_item_description")
    private String cashItemDescription;

    /**
     * 캐시 장비 옵션 목록
     */
    @SerializedName("cash_item_option")
    private List<CharacterCashItemEquipmentOptionDTO> cashItemOption;

    /**
     * 캐시 장비 유효 기간 (KST)
     */
    @SerializedName("date_expire")
    private String dateExpire;

    /**
     * 캐시 장비 옵션 유효 기간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
     */
    @SerializedName("date_option_expire")
    private String dateOptionExpire;

    /**
     * 캐시 장비 라벨 정보
     */
    @SerializedName("cash_item_label")
    private String cashItemLabel;

    /**
     * 캐시 장비 컬러링프리즘 정보
     */
    @SerializedName("cash_item_coloring_prism")
    private CharacterCashItemEquipmentColoringPrismDTO cashItemColoringPrism;

    /**
     * 아이템 장착 가능 성별
     */
    @SerializedName("item_gender")
    private String itemGender;

    /**
     * 스킬명
     */
    @SerializedName("skills")
    private List<String> skills;

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
     * 캐시 장비 유효 기간 만료 여부
     */
    private Boolean isExpired() {

        if (this.dateExpire == null) {
            return null;
        }

        return "expired".equals(this.dateExpire);
    }

    /**
     * 캐시 장비 옵션 유효 기간 만료 여부
     */
    private Boolean isOptionExpired() {

        if (this.dateOptionExpire == null) {
            return null;
        }

        return "expired".equals(this.dateOptionExpire);
    }
}

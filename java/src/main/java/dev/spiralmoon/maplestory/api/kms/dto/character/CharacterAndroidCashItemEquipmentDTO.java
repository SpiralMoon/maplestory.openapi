package dev.spiralmoon.maplestory.api.kms.dto.character;

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
 * 캐릭터 안드로이드 캐시 아이템 장착 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterAndroidCashItemEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAndroidCashItemEquipmentDTO<
        CharacterAndroidCashItemEquipmentOptionDTO,
        CharacterAndroidCashItemEquipmentColoringPrismDTO> {

    /**
     * 안드로이드 캐시 아이템 부위 명
     */
    @JsonProperty("cash_item_equipment_part")
    private String cashItemEquipmentPart;

    /**
     * 안드로이드 캐시 아이템 슬롯 위치
     */
    @JsonProperty("cash_item_equipment_slot")
    private String cashItemEquipmentSlot;

    /**
     * 안드로이드 캐시 아이템 명
     */
    @JsonProperty("cash_item_name")
    private String cashItemName;

    /**
     * 안드로이드 캐시 아이템 아이콘
     */
    @JsonProperty("cash_item_icon")
    private String cashItemIcon;

    /**
     * 안드로이드 캐시 아이템 설명
     */
    @JsonProperty("cash_item_description")
    private String cashItemDescription;

    /**
     * 안드로이드 캐시 아이템 옵션
     */
    @JsonProperty("cash_item_option")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterAndroidCashItemEquipmentOptionDTO> cashItemOption;

    /**
     * 안드로이드 캐시 아이템 유효 기간 (KST)
     */
    @JsonProperty("date_expire")
    private String dateExpire;

    /**
     * 안드로이드 캐시 아이템 옵션 유효 기간 (KST)
     */
    @JsonProperty("date_option_expire")
    private String dateOptionExpire;

    /**
     * 안드로이드 캐시 아이템 라벨 정보 (스페셜라벨, 레드라벨, 블랙라벨, 마스터라벨)
     */
    @JsonProperty("cash_item_label")
    private String cashItemLabel;

    /**
     * 안드로이드 캐시 아이템 컬러링프리즘 정보
     */
    @JsonProperty("cash_item_coloring_prism")
    private CharacterAndroidCashItemEquipmentColoringPrismDTO cashItemColoringPrism;

    /**
     * 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
     */
    @JsonProperty("freestyle_flag")
    private String freestyleFlag;

    /**
     * 아이템 장착 가능 성별
     */
    @JsonProperty("android_item_gender")
    private String androidItemGender;

    /**
     * 안드로이드 캐시 아이템 유효 기간 (KST)
     */
    public ZonedDateTime getDateExpire() {
        if (this.dateExpire != null && !"expired".equals(this.dateExpire)) {
            return Utils.toZonedDateTime(this.dateExpire);
        } else {
            return null;
        }
    }

    /**
     * 안드로이드 캐시 아이템 유효 기간 만료 여부
     */
    public Boolean isExpired() {

        if (this.dateExpire == null) {
            return null;
        }

        return "expired".equals(this.dateExpire);
    }

    /**
     * 안드로이드 캐시 아이템 옵션 유효 기간 (KST)
     */
    public ZonedDateTime getDateOptionExpire() {
        if (this.dateOptionExpire != null && !"expired".equals(this.dateOptionExpire)) {
            return Utils.toZonedDateTime(this.dateOptionExpire);
        } else {
            return null;
        }
    }

    /**
     * 안드로이드 캐시 아이템 옵션 유효 기간 만료 여부
     */
    public Boolean isOptionExpired() {

        if (this.dateOptionExpire == null) {
            return null;
        }

        return "expired".equals(this.dateOptionExpire);
    }

    /**
     * 프리스타일 쿠폰 적용 여부
     */
    public boolean isFreestyleFlag() {
        return this.freestyleFlag.equals("1");
    }
}

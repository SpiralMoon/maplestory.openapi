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
 * 캐릭터 프리셋 장착 캐시 장비 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterCashItemEquipmentPresetDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterCashItemEquipmentPresetDTO<
        CharacterCashItemEquipmentOptionDTO,
        CharacterCashItemEquipmentColoringPrismDTO> {

    /**
     * 캐시 장비 부위 명
     */
    @JsonProperty("cash_item_equipment_part")
    private String cashItemEquipmentPart;

    /**
     * 캐시 장비 슬롯 위치
     */
    @JsonProperty("cash_item_equipment_slot")
    private String cashItemEquipmentSlot;

    /**
     * 캐시 장비 명
     */
    @JsonProperty("cash_item_name")
    private String cashItemName;

    /**
     * 캐시 장비 아이콘
     */
    @JsonProperty("cash_item_icon")
    private String cashItemIcon;

    /**
     * 캐시 장비 설명
     */
    @JsonProperty("cash_item_description")
    private String cashItemDescription;

    /**
     * 캐시 장비 옵션 목록
     */
    @JsonProperty("cash_item_option")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterCashItemEquipmentOptionDTO> cashItemOption;

    /**
     * 캐시 장비 유효 기간 (KST)
     */
    @JsonProperty("date_expire")
    private String dateExpire;

    /**
     * 캐시 장비 옵션 유효 기간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
     */
    @JsonProperty("date_option_expire")
    private String dateOptionExpire;

    /**
     * 캐시 장비 라벨 정보
     */
    @JsonProperty("cash_item_label")
    private String cashItemLabel;

    /**
     * 캐시 장비 컬러링프리즘 정보
     */
    @JsonProperty("cash_item_coloring_prism")
    private CharacterCashItemEquipmentColoringPrismDTO cashItemColoringPrism;

    /**
     * 캐시 장비(무기) 이펙트 프리즘 정보
     */
    @JsonProperty("cash_item_effect_prism")
    private CharacterCashItemEquipmentEffectPrismDTO cashItemEffectPrism;

    /**
     * 아이템 장착 가능 성별
     */
    @JsonProperty("item_gender")
    private String itemGender;

    /**
     * 스킬명
     */
    @JsonProperty("skills")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<String> skills;

    /**
     * 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
     */
    @JsonProperty("freestyle_flag")
    private String freestyleFlag;

    /**
     * 표정 합성 정보
     */
    @JsonProperty("emotion_name")
    private String emotionName;

    /**
     * 캐시 장비 유효 기간 (KST)
     */
    public ZonedDateTime getDateExpire() {
        if (this.dateExpire != null && !"expired".equals(this.dateExpire)) {
            return Utils.toZonedDateTime(this.dateExpire);
        } else {
            return null;
        }
    }

    /**
     * 캐시 장비 유효 기간 만료 여부
     */
    public Boolean isExpired() {

        if (this.dateExpire == null) {
            return null;
        }

        return "expired".equals(this.dateExpire);
    }

    /**
     * 캐시 장비 옵션 유효 기간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
     */
    public ZonedDateTime getDateOptionExpire() {
        if (this.dateOptionExpire != null && !"expired".equals(this.dateOptionExpire)) {
            return Utils.toZonedDateTime(this.dateOptionExpire);
        } else {
            return null;
        }
    }

    /**
     * 캐시 장비 옵션 유효 기간 만료 여부
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

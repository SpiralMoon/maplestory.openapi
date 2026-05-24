package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

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
 * 연무장 입장 시 캐릭터 장착 캐시 장비 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterCashItemEquipmentDTO {

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
    private List<BattlePracticeCharacterCashItemOptionDTO> cashItemOption;

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
     * 캐시 장비 유효 기간 (KST)
     */
    public ZonedDateTime getDateExpire() {
        return dateExpire != null
                ? Utils.toZonedDateTime(this.dateExpire)
                : null;
    }

    /**
     * 캐시 장비 옵션 유효 기간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
     */
    public ZonedDateTime getDateOptionExpire() {
        return dateOptionExpire != null
                ? Utils.toZonedDateTime(this.dateOptionExpire)
                : null;
    }
}

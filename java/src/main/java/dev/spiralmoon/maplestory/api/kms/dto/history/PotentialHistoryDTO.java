package dev.spiralmoon.maplestory.api.kms.dto.history;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import dev.spiralmoon.maplestory.api.Utils;
import dev.spiralmoon.maplestory.api.common.dto.PotentialOptionGrade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 잠재능력 재설정 히스토리
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PotentialHistoryDTO {

    /**
     * 잠재능력 재설정 히스토리 식별자
     */
    @JsonProperty("id")
    private String id;

    /**
     * 캐릭터 명
     */
    @JsonProperty("character_name")
    private String characterName;

    /**
     * 사용 일시
     */
    @JsonProperty("date_create")
    private String dateCreate;

    /**
     * 대상 잠재능력 타입 (잠재능력, 에디셔널 잠재능력)
     */
    @JsonProperty("potential_type")
    private String potentialType;

    /**
     * 사용 결과
     */
    @JsonProperty("item_upgrade_result")
    private String itemUpgradeResult;

    /**
     * 미라클 타임 적용 여부
     */
    @JsonProperty("miracle_time_flag")
    private String miracleTimeFlag;

    /**
     * 장비 분류
     */
    @JsonProperty("item_equipment_part")
    private String itemEquipmentPart;

    /**
     * 장비 레벨
     */
    @JsonProperty("item_level")
    private int itemLevel;

    /**
     * 잠재능력 재설정 장비 명
     */
    @JsonProperty("target_item")
    private String targetItem;

    /**
     * 잠재능력 등급
     */
    @JsonProperty("potential_option_grade")
    private String potentialOptionGrade;

    /**
     * 에디셔널 잠재능력 등급
     */
    @JsonProperty("additional_potential_option_grade")
    private String additionalPotentialOptionGrade;

    /**
     * 천장에 도달하여 확정 등급 상승한 여부
     */
    @JsonProperty("upgradeGuarantee")
    private boolean upgradeGuarantee;

    /**
     * 현재까지 쌓은 스택
     */
    @JsonProperty("upgradeGuaranteeCount")
    private int upgradeGuaranteeCount;

    /**
     * 사용 전 잠재능력 옵션
     */
    @JsonProperty("before_potential_option")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<PotentialResultOptionDTO> beforePotentialOption;

    /**
     * 사용 전 에디셔널 잠재능력 옵션
     */
    @JsonProperty("before_additional_potential_option")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<PotentialResultOptionDTO> beforeAdditionalPotentialOption;

    /**
     * 사용 후 잠재능력 옵션
     */
    @JsonProperty("after_potential_option")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<PotentialResultOptionDTO> afterPotentialOption;

    /**
     * 사용 후 에디셔널 잠재능력 옵션
     */
    @JsonProperty("after_additional_potential_option")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<PotentialResultOptionDTO> afterAdditionalPotentialOption;

    public boolean isItemUpgrade() {
        return this.itemUpgradeResult.equals("성공");
    }

    public boolean isMiracleTimeFlag() {
        return !this.miracleTimeFlag.equals("이벤트 적용되지 않음");
    }

    public PotentialOptionGrade getPotentialOptionGradeEnum() {
        return PotentialOptionGrade.fromString(this.potentialOptionGrade);
    }

    public PotentialOptionGrade getAdditionalPotentialOptionGradeEnum() {
        return PotentialOptionGrade.fromString(this.potentialOptionGrade);
    }

    public ZonedDateTime getDateCreate() {
        return Utils.toZonedDateTime(this.dateCreate);
    }
}

package dev.spiralmoon.maplestory.api.dto.history;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import dev.spiralmoon.maplestory.api.dto.PotentialOptionGrade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 잠재능력 재설정 히스토리
 */
@AllArgsConstructor
@Data
@ToString
public class PotentialHistoryDTO {

    /**
     * 잠재능력 재설정 히스토리 식별자
     */
    @SerializedName("id")
    private String id;

    /**
     * 캐릭터 명
     */
    @SerializedName("character_name")
    private String characterName;

    /**
     * 사용 일시
     */
    @SerializedName("date_create")
    private String dateCreate;

    /**
     * 대상 잠재능력 타입 (잠재능력, 에디셔널 잠재능력)
     */
    @SerializedName("potential_type")
    private String potentialType;

    /**
     * 사용 결과
     */
    @SerializedName("item_upgrade_result")
    private String itemUpgradeResult;

    /**
     * 미라클 타임 적용 여부
     */
    @SerializedName("miracle_time_flag")
    private String miracleTimeFlag;

    /**
     * 장비 분류
     */
    @SerializedName("item_equipment_part")
    private String itemEquipmentPart;

    /**
     * 장비 레벨
     */
    @SerializedName("item_level")
    private int itemLevel;

    /**
     * 잠재능력 재설정 장비 명
     */
    @SerializedName("target_item")
    private String targetItem;

    /**
     * 잠재능력 등급
     */
    @SerializedName("potential_option_grade")
    private String potentialOptionGrade;

    /**
     * 에디셔널 잠재능력 등급
     */
    @SerializedName("additional_potential_option_grade")
    private String additionalPotentialOptionGrade;

    /**
     * 천장에 도달하여 확정 등급 상승한 여부
     */
    @SerializedName("upgradeGuarantee")
    private boolean upgradeGuarantee;

    /**
     * 현재까지 쌓은 스택
     */
    @SerializedName("upgradeGuaranteeCount")
    private int upgradeGuaranteeCount;

    /**
     * 사용 전 잠재능력 옵션
     */
    @SerializedName("before_potential_option")
    private List<PotentialResultOptionDTO> beforePotentialOption;

    /**
     * 사용 전 에디셔널 잠재능력 옵션
     */
    @SerializedName("before_additional_potential_option")
    private List<PotentialResultOptionDTO> beforeAdditionalPotentialOption;

    /**
     * 사용 후 잠재능력 옵션
     */
    @SerializedName("after_potential_option")
    private List<PotentialResultOptionDTO> afterPotentialOption;

    /**
     * 사용 후 에디셔널 잠재능력 옵션
     */
    @SerializedName("after_additional_potential_option")
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

    public LocalDateTime getDateCreate() {
        return Utils.toLocalDateTime(this.dateCreate);
    }
}

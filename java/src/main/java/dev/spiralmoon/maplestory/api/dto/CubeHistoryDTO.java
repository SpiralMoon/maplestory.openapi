package dev.spiralmoon.maplestory.api.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 큐브히스토리 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CubeHistoryDTO {

    /**
     * 큐브 사용 내역에 대한 고유 식별자
     */
    @SerializedName("id")
    private String id;

    /**
     * 캐릭터이름
     */
    @SerializedName("character_name")
    private String characterName;

    /**
     * 월드 이름
     */
    @SerializedName("world_name")
    private String worldName;

    /**
     * 큐브 사용 날짜
     */
    @SerializedName("create_date")
    private String createDate;

    /**
     * 사용한 큐브
     */
    @SerializedName("cube_type")
    private String cubeType;

    /**
     * 큐브 사용 결과
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
    @SerializedName("item_equip_part")
    private String itemEquipPart;

    /**
     * 장비 레벨
     */
    @SerializedName("item_level")
    private int itemLevel;

    /**
     * 큐브를 사용한 장비
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
    @SerializedName("upgradeguarantee")
    private boolean upgradeGuarantee;

    /**
     * 현재까지 쌓은 스택
     */
    @SerializedName("upgradeguaranteecount")
    private int upgradeGuaranteeCount;

    /**
     * 큐브 사용 전 잠재능력 옵션
     */
    @SerializedName("before_potential_options")
    private List<CubeResultOptionDTO> beforePotentialOptions;

    /**
     * 큐브 사용 전 에디셔널 잠재능력 옵션
     */
    @SerializedName("before_additional_potential_options")
    private List<CubeResultOptionDTO> beforeAdditionalPotentialOptions;

    /**
     * 큐브 사용 후 잠재능력 옵션
     */
    @SerializedName("after_potential_options")
    private List<CubeResultOptionDTO> afterPotentialOptions;

    /**
     * 큐브 사용 후 에디셔널 잠재능력 옵션
     */
    @SerializedName("after_additional_potential_options")
    private List<CubeResultOptionDTO> afterAdditionalPotentialOptions;

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
}

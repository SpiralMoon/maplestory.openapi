package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 에반 드래곤 장비 정보
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
     * 장비 부위 명
     */
    @SerializedName("item_equipment_part")
    private String itemEquipmentPart;

    /**
     * 장비 슬롯 위치
     */
    @SerializedName("item_equipment_slot")
    private String itemEquipmentSlot;

    /**
     * 장비 명
     */
    @SerializedName("item_name")
    private String itemName;

    /**
     * 장비 아이콘
     */
    @SerializedName("item_icon")
    private String itemIcon;

    /**
     * 장비 설명
     */
    @SerializedName("item_description")
    private String itemDescription;

    /**
     * 장비 외형
     */
    @SerializedName("item_shape_name")
    private String itemShapeName;

    /**
     * 장비 외형 아이콘
     */
    @SerializedName("item_shape_icon")
    private String itemShapeIcon;

    /**
     * 전용 성별
     */
    @SerializedName("item_gender")
    private String itemGender;

    /**
     * 장비 최종 옵션 정보
     */
    @SerializedName("item_total_option")
    private CharacterItemEquipmentTotalOptionDTO itemTotalOption;

    /**
     * 장비 기본 옵션 정보
     */
    @SerializedName("item_base_option")
    private CharacterItemEquipmentBaseOptionDTO itemBaseOption;

    /**
     * 착용 레벨 증가
     */
    @SerializedName("equipment_level_increase")
    private long equipmentLevelIncrease;

    /**
     * 장비 특별 옵션 정보
     */
    @SerializedName("item_exceptional_option")
    private CharacterItemEquipmentExceptionalOptionDTO itemExceptionalOption;

    /**
     * 장비 추가 옵션 정보
     */
    @SerializedName("item_add_option")
    private CharacterItemEquipmentAddOptionDTO itemAddOption;

    /**
     * 성장 경험치
     */
    @SerializedName("growth_exp")
    private long growthExp;

    /**
     * 성장 레벨
     */
    @SerializedName("growth_level")
    private long growthLevel;

    /**
     * 업그레이드 횟수
     */
    @SerializedName("scroll_upgrade")
    private String scrollUpgrade;

    /**
     * 가위 사용 가능 횟수 (교환 불가 장비, 가위 횟수가 없는 교환 가능 장비는 255)
     */
    @SerializedName("cuttable_count")
    private String cuttableCount;

    /**
     * 황금 망치 재련 적용 (1:적용, 이외 미 적용)
     */
    @SerializedName("golden_hammer_flag")
    private String goldenHammerFlag;

    /**
     * 복구 가능 횟수
     */
    @SerializedName("scroll_resilience_count")
    private String scrollResilienceCount;

    /**
     * 업그레이드 가능 횟수
     */
    @SerializedName("scroll_upgradeable_count")
    private String scrollUpgradeableCount;

    /**
     * 소울 명
     */
    @SerializedName("soul_name")
    private String soulName;

    /**
     * 소울 옵션
     */
    @SerializedName("soul_option")
    private String soulOption;

    /**
     * 장비 기타 옵션 정보
     */
    @SerializedName("item_etc_option")
    private CharacterItemEquipmentEtcOptionDTO itemEtcOption;

    /**
     * 강화 단계
     */
    @SerializedName("starforce")
    private String starforce;

    /**
     * 놀라운 장비 강화 주문서 사용 여부 (0:미사용, 1:사용)
     */
    @SerializedName("starforce_scroll_flag")
    private String starforceScrollFlag;

    /**
     * 장비 스타포스 옵션 정보
     */
    @SerializedName("item_starforce_option")
    private CharacterItemEquipmentStarforceOptionDTO itemStarforceOption;

    /**
     * 특수 반지 레벨
     */
    @SerializedName("special_ring_level")
    private long specialRingLevel;

    /**
     * 장비 유효 기간(KST)
     */
    @SerializedName("date_expire")
    private String dateExpire;

    /**
     * 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
     */
    @SerializedName("freestyle_flag")
    private String freestyleFlag;

    /**
     * 장비 유효 기간(KST)
     */
    public ZonedDateTime getDateExpire() {
        if (this.dateExpire != null && !"expired".equals(this.dateExpire)) {
            return Utils.toZonedDateTime(this.dateExpire);
        } else {
            return null;
        }
    }

    /**
     * 장비 유효 기간 만료 여부
     */
    public Boolean isExpired() {

        if (this.dateExpire == null) {
            return null;
        }

        return "expired".equals(this.dateExpire);
    }

    /**
     * 프리스타일 쿠폰 적용 여부
     */
    public boolean isFreestyleFlag() {
        return this.freestyleFlag.equals("1");
    }
}

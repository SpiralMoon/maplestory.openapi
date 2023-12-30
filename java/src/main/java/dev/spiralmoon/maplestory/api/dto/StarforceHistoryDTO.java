package dev.spiralmoon.maplestory.api.dto;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 스타포스 히스토리
 */
@AllArgsConstructor
@Data
@ToString
public class StarforceHistoryDTO {

    /**
     * 스타포스 히스토리 식별자
     */
    @SerializedName("id")
    private String id;

    /**
     * 강화 시도 결과
     */
    @SerializedName("item_upgrade_result")
    private String itemUpgradeResult;

    /**
     * 강화 시도 전 스타포스 수치
     */
    @SerializedName("before_starforce_count")
    private int beforeStarforceCount;

    /**
     * 강화 시도 후 스타포스 수치
     */
    @SerializedName("after_starforce_count")
    private int afterStarforceCount;

    /**
     * 스타 캐치
     */
    @SerializedName("starcatch_result")
    private String starCatchResult;

    /**
     * 슈페리얼 장비
     */
    @SerializedName("superior_item_flag")
    private String superiorItemFlag;

    /**
     * 파괴 방지
     */
    @SerializedName("destroy_defence")
    private String destroyDefence;

    /**
     * 찬스 타임
     */
    @SerializedName("chance_time")
    private String chanceTime;

    /**
     * 파괴 방지 필드 이벤트
     */
    @SerializedName("event_field_flag")
    private String eventFieldFlag;

    /**
     * 사용 주문서 명
     */
    @SerializedName("upgrade_item")
    private String upgradeItem;

    /**
     * 프로텍트 실드
     */
    @SerializedName("protect_shield")
    private String protectShield;

    /**
     * 보너스 스탯 부여 아이템 여부
     */
    @SerializedName("bonus_stat_upgrade")
    private String bonusStatUpgrade;

    /**
     * 캐릭터 명
     */
    @SerializedName("character_name")
    private String characterName;

    /**
     * 월드 명
     */
    @SerializedName("world_name")
    private String worldName;

    /**
     * 대상 장비 아이템 명
     */
    @SerializedName("target_item")
    private String targetItem;

    /**
     * 강화 일시 (KST)
     */
    @SerializedName("date_create")
    private String dateCreate;

    /**
     * 진행 중인 스타포스 강화 이벤트 정보
     */
    @SerializedName("starforce_event_list")
    private List<StarforceEventDTO> starforceEventList;

    public LocalDateTime getDateCreate() {
        return Utils.toLocalDateTime(this.dateCreate);
    }
}

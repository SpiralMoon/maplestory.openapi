package dev.spiralmoon.maplestory.api.kms.dto.history;

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
 * 스타포스 히스토리
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class StarforceHistoryDTO {

    /**
     * 스타포스 히스토리 식별자
     */
    @JsonProperty("id")
    private String id;

    /**
     * 강화 시도 결과
     */
    @JsonProperty("item_upgrade_result")
    private String itemUpgradeResult;

    /**
     * 강화 시도 전 스타포스 수치
     */
    @JsonProperty("before_starforce_count")
    private int beforeStarforceCount;

    /**
     * 강화 시도 후 스타포스 수치
     */
    @JsonProperty("after_starforce_count")
    private int afterStarforceCount;

    /**
     * 스타 캐치
     */
    @JsonProperty("starcatch_result")
    private String starCatchResult;

    /**
     * 슈페리얼 장비
     */
    @JsonProperty("superior_item_flag")
    private String superiorItemFlag;

    /**
     * 파괴 방지
     */
    @JsonProperty("destroy_defence")
    private String destroyDefence;

    /**
     * 찬스 타임
     */
    @JsonProperty("chance_time")
    private String chanceTime;

    /**
     * 파괴 방지 필드 이벤트
     */
    @JsonProperty("event_field_flag")
    private String eventFieldFlag;

    /**
     * 사용 주문서 명
     */
    @JsonProperty("upgrade_item")
    private String upgradeItem;

    /**
     * 프로텍트 실드
     */
    @JsonProperty("protect_shield")
    private String protectShield;

    /**
     * 보너스 스탯 부여 아이템 여부
     */
    @JsonProperty("bonus_stat_upgrade")
    private String bonusStatUpgrade;

    /**
     * 캐릭터 명
     */
    @JsonProperty("character_name")
    private String characterName;

    /**
     * 월드 명
     */
    @JsonProperty("world_name")
    private String worldName;

    /**
     * 대상 장비 아이템 명
     */
    @JsonProperty("target_item")
    private String targetItem;

    /**
     * 강화 일시 (KST)
     */
    @JsonProperty("date_create")
    private String dateCreate;

    /**
     * 진행 중인 스타포스 강화 이벤트 정보
     */
    @JsonProperty("starforce_event_list")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<StarforceEventDTO> starforceEventList;

    public ZonedDateTime getDateCreate() {
        return Utils.toZonedDateTime(this.dateCreate);
    }
}

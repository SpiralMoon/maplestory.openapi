package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 연무장 스킬 단위 전투 분석 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeSkillStatisticDTO {

    /**
     * 스킬 명
     */
    @JsonProperty("skill_name")
    private String skillName;

    /**
     * 누적 데미지
     */
    @JsonProperty("damage")
    private Long damage;

    /**
     * 데미지 점유율
     */
    @JsonProperty("damage_percent")
    private String damagePercent;

    /**
     * 초당 평균 데미지
     */
    @JsonProperty("dps")
    private Long dps;

    /**
     * 사용 횟수
     */
    @JsonProperty("use_count")
    private Long useCount;

    /**
     * 1회당 평균 데미지
     */
    @JsonProperty("damage_per_use")
    private Long damagePerUse;

    /**
     * 공격 횟수
     */
    @JsonProperty("attack_count")
    private Long attackCount;

    /**
     * 최대 데미지 (1타)
     */
    @JsonProperty("max_damage")
    private Long maxDamage;

    /**
     * 최소 데미지 (1타)
     */
    @JsonProperty("min_damage")
    private Long minDamage;
}

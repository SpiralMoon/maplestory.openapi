package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 연무장 입장 시 캐릭터 장비 추가 옵션 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterItemAddOptionDTO {

    /**
     * STR
     */
    @JsonProperty("str")
    private String str;

    /**
     * DEX
     */
    @JsonProperty("dex")
    private String dex;

    /**
     * INT
     */
    @JsonProperty("int")
    private String intStat;

    /**
     * LUK
     */
    @JsonProperty("luk")
    private String luk;

    /**
     * 최대 HP
     */
    @JsonProperty("max_hp")
    private String maxHp;

    /**
     * 최대 MP
     */
    @JsonProperty("max_mp")
    private String maxMp;

    /**
     * 공격력
     */
    @JsonProperty("attack_power")
    private String attackPower;

    /**
     * 마력
     */
    @JsonProperty("magic_power")
    private String magicPower;

    /**
     * 방어력
     */
    @JsonProperty("armor")
    private String armor;

    /**
     * 이동속도
     */
    @JsonProperty("speed")
    private String speed;

    /**
     * 점프력
     */
    @JsonProperty("jump")
    private String jump;

    /**
     * 보스 몬스터 데미지 증가 (%)
     */
    @JsonProperty("boss_damage")
    private String bossDamage;

    /**
     * 데미지 (%)
     */
    @JsonProperty("damage")
    private String damage;

    /**
     * 올스탯 (%)
     */
    @JsonProperty("all_stat")
    private String allStat;

    /**
     * 착용 레벨 감소
     */
    @JsonProperty("equipment_level_decrease")
    private Integer equipmentLevelDecrease;
}

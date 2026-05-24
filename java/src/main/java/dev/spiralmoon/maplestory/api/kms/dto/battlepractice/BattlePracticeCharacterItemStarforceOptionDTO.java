package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 연무장 입장 시 캐릭터 장비 스타포스 옵션 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterItemStarforceOptionDTO {

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
}

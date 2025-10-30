package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 캐릭터 장비 특별 옵션 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentExceptionalOptionDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterItemEquipmentExceptionalOptionDTO {
    /**
     * STR
     */
    @JsonProperty("str")
    private String strength;

    /**
     * DEX
     */
    @JsonProperty("dex")
    private String dexterity;

    /**
     * INT
     */
    @JsonProperty("int")
    private String intelligence;

    /**
     * LUK
     */
    @JsonProperty("luk")
    private String luck;

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
     * 익셉셔널 강화 적용 횟수
     */
    @JsonProperty("exceptional_upgrade")
    private int exceptionalUpgrade;
}

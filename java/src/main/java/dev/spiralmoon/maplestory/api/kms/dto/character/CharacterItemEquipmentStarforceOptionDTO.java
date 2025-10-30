package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 캐릭터 장비 스타포스 옵션 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentStarforceOptionDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterItemEquipmentStarforceOptionDTO {

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

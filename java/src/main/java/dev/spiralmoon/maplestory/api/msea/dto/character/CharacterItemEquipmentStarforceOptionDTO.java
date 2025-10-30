package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Equipment Star Force option information
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
     * Max HP
     */
    @JsonProperty("max_hp")
    private String maxHp;

    /**
     * Max MP
     */
    @JsonProperty("max_mp")
    private String maxMp;

    /**
     * Attack Power
     */
    @JsonProperty("attack_power")
    private String attackPower;

    /**
     * Magic ATT
     */
    @JsonProperty("magic_power")
    private String magicPower;

    /**
     * Defense
     */
    @JsonProperty("armor")
    private String armor;

    /**
     * Speed
     */
    @JsonProperty("speed")
    private String speed;

    /**
     * Jump
     */
    @JsonProperty("jump")
    private String jump;
}

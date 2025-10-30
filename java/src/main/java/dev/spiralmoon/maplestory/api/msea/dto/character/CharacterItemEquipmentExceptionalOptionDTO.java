package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Exceptional equipment option information
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
     * Number of exceptional boost applications
     */
    @JsonProperty("exceptional_upgrade")
    private int exceptionalUpgrade;
}

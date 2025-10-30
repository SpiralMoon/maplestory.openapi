package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Final equipment option information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentTotalOptionDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterItemEquipmentTotalOptionDTO {

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

    /**
     * Boss Damage (%)
     */
    @JsonProperty("boss_damage")
    private String bossDamage;

    /**
     * Ignore Enemy Defense (%)
     */
    @JsonProperty("ignore_monster_armor")
    private String ignoreMonsterArmor;

    /**
     * All Stats (%)
     */
    @JsonProperty("all_stat")
    private String allStat;

    /**
     * Damage (%)
     */
    @JsonProperty("damage")
    private String damage;

    /**
     * Equipment level decreases
     */
    @JsonProperty("equipment_level_decrease")
    private Long equipmentLevelDecrease;

    /**
     * Max HP (%)
     */
    @JsonProperty("max_hp_rate")
    private String maxHpRate;

    /**
     * Max MP (%)
     */
    @JsonProperty("max_mp_rate")
    private String maxMpRate;
}

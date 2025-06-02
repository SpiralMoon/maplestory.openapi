package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Final equipment option information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentTotalOptionDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterItemEquipmentTotalOptionDTO {

    /**
     * STR
     */
    @SerializedName("str")
    private String strength;

    /**
     * DEX
     */
    @SerializedName("dex")
    private String dexterity;

    /**
     * INT
     */
    @SerializedName("int")
    private String intelligence;

    /**
     * LUK
     */
    @SerializedName("luk")
    private String luck;

    /**
     * Max HP
     */
    @SerializedName("max_hp")
    private String maxHp;

    /**
     * Max MP
     */
    @SerializedName("max_mp")
    private String maxMp;

    /**
     * Attack Power
     */
    @SerializedName("attack_power")
    private String attackPower;

    /**
     * Magic ATT
     */
    @SerializedName("magic_power")
    private String magicPower;

    /**
     * Defense
     */
    @SerializedName("armor")
    private String armor;

    /**
     * Speed
     */
    @SerializedName("speed")
    private String speed;

    /**
     * Jump
     */
    @SerializedName("jump")
    private String jump;

    /**
     * Boss Damage (%)
     */
    @SerializedName("boss_damage")
    private String bossDamage;

    /**
     * Ignore Enemy Defense (%)
     */
    @SerializedName("ignore_monster_armor")
    private String ignoreMonsterArmor;

    /**
     * All Stats (%)
     */
    @SerializedName("all_stat")
    private String allStat;

    /**
     * Damage (%)
     */
    private String damage;

    /**
     * Equipment level decreases
     */
    @SerializedName("equipment_level_decrease")
    private Long equipmentLevelDecrease;

    /**
     * Max HP (%)
     */
    @SerializedName("max_hp_rate")
    private String maxHpRate;

    /**
     * Max MP (%)
     */
    @SerializedName("max_mp_rate")
    private String maxMpRate;
}

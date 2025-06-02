package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Additional equipment options
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentAddOptionDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterItemEquipmentAddOptionDTO {

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
     * Damage (%)
     */
    private String damage;

    /**
     * All Stats (%)
     */
    @SerializedName("all_stat")
    private String allStat;

    /**
     * Equipment level decrease
     */
    @SerializedName("equipment_level_decrease")
    private Long equipmentLevelDecrease;
}

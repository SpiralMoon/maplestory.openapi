package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Miscellaneous equipment option information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentEtcOptionDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterItemEquipmentEtcOptionDTO {

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
}

package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Symbol information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterSymbolEquipmentInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSymbolEquipmentInfoDTO {

    /**
     * Symbol name
     */
    @SerializedName("symbol_name")
    private String symbolName;

    /**
     * Symbol icon
     */
    @SerializedName("symbol_icon")
    private String symbolIcon;

    /**
     * Symbol description
     */
    @SerializedName("symbol_description")
    private String symbolDescription;

    /**
     * Increase in stats due to the symbol
     */
    @SerializedName("symbol_force")
    private String symbolForce;

    /**
     * Symbol level
     */
    @SerializedName("symbol_level")
    private long symbolLevel;

    /**
     * Increase in Strength due to the symbol
     */
    @SerializedName("symbol_str")
    private String symbolStr;

    /**
     * Increase in Dexterity due to the symbol
     */
    @SerializedName("symbol_dex")
    private String symbolDex;

    /**
     * Increase in Intelligence due to the symbol
     */
    @SerializedName("symbol_int")
    private String symbolInt;

    /**
     * Increase in Luck due to the symbol
     */
    @SerializedName("symbol_luk")
    private String symbolLuk;

    /**
     * Increase in HP due to the symbol
     */
    @SerializedName("symbol_hp")
    private String symbolHp;

    /**
     * Increase in item drop rate due to the symbol
     */
    @SerializedName("symbol_drop_rate")
    private String symbolDropRate;

    /**
     * Increase in Meso acquisition rate due to the symbol
     */
    @SerializedName("symbol_meso_rate")
    private String symbolMesoRate;

    /**
     * Increase in EXP acquisition rate due to the symbol
     */
    @SerializedName("symbol_exp_rate")
    private String symbolExpRate;

    /**
     * Current growth points
     */
    @SerializedName("symbol_growth_count")
    private long symbolGrowthCount;

    /**
     * Growth points required for the next level
     */
    @SerializedName("symbol_require_growth_count")
    private long symbolRequireGrowthCount;

    /**
     * Increase in item drop rate due to the symbol
     */
    public String getSymbolDropRate() {
        return symbolDropRate != null
                ? symbolDropRate
                : "0%";
    }

    /**
     * Increase in Meso acquisition rate due to the symbol
     */
    public String getSymbolMesoRate() {
        return symbolMesoRate != null
                ? symbolMesoRate
                : "0%";
    }

    /**
     * Increase in EXP acquisition rate due to the symbol
     */
    public String getSymbolExpRate() {
        return symbolExpRate != null
                ? symbolExpRate
                : "0%";
    }
}

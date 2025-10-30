package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Symbol information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterSymbolEquipmentInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSymbolEquipmentInfoDTO {

    /**
     * Symbol name
     */
    @JsonProperty("symbol_name")
    private String symbolName;

    /**
     * Symbol icon
     */
    @JsonProperty("symbol_icon")
    private String symbolIcon;

    /**
     * Symbol description
     */
    @JsonProperty("symbol_description")
    private String symbolDescription;

    /**
     * Increase in stats due to the symbol
     */
    @JsonProperty("symbol_force")
    private String symbolForce;

    /**
     * Symbol level
     */
    @JsonProperty("symbol_level")
    private long symbolLevel;

    /**
     * Increase in Strength due to the symbol
     */
    @JsonProperty("symbol_str")
    private String symbolStr;

    /**
     * Increase in Dexterity due to the symbol
     */
    @JsonProperty("symbol_dex")
    private String symbolDex;

    /**
     * Increase in Intelligence due to the symbol
     */
    @JsonProperty("symbol_int")
    private String symbolInt;

    /**
     * Increase in Luck due to the symbol
     */
    @JsonProperty("symbol_luk")
    private String symbolLuk;

    /**
     * Increase in HP due to the symbol
     */
    @JsonProperty("symbol_hp")
    private String symbolHp;

    /**
     * Increase in item drop rate due to the symbol
     */
    @JsonProperty("symbol_drop_rate")
    private String symbolDropRate;

    /**
     * Increase in Meso acquisition rate due to the symbol
     */
    @JsonProperty("symbol_meso_rate")
    private String symbolMesoRate;

    /**
     * Increase in EXP acquisition rate due to the symbol
     */
    @JsonProperty("symbol_exp_rate")
    private String symbolExpRate;

    /**
     * Current growth points
     */
    @JsonProperty("symbol_growth_count")
    private long symbolGrowthCount;

    /**
     * Growth points required for the next level
     */
    @JsonProperty("symbol_require_growth_count")
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

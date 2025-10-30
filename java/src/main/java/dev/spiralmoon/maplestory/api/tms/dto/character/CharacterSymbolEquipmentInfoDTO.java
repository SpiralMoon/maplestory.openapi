package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 符文資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterSymbolEquipmentInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSymbolEquipmentInfoDTO {

    /**
     * 符文名稱
     */
    @JsonProperty("symbol_name")
    private String symbolName;

    /**
     * 符文圖示
     */
    @JsonProperty("symbol_icon")
    private String symbolIcon;

    /**
     * 符文描述
     */
    @JsonProperty("symbol_description")
    private String symbolDescription;

    /**
     * 因符文增加的數值
     */
    @JsonProperty("symbol_force")
    private String symbolForce;

    /**
     * 符文等級
     */
    @JsonProperty("symbol_level")
    private long symbolLevel;

    /**
     * 符文增加的力量 (STR)
     */
    @JsonProperty("symbol_str")
    private String symbolStr;

    /**
     * 符文增加的敏捷 (DEX)
     */
    @JsonProperty("symbol_dex")
    private String symbolDex;

    /**
     * 符文增加的智力 (INT)
     */
    @JsonProperty("symbol_int")
    private String symbolInt;

    /**
     * 符文增加的幸運 (LUK)
     */
    @JsonProperty("symbol_luk")
    private String symbolLuk;

    /**
     * 符文增加的體力 (HP)
     */
    @JsonProperty("symbol_hp")
    private String symbolHp;

    /**
     * 符文增加的道具掉落率
     */
    @JsonProperty("symbol_drop_rate")
    private String symbolDropRate;

    /**
     * 符文增加的楓幣掉落率
     */
    @JsonProperty("symbol_meso_rate")
    private String symbolMesoRate;

    /**
     * 符文增加的經驗值獲得量
     */
    @JsonProperty("symbol_exp_rate")
    private String symbolExpRate;

    /**
     * 現有成長值
     */
    @JsonProperty("symbol_growth_count")
    private long symbolGrowthCount;

    /**
     * 成長所需的成長值
     */
    @JsonProperty("symbol_require_growth_count")
    private long symbolRequireGrowthCount;

    /**
     * 符文增加的道具掉落率
     */
    public String getSymbolDropRate() {
        return symbolDropRate != null
                ? symbolDropRate
                : "0%";
    }

    /**
     * 符文增加的楓幣掉落率
     */
    public String getSymbolMesoRate() {
        return symbolMesoRate != null
                ? symbolMesoRate
                : "0%";
    }

    /**
     * 符文增加的經驗值獲得量
     */
    public String getSymbolExpRate() {
        return symbolExpRate != null
                ? symbolExpRate
                : "0%";
    }
}

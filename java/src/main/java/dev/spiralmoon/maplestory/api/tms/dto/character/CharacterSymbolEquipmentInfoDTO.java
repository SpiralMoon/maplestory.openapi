package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 符文資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterSymbolEquipmentInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSymbolEquipmentInfoDTO {

    /**
     * 符文名稱
     */
    @SerializedName("symbol_name")
    private String symbolName;

    /**
     * 符文圖示
     */
    @SerializedName("symbol_icon")
    private String symbolIcon;

    /**
     * 符文描述
     */
    @SerializedName("symbol_description")
    private String symbolDescription;

    /**
     * 因符文增加的數值
     */
    @SerializedName("symbol_force")
    private String symbolForce;

    /**
     * 符文等級
     */
    @SerializedName("symbol_level")
    private long symbolLevel;

    /**
     * 符文增加的力量 (STR)
     */
    @SerializedName("symbol_str")
    private String symbolStr;

    /**
     * 符文增加的敏捷 (DEX)
     */
    @SerializedName("symbol_dex")
    private String symbolDex;

    /**
     * 符文增加的智力 (INT)
     */
    @SerializedName("symbol_int")
    private String symbolInt;

    /**
     * 符文增加的幸運 (LUK)
     */
    @SerializedName("symbol_luk")
    private String symbolLuk;

    /**
     * 符文增加的體力 (HP)
     */
    @SerializedName("symbol_hp")
    private String symbolHp;

    /**
     * 符文增加的道具掉落率
     */
    @SerializedName("symbol_drop_rate")
    private String symbolDropRate;

    /**
     * 符文增加的楓幣掉落率
     */
    @SerializedName("symbol_meso_rate")
    private String symbolMesoRate;

    /**
     * 符文增加的經驗值獲得量
     */
    @SerializedName("symbol_exp_rate")
    private String symbolExpRate;

    /**
     * 現有成長值
     */
    @SerializedName("symbol_growth_count")
    private long symbolGrowthCount;

    /**
     * 成長所需的成長值
     */
    @SerializedName("symbol_require_growth_count")
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

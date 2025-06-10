package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 캐릭터 심볼 상세 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterSymbolEquipmentInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSymbolEquipmentInfoDTO {

    /**
     * 심볼 명
     */
    @SerializedName("symbol_name")
    private String symbolName;

    /**
     * 심볼 아이콘
     */
    @SerializedName("symbol_icon")
    private String symbolIcon;

    /**
     * 심볼 설명
     */
    @SerializedName("symbol_description")
    private String symbolDescription;

    /**
     * 심볼로 인한 증가 수치
     */
    @SerializedName("symbol_force")
    private String symbolForce;

    /**
     * 심볼 레벨
     */
    @SerializedName("symbol_level")
    private long symbolLevel;

    /**
     * 심볼로 증가한 힘
     */
    @SerializedName("symbol_str")
    private String symbolStr;

    /**
     * 심볼로 증가한 민첩
     */
    @SerializedName("symbol_dex")
    private String symbolDex;

    /**
     * 심볼로 증가한 지력
     */
    @SerializedName("symbol_int")
    private String symbolInt;

    /**
     * 심볼로 증가한 운
     */
    @SerializedName("symbol_luk")
    private String symbolLuk;

    /**
     * 심볼로 증가한 체력
     */
    @SerializedName("symbol_hp")
    private String symbolHp;

    /**
     * 심볼로 증가한 아이템 드롭률
     */
    @SerializedName("symbol_drop_rate")
    private String symbolDropRate;

    /**
     * 심볼로 증가한 메소 획득량
     */
    @SerializedName("symbol_meso_rate")
    private String symbolMesoRate;

    /**
     * 심볼로 증가한 경험치 획득량
     */
    @SerializedName("symbol_exp_rate")
    private String symbolExpRate;

    /**
     * 현재 보유 성장치
     */
    @SerializedName("symbol_growth_count")
    private long symbolGrowthCount;

    /**
     * 성장 시 필요한 성장치
     */
    @SerializedName("symbol_require_growth_count")
    private long symbolRequireGrowthCount;

    /**
     * 심볼로 증가한 아이템 드롭률
     */
    public String getDropRate() {
        return symbolDropRate != null
                ? symbolDropRate
                : "0%";
    }

    /**
     * 심볼로 증가한 메소 획득량
     */
    public String getMesoRate() {
        return symbolMesoRate != null
                ? symbolMesoRate
                : "0%";
    }

    /**
     * 심볼로 증가한 경험치 획득량
     */
    public String getExpRate() {
        return symbolExpRate != null
                ? symbolExpRate
                : "0%";
    }
}

package dev.spiralmoon.maplestory.api.dto;

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
public class CharacterSymbolEquipmentInfoDTO {

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
     * 현재 보유 성장치
     */
    @SerializedName("symbol_growth_count")
    private long symbolGrowthCount;

    /**
     * 성장 시 필요한 성장치
     */
    @SerializedName("symbol_require_growth_count")
    private long symbolRequireGrowthCount;
}

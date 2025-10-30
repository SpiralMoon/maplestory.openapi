package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 캐릭터 심볼 상세 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterSymbolEquipmentInfoDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSymbolEquipmentInfoDTO {

    /**
     * 심볼 명
     */
    @JsonProperty("symbol_name")
    private String symbolName;

    /**
     * 심볼 아이콘
     */
    @JsonProperty("symbol_icon")
    private String symbolIcon;

    /**
     * 심볼 설명
     */
    @JsonProperty("symbol_description")
    private String symbolDescription;

    /**
     * 심볼로 인한 증가 수치
     */
    @JsonProperty("symbol_force")
    private String symbolForce;

    /**
     * 심볼 레벨
     */
    @JsonProperty("symbol_level")
    private long symbolLevel;

    /**
     * 심볼로 증가한 힘
     */
    @JsonProperty("symbol_str")
    private String symbolStr;

    /**
     * 심볼로 증가한 민첩
     */
    @JsonProperty("symbol_dex")
    private String symbolDex;

    /**
     * 심볼로 증가한 지력
     */
    @JsonProperty("symbol_int")
    private String symbolInt;

    /**
     * 심볼로 증가한 운
     */
    @JsonProperty("symbol_luk")
    private String symbolLuk;

    /**
     * 심볼로 증가한 체력
     */
    @JsonProperty("symbol_hp")
    private String symbolHp;

    /**
     * 심볼로 증가한 아이템 드롭률
     */
    @JsonProperty("symbol_drop_rate")
    private String symbolDropRate;

    /**
     * 심볼로 증가한 메소 획득량
     */
    @JsonProperty("symbol_meso_rate")
    private String symbolMesoRate;

    /**
     * 심볼로 증가한 경험치 획득량
     */
    @JsonProperty("symbol_exp_rate")
    private String symbolExpRate;

    /**
     * 현재 보유 성장치
     */
    @JsonProperty("symbol_growth_count")
    private long symbolGrowthCount;

    /**
     * 성장 시 필요한 성장치
     */
    @JsonProperty("symbol_require_growth_count")
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

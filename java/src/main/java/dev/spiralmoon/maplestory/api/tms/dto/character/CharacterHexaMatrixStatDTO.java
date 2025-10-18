package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 角色設定於 HEXA 矩陣中的 HEXA 屬性資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterHexaMatrixStatDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHexaMatrixStatDTO<CharacterHexaMatrixStatCoreDTO> {

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    @SerializedName("date")
    private String date;

    /**
     * 角色職業
     */
    @SerializedName("character_class")
    private String characterClass;

    /**
     * HEXA 屬性 I 核心資訊
     */
    @SerializedName("character_hexa_stat_core")
    private List<CharacterHexaMatrixStatCoreDTO> characterHexaStatCore;

    /**
     * HEXA 屬性 II 核心資訊
     */
    @SerializedName("character_hexa_stat_core_2")
    private List<CharacterHexaMatrixStatCoreDTO> characterHexaStatCore2;

    /**
     * HEXA 屬性 III 核心資訊
     */
    @SerializedName("character_hexa_stat_core_3")
    private List<CharacterHexaMatrixStatCoreDTO> characterHexaStatCore3;

    /**
     * 預設的 HEXA 屬性 I 核心資訊
     */
    @SerializedName("preset_hexa_stat_core")
    private List<CharacterHexaMatrixStatCoreDTO> presetHexaStatCore;

    /**
     * 預設的 HEXA 屬性 II 核心資訊
     */
    @SerializedName("preset_hexa_stat_core_2")
    private List<CharacterHexaMatrixStatCoreDTO> presetHexaStatCore2;

    /**
     * 預設的 HEXA 屬性 III 核心資訊
     */
    @SerializedName("preset_hexa_stat_core_3")
    private List<CharacterHexaMatrixStatCoreDTO> presetHexaStatCore3;

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}

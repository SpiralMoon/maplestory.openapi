package dev.spiralmoon.maplestory.api.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 캐릭터 HEXA 스탯 코어 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterHexaMatrixStatDTO {

    /**
     * 조회 기준일 (KST)
     */
    @SerializedName("date")
    private String date;

    /**
     * 캐릭터 직업
     */
    @SerializedName("character_class")
    private String characterClass;

    /**
     * HEXA 스탯 I 코어 정보
     */
    @SerializedName("character_hexa_stat_core")
    private List<CharacterHexaMatrixStatCoreDTO> characterHexaStatCore;

    /**
     * HEXA 스탯 II 코어 정보
     */
    @SerializedName("character_hexa_stat_core_2")
    private List<CharacterHexaMatrixStatCoreDTO> characterHexaStatCore2;

    /**
     * HEXA 스탯 III 코어 정보
     */
    @SerializedName("character_hexa_stat_core_3")
    private List<CharacterHexaMatrixStatCoreDTO> characterHexaStatCore3;

    /**
     * 프리셋 HEXA 스탯 I 코어 정보
     */
    @SerializedName("preset_hexa_stat_core")
    private List<CharacterHexaMatrixStatCoreDTO> presetHexaStatCore;

    /**
     * 프리셋 HEXA 스탯 II 코어 정보
     */
    @SerializedName("preset_hexa_stat_core_2")
    private List<CharacterHexaMatrixStatCoreDTO> presetHexaStatCore2;

    /**
     * 프리셋 HEXA 스탯 III 코어 정보
     */
    @SerializedName("preset_hexa_stat_core_3")
    private List<CharacterHexaMatrixStatCoreDTO> presetHexaStatCore3;

    public LocalDateTime getDate() {
        return date != null
                ? Utils.toLocalDateTime(this.date)
                : null;
    }
}

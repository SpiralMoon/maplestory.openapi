package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 캐릭터 HEXA 스탯 코어 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterHexaMatrixStatDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHexaMatrixStatDTO<
        CharacterHexaMatrixStatCoreDTO> {

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
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

    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}

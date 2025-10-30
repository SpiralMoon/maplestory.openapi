package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 캐릭터 HEXA 스탯 코어 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterHexaMatrixStatDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHexaMatrixStatDTO<
        CharacterHexaMatrixStatCoreDTO> {

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @JsonProperty("date")
    private String date;

    /**
     * 캐릭터 직업
     */
    @JsonProperty("character_class")
    private String characterClass;

    /**
     * HEXA 스탯 I 코어 정보
     */
    @JsonProperty("character_hexa_stat_core")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterHexaMatrixStatCoreDTO> characterHexaStatCore;

    /**
     * HEXA 스탯 II 코어 정보
     */
    @JsonProperty("character_hexa_stat_core_2")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterHexaMatrixStatCoreDTO> characterHexaStatCore2;

    /**
     * HEXA 스탯 III 코어 정보
     */
    @JsonProperty("character_hexa_stat_core_3")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterHexaMatrixStatCoreDTO> characterHexaStatCore3;

    /**
     * 프리셋 HEXA 스탯 I 코어 정보
     */
    @JsonProperty("preset_hexa_stat_core")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterHexaMatrixStatCoreDTO> presetHexaStatCore;

    /**
     * 프리셋 HEXA 스탯 II 코어 정보
     */
    @JsonProperty("preset_hexa_stat_core_2")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterHexaMatrixStatCoreDTO> presetHexaStatCore2;

    /**
     * 프리셋 HEXA 스탯 III 코어 정보
     */
    @JsonProperty("preset_hexa_stat_core_3")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterHexaMatrixStatCoreDTO> presetHexaStatCore3;

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}

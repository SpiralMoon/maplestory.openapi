package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 연무장 입장 시 캐릭터 HEXA 스탯 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterHexaMatrixStatObjectDTO {

    /**
     * HEXA 스탯 I 코어 정보
     */
    @JsonProperty("character_hexa_stat_core")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<BattlePracticeCharacterHexaStatCoreDTO> characterHexaStatCore;

    /**
     * HEXA 스탯 II 코어 정보
     */
    @JsonProperty("character_hexa_stat_core_2")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<BattlePracticeCharacterHexaStatCoreDTO> characterHexaStatCore2;

    /**
     * HEXA 스탯 III 코어 정보
     */
    @JsonProperty("character_hexa_stat_core_3")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<BattlePracticeCharacterHexaStatCoreDTO> characterHexaStatCore3;
}

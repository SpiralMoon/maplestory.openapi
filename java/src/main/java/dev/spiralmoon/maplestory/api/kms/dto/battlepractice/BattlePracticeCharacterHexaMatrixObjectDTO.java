package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 연무장 입장 시 캐릭터 HEXA 매트릭스 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterHexaMatrixObjectDTO {

    /**
     * HEXA 코어 정보
     */
    @JsonProperty("hexa_core_object")
    private BattlePracticeCharacterHexaCoreObjectDTO hexaCoreObject;

    /**
     * HEXA 스탯 정보
     */
    @JsonProperty("hexa_matrix_stat_object")
    private BattlePracticeCharacterHexaMatrixStatObjectDTO hexaMatrixStatObject;
}

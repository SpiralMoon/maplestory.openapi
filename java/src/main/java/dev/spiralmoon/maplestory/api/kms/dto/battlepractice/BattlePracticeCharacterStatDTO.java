package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 연무장 입장 시 캐릭터 스탯 관련 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterStatDTO {

    /**
     * 스탯 정보
     */
    @JsonProperty("basic_stat_object")
    private BattlePracticeCharacterBasicStatDTO basicStatObject;

    /**
     * 장착 심볼 정보
     */
    @JsonProperty("symbol_stat_object")
    private BattlePracticeCharacterSymbolStatDTO symbolStatObject;

    /**
     * 기타 능력치 영향 요소
     */
    @JsonProperty("other_stat_object")
    private BattlePracticeCharacterOtherStatDTO otherStatObject;
}

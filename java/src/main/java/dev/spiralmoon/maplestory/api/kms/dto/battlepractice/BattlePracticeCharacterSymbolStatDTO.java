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
 * 연무장 입장 시 캐릭터 장착 심볼 스탯 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterSymbolStatDTO {

    /**
     * 심볼 정보
     */
    @JsonProperty("symbol")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<BattlePracticeCharacterSymbolDTO> symbol;
}

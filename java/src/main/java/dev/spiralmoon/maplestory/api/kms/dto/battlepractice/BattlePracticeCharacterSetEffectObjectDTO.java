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
 * 연무장 입장 시 캐릭터 적용 세트 효과 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterSetEffectObjectDTO {

    /**
     * 세트 효과 정보
     */
    @JsonProperty("set_effect")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<BattlePracticeCharacterSetEffectDTO> setEffect;
}

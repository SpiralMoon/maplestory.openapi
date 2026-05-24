package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 연무장 입장 시 캐릭터 적용 중인 세트 효과 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterSetEffectInfoDTO {

    /**
     * 세트 효과 레벨 (장비 수)
     */
    @JsonProperty("set_count")
    private Integer setCount;

    /**
     * 세트 효과
     */
    @JsonProperty("set_option")
    private String setOption;
}

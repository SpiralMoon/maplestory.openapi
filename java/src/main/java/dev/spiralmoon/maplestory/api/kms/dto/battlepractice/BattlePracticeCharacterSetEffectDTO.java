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
 * 연무장 입장 시 캐릭터 세트 효과 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterSetEffectDTO {

    /**
     * 세트 효과 명
     */
    @JsonProperty("set_name")
    private String setName;

    /**
     * 세트 개수 (럭키 아이템 포함)
     */
    @JsonProperty("total_set_count")
    private Integer totalSetCount;

    /**
     * 적용 중인 세트 효과 정보
     */
    @JsonProperty("set_effect_info")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<BattlePracticeCharacterSetEffectInfoDTO> setEffectInfo;
}

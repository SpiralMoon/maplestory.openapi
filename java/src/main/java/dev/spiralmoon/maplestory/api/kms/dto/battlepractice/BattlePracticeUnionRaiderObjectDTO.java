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
 * 연무장 입장 시 유니온 공격대 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeUnionRaiderObjectDTO {

    /**
     * 유니온 공격대원 효과
     */
    @JsonProperty("union_raider_stat")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<String> unionRaiderStat;

    /**
     * 유니온 공격대 점령 효과
     */
    @JsonProperty("union_occupied_stat")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<String> unionOccupiedStat;
}

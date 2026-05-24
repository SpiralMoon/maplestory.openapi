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
 * 연무장 입장 시 유니온 챔피언 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeUnionChampionObjectDTO {

    /**
     * 유니온 챔피언 휘장
     */
    @JsonProperty("champion_badge_total_info")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<BattlePracticeUnionChampionBadgeDTO> championBadgeTotalInfo;
}

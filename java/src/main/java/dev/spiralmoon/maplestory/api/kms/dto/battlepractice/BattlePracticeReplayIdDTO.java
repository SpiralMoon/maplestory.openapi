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
 * 연무장 리플레이 식별자 목록
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeReplayIdDTO {

    /**
     * 리플레이 목록
     */
    @JsonProperty("replay_list")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<BattlePracticeReplayIdInfoDTO> replayList;
}

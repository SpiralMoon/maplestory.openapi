package dev.spiralmoon.maplestory.api.kms.dto.history;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 잠재능력 재설정 히스토리 응답 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PotentialHistoryResponseDTO {

    /**
     * 결과 건 수
     */
    @JsonProperty("count")
    private int count;

    /**
     * 잠재능력 재설정 히스토리
     */
    @JsonProperty("potential_history")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<PotentialHistoryDTO> potentialHistory;

    /**
     * 페이징 처리를 위한 cursor
     */
    @JsonProperty("next_cursor")
    private String nextCursor;
}

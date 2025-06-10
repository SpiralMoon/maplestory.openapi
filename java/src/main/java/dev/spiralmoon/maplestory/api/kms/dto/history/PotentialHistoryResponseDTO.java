package dev.spiralmoon.maplestory.api.kms.dto.history;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 잠재능력 재설정 히스토리 응답 정보
 */
@AllArgsConstructor
@Data
@ToString
public class PotentialHistoryResponseDTO {

    /**
     * 결과 건 수
     */
    @SerializedName("count")
    private int count;

    /**
     * 잠재능력 재설정 히스토리
     */
    @SerializedName("potential_history")
    private List<PotentialHistoryDTO> potentialHistory;

    /**
     * 페이징 처리를 위한 cursor
     */
    @SerializedName("next_cursor")
    private String nextCursor;
}

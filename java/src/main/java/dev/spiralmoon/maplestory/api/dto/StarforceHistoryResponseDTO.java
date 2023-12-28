package dev.spiralmoon.maplestory.api.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 스타포스 히스토리 응답 정보
 */
@AllArgsConstructor
@Data
@ToString
public class StarforceHistoryResponseDTO {

    /**
     * 결과 건 수
     */
    @SerializedName("count")
    private int count;

    /**
     * 스타포스 히스토리
     */
    @SerializedName("starforce_history")
    private List<StarforceHistoryDTO> starforceHistory;

    /**
     * 페이징 처리를 위한 cursor
     */
    @SerializedName("next_cursor")
    private String nextCursor;
}

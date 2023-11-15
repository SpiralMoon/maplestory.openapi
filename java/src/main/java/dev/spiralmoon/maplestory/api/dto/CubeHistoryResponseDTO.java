package dev.spiralmoon.maplestory.api.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 큐브히스토리 응답 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CubeHistoryResponseDTO {

    /**
     * 결과 건 수
     */
    @SerializedName("count")
    private int count;

    /**
     * 큐브 히스토리
     */
    @SerializedName("cube_histories")
    private List<CubeHistoryDTO> cubeHistories;

    /**
     * 페이징 처리를 위한 cursor
     */
    @SerializedName("next_cursor")
    private String nextCursor;
}

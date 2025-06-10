package dev.spiralmoon.maplestory.api.common.param;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * API 서버의 데이터 갱신 시각과 조회 가능한 최근 날짜와 현재 날짜와의 차이
 */
@AllArgsConstructor
@Data
public class LatestApiUpdateTimeOption {
    private int hour;
    private int minute;
    private Integer dateOffset;
}

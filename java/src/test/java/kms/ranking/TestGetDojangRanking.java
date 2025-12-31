package kms.ranking;

import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.ranking.DojangRankingResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getDojangRanking")
public class TestGetDojangRanking {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ocid = "e0a4f439e53c369866b55297d2f5f4eb";

    @Test
    @DisplayName("success: getDojangRanking")
    void getDojangRanking() {
        DojangRankingResponseDTO response = api.getDojangRanking(null, 0, null, null, null).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getDojangRanking with paging")
    void getDojangRanking_with_paging() {
        DojangRankingResponseDTO response = api.getDojangRanking(null, 1, null, null, 2).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getDojangRanking with ocid")
    void getDojangRanking_with_ocid() {
        DojangRankingResponseDTO response = api.getDojangRanking(null, 1, null, ocid, null).join();
        assertThat(response.getRanking()).hasSizeGreaterThanOrEqualTo(0);
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getDojangRanking with world name")
    void getDojangRanking_with_world_name() {
        DojangRankingResponseDTO response = api.getDojangRanking("스카니아", 1, null, null, null).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getDojangRanking with specific job")
    void getDojangRanking_with_specific_job() {
        DojangRankingResponseDTO response = api.getDojangRanking(null, 1, "전사-히어로", null, null).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getDojangRanking with date")
    void getDojangRanking_with_date() {
        LocalDateTime date = LocalDateTime.of(2025, 1, 1, 0, 0);
        DojangRankingResponseDTO response = api.getDojangRanking(null, 1, null, null, null, date).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("fail: getDojangRanking with invalid date")
    void getDojangRanking_with_invalid_date() {
        LocalDateTime invalidDate = LocalDateTime.of(2023, 12, 21, 0, 0);
        assertThatThrownBy(() -> api.getDojangRanking(null, 1, null, null, null, invalidDate).join())
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .satisfies(e -> {
                    Throwable error = e.getCause();
                    assertThat(error.getMessage()).contains("You can only retrieve data after 2023-12-22.");
                    System.out.println(error.getMessage());
                });
    }

    @Test
    @DisplayName("fail: getDojangRanking with invalid ocid throw OPENAPI00003")
    void getDojangRanking_with_invalid_ocid_throw_OPENAPI00003() {
        final String invalidOcid = "invalid_ocid_123";
        assertThatThrownBy(() -> api.getDojangRanking(null, 1, null, invalidOcid, null).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00003);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }
}

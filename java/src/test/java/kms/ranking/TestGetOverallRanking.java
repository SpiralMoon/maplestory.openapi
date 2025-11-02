package kms.ranking;

import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.ranking.OverallRankingResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getOverallRanking")
public class TestGetOverallRanking {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ocid = "e0a4f439e53c369866b55297d2f5f4eb";

    @Test
    @DisplayName("success: getOverallRanking")
    void getOverallRanking() {
        OverallRankingResponseDTO response = api.getOverallRanking(null, null, null, null, null).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getOverallRanking with paging")
    void getOverallRanking_with_paging() {
        OverallRankingResponseDTO response = api.getOverallRanking(null, null, null, null, 2).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getOverallRanking with ocid")
    void getOverallRanking_with_ocid() {
        OverallRankingResponseDTO response = api.getOverallRanking(null, null, null, ocid, null).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getOverallRanking with specific job")
    void getOverallRanking_with_specific_job() {
        OverallRankingResponseDTO response = api.getOverallRanking(null, null, "전사-히어로", null, null).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getOverallRanking with job group")
    void getOverallRanking_with_job_group() {
        OverallRankingResponseDTO response = api.getOverallRanking(null, null, "전사-전체 전직", null, null).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getOverallRanking with world name")
    void getOverallRanking_with_world_name() {
        OverallRankingResponseDTO response = api.getOverallRanking("스카니아", null, null, null, null).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getOverallRanking with world type")
    void getOverallRanking_with_world_type() {
        OverallRankingResponseDTO response = api.getOverallRanking(null, 0, null, null, null).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getOverallRanking with world and job")
    void getOverallRanking_with_world_and_job() {
        OverallRankingResponseDTO response = api.getOverallRanking("스카니아", null, "아델-전체 전직", null, null).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getOverallRanking with date")
    void getOverallRanking_with_date() {
        LocalDateTime date = LocalDateTime.of(2023, 12, 23, 0, 0);
        OverallRankingResponseDTO response = api.getOverallRanking(null, null, null, null, null, date).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("fail: getOverallRanking with invalid date")
    void getOverallRanking_with_invalid_date() {
        LocalDateTime invalidDate = LocalDateTime.of(2023, 12, 20, 0, 0);
        assertThatThrownBy(() -> api.getOverallRanking(null, null, null, null, null, invalidDate).join())
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .satisfies(e -> {
                    Throwable error = e.getCause();
                    assertThat(error.getMessage()).contains("You can only retrieve data after 2023-12-22.");
                    System.out.println(error.getMessage());
                });
    }

    @Test
    @DisplayName("fail: getOverallRanking with invalid ocid throw OPENAPI00003")
    void getOverallRanking_with_invalid_ocid_throw_OPENAPI00003() {
        String invalidOcid = "invalid_ocid_123";
        assertThatThrownBy(() -> api.getOverallRanking(null, null, null, invalidOcid, null).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00003);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }
}

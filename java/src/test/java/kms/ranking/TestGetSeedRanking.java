package kms.ranking;

import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.ranking.TheSeedRankingResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getSeedRanking")
public class TestGetSeedRanking {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ocid = "e0a4f439e53c369866b55297d2f5f4eb";

    @Test
    @DisplayName("success: getSeedRanking")
    void getSeedRanking() {
        TheSeedRankingResponseDTO response = api.getTheSeedRanking(null, null, null).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getSeedRanking with paging")
    void getSeedRanking_with_paging() {
        TheSeedRankingResponseDTO response = api.getTheSeedRanking(null, null, 2).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getSeedRanking with ocid")
    void getSeedRanking_with_ocid() {
        TheSeedRankingResponseDTO response = api.getTheSeedRanking(null, ocid, null).join();
        assertThat(response.getRanking()).hasSizeGreaterThanOrEqualTo(0);
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getSeedRanking with world name")
    void getSeedRanking_with_world_name() {
        TheSeedRankingResponseDTO response = api.getTheSeedRanking("스카니아", null, null).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getSeedRanking with date")
    void getSeedRanking_with_date() {
        LocalDateTime date = LocalDateTime.of(2023, 12, 23, 0, 0);
        TheSeedRankingResponseDTO response = api.getTheSeedRanking(null, null, null, date).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("fail: getSeedRanking with invalid date")
    void getSeedRanking_with_invalid_date() {
        LocalDateTime invalidDate = LocalDateTime.of(2023, 12, 21, 0, 0);
        assertThatThrownBy(() -> api.getTheSeedRanking(null, null, null, invalidDate).join())
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .satisfies(e -> {
                    Throwable error = e.getCause();
                    assertThat(error.getMessage()).contains("You can only retrieve data after 2023-12-22.");
                    System.out.println(error.getMessage());
                });
    }

    @Test
    @DisplayName("fail: getSeedRanking with invalid ocid throw OPENAPI00003")
    void getSeedRanking_with_invalid_ocid_throw_OPENAPI00003() {
        final String invalidOcid = "invalid_ocid_123";
        assertThatThrownBy(() -> api.getTheSeedRanking(null, invalidOcid, null).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00003);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }
}

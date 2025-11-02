package kms.ranking;

import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.ranking.AchievementRankingResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getAchievementRanking")
public class TestGetAchievementRanking {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ocid = "e0a4f439e53c369866b55297d2f5f4eb";

    @Test
    @DisplayName("success: getAchievementRanking")
    void getAchievementRanking() {
        AchievementRankingResponseDTO response = api.getAchievementRanking(null, null).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getAchievementRanking with paging")
    void getAchievementRanking_with_paging() {
        AchievementRankingResponseDTO response = api.getAchievementRanking(null, 2).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getAchievementRanking with ocid")
    void getAchievementRanking_with_ocid() {
        AchievementRankingResponseDTO response = api.getAchievementRanking(ocid, null).join();
        assertThat(response.getRanking()).hasSizeGreaterThanOrEqualTo(0);
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getAchievementRanking with date")
    void getAchievementRanking_with_date() {
        LocalDateTime date = LocalDateTime.of(2023, 12, 23, 0, 0);
        AchievementRankingResponseDTO response = api.getAchievementRanking(null, null, date).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("fail: getAchievementRanking with invalid date")
    void getAchievementRanking_with_invalid_date() {
        LocalDateTime invalidDate = LocalDateTime.of(2023, 12, 21, 0, 0);
        assertThatThrownBy(() -> api.getAchievementRanking(null, null, invalidDate).join())
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .satisfies(e -> {
                    Throwable error = e.getCause();
                    assertThat(error.getMessage()).contains("You can only retrieve data after 2023-12-22.");
                    System.out.println(error.getMessage());
                });
    }

    @Test
    @DisplayName("fail: getAchievementRanking with invalid ocid throw OPENAPI00003")
    void getAchievementRanking_with_invalid_ocid_throw_OPENAPI00003() {
        final String invalidOcid = "invalid_ocid_123";
        assertThatThrownBy(() -> api.getAchievementRanking(invalidOcid, null).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00003);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }
}

package kms.ranking;

import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.ranking.UnionRankingResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getUnionRanking")
public class TestGetUnionRanking {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ocid = "e0a4f439e53c369866b55297d2f5f4eb";

    @Test
    @DisplayName("success: getUnionRanking")
    void getUnionRanking() {
        UnionRankingResponseDTO response = api.getUnionRanking(null, null, null).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getUnionRanking with paging")
    void getUnionRanking_with_paging() {
        UnionRankingResponseDTO response = api.getUnionRanking(null, null, 2).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getUnionRanking with ocid")
    void getUnionRanking_with_ocid() {
        UnionRankingResponseDTO response = api.getUnionRanking(null, ocid, null).join();
        assertThat(response.getRanking()).hasSize(1);
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getUnionRanking with world name")
    void getUnionRanking_with_world_name() {
        UnionRankingResponseDTO response = api.getUnionRanking("스카니아", null, null).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getUnionRanking with date")
    void getUnionRanking_with_date() {
        LocalDateTime date = LocalDateTime.of(2023, 12, 23, 0, 0);
        UnionRankingResponseDTO response = api.getUnionRanking(null, null, null, date).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("fail: getUnionRanking with invalid date")
    void getUnionRanking_with_invalid_date() {
        LocalDateTime invalidDate = LocalDateTime.of(2023, 12, 21, 0, 0);
        assertThatThrownBy(() -> api.getUnionRanking(null, null, null, invalidDate).join())
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .satisfies(e -> {
                    Throwable error = e.getCause();
                    assertThat(error.getMessage()).contains("You can only retrieve data after 2023-12-22.");
                    System.out.println(error.getMessage());
                });
    }

    @Test
    @DisplayName("fail: getUnionRanking with invalid ocid throw OPENAPI00003")
    void getUnionRanking_with_invalid_ocid_throw_OPENAPI00003() {
        String invalidOcid = "invalid_ocid_123";
        assertThatThrownBy(() -> api.getUnionRanking(null, invalidOcid, null).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00003);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }
}

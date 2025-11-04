package kms.history;

import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.history.CubeHistoryResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

@DisplayName("getCubeHistory")
public class TestGetCubeHistory {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);

    @Test
    @DisplayName("success: getCubeHistory")
    void getCubeHistory() {
        int count = 1000;
        CubeHistoryResponseDTO response = api.getCubeHistory(count).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getCubeHistory with date")
    void getCubeHistory_with_date() {
        int count = 1000;
        LocalDateTime date = LocalDateTime.of(2025, 10, 23, 0, 0);
        CubeHistoryResponseDTO response = api.getCubeHistory(count, date).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getCubeHistory with cursor")
    void getCubeHistory_with_cursor() {
        int count = 10;
        LocalDateTime date = LocalDateTime.of(2025, 10, 23, 0, 0);
        CubeHistoryResponseDTO response = api.getCubeHistory(count, date).join();
        String nextCursor = response.getNextCursor();
        assertThat(nextCursor).isNotNull();

        CubeHistoryResponseDTO nextResponse = api.getCubeHistory(count, nextCursor).join();
        System.out.println(nextResponse.toString());
    }

    @Test
    @DisplayName("fail: getCubeHistory with invalid cursor throw OPENAPI00003")
    void getCubeHistory_with_invalid_cursor() {
        int count = 1000;
        String invalidCursor = "invalid_cursor_123";
        assertThatThrownBy(() -> api.getCubeHistory(count, invalidCursor).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00003);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }

    @Test
    @DisplayName("fail: getCubeHistory with excessive count throw OPENAPI00004")
    void getCubeHistory_with_excessive_count() {
        int count = 9999;
        assertThatThrownBy(() -> api.getCubeHistory(count).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00004);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }
}
